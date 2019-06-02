package com.zz.we.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getDate(){
        DateFormat simpleDateFormat =new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    public static String getDate(String pattern,Date date){
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
}
