package org.jsoup.imgcrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Iterator;

import javax.imageio.ImageIO;

public class NaverCrawler {
	UrlList urls;
	int pages;
	int toCrawl;
	Iterator urlIterator;
	String save_directory;
	
	public NaverCrawler(String search_word, int num) {
		// TODO Auto-generated constructor stub
		urls = new UrlList(search_word, num);	
		pages = 0;
		toCrawl = num;
		save_directory = "C:\\Users\\ddamddi\\Documents\\crawl\\";
	}
	
	public void run() throws IOException {
		while(pages < toCrawl) {
			 urls.refill(0);
			 urlIterator = urls.createIterator();
			
			while(urlIterator.hasNext()) {
				Elements img = getElements();
				
				for(Element e : img) {
					if(pages >= toCrawl)
						break;
					
					String url = decodeUrl(e);
			        saveImg(new URL(url));
				}
			}
					
		}
	}
	
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
	
	public void saveImg(URL imgUrl){
		try {
		BufferedImage jpg = ImageIO.read(imgUrl);
        File file = new File(save_directory+ pages +".jpg");
        ImageIO.write(jpg, "jpg", file);
        System.out.println("image " + pages + "crwaled!!");
        pages += 1;
		} catch (javax.imageio.IIOException d) {
			return;
		} catch (java.lang.ArrayIndexOutOfBoundsException f) {
			return;
		} catch (IOException e) {
			return;
		} catch (java.lang.IllegalArgumentException g) {
			return;
		}
		
	}
	
	public Elements getElements() throws IOException {
		Document doc = Jsoup.connect(urlIterator.next().toString()).get();
		return doc.select("img");	
	}
	
	
	
	public static void main(String[] args) throws IOException {
		NaverCrawler crawler = new NaverCrawler("슈렉", 500);
		crawler.run();
		
		
	}

}
