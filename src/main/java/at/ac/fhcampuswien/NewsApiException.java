package at.ac.fhcampuswien;

import at.ac.fhcampuswien.newsapi.NewsApi;

public class NewsApiException extends RuntimeException {
    public NewsApiException (String errormessage, Throwable error) {
        super(errormessage, error);
    }

    public NewsApiException (String errormessage) {
        super(errormessage);
    }

}
