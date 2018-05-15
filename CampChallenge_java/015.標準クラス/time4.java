package org.standard.servlet;

import java.util.Calendar;

class Time4 {
    public static void main(String [] args) {
        // カレンダーインスタンスの作成
        Calendar c = Calendar.getInstance();

        // 2015年1月1日 0時0分0秒
        c.set(2015, 0, 1, 0, 0, 0);
        
        // カレンダーインスタンスの作成
        Calendar d = Calendar.getInstance();
        
         // 2015年12月31日 23時59分59秒
        d.set(2015, 11, 31, 23, 59, 59);
        
       // タイムスタンプ表示
        System.out.println(d.getTimeInMillis()-c.getTimeInMillis());
        
        
    }   
}

    

