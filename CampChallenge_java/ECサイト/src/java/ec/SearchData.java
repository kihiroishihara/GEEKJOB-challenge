package ec;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ページで入出力されるユーザー情報を持ちまわるJavaBeans。DTOと違い画面表示系への結びつきが強い
 * DTOへの変換メソッド、入力チェックリストを出力するメソッドも準備されている←ちょっと仕事しすぎかも
 * @author hayashi-s
 */
public class SearchData implements Serializable{
    private int totalresultsavailable;
    private String query;
    private String name;
    private String uri;
    private String description;
    private String headline;
    private int price;
    private double review;
    private String code;
    private String search;
    
    
    public SearchData(){
        this.totalresultsavailable = 0;
        this.query = "";
        this.name = "";
        this.uri = "";
        this.description = "";
        this.headline = "";
        this.price = 0;
        this.review = 0;
        this.code = "";
        this.search = "";
    }
    
    public int getTotalResultsAvailable() {
        return totalresultsavailable;
    }
    public void setTotalResultsAvailable(int totalresultsavailable) {
        //空文字(未入力)の場合空文字をセット
        if(totalresultsavailable == 0){
            this.totalresultsavailable = 0;
        }else{
            this.totalresultsavailable = totalresultsavailable;
        }
    }

    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        //空文字(未入力)の場合空文字をセット
        if(query.trim().length()==0){
            this.query = "";
        }else{
            this.query = query;
        }
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

    public String getUri() {
        return uri;
    }
    public void setUri(String uri) {
        //空文字(未入力)の場合空文字をセット
        if(uri.trim().length()==0){
            this.uri = "";
        }else{
            this.uri = uri;
        }
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        //空文字(未入力)の場合空文字をセット
        if(description.trim().length()==0){
            this.description = "";
        }else{
            this.description = description;
        }
    }
    
    public String getHeadline() {
        return headline;
    }
    public void setHeadline(String headline) {
        //空文字(未入力)の場合空文字をセット
        if(headline.trim().length()==0){
            this.headline = "";
        }else{
            this.headline = headline;
        }
    }
    
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        //空文字(未入力)の場合空文字をセット
        if(price == 0){
            this.price = 0;
        }else{
            this.price = price;
        }
    }
    
    public double getReview() {
        return review;
    }
    public void setReview(double review) {
        //空文字(未入力)の場合空文字をセット
        if(price == 0){
            this.review = 0;
        }else{
            this.review = review;
        }
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
    
    public String getSearch() {
        return search;
    }
    public void setSearch(String search) {
        //空文字(未入力)の場合空文字をセット
        if(search.trim().length()==0){
            this.search = "";
        }else{
            this.search = search;
        }
    }
}