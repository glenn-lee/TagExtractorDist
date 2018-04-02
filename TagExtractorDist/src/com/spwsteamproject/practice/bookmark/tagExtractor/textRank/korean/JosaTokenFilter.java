package com.spwsteamproject.practice.bookmark.tagExtractor.textRank.korean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JosaTokenFilter {
	
	public static Set<String> josaSet;
	static {
		String josas = "가,와의,으로서의,부터는,에서도,까지는,마다,으로부터,과는,이라는,보다도,이라,치고,하고,만에,는,요,과를,나,로써,만의,조차,에게,에게는,부터,토록,로는,에서는,으로,으로의,이나,만으로,만이,이라도,은,와,까지의,을,도,아,로부터,니,에선,과의,으로써,대로,만,와는,에,에서,로서의,엔,로서,의,께,이라고,로,에는,라도,고,든,까지,다,이며,에만,보다,이다,로의,여,에도,밖에,같이,만을,며,에서의,라고,이,이고,으로는,보고,를,과,라,야,처럼,으로서,보다는,로도";
		
		List<String> josaList = Arrays.asList(josas.split(","));
		
		josaSet = new HashSet<String>();
		
		for(String josa : josaList) {
			josaSet.add(josa);
		}
		
	}
	
	public static boolean isNotJosa(String token) {
		return !josaSet.contains(token);
	}
}
