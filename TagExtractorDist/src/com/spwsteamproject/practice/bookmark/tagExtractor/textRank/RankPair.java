package com.spwsteamproject.practice.bookmark.tagExtractor.textRank;

public class RankPair {
	private double metric;
	private String tag;
	
	public RankPair(double m, String t) {
		metric = m;
		tag = t;
	}
	
	public double getMetric() {
		return metric;
	}
	public void setMetric(double metric) {
		this.metric = metric;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
}
