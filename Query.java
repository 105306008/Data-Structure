package Test;

import java.awt.List;
import java.io.IOException;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import org.jsoup.nodes.*;
import org.jsoup.Jsoup;

public class Query {
	public String searchKeyword;
	public String url;
	public ArrayList<WebPage> list = new ArrayList<WebPage>();
	public ArrayList<WebTree> trees = new ArrayList<WebTree>();
	String health = "health";
	String disease = "disease";
	String medical = "medical";

	
	public Query(String searchKeyword){
		this.searchKeyword = searchKeyword;
		this.url = "http://www.google.com/search?q=" + searchKeyword + health + disease + medical
				+ "&oe=utf8&num=50";
	}
	

	public void query() throws Exception{
		
		
		Document document = Jsoup.connect(this.url).get();
	    Elements div_rcs = document.select("div.rc");
	    
	    for(Element div_rc : div_rcs){
	    	Element h3 = div_rc.select("h3.r").get(0);
	    	String title = h3.text();
	    	
	    	Element cite = div_rc.select("cite").get(0);
	    	String citeUrl = cite.text();
	    	
	    	WebPage ws = new WebPage(title, citeUrl);
	    	WebTree wt = new WebTree(ws);
	    	list.add(ws);
	    	trees.add(wt);
	    	
	    }
	    System.out.println(list.toString());
	}
	
	
     public void find() throws Exception{
	    
	    for(int i=0; i<list.size();i++) {

	    	
			try {
				Document doc = Jsoup.connect(list.get(i).URL).get();
				Elements div_r = doc.select("a[href]");
				ArrayList<WebPage> childList = new ArrayList<WebPage>();
				int j = 0;

				
			    for(Element div_rc : div_r){
			    	
			    	j++;
			    	
			    	String title = div_rc.text();			    	
			    	String linkHref = div_rc.attr("abs:href");
			    	
			    	WebPage ws = new WebPage(title, linkHref);
			    	trees.get(i).root.addChild(new WebNode(ws));
			    	childList.add(ws);
//			    	System.out.println(ws.toString());
			    	
			    	
			    	if(j>=5) break;

			    }
			    
			    for(int k=0; i<childList.size();i++) {
			    	try {
						Document doc2 = Jsoup.connect(childList.get(i).URL).get();
						Elements div_r2 = doc2.select("a[href]");
						int l = 0;
			    	
                for(Element div_rc : div_r2){
			    	
			    	l++;
			    	
			    	String title = div_rc.text();			    	
			    	String linkHref = div_rc.attr("abs:href");
			    	
			    	WebPage ws = new WebPage(title, linkHref);
			    	trees.get(i).root.children.get(i).addChild(new WebNode(ws));
//			    	System.out.println(ws.toString());
			    	
			    	
			    	if(l>=3) break;

			    }
			    	}catch(Exception e) {
					continue;
				}
			    }
			}catch(Exception e) {
				continue;
			}
			
			
			
			
	    }
		
     }
	
	    

		
	
	


}
