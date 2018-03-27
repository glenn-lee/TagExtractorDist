package ml.com.tagExtractor;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main( String[] args ) throws IOException {
    	
    	TagExtractor te = new TagExtractor();
		List<String> tags = te.extractTagFromWebPage("https://en.wikipedia.org/wiki/Spring_Framework"); // extract tags from web page

		for(String tag : tags ){
			System.out.println(tag); // print extracted tags
		}

    }
}
