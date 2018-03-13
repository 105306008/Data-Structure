package Test;

import java.util.ArrayList;

public class KeywordList {

	public ArrayList<Keyword> keywords = new ArrayList<Keyword>();
//	private ArrayList<String> keywordName = new ArrayList<String>();
	
	KeywordList(){
//		keywords.add(new Keyword("cold",1));
//		keywords.add(new Keyword("colds",1));
		keywords.add(new Keyword("effective",1));
//		keywords.add(new Keyword("effectively",1));
		keywords.add(new Keyword("caution",1));
		keywords.add(new Keyword("careful",1));
		keywords.add(new Keyword("beware",1));
		keywords.add(new Keyword("deal with",0.5));
		keywords.add(new Keyword("deals with",0.5));
		keywords.add(new Keyword("dealing with",0.5));
		keywords.add(new Keyword("cure",0.5));
//		keywords.add(new Keyword("cures",0.5));
		keywords.add(new Keyword("curing",0.5));
		keywords.add(new Keyword("curable",0.5));
		keywords.add(new Keyword("relief",0.5));
		keywords.add(new Keyword("relieve",0.5));
//		keywords.add(new Keyword("relieves",0.5));
		keywords.add(new Keyword("relieving",0.5));
		keywords.add(new Keyword("Dr",2));
		keywords.add(new Keyword("doctor",2));
		keywords.add(new Keyword("health",2));
		keywords.add(new Keyword("report",1.5));
		keywords.add(new Keyword("study",1.5));
		keywords.add(new Keyword("research",1.5));
//		keywords.add(new Keyword("healthcare",1.5));
		keywords.add(new Keyword("medicine",1.5));
		keywords.add(new Keyword("treatment",1.5));
		keywords.add(new Keyword("medical",1.5));
		
		
	}

	
}
