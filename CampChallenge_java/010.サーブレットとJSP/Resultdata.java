
package org.camp.servlet;


import java.io.Serializable;
import java.util.Date;

public class Resultdata implements Serializable {
    private Date d ;
    private String luck ;
    
    public Resultdata(){}
    
    public Date getD (){
      return d;  
    }
    
    public void setD (Date d){
      this.d = d ;  
    }
    
    public String getLuck (){
      return luck;  
    }
    
    public void setLuck (String luck){
      this.luck = luck ;  
    } 
     
}
