package org.jsoup.imgcrawler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.sound.midi.SysexMessage;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.urllist.UrlList;

public abstract class Crawler {
	UrlList urls;
	Iterator urlIterator;
	String save_directory;
	int pages, toCrawl;
	String prefix;
	
	public Crawler(int num) {
		// TODO Auto-generated constructor stub
		pages = 0;
		toCrawl = num;
		save_directory = "./img/";
		prefix = "";
	}
	
	public void run() throws IOException {
		RUNOUT :
			while(pages < toCrawl) {
				 urlIterator = urls.createIterator();
				
				while(urlIterator.hasNext()) {
					Elements img = getElements();
					Validate.noNullElements(img, "There is no searched image");
					
					for(Element e : img) {
						if(pages >= toCrawl)
							break;
						
						String url = decodeUrl(e);
						try {
				        saveImg(new URL(url));
						}
						catch (FileNotFoundException f){
							break RUNOUT;
						}
				        System.out.println("###############");
					}
				}
				urls.refill();		
			}
	}
	
	public abstract Elements getElements() throws IOException;
	public abstract String decodeUrl(Element e);
	public void saveImg(URL imgUrl) throws FileNotFoundException {
		try {
			BufferedImage jpg = ImageIO.read(imgUrl);
	        File file = new File(save_directory + prefix + "_" + pages + ".jpg");
	        ImageIO.write(jpg, "jpg", file);
	        System.out.println( urls.getSearchWord() + " " + prefix + "_" + pages + " Crawled!!");
	        pages += 1;
		} catch (NullPointerException n) {
			System.out.println("saveImg n");
			return;
		} catch (IOException i) {
			System.out.println("saveImg i");
			return;
		}
	}
	
	public void setDirectory(String dir) { 
		this.save_directory = dir;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
}
