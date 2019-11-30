package org.jsoup.imgcrawler;

public class CrawlerFactory {
	
	public CrawlerFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Crawler createCrawler(String name, String search_word, int num) {
		switch (name) {
		case "naver" : return new NaverCrawler(search_word, num);
		case "bing"  : return null;
		case "daum"  : return null;
		default : return null;
		}
	}
}
