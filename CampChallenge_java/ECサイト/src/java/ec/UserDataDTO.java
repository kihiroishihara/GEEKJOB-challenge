package ec;

import java.sql.Timestamp;
import java.util.Date;

/**
 * ユーザー情報を持ちまわるJavaBeans
 * データベースのカラムと型に対応させている(DTO)。データの挿入、取り出しどちらにも便利
 * @version 1.00
 * @author hayashi-s
 */
public class UserDataDTO {
    private int userID;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    private Timestamp newDate;
    private int daleteFlg;
    private String itemcode;
    private int type;
    
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;System.out.print("don"+this.name);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        System.out.print("dom"+mail);
        this.mail = mail;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }
    
    public int getDaleteFlg() {
        return daleteFlg;
    }
    public void setDaleteFlg(int daleteFlg) {
        this.daleteFlg = daleteFlg;
    }
    
    public String getItemCode(){
        return itemcode;
    }
    public void setItemCode(String itemcode){
        this.itemcode = itemcode;
    }
    
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

}