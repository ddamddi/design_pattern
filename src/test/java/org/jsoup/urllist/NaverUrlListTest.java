package org.jsoup.urllist;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class NaverUrlListTest {

	@Test
	public void NaverAddUrlTest() {
		UrlList testurl = new NaverUrlList(10);
		testurl.setSearchWord("강아지");
		testurl.addUrl();
		assertEquals(testurl.urls.get(0).toString(), "https://s.search.naver.com/imagesearch/instant/search.naver?where=image&section=image&rev=31&res_fr=0&res_to=0&face=0&color=0&ccl=0&ac=0&aq=0&spq=1&query=" + "강아지" + "&nx_search_query="+ "강아지" + "&nx_and_query=&nx_sub_query=&nx_search_hlquery=&nx_search_fasquery=&datetype=0&startdate=0&enddate=0&json_type=6&nlu_query=&nqx_theme={\\\"theme\\\":{\\\"main\\\":{\\\"name\\\":\\\"animal\\\"}}}&start="+ 0 + "&display=200&_callback=window.__jindo2_callback.__sauImageTabList_0");
	}

}
