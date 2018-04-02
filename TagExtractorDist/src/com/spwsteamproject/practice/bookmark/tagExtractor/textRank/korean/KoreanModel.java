package com.spwsteamproject.practice.bookmark.tagExtractor.textRank.korean;

import java.util.List;

import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.tokenizer.Sentence;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer.KoreanToken;

import scala.collection.Seq;
import scala.collection.mutable.ArraySeq;



public class KoreanModel {
	
	private String textSource;
	
	private CharSequence normalizedSource;
	
	private String[] sentences;
	
	public KoreanModel(String textSource) {
		this.textSource = textSource;
		normalizedSource = TwitterKoreanProcessorJava.normalize(textSource);
	}
	
	public List<Sentence> splitSentence() {
		List<Sentence> sentences = TwitterKoreanProcessorJava.splitSentences(normalizedSource);
		return sentences;
	}
	
	public Seq<KoreanToken> extractPhrases(String text) {
		return TwitterKoreanProcessorJava.tokenize(text);
	}
	
	public Seq<KoreanToken> tokenize(String text) {
		return TwitterKoreanProcessorJava.tokenize(text);
	}
	
	public Seq<KoreanToken> stem(Seq<KoreanToken> singleToken) {
		return TwitterKoreanProcessorJava.stem(singleToken);
	}
	
	public String getNodeKey(KoreanToken singleToken, String pos) {
		return pos.substring(0, 4) + singleToken.text();
	}
	
	public boolean isRelevant(String pos, String token) {
		return pos.equals("Noun") && token.length() > 1 && JosaTokenFilter.isNotJosa(token);
	}
	
	public boolean isNoun(String pos) {
		return pos.equals("Noun");
	}
	
}
