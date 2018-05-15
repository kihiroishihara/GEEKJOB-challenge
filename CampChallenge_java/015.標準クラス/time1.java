
package org.standard.servlet;

import java.util.Calendar;

class Time {
    public static void main(String [] args) {
        // カレンダーインスタンスの作成
        Calendar c = Calendar.getInstance();

        // 2016年1月1日 0時0分0秒
        c.set(2016, 0, 1, 0, 0, 0);
        
       // タイムスタンプ表示
        System.out.println(c.getTimeInMillis());      
    }   
}

    

