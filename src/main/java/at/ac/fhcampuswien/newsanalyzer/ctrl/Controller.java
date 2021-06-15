package at.ac.fhcampuswien.newsanalyzer.ctrl;

import at.ac.fhcampuswien.newsanalyzer.ui.UserInterface;
import at.ac.fhcampuswien.newsapi.NewsApi;
import at.ac.fhcampuswien.newsapi.NewsApiBuilder;
import at.ac.fhcampuswien.newsapi.beans.Article;
import at.ac.fhcampuswien.newsapi.beans.NewsResponse;
import at.ac.fhcampuswien.newsapi.enums.Category;
import at.ac.fhcampuswien.newsapi.enums.Country;
import at.ac.fhcampuswien.newsapi.enums.Endpoint;
import at.ac.fhcampuswien.newsapi.enums.Language;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {
	public int choice;

	public static final String APIKEY = "06f0f6dc8e794d97902e05cb4f116206"; //6b627a3b61b74aa8a9e672a4791581f9

	public void process() {
		System.out.println("Start process");
		NewsResponse newsResponse=null;
		//TODO implement Error handling
		if(choice==1){
			NewsApi newsApi = new NewsApiBuilder()
					.setLanguage(Language.en)
					.setApiKey(APIKEY)
					.setQ("corona")
					.setEndPoint(Endpoint.TOP_HEADLINES)// example of how to use enums
					.setSourceCountry(Country.us)// example of how to use enums
					.setSourceCategory(Category.health) // example of how to use enums
					.setPageSize("100")
					.createNewsApi();
			 newsResponse = newsApi.getNews();

		}
		else if (choice==2){
			NewsApi newsApi = new NewsApiBuilder()
					.setLanguage(Language.de)
					.setApiKey(APIKEY)
					.setQ("corona")
					.setEndPoint(Endpoint.TOP_HEADLINES)// example of how to use enums
					.setSourceCountry(Country.de)// example of how to use enums
					.setSourceCategory(Category.health) // example of how to use enums
					.createNewsApi();
			 newsResponse = newsApi.getNews();

			/*if(newsResponse != null){

				List<Article> articles = newsResponse.getArticles();
				articles.stream().forEach(article -> System.out.println(article.toString()));

				List<Article> articles1 = newsResponse.getArticles();
			}

			System.out.println('\n'+"Total amount of Articles found: "+newsResponse.getTotalResults() +'\n');

			getShortestAuthor(newsResponse);

			getSortedTitles(newsResponse);

			getTheMostPopularSource(newsResponse);*/
		}
		else if(choice==3){
			NewsApi newsApi = new NewsApiBuilder()
					.setApiKey(APIKEY)
					.setEndPoint(Endpoint.TOP_HEADLINES)
					.setQ("money")
					.setFrom("2021-05-16")
					.setTo("2021-06-15")
					.setSourceCountry(Country.au)
					.setSourceCategory(Category.business)
					.setLanguage(Language.en)
					.createNewsApi();

			 newsResponse = newsApi.getNews();
			/*if(newsResponse != null){
				List<Article> articles = newsResponse.getArticles();
				articles.stream().forEach(article -> System.out.println(article.toString()));
			}
			System.out.println('\n'+"Total amount of Articles found: "+newsResponse.getTotalResults() +'\n');

			getShortestAuthor(newsResponse);

			getSortedTitles(newsResponse);

			getTheMostPopularSource(newsResponse);*/
		}
		else{
			NewsApi newsApi=null;
			System.out.println("Precofigured filters are: Endpoint: top headlines, Source Category: sports, Language: en.");
			System.out.print("Write your own Q, please: ");
			Scanner in=new Scanner(System.in);
			String input=in.nextLine();
			System.out.print("Do you want to set Source Country? Type 'yes' to choose one and 'no' to skip this part ");
			String confirmCountry=in.nextLine();
			if(confirmCountry.equals("yes")){
				System.out.println("Countries available: au, at, de, ca, eg, gb, us, ru. Type to choose one");
				String country=in.nextLine();
				switch (country){
					case "au":
						System.out.println("You have successfully chosen au");
						newsApi = new NewsApiBuilder()
							.setApiKey(APIKEY)
							.setEndPoint(Endpoint.TOP_HEADLINES)
							.setQ(input)
							.setSourceCountry(Country.au)
							.setSourceCategory(Category.sports)
							.setLanguage(Language.en)
							.createNewsApi();
							break;
					case "at": System.out.println("You have successfully chosen at");
						newsApi = new NewsApiBuilder()
							.setApiKey(APIKEY)
							.setEndPoint(Endpoint.TOP_HEADLINES)
							.setQ(input)
							.setSourceCountry(Country.at)
							.setSourceCategory(Category.sports)
							.setLanguage(Language.en)
							.createNewsApi();
							break;
					case "de": System.out.println("You have successfully chosen de");
						newsApi = new NewsApiBuilder()
							.setApiKey(APIKEY)
							.setEndPoint(Endpoint.TOP_HEADLINES)
							.setQ(input)
							.setSourceCountry(Country.de)
							.setSourceCategory(Category.sports)
							.setLanguage(Language.en)
							.createNewsApi();
							break;
					case "ca": System.out.println("You have successfully chosen ca");
						newsApi = new NewsApiBuilder()
							.setApiKey(APIKEY)
							.setEndPoint(Endpoint.TOP_HEADLINES)
							.setQ(input)
							.setSourceCountry(Country.ca)
							.setSourceCategory(Category.sports)
							.setLanguage(Language.en)
							.createNewsApi();
							break;
					case "eg": System.out.println("You have successfully chosen eg");
						newsApi = new NewsApiBuilder()
							.setApiKey(APIKEY)
							.setEndPoint(Endpoint.TOP_HEADLINES)
							.setQ(input)
							.setSourceCountry(Country.eg)
							.setSourceCategory(Category.sports)
							.setLanguage(Language.en)
							.createNewsApi();
							break;
					case "gb": System.out.println("You have successfully chosen gb");
						newsApi = new NewsApiBuilder()
							.setApiKey(APIKEY)
							.setEndPoint(Endpoint.TOP_HEADLINES)
							.setQ(input)
							.setSourceCountry(Country.gb)
							.setSourceCategory(Category.sports)
							.setLanguage(Language.en)
							.createNewsApi();
							break;
					case "us": System.out.println("You have successfully chosen us");
						newsApi = new NewsApiBuilder()
							.setApiKey(APIKEY)
							.setEndPoint(Endpoint.TOP_HEADLINES)
							.setQ(input)
							.setSourceCountry(Country.us)
							.setSourceCategory(Category.sports)
							.setLanguage(Language.en)
							.createNewsApi();
							break;
					default:
						System.out.println("Wrong input. No filter for Source Country will be apllied");
							 newsApi = new NewsApiBuilder()
							.setApiKey(APIKEY)
							.setEndPoint(Endpoint.TOP_HEADLINES)
							.setQ(input)
							.setSourceCategory(Category.sports)
							.setLanguage(Language.en)
							.createNewsApi();

				}

			}
			else{
				newsApi = new NewsApiBuilder()
						.setApiKey(APIKEY)
						.setEndPoint(Endpoint.TOP_HEADLINES)
						.setQ(input)
						.setSourceCategory(Category.sports)
						.setLanguage(Language.en)
						.createNewsApi();
			}


			newsResponse = newsApi.getNews();
		}
		if(newsResponse != null){
			List<Article> articles = newsResponse.getArticles();
			articles.stream().forEach(article -> System.out.println(article.toString()));
		}

		System.out.println('\n'+"Total amount of Articles found: "+newsResponse.getTotalResults() + '\n');
		List<Article> articles = newsResponse.getArticles();
		articles.stream().peek(article -> System.out.println(article.getSource().getName()));

		getShortestAuthor(newsResponse);

		getSortedTitles(newsResponse);

		getTheMostPopularSource(newsResponse);
		//TODO load the news based on the parameters

		//TODO implement methods for analysis



		System.out.println("End process");
	}

	public void getShortestAuthor(NewsResponse newsResponse){
		Article [] articles1=newsResponse.getArticles().stream().toArray(Article[]::new);
		String shortestAuthor="no Author found";
		for(int i=0; i<articles1.length; i++){
			for(int j=0; j<articles1.length; j++){
				if(articles1[i].getAuthor()!=null && articles1[j].getAuthor()!=null &&(articles1[i].getAuthor().length()>articles1[j].getAuthor().length())){
					shortestAuthor=articles1[j].getAuthor();
				}
				if(articles1.length==2){
					if(articles1[0].getAuthor().length()<articles1[1].getAuthor().length()){
						shortestAuthor=articles1[0].getAuthor();
					}
					else{
						shortestAuthor=articles1[1].getAuthor();
					}
				}
			}
		}
		System.out.println("The shortest Author name is: " + shortestAuthor + '\n');
	}

	public void getSortedTitles(NewsResponse newsResponse){
		System.out.println("Starting to Sort the Titles" +'\n');
		List<Article> employees = newsResponse.getArticles().stream()
				.sorted((e1, e2) -> e1.getTitle().compareTo(e2.getTitle()))
				.sorted((e1,e2)->e2.getTitle().length()-e1.getTitle().length())
				.collect(Collectors.toList());
		employees.forEach(article -> System.out.println(article.getTitle()));
		System.out.println('\n');
	}

	public void getTheMostPopularSource(NewsResponse newsResponse){
		Article [] articles1=newsResponse.getArticles().stream().toArray(Article[]::new);
		Article savedArticle = null;
		int countSaved=0;
		int countInLoop=0;
		for(int i=0; i<articles1.length; i++){
			if(savedArticle!=null && articles1[i]==savedArticle){
				break;
			}
			for (int j=0; j<articles1.length; j++){
				if(articles1[i].getSource().getName().equals(articles1[j].getSource().getName()) && (i!=j)){
					countInLoop++;
				}
			}
			if(countSaved<countInLoop){
				countSaved=countInLoop;
				savedArticle=articles1[i];
			}
		}
		if(savedArticle==null){
			System.out.println("The most often listed resource does not exist");
		}
		else{
			System.out.println("The most often listed source is: " + savedArticle.getSource().getName());
		}
	}

	public Object getData() {
		
		return null;
	}
}
