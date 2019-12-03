package org.jsoup.imgcrawler;

import org.jsoup.helper.Validate;

public class CrawlerFactory {
	
	public CrawlerFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Crawler createCrawler(String name, String search_word, int num) {
		Crawler crawler;
		
		switch (name.toLowerCase()) {
		case "naver" : crawler = new NaverCrawler(search_word, num); break;
		case "bing"  : crawler = new BingCrawler(search_word, num); break;
		default 	 : crawler = null;
		}
		Validate.notNull(crawler);
		return crawler;
	}
}
