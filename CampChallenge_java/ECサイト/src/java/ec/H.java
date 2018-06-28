package ec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.arnx.jsonic.JSON;



public class H {
 
     //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    // Yahoo!ディベロッパーのAPPIDとYahoo!ショッピングAPIのベースURI
    private static String APP_ID = "dj00aiZpPTlaY2EybDZiZ0J4YSZzPWNvbnN1bWVyc2VjcmV0Jng9MzE-";
    private static String BASE_URI = "https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup";
 
    /**
     * YahooショッピングAPIを使って商品データを検索し、Productインスタンスの該当フィールドを補足する
     * @param product
     * @throws IOException
    */
    public static void productData(Product product,HttpServletRequest request) throws IOException{
        HttpSession session = request.getSession();
        
        if(product != null && product.code != null){
            URL url = new URL(BASE_URI+"?appid="+APP_ID+"&itemcode="+product.code);
            HttpURLConnection urlconn = (HttpURLConnection)url.openConnection();
            urlconn.setRequestMethod("GET");
            urlconn.setInstanceFollowRedirects(false);
            urlconn.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlconn.getInputStream()));
            StringBuffer responseBuffer = new StringBuffer();
            while (true){
                String line = reader.readLine();
                if ( line == null ){
                    break;
                }
                responseBuffer.append(line);
            }
            reader.close();
            urlconn.disconnect();
            String response = responseBuffer.toString();
            SearchData datas = parse(product, response);
            ArrayList<SearchData> productdata1 = new ArrayList<>();
              productdata1.add(datas);
              System.out.print(datas.getName());
            session.setAttribute("hih", datas);
        }
    }
    
    /**
     * JSONテキストをパースして、Productインスタンスの該当フィールドに追加
     * @param product
     * @param jsonText
    */
    private static SearchData parse(Product product, String jsonText){
        Map<String, Map<String, Object>> json = JSON.decode(jsonText);
        
       
    //  if( !Integer.valueOf((String) json.get("ResultSet").get("totalResultsReturned")).equals(0) ){
            @SuppressWarnings("unchecked")
                Map<String, Object> result = ((Map<String, Object>)(
                (Map<String, Map<String, Object>>)json.get("ResultSet").get("0")
                ).get("Result").get("0")
                );
                //名前
                String name = result.get("Name").toString();
                
                product.name = name;
                
                SearchData data3 = new SearchData();
                data3.setName(product.name);
                System.out.print(name);
               
               
         //   }  
        
        return data3;
        
   
    }
    protected void processRequest(HttpServletRequest request, SearchData ud)throws ServletException, IOException {
        
        
        
        try{
            //リクエストパラメータの文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");
            
           
            
            Product product = new Product();
                product.code = ud.getCode() ;
                Item.productData(product,request);
            
            
            
            
        }catch(Exception e){
        }
            
    }

    
}

