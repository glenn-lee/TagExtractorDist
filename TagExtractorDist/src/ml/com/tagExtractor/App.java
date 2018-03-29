package ml.com.tagExtractor;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main( String[] args ) throws IOException {
    	
    	TagExtractor te = new TagExtractor();
		//List<String> tags = te.extractTagFromWebPage("http://www.google.com"); // extract tags from web page
    	String t = "Google    Chrome  .        Chrome  .     Gmail   Google     .    Enter .  Google     .  Enter .  Enter .          Google.com Google      YouTube Play  Gmail   Google+     Blogger   Keep Google   ";
    	//res
    	List<String> tags = te.extractTagFromText(t);
		for(String tag : tags ){
			System.out.println(tag); // print extracted tags
		}

    }
}
