
package org.standard.servlet;

class mozi3 {
    public static void main(String[] args) {
        String word = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        
        // 文字の置換 -- "U"を"う"に
        String word1 = word.replace("U", "う");
        // 文字の置換（既に"U"を"う"になったward1を） -- "I"を"い"に
        System.out.print(word1.replace("I", "い"));
    }
}