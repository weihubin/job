package com.finrun.trading.common.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 字符串工具方法类。
 */
public class StringUtil {
	/**
	 * 生成指定重复数量的字符串组成的新字符串。
	 *
	 * @param text  需要重复的字符串。
	 * @param count 重复次数。
	 * @return 生成的新字符串。
	 */
	public static String repeat(String text, int count) {
		StringBuilder buf = new StringBuilder(text.length() * count);
		int i;

		for (i = 0; i < count; i++)
			buf.append(text);
		return buf.toString();
	}

	/**
	 * 对字符串按指定分隔符进行分割，并返回分隔后字符串组成的数组。
	 * 如果分隔符separator是单个字符，请使用更高效的split(String, char)方法。
	 * 该方法不支持正则表达式，因此较String.split方法具有更高的性能。
	 *
	 * @param string    需要分隔的字符串。
	 * @param separator 分隔符。
	 * @return 分隔字符串组成的数组。
	 * @see com.wb.util.StringUtil#split(String, char)
	 * @see String#split(String)
	 */
	public static String[] split(String string, String separator) {
		return split(string, separator, false);
	}

	/**
	 * 对字符串按指定分隔符进行分割，并返回分隔后字符串组成的数组。
	 * 如果分隔符separator是单个字符，请使用更高效的split(String, char, boolean)方法。
	 * 该方法允许对每个分隔的字符串执行trim操作。
	 * 该方法不支持正则表达式，因此较String.split方法具有更高的性能。
	 *
	 * @param string    需要分隔的字符串。
	 * @param separator 分隔符。
	 * @param trim      是否对每个分隔的字符串执行trim操作。
	 * @return 分隔字符串组成的数组。
	 * @see com.wb.util.StringUtil#split(String, char, boolean)
	 * @see String#split(String)
	 */
	public static String[] split(String string, String separator, boolean trim) {
		int pos = 0, oldPos = 0, index = 0, separatorLen = separator.length();
		ArrayList<Integer> posData = new ArrayList<Integer>();
		if (string == null)
			string = "";
		while ((pos = string.indexOf(separator, pos)) != -1) {
			posData.add(pos);
			pos += separatorLen;
		}
		posData.add(string.length());
		String[] result = new String[posData.size()];
		for (int p : posData) {
			if (trim)
				result[index] = string.substring(oldPos, p).trim();
			else
				result[index] = string.substring(oldPos, p);
			oldPos = p + separatorLen;
			index++;
		}
		return result;
	}

	/**
	 * 对字符串按指定分隔符进行分割，并返回分隔后字符串组成的数组。
	 * 该方法不支持正则表达式，因此较String.split方法具有更高的性能。
	 *
	 * @param string    需要分隔的字符串。
	 * @param separator 分隔符。
	 * @return 分隔字符串组成的数组。
	 * @see com.wb.util.StringUtil#split(String, String)
	 * @see String#split(String)
	 */
	public static String[] split(String string, char separator) {
		return split(string, separator, false);
	}

	/**
	 * 对字符串按指定分隔符进行分割，并返回分隔后字符串组成的数组。
	 * 该方法允许对每个分隔的字符串执行trim操作。
	 * 该方法不支持正则表达式，因此较String.split方法具有更高的性能。
	 *
	 * @param string    需要分隔的字符串。
	 * @param separator 分隔符。
	 * @param trim      是否对每个分隔的字符串执行trim操作。
	 * @return 分隔字符串组成的数组。
	 * @see com.wb.util.StringUtil#split(String, String, boolean)
	 * @see String#split(String)
	 */
	public static String[] split(String string, char separator, boolean trim) {
		int pos = 0, oldPos = 0, index = 0;
		ArrayList<Integer> posData = new ArrayList<Integer>();
		if (string == null)
			string = "";
		while ((pos = string.indexOf(separator, pos)) != -1) {
			posData.add(pos);
			pos++;
		}
		posData.add(string.length());
		String[] result = new String[posData.size()];
		for (int p : posData) {
			if (trim)
				result[index] = string.substring(oldPos, p).trim();
			else
				result[index] = string.substring(oldPos, p);
			oldPos = p + 1;
			index++;
		}
		return result;
	}

