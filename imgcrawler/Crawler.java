package org.jsoup.imgcrawler;

import java.io.IOException;
import java.net.URL;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class Crawler {
	public abstract void run() throws IOException;
	public abstract Elements getElements() throws IOException;
	public abstract String decodeUrl(Element e);
	public abstract void saveImg(URL imgUrl);
	
	public void setDirectory(String dir) { };
	
}
