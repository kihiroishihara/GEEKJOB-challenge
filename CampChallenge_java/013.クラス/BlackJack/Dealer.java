package org.classs.servlet;

import java.util.ArrayList;
import java.util.Random;

//Humanを継承
public class Dealer extends Human{
    
    //cardsというArrayListの変数を用意
    ArrayList<Integer> cards = new ArrayList<Integer>();
    
    //初期処理でこのcardsに全てのトランプを持たせてください。
    //for文を使ってカードの数値を1から13まで数えあげ---l，それぞれを4回ずつ山札cardsに追加しましょう---i。
    //追加は，ArrayList のメソッドである add( ... ) によって行ないましょう。
    //なお，ブラックジャックでは11〜13のカードも10として扱う必要があります。
    //この点については if 文を使うと良いでしょう。

    
    public Dealer () {
        for (int i = 1; i <= 4; i++) {
            for (int l = 1; l <= 13; l++) {
                if (l >= 10){
                    cards.add(10);
                }else{
                  cards.add(i);  
                
                }
            }
            
            
        }   
    }
    
    	

    //dealという公開メソッドを用意し、
    public ArrayList<Integer> Deal () {
        //cardsからランダムで2枚のカードをArrayListにして返却してください。
        ArrayList<Integer> deal = new ArrayList();
        
        for (int i = 0; i <= 1; i++) {
            Random ccc = new Random();
            Integer index = ccc.nextInt(cards.size());
            deal.add(cards.get(index));
            cards.remove(index);
        }
        return deal;                      
    }

    //hitという公開メソッドを用意し、
    public ArrayList<Integer> Hit () {
        //cardsからランダムで1枚のカードをArrayListにして返却してください。
        ArrayList<Integer> deal = new ArrayList();
        
        Random ccc = new Random();
        Integer index = ccc.nextInt(cards.size());
        deal.add(cards.get(index));
        cards.remove(index);
        
        return deal;                      
    }

     //setCardは、ArrayListで受けたカード情報をmyCardsに追加するように実装してください。
    @Override
    public void setCard(ArrayList<Integer> hand){  
        for(int i = 0 ; i < hand.size() ; i++){
            myCards.add(hand.get(i));   
        }    
    }
    
    //openは、myCardsのカードの合計値を返却するように実装してください。
    @Override
    public int open(){ 
        
        int total = 0;
        for(int i = 0 ; i < myCards.size() ; i++){
            Integer number = (Integer)myCards.get(i);
            total = total + number;
        }
        
        return total;
    }
    
    //checkSumは、myCardsを確認し、まだカードが必要ならtrue、必要無ければfalseを返却するように実装してください。
    @Override
    public boolean checkSum(){ 
        int total = open();
   
        if (total <= 20){
            return true;
        }else{
            return false;
        }
    }

    
}




