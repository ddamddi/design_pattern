package org.jsoup.urllist;

import java.net.MalformedURLException;
import java.net.URL;

public class BingUrlList extends UrlList {

	public BingUrlList(int tot_imgCnt) {
		super(tot_imgCnt);
	}

	public void addUrl(){
		URL tmp = null;
		try {
			tmp = new URL("https://www.bing.com/images/async?q=" + getSearchWord() + "&first="+ crnt_imgCnt + "&count=200&mmasync=1");
			crnt_imgCnt += DEFAULT_URL_IMG_CNT;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		urls.add(tmp);
	}
}