	/**
	 * 判断两个字符串是否相等，该比较忽略字符串大小写。
	 *
	 * @param string1 比较的源字符串。
	 * @param string2 比较的目标字符串。
	 * @return 比较结果。如果两个字符串都为null，返回true。
	 * @see com.wb.util.StringUtil#isEqual(String, String)
	 */
	public static boolean isSame(String string1, String string2) {
		if(string1 ==null && string2 == null){
			return true;
		}else if(string1 ==null || string2 == null){
			return false;
		}else {
			return string1.equalsIgnoreCase(string2);
		}
	}

	/**
	 * 判断两个字符串是否相等，该比较区分字符串大小写。
	 * @param string1 比较的源字符串。
	 * @param string2 比较的目标字符串。
	 * @return 比较结果。如果两个字符串都为null，返回true。
	 * @see com.wb.util.StringUtil#isSame(String, String)
	 */
	public static boolean isEqual(String string1, String string2) {
		if(string1 ==null && string2 == null){
			return true;
		}else if(string1 ==null || string2 == null){
			return false;
		}else {
			return string1.equals(string2);
		}
	}

	/**
	 * 使用html textarea标记引用指定文本。
	 * @param text 需要引用的文本。
	 * @return 引用后的文本。
	 */
	public static String textareaQuote(String text) {
		return StringUtil.concat("<textarea>", text, "</textarea>");
	}

	/**
	 * 把指定字符串文本的关键字符(&, <, >, ', 和 ")转换成其对应的html字符。该方法同toHTML的区别
	 *在于前者用于转码后者仅用于显示目的。
	 * @param text 需要转换的文本。
	 * @return 转换后的HTML脚本。
	 */
	public static String toHTMLKey(String text) {
		if (isEmpty(text))
			return "";
		int i, j = text.length();
		StringBuilder out = new StringBuilder(text.length());
		char c;

		for (i = 0; i < j; i++) {
			c = text.charAt(i);
			switch (c) {
			case '&':
				out.append("&amp;");
				break;
			case '<':
				out.append("&lt;");
				break;
			case '>':
				out.append("&gt;");
				break;
			case '\'':
				out.append("&#39;");
				break;
			case '"':
				out.append("&quot;");
				break;
			default:
				out.append(c);
			}
		}
		return out.toString();
	}

	/**
	 * 把指定字符串文本转换成HTML脚本。
	 * @param text 需要转换的文本。
	 * @return 转换后的HTML脚本。
	 */
	public static String toHTML(String text) {
		return toHTML(text, false, true);
	}

	/**
	 * 把指定字符串文本转换成HTML脚本。
	 * @param text 需要转换的文本。
	 * @param nbspAsEmpty 如果文本为空是否使用&amp;nbsp;替代。
	 * @param allowNewLine 是否允许换行，如果不允许则使用&amp;nbsp;替代。
	 * @return 转换后的HTML脚本。
	 */
	public static String toHTML(String text, boolean nbspAsEmpty, boolean allowNewLine) {
		if (isEmpty(text)) {
			if (nbspAsEmpty)
				return "&nbsp;";
			else
				return "";
		}
		int i, j = text.length();
		StringBuilder out = new StringBuilder(text.length());
		char c;

		for (i = 0; i < j; i++) {
			c = text.charAt(i);
			switch (c) {
			case ' ':
				if (i < j - 1 && text.charAt(i + 1) == ' ' || i > 1 && text.charAt(i - 1) == ' ')
					out.append("&nbsp;");
				else
					out.append(" ");
				break;
			case '"':
				out.append("&quot;");
				break;
			case '\'':
				out.append("&#39;");
				break;
			case '<':
				out.append("&lt;");
				break;
			case '>':
				out.append("&gt;");
				break;
			case '&':
				out.append("&amp;");
				break;
			case '\n':
				if (allowNewLine)
					out.append("<br>");
				else
					out.append("&nbsp;");
				break;
			case '\r':
				break;
			case '\t':
				out.append("&nbsp;&nbsp;&nbsp;&nbsp;");
				break;
			default:
				out.append(c);
			}
		}
		return out.toString();
	}

