package org.jsoup.imgcrawler;

import org.jsoup.helper.Validate;

public class CrawlerFactory {
	
	public CrawlerFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Crawler createCrawler(String type) {
		Crawler crawler;
		
		switch (type.toLowerCase()) {
		case "naver" : crawler = new NaverCrawler(); break;
		case "bing"  : crawler = new BingCrawler(); break;
		default 	 : crawler = null;
		}
		Validate.notNull(crawler);
		return crawler;
	}
}
