package org.jsoup.urllist;

import java.net.MalformedURLException;
import java.net.URL;

public class BingUrlList extends UrlList {

	public BingUrlList(String search_word, int num) {
		super(search_word, num);
	}

	public void addUrl(){
		URL tmp = null;
		try {
			tmp = new URL("https://www.bing.com/images/async?q=" + getSearchWord() + "&first="+ page + "&count=200&mmasync=1");
			page += 200;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		urls.add(tmp);
	}
}
