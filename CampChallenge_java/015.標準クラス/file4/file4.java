package org.standard.servlet;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class file4 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        int a = 9;
        int b = 4;
        System.out.println("「"+ a + "の" + b + "乗は"+ Math.pow(a, b) + "です。」");
        System.out.println();
        
        File fp = new File("file4.txt");
        // FileReader作成
        FileReader fr = new FileReader(fp);
        // BufferedReader作成
        BufferedReader br = new BufferedReader(fr);
        
        // 1行読み出し
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());

        br.close();  
    }
}