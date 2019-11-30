package org.jsoup.imgcrawler;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class UrlIterator implements Iterator<URL>{
	
	ArrayList<URL> urls;
	int position = 0;
	
	public UrlIterator(ArrayList<URL> urls) {
		this.urls = urls;
	}
	
	@Override
	public boolean hasNext() {
		if(position >= urls.size()) return false;
		else return true;
	}

	@Override
	public URL next() {
		URL url = urls.get(position);
		position++;
		return url;
	}

}
