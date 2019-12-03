package org.jsoup.urllist;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class NaverUrlList extends UrlList {
	
	public NaverUrlList(String search_word, int num) {
		super(search_word, num);
	}

	public void addUrl(){
		URL tmp = null;
		try {
			tmp = new URL("https://s.search.naver.com/imagesearch/instant/search.naver?where=image&section=image&rev=31&res_fr=0&res_to=0&face=0&color=0&ccl=0&ac=0&aq=0&spq=1&query=" + getSearchWord() + "&nx_search_query="+ getSearchWord() + "&nx_and_query=&nx_sub_query=&nx_search_hlquery=&nx_search_fasquery=&datetype=0&startdate=0&enddate=0&json_type=6&nlu_query=&nqx_theme={\\\"theme\\\":{\\\"main\\\":{\\\"name\\\":\\\"animal\\\"}}}&start="+ page + "&display=200&_callback=window.__jindo2_callback.__sauImageTabList_0");
			page += 200;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		urls.add(tmp);
	}

	@Override
	public String getSearchWord() {
		return search_word.replaceAll(" ", "+");
	}
}
