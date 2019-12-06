package org.jsoup.examples;


import java.io.IOException;

import org.jsoup.imgcrawler.Crawler;
import org.jsoup.imgcrawler.CrawlerFactory;

public class CrawlerTest {
	public static void main(String[] args) throws IOException {
		CrawlerFactory cf = new CrawlerFactory();

//		Crawler bingImgCrawler = cf.createCrawler("bing");
//		bingImgCrawler.imgCrawling("cat",1000,"./img/cat/");
		
		Crawler naverImgCrawler = cf.createCrawler("naver");
		naverImgCrawler.imgCrawling("°­¾ÆÁö",1000,"./img/dog/");
	}
}