	/**
	 * 查找指定字符串在数组中的位置。如果list参数为null，返回-1。
	 * @param list 查找的数组。
	 * @param string 查找的字符串。
	 * @return 在数组中位置的索引号。
	 */
	public static int indexOf(String list[], String string) {
		int i, j;

		if (list == null)
			return -1;
		j = list.length;
		for (i = 0; i < j; i++)
			if (list[i].equals(string))
				return i;
		return -1;
	}

	/**
	 * 把以字符串形式表达的布尔值转换为对应的数字。字符串比较将忽略大小写。
	 * @param value 以字符串表达的布尔值。
	 * @return 布尔值对应的数字，"true"转换为"1", "false"转换为"0"，其他值保持不变。
	 */
	public static String convertBool(String value) {
		if ("true".equalsIgnoreCase(value))
			return "1";
		else if ("false".equalsIgnoreCase(value))
			return "0";
		else
			return value;
	}

	/**
	 * 连接多个字符串为单个字符串。
	 * @param string 多个字符串列表。
	 * @return 多个字符串连接起来的单个字符串。
	 */
	public static String concat(String... string) {
		int length = 0;
		// 计算StringBuilder初始容量
		for (String str : string)
			length += str.length();
		StringBuilder buf = new StringBuilder(length);
		for (String str : string)
			buf.append(str);
		return buf.toString();
	}

	/**
	 * 查找目标字符在源字符串中出现的次数。
	 * @param source 源字符串。
	 * @param dest 目标字符。
	 * @return 源字符出现的次数。
	 */
	public static int stringOccur(String source, char dest) {
		return stringOccur(source, dest, 0, source.length())[0];
	}

	/**
	 * 查找目标字符在源字符串中出现的次数。
	 * @param source 源字符串。
	 * @param dest 目标字符。
	 * @param startIndex 查找的开始位置。
	 * @param endIndex 查找的结束位置。
	 * @return 查找结果数组，0项出现个数，1项目标字符在源字符串最后一次出现的位置末尾。
	 */
	public static int[] stringOccur(String source, char dest, int startIndex, int endIndex) {
		int result[] = new int[2], newPos, pos = startIndex, count = 0;

		while ((newPos = source.indexOf(dest, pos)) != -1) {
			if (newPos > endIndex)
				break;
			pos = newPos + 1;
			count++;
		}
		result[0] = count;
		result[1] = count == 0 ? (source.lastIndexOf(dest, endIndex) + 1) : pos;
		return result;
	}

	/**
	 * 判断指定字符串是否是正负整数组成的字符串。
	 * @param string 需要判断的字符串。
	 * @return true整数，false不是整数。
	 */
	public static boolean isInteger(String string) {
		int i, j = string.length();
		char ch;

		if (j == 0)
			return false;
		for (i = 0; i < j; i++) {
			ch = string.charAt(i);
			if ((ch < '0' || ch > '9') && (i != 0 || ch != '-'))
				return false;
		}
		return true;
	}

	/**
	 * 把指定字符串的文本转换成单行的字符串。文本中的回车、换行和tab都将被替换为空格。
	 * @param string 需要转换的文本。
	 * @return 转换后的单行字符串。
	 */
	public static String toLine(String string) {
		int i, len = string.length();
		if (len == 0)
			return "";
		StringBuilder buffer = new StringBuilder();
		char c;
		for (i = 0; i < len; i++) {
			c = string.charAt(i);
			switch (c) {
			case '\n':
			case '\r':
			case '\t':
				buffer.append(' ');
				break;
			default:
				buffer.append(c);
			}
		}
		return buffer.toString();
	}

