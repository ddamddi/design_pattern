package org.jsoup.imgcrawler;

import org.jsoup.helper.Validate;

public class CrawlerFactory {
	
	public CrawlerFactory() {	}
	
	public Crawler createCrawler(String type) {
		Crawler crawler = null;
		
		switch (type.toLowerCase()) {
		case "naver" : crawler = new NaverCrawler(); break;
		case "bing"  : crawler = new BingCrawler(); break;
		default 	 : Validate.notNull(crawler);
		}
		return crawler;
	}
}
