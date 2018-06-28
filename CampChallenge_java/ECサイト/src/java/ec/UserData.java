package ec;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ページで入出力されるユーザー情報を持ちまわるJavaBeans。DTOと違い画面表示系への結びつきが強い
 * DTOへの変換メソッド、入力チェックリストを出力するメソッドも準備されている←ちょっと仕事しすぎかも
 * @author hayashi-s
 */
public class UserData implements Serializable{
    private String name;
    private String password;
    private String mail;
    private String address1;
    private String address2;
    private String address3;
    private String address;
    private String itemcode;
    private String type;
    private String userid;
    private String total;
    
    public UserData(){
        this.name = "";
        this.password = "";
        this.mail = "";
        this.address1 = "";
        this.address2 = "";
        this.address3 = "";
        this.address = "";
        this.itemcode = "";
        this.type = "";
        this.total = "";
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        //空文字(未入力)の場合空文字をセット
        if(name.trim().length()==0){
            this.name = "";
        }else{
            this.name = name;
        }
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        //空文字(未入力)の場合空文字をセット
        if(password.trim().length()==0){
            this.password = "";
        }else{
            this.password = password;
        }
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        //空文字(未入力)の場合空文字をセット
        if(mail.trim().length()==0){
            this.mail = "";
        }else{
            this.mail = mail;
        }
    }

    public String getAddress1() {
        return address1;
    }
    public void setAddress1(String address1) {
        //空文字(未入力)の場合空文字をセット
        if(address1.equals("都道府県")){
            this.address1 = "";
        }else{
            this.address1 = address1;
        }
    }
    
    public String getAddress2() {
        return address2;
    }
    public void setAddress2(String address2) {
        //空文字(未入力)の場合空文字をセット
        if(address2.trim().length()==0){
            this.address2 = "";
        }else{
            this.address2 = address2;
        }
    }
    
    public String getAddress3() {
        return address3;
    }
    public void setAddress3(String address3) {
        //空文字(未入力)の場合空文字をセット
        if(address3.trim().length()==0){
            this.address3 = "";
        }else{
            this.address3 = address3;
        }
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        //空文字(未入力)の場合空文字をセット
        if(type.trim().length()==0){
            this.type = "";
        }else{
            this.type = type;
        }
    }
    
    public String getUserID() {
        return userid;
    }
    public void setUserID(String userid) {
        //空文字(未入力)の場合空文字をセット
        if(userid.trim().length()==0){
            this.userid = "";
        }else{
            this.userid = userid;
        }
    }
    
    public String getItemcode() {
        return itemcode;
    }
    public void setItemcode(String itemcode) {
        //空文字(未入力)の場合空文字をセット
        if(itemcode.trim().length()==0){
            this.itemcode = "";
        }else{
            this.itemcode = itemcode;
        }
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        //空文字(未入力)の場合空文字をセット
        if(address.trim().length()==0){
            this.address = "";
        }else{
            this.address = address;
        }
    }
    
     public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        //空文字(未入力)の場合空文字をセット
        if(total.trim().length()==0){
            this.total = "";
        }else{
            this.total = total;
        }
    }
    
    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.password.equals("")){
            chkList.add("password");
        }
        if(this.mail.equals("")){
            chkList.add("mail");
        }
        if(this.address1.equals("")){
            chkList.add("address1");
        }
        if(this.address2.equals("")){
            chkList.add("address2");
        }
        
        return chkList;
    }

    public void UD2DTOMapping(UserDataDTO udd){
        udd.setName(this.name);
        udd.setPassword(this.password);System.out.print("mapp"+this.name);
        udd.setMail(this.mail);System.out.print("mapp"+this.mail);
        udd.setAddress(this.address1 + this.address2 + this.address3 + this.address);
        udd.setItemCode(this.itemcode);
        
    }
}

