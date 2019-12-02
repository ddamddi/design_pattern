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

public class BingCrawler extends Crawler {
	UrlList urls;
	int pages;
	int toCrawl;
	Iterator urlIterator;
	String save_directory;
	
	public BingCrawler (String search_word, int num) {
		// TODO Auto-generated constructor stub
		urls = new UrlList(search_word, num);	
		pages = 0;
		toCrawl = num;
		save_directory = "C:\\Users\\문태현\\Desktop\\hi\\";
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
		return e.getElementsByAttribute("src").attr("src");
		//변경
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
		BingCrawler crawler = new BingCrawler("강아지", 400);
		crawler.run();
		
		
	}
}
