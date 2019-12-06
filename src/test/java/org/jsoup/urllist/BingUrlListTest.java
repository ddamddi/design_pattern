package org.jsoup.urllist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.jsoup.urllist.BingUrlList;
public class BingUrlListTest {

	@Test
	public void BingAddUrlTest() {
		UrlList testurl = new BingUrlList(10);
		testurl.setSearchWord("강아지");
		testurl.addUrl();
		assertEquals(testurl.urls.get(0).toString(), "https://www.bing.com/images/async?q=" + "강아지" + "&first="+ 0 + "&count=200&mmasync=1");
	}

}
