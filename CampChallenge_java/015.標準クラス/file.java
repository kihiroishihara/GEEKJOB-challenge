
package org.standard.servlet;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class file {
    public static void main(String[] args) throws IOException{
        // ファイルオープン
        File fp = new File("kihiro.zikosyoukai.txt");

        // FileWriter作成
        FileWriter fw = new FileWriter(fp);
        // 書き込み
        fw.write("私の名前は石原希比呂です。かきこかきこ。");
        // クローズ
        fw.close();
    }
}