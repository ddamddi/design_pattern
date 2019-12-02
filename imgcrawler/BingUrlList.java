package org.jsoup.imgcrawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class BingUrlList {
	String search_word;
	final int PAGE_NUM = 100; //변경
	private int page = 0;
	ArrayList<URL> urls;
	
	public BingUrlList(String search_word, int num) {
		// TODO Auto-generated constructor stub
		this.search_word = search_word;
		urls = new ArrayList<URL>();
//		int num_urls = (num / 200) * 2;
		//for(int i = 0; i < 2; i++)
			//addUrl();
	}
	
	public void addUrl(){
		URL tmp = null;
		try {
			tmp = new URL("https://www.bing.com/images/async?q=" + search_word + "&first="+ page + "&count=100&mmasync=1");
			page += 100; //변경
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
		UrlList a = new UrlList("강아지", 500);
		a.printURL();
		
		
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
