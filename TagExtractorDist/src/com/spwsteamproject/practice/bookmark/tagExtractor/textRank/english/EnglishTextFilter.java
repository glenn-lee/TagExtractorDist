package com.spwsteamproject.practice.bookmark.tagExtractor.textRank.english;

public class EnglishTextFilter {
	/**
	 * remove non-ascii characters
	 * */
	public static String filter(String text) {
		
		if(text == null)
			return null;
		
		// strips off all non-ASCII characters
        text = text.replaceAll("[^\\x00-\\x7F]", "");

        // removes non-printable characters from Unicode
        text = text.replaceAll("\\p{C}", "");
		
		return text;
	}
	


	 
}
