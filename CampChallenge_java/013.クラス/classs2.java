
package org.classs.servlet;

// 継承
class warai extends Wakuwaku {
    public void wahhahha() {
       // クリアする
       this.name = null ;
       this.age = 0 ; 
       
    }
}
public class classs2 {
    public static void main(String[] args) {
    // インスタンスを生成
    warai www = new warai();
   
    www.Ehehe("にこにこ", 25);
    www.wahhahha();
   
    www.Ufufu();
}
}