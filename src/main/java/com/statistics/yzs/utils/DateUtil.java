package com.statistics.yzs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lgq
 * @Desc
 * @create 2019-01-17 14:53
 **/
public class DateUtil {
    public static String getWeekDay(Date date){
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        String currSun = dateFm.format(date);
        return currSun;
    }
}
