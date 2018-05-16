
package org.classs.servlet;

public class BlackJack {

    public static void main(String[] args) {
        // Dealerクラスのインスタンス生成
        Dealer dealer = new Dealer();
        // Userクラスのインスタンス生成
        User user = new User();  
        
        
        // ゲーム開始の宣言
        System.out.println("----ゲーム開始----");
        System.out.println(""); 
        
        // DealerとUserにカードを2枚ずつ配る
        // dealで2枚引く
        dealer.setCard(dealer.Deal());
        user.setCard(dealer.Deal());
        System.out.println("Dealerが配られた数は「" + dealer.myCards.get(0) + "」と「" + dealer.myCards.get(1) + "」です。");
        System.out.println("Dealerの現在の合計値は" + dealer.open() + "です。");
        System.out.println("あなたに配られた数は「" + user.myCards.get(0) + "」と「" + user.myCards.get(1) + "」です。");
        System.out.println("あなたに現在の合計値は" + user.open() + "です。");
        // ナチュラルブラックジャック処理
        if (dealer.open() == 21 && user.open() != 21) {
            System.out.println("Dealerがナチュラルブラックジャックで勝利です。");    
        }else if (dealer.open() != 21 && user.open() == 21) {
            System.out.println("あなたがナチュラルブラックジャックで勝利です。");    
        }else if (dealer.open() == 21 && user.open() == 21) {
            System.out.println("Dealer,あなた共にナチュラルブラックジャックで引き分けです。");    
        }else if (dealer.open() > 21 && user.open() > 21) {
            System.out.println("Dealer,あなた共にバーストで引き分けです。");    
        }else{
            System.out.println(""); 
        
            // Dealerのカードの合計値が18未満の時、HIt
            if (dealer.open() < 18) {
                System.out.println("Dealerはヒットします。");            
            }else if (dealer.open() >= 18) {
                System.out.println("Dealerはスタンドします。");
            }
            int countD = 1;
            while (dealer.open() < 18) {
                dealer.setCard(dealer.Hit());
                countD++;
                System.out.println("「" + dealer.myCards.get(countD) + "」が配られました。合計値：" + dealer.open());
            }
       
            // Userのカードの合計値が18未満の時、HIt
            if (user.open() < 18) {
                System.out.println("あなたはヒットします。");    
            }else if (user.open() >= 18) {
                System.out.println("あなたはスタンドします。");
            }
            int countU = 1;
            while (user.open() < 18) {
                user.setCard(dealer.Hit());
                countU++;
                System.out.println("「" +  user.myCards.get(countU) + "」が配られました。合計値：" + user.open());
            }
        
            System.out.println("");
        
            // 結果の表示
            System.out.println("Dealerは「" + dealer.open() + "」,Userは「" + user.open() + "」 で");
            if (dealer.open() <= 21 && dealer.open() >user.open()) {
                System.out.println("Dealerの勝利です。");    
            }else if (dealer.open() < user.open() && user.open() <= 21) {
                System.out.println("あなたの勝利です。");    
            }else if (dealer.open() == user.open()) {
                System.out.println("引き分けです。");    
            }else if (dealer.open() > 21 && user.open() > 21) {
                System.out.println("Dealer,あなた共にバーストで引き分けです。");    
            }else if (dealer.open() > 21 && user.open() <= 21) {
                System.out.println("Dealerがバーストしたので、あなたの勝利です。");    
            }else if (dealer.open() <= 21 && user.open() > 21) {
                System.out.println("あなたがバーストしたので、Dealerの勝利です。");    
            }
        
        
        }
    }
}
   

    
    
    
    
    
    

