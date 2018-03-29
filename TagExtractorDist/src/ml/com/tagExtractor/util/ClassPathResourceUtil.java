package ml.com.tagExtractor.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class ClassPathResourceUtil {
	public static File toFile(String resourcePath) throws URISyntaxException {
		URL url = ClassPathResourceUtil.class.getClassLoader().getResource(resourcePath);
		if(url == null) {
			System.out.println("url == null");
			System.out.println(resourcePath);
		}
		return new File(url.toURI());
	}
}
