package org.jsoup.imgcrawler;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CrawlerFactoryTest {

	@Test
	public void testCreateCrawler() {
		CrawlerFactory crawlerFactory = new CrawlerFactory();
		Crawler crawler = crawlerFactory.createCrawler("naver");
		
		assertEquals(crawler.getClass(), NaverCrawler.class);
	}

	@Test
	public void testCreateCrawler2() {
		CrawlerFactory crawlerFactory = new CrawlerFactory();
		Crawler crawler = crawlerFactory.createCrawler("NaVer");
		
		assertEquals(crawler.getClass(), NaverCrawler.class);
	}
	
	@Test
	public void testCreateCrawler3() {
		try {
			CrawlerFactory crawlerFactory = new CrawlerFactory();
			Crawler crawler = crawlerFactory.createCrawler("google");
		}
		catch (IllegalArgumentException ex) {
			assertEquals("Object must not be null", ex.getMessage());
		}

	}	
	
}