	/**
	 * 获取字符串中“=”前面部分的字符串。如果没找到“=”将返回整个字符串。
	 * @param string 字符串。
	 * @return “=”前面部分的字符串。
	 */
	public static String getNamePart(String string) {
		return getNamePart(string, '=');
	}

	/**
	 * 获取字符串中“=”后面部分的字符串。如果没找到“=”将返回空串。
	 * @param string 字符串。
	 * @return “=”后面部分的字符串。
	 */
	public static String getValuePart(String string) {
		return getValuePart(string, '=');
	}

	/**
	 * 获取字符串中指定分割符前面部分的字符串。如果没找到分割符将返回整个字符串。
	 * @param string 字符串。
	 * @param separator 分割符。
	 * @return 分割符前的字符串。
	 */
	public static String getNamePart(String string, char separator) {
		if (string == null)
			return "";
		int index = string.indexOf(separator);

		if (index == -1)
			return string;
		else
			return string.substring(0, index);
	}

	/**
	 * 获取字符串中指定分割符后面部分的字符串。如果没找到分割符将返回空串。
	 * @param string 字符串。
	 * @param separator 分割符。
	 * @return 分割符后的字符串。
	 */
	public static String getValuePart(String string, char separator) {
		if (string == null)
			return "";
		int index = string.indexOf(separator);

		if (index == -1)
			return "";
		else
			return string.substring(index + 1);
	}

	/**
	 * 全部替换字符串中指定子串为另一字符串。该方法不支持正则表达式，
	 *因此较String.replace具有更高效率。
	 * @param string 需要替换的文本。
	 * @param oldString 替换的源字符串。
	 * @param newString 替换的目标字符串。
	 * @return 替换后的文本。
	 * @see String#replaceAll(String, String)
	 */
	public static String replaceAll(String string, String oldString, String newString) {
		return innerReplace(string, oldString, newString, true);
	}

	/**
	 * 替换字符串中首个指定子串为另一字符串。该方法不支持正则表达式，
	 *因此较String.replace具有更高效率。
	 * @param string 需要替换的文本。
	 * @param oldString 替换的源字符串。
	 * @param newString 替换的目标字符串。
	 * @return 替换后的文本。
	 * @see String#replaceFirst(String, String)
	 */
	public static String replaceFirst(String string, String oldString, String newString) {
		return innerReplace(string, oldString, newString, false);
	}

	/**
	 * 替换字符串中指定子串为另一字符串。该方法不支持正则表达式，
	 *因此较String.replace方法具有更高效率。
	 * @param string 需要替换的文本。
	 * @param oldString 替换的源字符串。
	 * @param newString 替换的目标字符串。
	 * @param isAll 是否替换全部出现的字符串，true替换全部，false替换首个。
	 * @return 替换后的文本。
	 */
	private static String innerReplace(String string, String oldString, String newString, boolean isAll) {
		int index = string.indexOf(oldString);
		if (index == -1)
			return string;
		int start = 0, len = oldString.length();
		if (len == 0)
			return string;
		StringBuilder buffer = new StringBuilder(string.length());
		do {
			buffer.append(string.substring(start, index));
			buffer.append(newString);
			start = index + len;
			if (!isAll)
				break;
			index = string.indexOf(oldString, start);
		} while (index != -1);
		buffer.append(string.substring(start));
		return buffer.toString();
	}

	/**
	 * 获取字符串的省略文本，如果字符串长过超过指定长度，
	 *将使用“...”省略显示，否则直接返回原字符串。
	 * @param string 需要省略显示的字符串。
	 * @param length 最大显示长度。
	 * @return 省略后的字符串。
	 */
	public static String ellipsis(String string, int length) {
		if (string.length() > length)
			return string.substring(0, length - 3) + "...";
		return string;
	}

	/**
	 *对指定字符串进行引用操作，替换字符串中的特殊符号或不可见关键字为转义符，
	 *使字符串可以文本的形式直接显示和表达。字符串本身也加引号。
	 * @param string 需要被引用的字符串。
	 * @return 加引用后的字符串。
	 */
	public static String quote(String string) {
		return quote(string, true);
	}

