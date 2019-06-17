package com.irish.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLUtils {
	/**
	 * 
	 * 获取Insert语句后面values 参数信息<br>
	 */
	public static String[] sqlInsertParameter(String sql) {
		int startIndex = sql.indexOf("values");
		int endIndex = sql.length();
		String substring = sql.substring(startIndex + 6, endIndex).replace("(", "").replace(")", "").replace("#{", "")
				.replace("}", "");
		String[] split = substring.split(",");
		return split;
	}

	/**
	 * 
	 * 获取select 后面where语句
	 */
	public static List<String> sqlSelectParameter(String sql) {
		int startIndex = sql.indexOf("where");
		int endIndex = sql.length();
		String substring = sql.substring(startIndex + 5, endIndex);
		String[] split = substring.split("and");
		List<String> listArr = new ArrayList<>();
		for (String string : split) {
			String[] sp2 = string.split("=");
			listArr.add(sp2[0].trim());
		}
		return listArr;
	}

	/**
	 * 将SQL语句的参数替换变为?<br>
	 * 
	 */
	public static String parameQuestion(String sql, String[] parameterName) {
		for (int i = 0; i < parameterName.length; i++) {
			String string = parameterName[i];
			sql = sql.replace("#{" + string + "}", "?");
		}
		return sql;
	}

	public static String parameQuestion(String sql, List<String> parameterName) {
		for (int i = 0; i < parameterName.size(); i++) {
			String string = parameterName.get(i);
			sql = sql.replace("#{" + string + "}", "?");
		}
		return sql;
	}

	public static  String[] sqlUpdateParameter(String updateSql) {
		Pattern pattern = Pattern.compile("#\\{.*?\\}");
		Matcher matcher = pattern.matcher(updateSql);
		int index = 0;
	    List<String> list = new ArrayList<String>();
		while (matcher.find()) {
			String e = matcher.group(0);
			String newString = e.replace("#{", "").replace("}", "");
			list.add(newString);
		}
		return  list.toArray(new String[list.size()]);
	}
	
}
