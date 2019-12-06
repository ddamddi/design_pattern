package org.jsoup.imgcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.urllist.NaverUrlList;
import org.jsoup.urllist.UrlList;

import com.sun.org.omg.SendingContext.CodeBasePackage.URLSeqHelper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Iterator;

import javax.imageio.ImageIO;


public class NaverCrawler extends Crawler {

	public NaverCrawler() {
		super();		
		urls = new NaverUrlList(tot_imgCnt);
	}
	
	@Override
	public Elements getImages() throws IOException {
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
