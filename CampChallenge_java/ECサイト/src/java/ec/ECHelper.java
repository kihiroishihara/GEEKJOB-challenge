package ec;

// 画面系の処理や表示を簡略化するためのヘルパークラス。

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ECHelper {
    
    //トップへのリンクを定数として設定
    private final String homeURL = "top.jsp";
    //ログインページへのリンクを定数として設定
    private final String loginURL = "login.jsp";
    //ログアウト，トップページへのリンクを定数として設定
    private final String logoutURL = "top.jsp";
    //カートページへのリンクを定数として設定
    private final String cartURL = "cart.jsp";
    //カートページへのリンクを定数として設定
    private final String mydataURL = "mydata.jsp";
    
    public static ECHelper getInstance(){
        return new ECHelper();
    }
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    //ログインページへのリンクを返却
    public String login(){
        return "<a href=\""+loginURL+"\">ログイン</a>";
    }
    //ログアウト，トップページリンクを返却
    public String logout(){
        return "<a href=\""+logoutURL+"\">ログアウト</a>";
    }
    //カートページへのリンクを返却
    public String cart(){
        return "<a href=\""+cartURL+"\">買い物かご</a>";
    }
    //カートページへのリンクを返却
    public String mydata(){
        return "<a href=\""+mydataURL+"\">ようこそ</a>";
    }
    
    
    /**
     * 入力されたデータのうち未入力項目がある場合、チェックリストにしたがいどの項目が
     * 未入力なのかのhtml文を返却する
     * @param chkList　UserDataBeansで生成されるリスト。未入力要素の名前が格納されている
     * @return 未入力の項目に対応する文字列
     */
    public String chkinput(ArrayList<String> chkList){
        String output = "";
        for(String val : chkList){
            if(val.equals("name")){
                output += "名前";
            }
            if(val.equals("password")){
                output +="パスワード";
            }
            if(val.equals("mail")){
                output +="メールアドレス";
            }
            if(val.equals("address1")){
                output +="都道府県";
            }
            if(val.equals("address2")){
                output +="市区町村番地";
            }
            output +="が未記入です<br>";
            }
        return output;
    }
}

