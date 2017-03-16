package com.sparrow.util;

import org.mozilla.universalchardet.UniversalDetector;

import com.sparrow.constants.SysConst;

/**
 * 
 * <p>
 * Title: StringUtils
 * </p>
 * <p>
 * Description: 字符串工具类
 * </p>
 * 
 * @author wjc
 * @date 2017年3月15日
 */
public class StringUtils {

	private StringUtils() {
	}

	/**
	 * 根据字节数组，猜测可能的字符集，如果猜测失败，返回utf-8
	 * 
	 * @param bytes
	 *            待检测的字节数组
	 * @return 可能的字符集，如果检测失败，返回utf-8
	 */
	public static String guessEncoding(byte[] bytes) {
		String defaultEncoding = SysConst.ENCODING_UTF_8;

		UniversalDetector detector = new UniversalDetector(null);
		detector.handleData(bytes, 0, bytes.length);
		detector.dataEnd();
		String encoding = detector.getDetectedCharset();
		detector.reset();
		if (encoding == null) {
			encoding = defaultEncoding;
		}
		return encoding;
	}

}
