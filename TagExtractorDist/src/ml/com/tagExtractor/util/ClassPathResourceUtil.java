package ml.com.tagExtractor.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ClassPathResourceUtil {
	
	private static File tempDir;
	
	private static String resourcePath = "res";
	
	static {
		tempDir = createTempDir();
		copyResourcesToTempDir();
	}
	
	public static File getFile(String resourcePath) throws URISyntaxException {
		File target = new File(tempDir, resourcePath);
		if(!target.exists()) {
			System.out.println("resource file not found : " + target.getPath());
		}
		return target;
	}
	
	
	private static void copyResourcesToTempDir() {
		tempDir = createTempDir();
		
		String tempPath = "";
		List<String> tempDirPaths = new ArrayList<String>();
		tempDirPaths.add("en");
		tempDirPaths.add("en/opennlp");
		tempDirPaths.add("en/wn");
		
		for(String tempDirPath : tempDirPaths) {
			try {
				createDirInTempDir(tempDirPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		List<String> tempFilePaths = new ArrayList<String>();
		tempFilePaths.add("en/wn_file_props.xml");

		tempFilePaths.add("en/opennlp/EnglishChunk.bin.gz");
		tempFilePaths.add("en/opennlp/EnglishSD.bin.gz");
		tempFilePaths.add("en/opennlp/EnglishTok.bin.gz");
		tempFilePaths.add("en/opennlp/tag.bin.gz");
		tempFilePaths.add("en/opennlp/tagdict");

		tempFilePaths.add("en/wn/adj.exc");
		tempFilePaths.add("en/wn/adv.exc");
		tempFilePaths.add("en/wn/cntlist");
		tempFilePaths.add("en/wn/cntlist.rev");
		tempFilePaths.add("en/wn/data.adj");
		tempFilePaths.add("en/wn/data.adv");
		tempFilePaths.add("en/wn/data.noun");
		tempFilePaths.add("en/wn/data.verb");
		tempFilePaths.add("en/wn/frames.vrb");
		tempFilePaths.add("en/wn/index.adj");
		tempFilePaths.add("en/wn/index.adv");
		tempFilePaths.add("en/wn/index.noun");
		tempFilePaths.add("en/wn/index.sense");
		tempFilePaths.add("en/wn/index.verb");
		tempFilePaths.add("en/wn/log.grind.2.1");
		tempFilePaths.add("en/wn/Makefile");
		tempFilePaths.add("en/wn/Makefile.am");
		tempFilePaths.add("en/wn/Makefile.in");
		tempFilePaths.add("en/wn/noun.exc");
		tempFilePaths.add("en/wn/sentidx.vrb");
		tempFilePaths.add("en/wn/sents.vrb");
		tempFilePaths.add("en/wn/verb.exc");
		tempFilePaths.add("en/wn/verb.Framestext");
		
		for(String filePath : tempFilePaths) {
			try {
				copyResourceToTempDir(filePath);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void createDirInTempDir(String dirPath) throws Exception {
		if(tempDir == null) { throw new Exception("tempDir must created before invoke createDirInTempDir method.");}
		
		File newDir = new File(tempDir + File.separator + dirPath);
		System.out.println("%%%%%%%"+newDir.getPath());
		for (int counter = 0; counter < TEMP_DIR_ATTEMPTS; counter++) {
		    if (newDir.mkdir()) {
		    	return;
		    }else {
		    	System.out.println("error occured createing temp resource dir : " + newDir.getPath());
		    }
		}
		
	}
	
	private static void copyResourceToTempDir(String filePath) throws Exception{
		if(tempDir == null) { throw new Exception("tempDir must created before invoke createDirInTempDir method.");}
		System.out.println(filePath);
		File newDir = new File(tempDir +File.separator + filePath);
		
		InputStream in = ClassPathResourceUtil.class.getClassLoader().getResourceAsStream(resourcePath+"/"+filePath);

	    try {
			FileUtils.copyInputStreamToFile(in, newDir);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error occured createing temp resource file : " + newDir);
		}

	}
	
	private final static int TEMP_DIR_ATTEMPTS = 1000;
	public static File createTempDir() {
		  File baseDir = new File(System.getProperty("java.io.tmpdir"));
		  String baseName = System.currentTimeMillis() + "-";

		  for (int counter = 0; counter < TEMP_DIR_ATTEMPTS; counter++) {
		    File tempDir = new File(baseDir, baseName + counter);
		    System.out.println(tempDir.getPath());
		    if (tempDir.mkdir()) {
		      return tempDir;
		    }
		  }
		  throw new IllegalStateException("Failed to create directory within "
		      + TEMP_DIR_ATTEMPTS + " attempts (tried "
		      + baseName + "0 to " + baseName + (TEMP_DIR_ATTEMPTS - 1) + ')');
	}
	
	
}
