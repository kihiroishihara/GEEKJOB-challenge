package org.standard.servlet;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


class Time3 {
    public static void main(String [] args) {
        // カレンダーインスタンスの作成
        Calendar c = Calendar.getInstance();

        // 「2016年11月4日 10時0分0秒」
        c.set(2016, 10, 4, 10, 0, 0);
        
       // タイムスタンプ表示
        System.out.println(c.getTimeInMillis());
        long d = c.getTimeInMillis();
        
        
        // SimpleDateFormat作成
        SimpleDateFormat sdf =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 表示
        System.out.print(sdf.format(d));
           
    }
    
    
        
    }
