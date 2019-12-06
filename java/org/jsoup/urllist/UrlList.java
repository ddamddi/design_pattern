package org.jsoup.urllist;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class UrlList {
	String search_word;
	final int DEFAULT_URL_IMG_CNT = 200;
	int crnt_imgCnt;
//	final int PAGE_NUM = 200;
//	int page;
	ArrayList<URL> urls;
	
	public UrlList(int tot_imgCnt) {
		urls = new ArrayList<URL>();
		crnt_imgCnt = 0;
		int itr = tot_imgCnt / DEFAULT_URL_IMG_CNT * 2;
		
		for(int i = 0;i < itr;i++ ) {
			addUrl();
		}
		

	}
//	
//	public UrlList(String search_word, int num) {
//		this.search_word = search_word;
//		urls = new ArrayList<URL>();
//		page = 0;
//			
//		int num_urls = (num / 200) * 2;
//		for(int i = 0; i < num_urls; i++)
//			addUrl();
//	}
	
	public abstract void addUrl();
	
	public void setSearchWord(String search_word) {
		this.search_word = search_word;
	}
	
	public String getSearchWord() {
		return search_word;
	};
	
	public int getUrlSize(){	
		return urls.size();
	}
	
	public void printURL() {
		for(URL url: urls) {
			System.out.println(url);
		}
	}
	
	public Iterator createIterator() {
		return new UrlIterator(urls);
	}
	
	public void refill() {
		urls.clear();
		for(int i = 0; i < 2; i++)
			addUrl();
	}
}
