
package org.classs.servlet;

import java.util.ArrayList;

//Humanを継承
public class User extends Human{

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
   
        if (total <=20){
            return true;
        }else{
            return false;
        }
    }
}
    
    
    
    
