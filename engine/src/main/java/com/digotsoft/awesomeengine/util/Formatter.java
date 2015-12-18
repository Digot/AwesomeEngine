package com.digotsoft.awesomeengine.util;

/**
 * Created on 01.10.2015.
 */
public class Formatter {

    public static String get(String formatString, Object... args) {
        if (args == null || args.length == 0) return formatString;

        String resultString = formatString;

        for (int i = 0; i < args.length; i++) {
            String formatIndex = "{" + i + "}";
            if (!resultString.contains(formatIndex)) {
                throw new IllegalStateException("There were more arguments given than formats given!");
            }

            resultString = resultString.replace(formatIndex, args[i].toString());
        }

        return resultString;
    }

}
