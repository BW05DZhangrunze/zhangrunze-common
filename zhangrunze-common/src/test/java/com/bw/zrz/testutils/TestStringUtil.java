/*
作者：张润泽
创建日期：2019年9月8日 下午7:41:44
类说明：
*/
package com.bw.zrz.testutils;

import com.zhangrunze.common.utils.StringUtils;

public class TestStringUtil {

	public static void main(String[] args) {
		StringUtils stringUtils = new StringUtils();
		boolean hasText = StringUtils.hasText(" 1 ");
		System.out.println(hasText);
	}
}
