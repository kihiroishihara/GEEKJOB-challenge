
package org.standard.servlet;

class mozi {
    public static void main(String[] args) {
        String word = "石原希比呂";

        // 文字列の長さを表示
        System.out.println("文字列の長さ：" + (word.length()));
        // 文字列のバイト数を表示
        System.out.println("文字列のバイト数：" + (word.getBytes().length));
        
    }
}