package ec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ページで入出力されるユーザー情報を持ちまわるJavaBeans。DTOと違い画面表示系への結びつきが強い
 * DTOへの変換メソッド、入力チェックリストを出力するメソッドも準備されている←ちょっと仕事しすぎかも
 * @author hayashi-s
 */
public class CartData implements Serializable{
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static CartData getInstance(){
        return new CartData();
    }
    
    private String code;
    
    public CartData(){
        this.code = "";
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        //空文字(未入力)の場合空文字をセット
        if(code.trim().length()==0){
            this.code = "";
        }else{
            this.code = code;
        }
    }
    
    
    
    

    

   

   
}