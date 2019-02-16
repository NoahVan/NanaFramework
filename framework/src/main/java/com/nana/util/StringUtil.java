package com.nana.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author keshawn
 * @date 2017/11/8
 */
public final class StringUtil {

    private static final String UNDER_LINE = "_";

    private static final String URL_PREFIX = "/";

    private static final String BLANK = "";

    private static final String SET = "set";

    private static final String GET = "get";

    private static final int TWO = 2;

    private static final int RADIX = 16;

    private static final String ZERO = "0";

    private static final int UNDERLINE = 95;

    private static final int A = 65;

    private static final int Z = 91;

    private static final String LEFT_SQUARE_BRACKET = "[";

    private static final String LEFT_BRACE = "{";

    private static final String SLASH = "\"";

    private static final Pattern TIME_PATTERN = Pattern.compile("^(((20[0-9][0-9]-(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|(20[0-3][0-9]-(0[2469]|11)-(0[1-9]|[12][0-9]|30))) (20|21|22|23|[0-1][0-9]):[0-5][0-9]:[0-5][0-9])$");

    private StringUtil() {
    }

    public static boolean isEmpty(String string) {
        return string == null || StringUtils.isEmpty(string.trim());
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static String toHex(byte[] hash) {
        StringBuilder buf = new StringBuilder(hash.length * TWO);
        int i;

        for (i = 0; i < hash.length; i++) {
            if (((int) hash[i] & 0xff) < 0x10) {
                buf.append(ZERO);
            }
            buf.append(Long.toString((int) hash[i] & 0xff, RADIX));
        }
        return buf.toString();
    }

    public static boolean checkStringIsAllDigital(String str) {
        return StringUtils.isNumeric(str);
    }

    public static boolean isSame(Object first, Object second) {
        if (first == null && second == null) {
            return true;
        }
        if (first != null && second == null) {
            return false;
        }
        if (first == null && second != null) {
            return false;
        } else {
            return first.equals(second);
        }
    }

    public static String firstToLowerCase(String string) {
        if (isEmpty(string)) {
            return BLANK;
        }
        return (new StringBuilder()).append(Character.toLowerCase(string.charAt(0))).append(string.substring(1)).toString();
    }

    public static String castJsonString(Object object) {
        if (object != null) {
            return castJsonString(object.toString());
        } else {
            return BLANK;
        }
    }

    public static String castJsonString(String string) {
        if (isEmpty(string)) {
            return BLANK;
        }
        if (string.startsWith(LEFT_BRACE) || string.startsWith(LEFT_SQUARE_BRACKET)) {
            return string;
        }
        return SLASH + string + SLASH;
    }

    public static String getSetMethodName(String fieldName) {
        String prefix = SET;
        String fieldFirst = fieldName.substring(0, 1).toUpperCase();
        return prefix + fieldFirst + fieldName.substring(1, fieldName.length());
    }

    public static String getGetMethodName(String fieldName) {
        String prefix = GET;
        String fieldFirst = fieldName.substring(0, 1).toUpperCase();
        return prefix + fieldFirst + fieldName.substring(1, fieldName.length());
    }

    public static String checkUrlPrefix(String requestMapping) {
        String classRequestMapping;
        if (requestMapping.startsWith(URL_PREFIX)) {
            classRequestMapping = requestMapping;
        } else {
            classRequestMapping = URL_PREFIX + requestMapping;
        }
        return classRequestMapping;
    }

    public static String removeLast(String string) {
        if (isEmpty(string)) {
            return BLANK;
        }
        return string.substring(0, string.length() - 1);
    }

    public static boolean checkTimeValid(String patternString) {
        Matcher matcher = TIME_PATTERN.matcher(patternString);
        return matcher.matches();
    }

    public static String camelToUnderlineLowerCase(String camel) {
        return camelToUnderline(camel).toString().toLowerCase();
    }

    public static String camelToUnderlineUpperCase(String camel) {
        return camelToUnderline(camel).toString().toUpperCase();
    }

    private static StringBuilder camelToUnderline(String camel) {
        char[] chars = camel.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char s = chars[i];
            if (s >= A && s <= Z) {
                // _ = 95
                char underline = UNDERLINE;
                stringBuilder.append(underline).append(s);
                continue;
            }
            stringBuilder.append(s);
        }
        return stringBuilder;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
     * 例如：HELLO_WORLD->HelloWorld
     *
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String underLineToCamel(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (isEmpty(name)) {
            return BLANK;
        } else if (!name.contains(UNDER_LINE)) {
            // 不含下划线，仅将首字母小写
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String[] camels = name.split(UNDER_LINE);
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

}