package org.jsoup.examples;

import java.io.IOException;

import org.jsoup.imgcrawler.Crawler;
import org.jsoup.imgcrawler.CrawlerFactory;

public class CrwalerTest {
	public static void main(String[] args) throws IOException {
		CrawlerFactory cf = new CrawlerFactory();
		Crawler c = cf.createCrawler("naver", "강아지", 300);
		
		c.run();
	}
}
