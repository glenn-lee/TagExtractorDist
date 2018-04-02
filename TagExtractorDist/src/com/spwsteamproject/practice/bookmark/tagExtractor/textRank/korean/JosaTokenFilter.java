package com.spwsteamproject.practice.bookmark.tagExtractor.textRank.korean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JosaTokenFilter {
	
	public static Set<String> josaSet;
	static {
		String josas = "��,����,���μ���,���ʹ�,������,������,����,���κ���,����,�̶��,���ٵ�,�̶�,ġ��,�ϰ�,����,��,��,����,��,�ν�,����,����,����,���Դ�,����,���,�δ�,������,����,������,�̳�,������,����,�̶�,��,��,������,��,��,��,�κ���,��,����,����,���ν�,���,��,�ʹ�,��,����,�μ���,��,�μ�,��,��,�̶��,��,����,��,��,��,����,��,�̸�,����,����,�̴�,����,��,����,�ۿ�,����,����,��,������,���,��,�̰�,���δ�,����,��,��,��,��,ó��,���μ�,���ٴ�,�ε�";
		
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
