package com.fsky.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by FDD on 2018/1/17.
 */
public class DateUtil {

    public static String getNowDateStr() {
        SimpleDateFormat simpleDateFormat = new
                SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = simpleDateFormat.format(new Date());
        return dateStr;
    }
}
