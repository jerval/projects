package com.jvwl.util;

public class SQLUtil {

    public static String Replace(String str, String replaceChar, String[] params) {
        if (params == null || params.length == 0) {
        } else {
            for (String s : params) {
                str = str.replaceFirst(replaceChar, s);
            }
        }
        return str;
    }
}
