package com.digotsoft.awesomeengine.util;

import java.io.*;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Digot
 * @version 1.0
 */
public class Utils {

    /**
     * Logging
     */
    private static final String logFile = "log.txt";

    public static void log(String message){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        String output = Formatter.get("[{0}][{1}] {2}",
                dateFormat.format(date.getTime()),
                Thread.currentThread().getName(),
                message
        );

        try(PrintWriter printWriter = new PrintWriter(logFile)){
            printWriter.append(output);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(output);
    }

    public static String stackTraceToString(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : e.getStackTrace()) {
            sb.append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void dispose(){

    }

}
