package at.ac.fhcampuswien.newsapi;

import at.ac.fhcampuswien.newsapi.enums.*;

public class NewsApiBuilder {

    private Endpoint endpoint;
    private String q;
    private String qInTitle;
    private Country sourceCountry;
    private Category sourceCategory;
    private String domains;
    private String excludeDomains;
    private String from;
    private String to;
    private Language language;
    private SortBy sortBy;
    private String pageSize;
    private String page;
    private String apiKey;

    public NewsApiBuilder setQ(String q) {
        this.q = q;
        return this;
    }

    public NewsApiBuilder setQInTitle(String qInTitle) {
        this.qInTitle = qInTitle;
        return this;
    }

    public NewsApiBuilder setSourceCountry(Country sourceCountry) {
        this.sourceCountry = sourceCountry;
        return this;
    }

    public NewsApiBuilder setSourceCategory(Category sourceCategory) {
        this.sourceCategory = sourceCategory;
        return this;
    }

    public NewsApiBuilder setDomains(String domains) {
        this.domains = domains;
        return this;
    }

    public NewsApiBuilder setExcludeDomains(String excludeDomains) {
        this.excludeDomains = excludeDomains;
        return this;
    }

    public NewsApiBuilder setFrom(String from) {
        this.from = from;
        return this;
    }

    public NewsApiBuilder setTo(String to) {
        this.to = to;
        return this;
    }

    public NewsApiBuilder setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public NewsApiBuilder setSortBy(SortBy sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public NewsApiBuilder setPageSize(String pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public NewsApiBuilder setPage(String page) {
        this.page = page;
        return this;
    }

    public NewsApiBuilder setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public NewsApiBuilder setEndPoint(Endpoint endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public NewsApi createNewsApi() {
        return new NewsApi(q, qInTitle, sourceCountry, sourceCategory, domains, excludeDomains, from, to, language, sortBy, pageSize, page, apiKey, endpoint);
    }
}
