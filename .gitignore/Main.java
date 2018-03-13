# Compiled class file
*.class

# Log file
*.log

# BlueJ files
*.ctxt

# Mobile Tools for Java (J2ME)
.mtj.tmp/

# Package Files #
*.jar
*.war
*.ear
*.zip
*.tar.gz
*.rar

# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml
hs_err_pid*


import java.util.ArrayList;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);


		String name = in.next();
		double weight = 1;
		Keyword k = new Keyword(name, weight);
		String keyword = k.name;

//		String keyword = in.next();
			
        KeywordList keywordList = new KeywordList();
		ArrayList<Keyword> keywords = new ArrayList<Keyword>();
		keywords = keywordList.keywords;
		keywords.add(k);
		
		Query gq = new Query(keyword);
		ArrayList<WebTree> trees = new ArrayList<WebTree>();
		gq.query();
		gq.find();
		trees = gq.trees;
		
		HeapSort treeSort = new HeapSort();
		
//		System.out.println("test");
		for(int i=0; i<trees.size(); i++) {
			try {
		  trees.get(i).setPostOrderScore(keywords);
		  treeSort.add(trees.get(i));
		  }catch(Exception e) {
			  
		  }
		}
		
		for(int i=0; i<trees.size(); i++) {
			try {
		  WebTree tree = (WebTree) treeSort.removeMin();
			//System.out.print(i+1, tree.startNode.webpage.name)
		  System.out.println("\n\n" + (i+1) + " " + tree.root.webPage.toString() + "," + tree.root.nodeScore);
		  tree.eularPrintTree();
		  System.out.println("\n");
			}catch(Exception e) {
				continue;
			}
		}

		
		
		
	}

}
