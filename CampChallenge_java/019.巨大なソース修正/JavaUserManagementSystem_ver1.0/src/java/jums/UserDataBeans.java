
package jums;

import java.io.Serializable;


//publicクラスを宣言しています。
//コンストラクタはデフォルトコンストラクタを使用します。
public class UserDataBeans implements Serializable {
    //プロパティidをprivate変数で宣言しています。
    private String name;
    private String year;
    private String month;
    private String day;
    private String tell;
    private String type;
    private String comment;

    //プロパティidのsetメソッドを宣言しています。
    public void setName(String name) {
        //未入力チェック
        if( name == null) {
            { this.name = "";} 
        }else{ 
            { this.name = name;}     
        }
    }
    public void setYear(String year) {
        //未入力チェック
        if( year == null) {
            { this.year = "";} 
        }else{ 
            { this.year = year; }     
        }
    }
    public void setMonth(String month) {
        //未入力チェック
        if( month == null) {
            { this.month = "";} 
        }else{ 
            { this.month = month;}     
        }
    }
    public void setDay(String day) {
        //未入力チェック
        if( day == null) {
            { this.day = "";} 
        }else{ 
            { this.day = day;}     
        }
    }
    public void setTell(String tell) {
        //未入力チェック
        if( tell == null) {
            { this.tell = "";} 
        }else{ 
            { this.tell = tell;}    
        }
    }
    public void setType(String type) {
        //未入力チェック
        if( type == null) {
            { this.type = "";} 
        }else{ 
            { this.type = type;}    
        }
    }
    public void setComment(String comment) {
        //未入力チェック
        if( comment == null) {
            { this.comment = "";} 
        }else{ 
            { this.comment = comment;}     
        }
    }

    //プロパティidのgetメソッドを宣言しています。
    public String getName() { return this.name; }
    public String getYear() { return this.year; }
    public String getMonth() { return this.month; }
    public String getDay() { return this.day; }
    public String getTell() { return this.tell; }
    public String getType() { return this.type; }
    public String getComment() { return this.comment; }
}