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
	private final int DEFAULT_TOT_CRAWL_CNT = 100;
	private final String DEFAULT_SAVE_DIR = "./img/";
	int tot_imgCnt, crnt_imgCnt;
	UrlList urls;
	Iterator urlIterator;
	String prefix, save_directory;

	public Crawler() {
		crnt_imgCnt = 0;
		tot_imgCnt = DEFAULT_TOT_CRAWL_CNT;
		save_directory = DEFAULT_SAVE_DIR;
		prefix = "";
	}
	
	public void imgCrawling(String search_word) throws IOException { 
		this.urls.setSearchWord(search_word);
		this.prefix = search_word;
		while(crnt_imgCnt < tot_imgCnt) {
			urlIterator = urls.createIterator();
			
			while(urlIterator.hasNext()) {
				Elements images = getImages();
				Validate.noNullElements(images, "There is no searched image");
				
				for(Element image : images) {
					if(crnt_imgCnt >= tot_imgCnt)
						break;
					
					String url = decodeUrl(image);
			        saveImg(new URL(url));
			        System.out.println("###############");
				}
			}
			urls.refill();		
		}
	}
	
	public void imgCrawling(String search_word, int imgCnt) throws IOException {
		this.tot_imgCnt = imgCnt;
		imgCrawling(search_word);
	}
	
	public void imgCrawling(String search_word, int imgCnt, String save_dir) throws IOException {
		setDirectory(save_dir);
		imgCrawling(search_word, imgCnt);
	}
	
	public abstract Elements getImages() throws IOException;
	
	public abstract String decodeUrl(Element e);
	
	public void saveImg(URL imgUrl) {
		BufferedImage jpg = null;
		try {
			jpg = ImageIO.read(imgUrl);
		} catch (javax.imageio.IIOException e){
			System.out.println("imageIO");
			return;
		} catch (IOException e1) {
		      e1.printStackTrace();
		}
		System.out.println("Save Dir : "+save_directory);
		File folder = new File(save_directory);
		
		if (!folder.exists()) {
			folder.mkdir();
		}
		
		File file = new File(save_directory + prefix + "_" + crnt_imgCnt + ".jpg");
		try {
			ImageIO.write(jpg, "jpg", file);
		} catch(java.lang.IllegalArgumentException e1) {
	         System.out.println("illegal");
	         return;
		}catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
        System.out.println( urls.getSearchWord() + " " + prefix + "_" + crnt_imgCnt + " Crawled!!");
        crnt_imgCnt += 1;
	}
	
	public void setDirectory(String dir) { 
		this.save_directory = dir;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
}
