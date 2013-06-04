
package com.jvwl.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getTime(){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return sdf.format(new Date());
    }
}
