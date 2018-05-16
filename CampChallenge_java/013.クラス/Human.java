package org.classs.servlet;

import java.util.ArrayList;


public abstract class Human{
    // 抽象メソッド
    //openというabstractな公開メソッドを用意してください。
    abstract public int open();{ 
    }
    //setCardというArrayListを引数とした、abstractな公開メソッドを用意してください。
    abstract public void setCard(ArrayList<Integer> myCards);{    
    }
    //checkSumというabstractな公開メソッドを用意してください。
    abstract public boolean checkSum();{ 
    }
    //myCardsというArrayListの変数を用意してください。
    protected ArrayList<Integer> myCards = new ArrayList<Integer>();
       
}
