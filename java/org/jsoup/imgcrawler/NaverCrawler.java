package org.jsoup.imgcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.urllist.NaverUrlList;
import org.jsoup.urllist.UrlList;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Iterator;

import javax.imageio.ImageIO;


public class NaverCrawler extends Crawler {

	public NaverCrawler(String search_word, int num) {
		// TODO Auto-generated constructor stub
		super(num);
		urls = new NaverUrlList(search_word, num);		
	}
	
	public NaverCrawler(String search_word, int num, String save_dir) {
		// TODO Auto-generated constructor stub
		this(search_word, num);
		setDirectory(save_dir);
	}
	
	@Override
	public Elements getElements() throws IOException {
		Document doc = Jsoup.connect(urlIterator.next().toString()).get();
		return doc.select("img");
	}
	
	@Override
	public String decodeUrl(Element e) {
		String url = e.getElementsByAttribute("src").attr("data-source");
        url= url.substring(url.indexOf("src=")+4, url.length()-1);
        try {
			return URLDecoder.decode(url,"EUC_KR");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			return null;
		}
	}


}
