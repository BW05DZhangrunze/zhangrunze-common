package com.zhangrunze.common.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author zhangrunze 字符工具类
 */
public class StringUtils {

	/**
	 * 验证字符串是否为空方法
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		return (null == str || "".equals(str.trim()));
	}

	/**
	 * 是否有值 判断源字符串是否有值，空引号和空格也算没值
	 * 
	 * @param str
	 * @return Boolean
	 */
	public static boolean isHasValue(String str) {
		// 以下两种写法都对
		// return !(null ==str || "".equals(str.trim()));
		return (null != str && !"".equals(str.trim()));
	}

	/**
	 * 验证传入的字符串是不是手机号格式的
	 * @param str
	 * @return
	 */
	public static boolean isTelephone(String str) {
		String pattern = "^(136|135|137|185)\\d{8}$";
		return str.matches(pattern);
	}

	/**
	 * 验证输入字符串是不是Email格式的
	 * @param str
	 * @return Boolean
	 */
	public static boolean isEmail(String str) {

		String pattern = "^\\w+@\\w+\\.[a-zA-Z]{2,3}$";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(str);
		return matcher.matches();
	}

	/**
	 * 验证传入字符串是否全为字母
	 * 
	 * @param str
	 * @return Boolean
	 */
	public static boolean isLetter(String str) {
		String pattern = "^[a-zA-Z]+$";
		return str.matches(pattern);
	}

	/**
	 * 
	 * 获取n位随机英文字符串
	 * 
	 * @param n
	 * @return String
	 */
	public String randomLetterStr(int n) {
		if (n <= 0)
			return "";
		Random random = new Random();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			char letter = (char) ('A' + random.nextInt(26));
			sb.append(letter);
		}
		return sb.toString();
	}

	/**
	 * 获取n位随机英文和数字字符串
	 * 
	 * @param n 获取多少位参数
	 * @return String
	 */
	public String randomStr(int n) {

		char chars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N' };
		// 定义个随机对象
		Random random = new Random();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			// 随机得到一个下标，根据下标从数组当中获取值，拼接到字符串上
			// 随机获取一个下标
			int index = random.nextInt(chars.length);
			char c = chars[index];
			sb.append(c);// 向后拼接

			/*
			 * sb.append( chars[random.nextInt(chars.length)] );
			 */

		}
		return sb.toString();

	}

	/** 获取n个随机中文字符串
	 *  @return String
	 * */
	public static String getRandonCnStr(int n) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(getOneCn());
		}
		return sb.toString();

	}

	/**
	 * 随机获取一个中文字符
	 * 
	 * @return String
	 */
	private static String getOneCn() {

		String str = "";
		int hightPos; //
		int lowPos;
		Random random = new Random();

		hightPos = (176 + Math.abs(random.nextInt(39)));
		lowPos = (161 + Math.abs(random.nextInt(93)));

		byte[] b = new byte[2];
		b[0] = (Integer.valueOf(hightPos)).byteValue();
		b[1] = (Integer.valueOf(lowPos)).byteValue();

		try {
			str = new String(b, "GBK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("错误");
		}

		return str;
	}

	/**
	 * 
	 * @param src
	 * @return Boolean
	 * 判断输入字符串是否有值
	 */
	public static boolean hasText(String src) {
		// 将所有空格进行转换，转换为长度为0的字符串
		String string = src.replaceAll("\\s", "");
		return (!"".equals(string));
	}

	/*
	* 方法功能：将字符串转换成html文本，如果遇到“\n”换行换符，则要将这一段文本使用<p></p>标签
	* 包起来。如果遇到“\n\r”两个在一起按上面\n处理。如果只遇到一个“\r”则替换成<br/>标签。
	* 使用场景：网页文本框传到后台的字符串就可能就会回车换行。
	<p>9月5日一大早，又有了新情况。</p>
	<p>上午9点多，传出中美经贸高级别磋商牵头人通话的消息。</p>
	<p>9月5日上午，中共中央政治局委员、国务院副总理、中美全面经济对话中方牵头人刘鹤应约与美国贸易代表莱特希泽、财政部长姆努钦通话。</p>
	*/

	public static String toHtml(String text) {
		text = text.replaceAll("\\\n\r","\n");
		text = text.replaceAll("\\\r","<br/>");
		String[] split = text.split("(\\\n)");
		StringBuilder builder = new StringBuilder();
			for(String str:split) {
				builder.append("<p>").append(str).append("</p>\n");
			}
		return builder.toString();
	}
}