	/**
	 *对指定对象进行引用操作，先把对象转换为字符串，再替换字符串中的特殊符号或不可见关键字为转义符，
	 *使字符串可以文本的形式直接显示和表达。字符串本身不加引号。
	 * @param value 需要被引用的对象。
	 * @return 加引用后的字符串。
	 */
	public static String text(Object value) {
		return quote(value == null ? null : value.toString(), false);
	}

	/**
	 *对指定字符串进行引用操作，替换字符串中的特殊符号或不可见关键字为转义符，
	 *使字符串可以文本的形式直接显示和表达。
	 * @param string 需要被引用的字符串。
	 * @param addQuotes 字符串是否需要加引号。
	 * @return 加引用后的字符串。
	 */
	public static String quote(String string, boolean addQuotes) {
		int i, len;
		if (string == null || (len = string.length()) == 0)
			if (addQuotes)
				return "\"\"";
			else
				return "";
		char lastChar, curChar = 0;
		String str;
		StringBuilder sb = new StringBuilder(len + 10);

		if (addQuotes)
			sb.append('"');
		for (i = 0; i < len; i++) {
			lastChar = curChar;
			curChar = string.charAt(i);
			switch (curChar) {
			case '\\':
			case '"':
				sb.append('\\');
				sb.append(curChar);
				break;
			case '/':
				if (lastChar == '<')
					sb.append('\\');
				sb.append(curChar);
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\r':
				sb.append("\\r");
				break;
			default:
				if (curChar < ' ' || (curChar >= '\u0080' && curChar < '\u00a0')
						|| (curChar >= '\u2000' && curChar < '\u2100')) {
					sb.append("\\u");
					str = Integer.toHexString(curChar);
					sb.append("0000", 0, 4 - str.length());
					sb.append(str);
				} else
					sb.append(curChar);
			}
		}
		if (addQuotes)
			sb.append('"');
		return sb.toString();
	}

	/**
	 * 如果指定字符串为null则返回空串，否则返回字符串本身。
	 * @param string 字符串。
	 * @return 获得的字符串。
	 */
	public static String opt(String string) {
		if (string == null)
			return "";
		else
			return string;
	}

	/**
	 * 如果指定字符串为null或空串则返回null，否则返回字符串本身。
	 * @param string 字符串。
	 * @return 获得的字符串或null。
	 */
	public static String force(String string) {
		if (isEmpty(string))
			return null;
		else
			return string;
	}

	/**
	 * 返回第1个非空字符串，如果都为空则返回空串。
	 * @param string 字符串列表。
	 * @return 第1个非空字符串或空串。
	 */
	public static String select(String... string) {
		for (String s : string)
			if (!isEmpty(s))
				return s;
		return "";
	}

	/**
	 * 判断指定字符串值逻辑是否为真，'false'(不区分大小写)，'0'，''，null返回false其他返回true。
	 * @param value 判断的字符串值。
	 * @return 布尔值。
	 */
	public static boolean getBool(String value) {
		if (value == null || value.equalsIgnoreCase("false") || value.equals("0") || value.isEmpty())
			return false;
		else
			return true;
	}


	/**
	 * 判断指定的字符串是否为空，空串是指值为null或长度为0。
	 * @param string 需要判断的字符串。
	 * @return true为空，false非空。
	 */
	public static boolean isEmpty(String string) {
		return string == null || string.length() == 0;
	}


	/**
	 * 验证数组中的字符串的合法性。字符必须由字母，数字和下划线组成，其中首字符不能是数字。如果非法将抛出异常。
	 * @param strings 需要被验证的数组对象。
	 */
	public static void checkArray(String[] strings) {
		for (String string : strings) {
			if (!checkName(string))
				throw new RuntimeException("Invalid param \"" + string + "\"");
		}
	}

