
package org.standard.servlet;

import java.io.*;

class file2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fp = new File("kihiro.zikosyoukai.txt");

        // FileReader作成
        FileReader fr = new FileReader(fp);
        // BufferedReader作成
        BufferedReader br = new BufferedReader(fr);
        // 1行読み出し
        System.out.print(br.readLine());

        br.close();
    }
}