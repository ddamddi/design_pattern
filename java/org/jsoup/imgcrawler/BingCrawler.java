package org.jsoup.imgcrawler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Iterator;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.urllist.BingUrlList;
import org.jsoup.urllist.NaverUrlList;
import org.jsoup.urllist.UrlList;

public class BingCrawler extends Crawler {
	
	public BingCrawler (String search_word, int num) {
		// TODO Auto-generated constructor stub
		super(num);
		urls = new BingUrlList(search_word, num);	
	}
	
	public BingCrawler(String search_word, int num, String save_dir) {
		// TODO Auto-generated constructor stub
		this(search_word, num);
		setDirectory(save_dir);
	}

	@Override
	public Elements getElements() throws IOException {
		// TODO Auto-generated method stub
		Document doc = Jsoup.connect(urlIterator.next().toString()).get();
		return doc.select("img");
	}

	@Override
	public String decodeUrl(Element e) {
		// TODO Auto-generated method stub
		return e.getElementsByAttribute("src").attr("src");
	}

}


