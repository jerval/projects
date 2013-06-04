
package com.jvwl.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getTimeLocal(){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return sdf.format(new Date());
    }
    public static String getTime(){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
