package cn.itcast.bbs.utils.web;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class ReturnPathUtilsTest {

	@Test
	public void testDecodeReturnPath() {
		String encodedPath = "aHR0cDovL2xvY2FsaG9zdDo4MDgwL0l0Y2FzdEJCUy90ZXN0LmpzcA==";

		byte[] buf = Base64.decodeBase64(encodedPath.getBytes());
		String decodedPath = new String(buf);
		System.out.println("地址为：" + decodedPath);
	}
}
