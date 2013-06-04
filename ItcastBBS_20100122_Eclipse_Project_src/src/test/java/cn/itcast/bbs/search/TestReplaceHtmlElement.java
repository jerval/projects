package cn.itcast.bbs.search;

import org.junit.Test;

public class TestReplaceHtmlElement {

	@Test
	public void test() {
		// 用.*?是贪婪匹配
		String r = "<p>aaa</p>saff".replaceAll("<.*?>", "");
		System.out.println(r);
	}
}
