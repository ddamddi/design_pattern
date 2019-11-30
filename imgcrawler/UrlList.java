package org.jsoup.imgcrawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class UrlList {
	String search_word;
	final int PAGE_NUM = 200;
	private int page = 0;
	ArrayList<URL> urls;
	
	public UrlList(String search_word, int num) {
		// TODO Auto-generated constructor stub
		this.search_word = search_word;
		urls = new ArrayList<URL>();
//		int num_urls = (num / 200) * 2;
//		for(int i = 0; i < 2; i++)
//			addUrl();
	}
	
	public void addUrl(){
		URL tmp = null;
		try {
			tmp = new URL("https://s.search.naver.com/imagesearch/instant/search.naver?where=image&section=image&rev=31&res_fr=0&res_to=0&face=0&color=0&ccl=0&ac=0&aq=0&spq=1&query=" + search_word + "&nx_search_query="+ search_word + "&nx_and_query=&nx_sub_query=&nx_search_hlquery=&nx_search_fasquery=&datetype=0&startdate=0&enddate=0&json_type=6&nlu_query=&nqx_theme={\\\"theme\\\":{\\\"main\\\":{\\\"name\\\":\\\"animal\\\"}}}&start="+ page + "&display=200&_callback=window.__jindo2_callback.__sauImageTabList_0");
			page += 200;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		urls.add(tmp);
	}
	
	public int getUrlSize(){	
		return urls.size();
	}
	
	public void printURL() {
		for(URL url: urls) {
			System.out.println(url);
		}
	}
	
	public static void main(String[] args) {
		UrlList a = new UrlList("강아지", 1000);
		a.printURL();
		
		a.clear();
		System.out.println("=====================================================");
		a.addUrl();
		a.addUrl();
		a.printURL();
	}
	
	public Iterator createIterator() {
		return new UrlIterator(urls);
	}
	
	public void clear() {
		urls.clear();
	}
	
	public void refill(int num) {
		urls.clear();
		for(int i = 0; i < 2; i++)
			addUrl();
	}
}
