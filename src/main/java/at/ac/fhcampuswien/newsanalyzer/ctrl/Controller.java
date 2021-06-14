package at.ac.fhcampuswien.newsanalyzer.ctrl;

import at.ac.fhcampuswien.newsapi.NewsApi;
import at.ac.fhcampuswien.newsapi.NewsApiBuilder;
import at.ac.fhcampuswien.newsapi.beans.Article;
import at.ac.fhcampuswien.newsapi.beans.NewsResponse;
import at.ac.fhcampuswien.newsapi.enums.Country;
import at.ac.fhcampuswien.newsapi.enums.Endpoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

	public static final String APIKEY = "8b865417560b4a34ae0b98af6be0ab3f";  //TODO add your api key

	public void process(String choice, String fromDate) {
		System.out.println("Start process");

		//TODO implement Error handling

		//TODO load the news based on the parameters

		NewsApi newsApi = new NewsApiBuilder()
				.setApiKey(APIKEY)                        //API Key is needed
				.setQ(choice)                            //"keyword"
				//.setSourceCountry(Country.at)          	//relevant country
				.setFrom(fromDate)                            //from which date on
				.setEndPoint(Endpoint.TOP_HEADLINES)        //"how many articles to retrieve"
				.createNewsApi();

		//TODO implement methods for analysis
		NewsResponse newsResponse = newsApi.getNews();
		if (newsResponse != null) {
			List<Article> articles = newsResponse.getArticles();
			articles.stream().forEach(article -> System.out.println(article.toString()));
			//Number of articles
			System.out.println("--------------Analytics--------------");
			System.out.println("Number of articles: " + articles.size());
			System.out.println("Provides most articles: " + analiseProvider(articles));
			System.out.println("Author with shortest name: " + shortestAuthorName(articles));
			System.out.println("Titels with longest name: " + longestTitleNames(articles));

		}

		System.out.println("End process");
	}


	public Object getData() {

		return null;
	}

	public String analiseProvider(List<Article> articleList) {
		Map<String, Integer> providerNames = new HashMap<>();
		for (Article article : articleList) {
			Integer value = providerNames.get(article.getSource().getName());
			if (value == null) {
				value = 0;
			}
			value++;
			providerNames.put(article.getSource().getName(), value);
		}
		int value = 0;
		String mostCommonName = null;
		for (String name : providerNames.keySet()) {
			int test = providerNames.get(name);
			if (test > value) {
				value = test;
				mostCommonName = name;
			}
		}
		return mostCommonName;
	}

	public String shortestAuthorName(List<Article> articleList) {
		int maxLength = 100;
		String shortestName = null;
		for (Article article : articleList) {
			if (article.getAuthor() != null) {
				int length = article.getAuthor().length();
				if (length < maxLength) {
					maxLength = length;
					shortestName = article.getAuthor();
				}
			}
		}
		return shortestName;
	}

	public List<String> longestTitleNames(List<Article> articleList) {

		String maxLengthTitle = "";
		List<String> longestTitlelist = new ArrayList<>();

		while (!articleList.isEmpty()) {
			for (Article article : articleList) {
				if (article.getTitle().length() > maxLengthTitle.length()) {
					maxLengthTitle = article.getTitle();
					System.out.println(maxLengthTitle);

				}
			}
			longestTitlelist.add(maxLengthTitle);
			while (articleList.contains(maxLengthTitle)) {
				articleList.remove(maxLengthTitle);
			}
		}
		return longestTitlelist;

	/*	for (int i = 0; i < articleList.size(); i++) {
			for(Article article : articleList) {
				if(article.getTitle() != null) {
					int length = article.getTitle().length();
					if (length > maxLength.length()) {
						maxLength = length;
						shortestName = article.getAuthor();
					}
			}
		}

	}*/
	}

/*	public List<Article> printlist(List<Article> articlelist) {
		for (Article elem : articlelist){
			System.out.println(elem.getTitle());
		}
		return articlelist;
	}*/
}

// while(!zoo.isEmpty()) {
//		String bigger = "";
//		for(String animal : zoo) {
//			if(animal.length() > bigger.length()) {
//				bigger = animal;
//			}
//		}
//		System.out.println(bigger);
//		while(zoo.contains(bigger)) {
//			zoo.remove(bigger);
//		}
//	}