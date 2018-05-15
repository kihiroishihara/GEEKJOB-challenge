
package org.classs.servlet;

// クラスの宣言
class Wakuwaku {
    // フィールドの宣言
    public String name = "";
    public int age = 0;

    // メソッド1の宣言
    public void Ehehe(String n, int a) {
        // 引数をフィールドへ設定
        this.name = n;
        this.age = a;
    }
    // メソッド2の宣言
    public void Ufufu() {
        // 画面表示
        System.out.println("名前：" + name);
        System.out.println("年齢：" + age);
    }
}


// 実行
public class classs {

    public static void main(String[] args) {
        // インスタンス生成
        Wakuwaku nico = new Wakuwaku();
        // フィールド
        nico.age = 18;
        nico.name = "にこにこ";

        // メソッド
        nico.Ehehe("わはは本舗", 88);
        // メソッド2
        nico.Ufufu();
    }
    
    
}