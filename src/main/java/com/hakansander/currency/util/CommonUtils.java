package com.hakansander.currency.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
    public static String getCurrentDate() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        return formatter.format(date);
    }
}
