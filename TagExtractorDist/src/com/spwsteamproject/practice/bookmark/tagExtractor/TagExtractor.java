package com.spwsteamproject.practice.bookmark.tagExtractor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.spwsteamproject.practice.bookmark.tagExtractor.textRank.RankPair;
import com.spwsteamproject.practice.bookmark.tagExtractor.textRank.english.TextRankEnglish;
import com.spwsteamproject.practice.bookmark.tagExtractor.textRank.korean.TextRankKorean;

public class TagExtractor {
	public List<String> extractTagFromWebPage(String url) throws IOException {
		String text = getTextFromURL(url);
		List<RankPair>krTags = rankKorean(text);
		List<RankPair> engTags = rankEnglish(text);

		return organizeTagList(krTags, engTags);
	}
	
	public List<String> extractTagFromText(String text) {
		List<RankPair>krTags = rankKorean(text);
		List<RankPair> engTags = rankEnglish(text);

		return organizeTagList(krTags, engTags);
	}

	private String getTextFromURL(String url) throws IOException {
		Document doc = Jsoup.connect(url).get();
		return doc.text();
	}
	
	private List<RankPair> rankKorean(String text) {
		TextRankKorean trk = new TextRankKorean();
		return trk.rank(text);
	}
	
	private List<RankPair> rankEnglish(String text) {
		TextRankEnglish tre = new TextRankEnglish();
		return tre.rank(text);
	}
	
	private void narrowToTop10(List<RankPair> tags) {
		if(tags != null) {
			int size = tags.size();
			if(tags.size()>10) {
				for(int i=size-1; i > 9; i--) {
					tags.remove(i);
				}
				
			}
		}
	}
	
	
	/**
	 * 두 태그 리스트를 합치고 metric 수치에 따라 정렬한다.
	 * 
	 * */
	private List<String> organizeTagList(List<RankPair> one, List<RankPair> other) {
		narrowToTop10(one);
		narrowToTop10(other);
		
		List<RankPair> combined = null;
		
		if(one != null) {
			one.addAll(other);
			combined = one;
		}else if(other != null) {
			other.addAll(one);
			combined = other;
		}
		
		if(combined !=null) {
			combined.sort(new Comparator<RankPair>() {
				@Override
				public int compare(RankPair a, RankPair b) {
					if(a.getMetric() >= b.getMetric()) {
						return 1;
					}else {
						return -1;
					}
				}
			});
		}
		
		List<String> ret = new ArrayList<String>();
		for(RankPair pair : combined) {
			ret.add(pair.getTag());
		}
		
		return ret;
		
	}
}
