
package org.standard.servlet;

import java.util.Date;
import java.text.SimpleDateFormat;

class Time2 {
    public static void main(String[] args) {
        // 今日の日付作成
        Date now = new Date();
        // SimpleDateFormat作成
        SimpleDateFormat sdf =
            new SimpleDateFormat("現在の時刻は　yyyy年MM月dd日 HH時mm分ss秒");
        // 表示
        System.out.print(sdf.format(now));
    }
}