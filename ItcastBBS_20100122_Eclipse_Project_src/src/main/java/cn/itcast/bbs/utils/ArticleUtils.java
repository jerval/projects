package cn.itcast.bbs.utils;

public class ArticleUtils {

	/**
	 * 移除html中的所有标签，只留文本
	 * 
	 * @param html
	 * @return
	 */
	public static String removeHtmlElements(String html) {
		return html.replaceAll("<.*?>", "　");
	}

	public static String makeHtmlElementsSafe(String html) {
		// FIXME 以下替换做成配置项，可以在后台随时添加与修改，这样发现后就可以马上修改了
		// 1, 去掉script标签。有可能：
		return html.replaceAll("</?(script.*?)>", "&lt;$1&gt;")//
				// 2, 还有可能：<meta http-equiv="refresh" content="1; url=http://bbs.itcast.cn" />
				// 2, 还有可能：<meta http-equiv=refresh content="1; url=http://bbs.itcast.cn" />
				// 2, 还有可能：<meta http-equiv='refresh' content="1; url=http://bbs.itcast.cn" />
				// 2, 还有可能：<meta content="1; url=http://bbs.itcast.cn" http-equiv='refresh'/>
				.replaceAll("</?(meta.*?)>", "&lt;$1&gt;")//
		// 3, 还有可能使用事件：<div onmousemove="javascript:while(true){alert('结束进程吧!');}"></div>
		// 3, 去掉所有的事件
		// 4, 注释 <!-- 或 -->
		;
	}

	// FIXME 放到测试类中
	public static void main(String[] args) {
		String str = removeHtmlElements("<img src=xx />");
		System.out.println("[" + str + "]");

		String html = "</script><font color='red'>red</font><script type=\"text/javascript\"> setTimeout(\"window.location.reload();\",1); </script>";
		System.out.println(makeHtmlElementsSafe(html));
		html = "abc<script type='text/javascript'>settimeout()</script>jaja";
		System.out.println(makeHtmlElementsSafe(html));

		html = "<font color='red'>red</font><meta http-equiv=\"refresh\" content=\"1; url=http://bbs.itcast.cn\" />";
		System.out.println(makeHtmlElementsSafe(html));

		html = "<meta content=\"1; url=http://bbs.itcast.cn\" http-equiv=\"refresh\"  />";
		System.out.println(makeHtmlElementsSafe(html));

		html = "<div onmousemove=\"javascript:while(true){alert('结束进程吧!');}\">xxx</div>";
		System.out.println(makeHtmlElementsSafe(html));

		html = "<div onmousemove=\"javascript:while(true){alert('结束进程吧!');}\" style='red' onmouseout='alert()' onclick=alertMe()\">xxx</div>";
		System.out.println(makeHtmlElementsSafe(html));
	}

}
