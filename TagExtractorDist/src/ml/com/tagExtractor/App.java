package ml.com.tagExtractor;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
    	
    	TagExtractor te = new TagExtractor();
    	try {
			List<String> s = te.extractTagFromWebPage("https://redis.io/topics/quickstart");
			for(String ss : s ){
				System.out.println(ss);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    }
}
