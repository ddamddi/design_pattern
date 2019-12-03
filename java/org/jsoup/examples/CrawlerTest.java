package org.jsoup.examples;


import java.io.IOException;

import org.jsoup.imgcrawler.Crawler;
import org.jsoup.imgcrawler.CrawlerFactory;

public class CrawlerTest {
	public static void main(String[] args) throws IOException {
		CrawlerFactory cf = new CrawlerFactory();
		Crawler c2 = cf.createCrawler("bing", "cat", 10);
		c2.setPrefix("Cat");
		c2.setDirectory("../../../../../../../../../img/");
		c2.run();
	}
}