	/**
	 * 验证name的合法性。name必须由字母，数字和下划线组成。
	 * @param name 需要被验证的字符串对象。
	 * @return true合法，false非法。
	 */
	public static boolean checkName(String name) {
		int i, j = name.length();
		char c;
		for (i = 0; i < j; i++) {
			c = name.charAt(i);
			if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c == '_' || c >= '0' && c <= '9')) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 如果指定名称是由字母、数字和下划线组成的合法名称直接返回，否则将被双引号引用后返回。
	 * @param name 需要引用的名称。
	 * @return 引用后的名称。
	 */
	public static String quoteIf(String name) {
		if (checkName(name))
			return name;
		else
			return quote(name);
	}

	/**
	 * 连接数组中的每个字符串，并以指定分隔符分隔。如果子项为空，则排除该项。
	 * @param strings 需要连接的字符串数组。
	 * @param splitter 分隔字符串。
	 * @return 连接后的字符串。
	 */
	public static String join(String[] strings, String splitter) {
		StringBuilder buf = new StringBuilder();
		boolean added = false;

		for (String s : strings) {
			if (StringUtil.isEmpty(s))
				continue;
			if (added)
				buf.append(splitter);
			else
				added = true;
			buf.append(s);
		}
		return buf.toString();
	}

	/**
	 * 使用单引号引用数组中的每个字符串，并使用逗号连接成单个字符串。如果子项为空，则排除该项。
	 * @param strings 需要连接的字符串数组。
	 * @return 连接后的字符串。
	 */
	public static String joinQuote(String[] strings) {
		return StringUtil.concat("'", join(strings, "','"), "'");
	}

	/**
	 * 判断两个字符串数组中是否存在不为null且相同的字符串。
	 * @param source 源字符串数组。
	 * @param dest 目标字符串数组。
	 * @return true存在相同的字符串，false不存在相同的字符串。
	 */
	public static boolean across(String[] source, String[] dest) {
		if (source == null || dest == null)
			return false;
		for (String s : source) {
			for (String d : dest) {
				if (s != null && s.equals(d))
					return true;
			}
		}
		return false;
	}

	/**
	 * 连接列表中的每个对象，并以指定分隔符分隔。如果子项为空，则排除该项。
	 * @param list 需要连接的列表。
	 * @param splitter 分隔字符串。
	 * @return 连接后的字符串。
	 */
	public static String join(List<String> list, String splitter) {
		StringBuilder buf = new StringBuilder();
		boolean added = false;

		for (String item : list) {
			if (StringUtil.isEmpty(item))
				continue;
			if (added)
				buf.append(splitter);
			else
				added = true;
			buf.append(item);
		}
		return buf.toString();
	}

	/**
	 * 截取字符串指定开始和结束位置的子串。此方法实现同js substring，但不同于java substring方法。
	 * @param string 需要截取的字符串。
	 * @param beginIndex 开始位置。
	 * @param endIndex 结束位置。
	 * @return 截取的子串。
	 */
	public static String substring(String string, int beginIndex, int endIndex) {
		if (string == null)
			return null;
		int len = string.length(), i, j;

		if (beginIndex > endIndex) {
			i = endIndex;
			j = beginIndex;
		} else {
			i = beginIndex;
			j = endIndex;
		}
		if (i < 0)
			i = 0;
		else if (i > len)
			i = len;
		if (j < 0)
			j = 0;
		else if (j > len)
			j = len;
		return string.substring(i, j);
	}

	/**
	 * 把浮点数按指定格式进行格式化并转换为文本值。
	 * @param value 需要格式化的浮点数值。
	 * @return 格式化后的文本值。
	 */
	public static String formatNumber(double value, String format) {
		DecimalFormat df;

		df = new DecimalFormat(format);
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(value);
	}
	
	/**
	 * 把null转为空字符串
	 * @param str
	 * @return
	 */
	public static String getBlank(Object str) {
		return str == null ? "" : str.toString();
	}

	/**
	 * uuid
	 * @return
	 */
	public static String uuid(){
		UUID uuid = UUID.randomUUID();
		return "{"+uuid.toString()+"}";
	}



}