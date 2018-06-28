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



public class Item extends HttpServlet {
 
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
            URL url = new URL(BASE_URI+"?appid="+APP_ID+"&itemcode="+product.code+"&responsegroup=large");
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
            ArrayList<SearchData> datas = parse(product, response);
            session.setAttribute("datass", datas);
        }
    }
    
    /**
     * JSONテキストをパースして、Productインスタンスの該当フィールドに追加
     * @param product
     * @param jsonText
    */
    private static ArrayList<SearchData> parse(Product product, String jsonText){
        Map<String, Map<String, Object>> json = JSON.decode(jsonText);
        ArrayList<SearchData> productdata1 = new ArrayList<>();
       
    //  if( !Integer.valueOf((String) json.get("ResultSet").get("totalResultsReturned")).equals(0) ){
            @SuppressWarnings("unchecked")
                Map<String, Object> result = ((Map<String, Object>)(
                (Map<String, Map<String, Object>>)json.get("ResultSet").get("0")
                ).get("Result").get("0")
                );
                //名前
                String name = result.get("Name").toString();
                //画像
                @SuppressWarnings("unchecked")
                String imageUrl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
                //商品説明
                String description = result.get("Description").toString();
                //ニックネーム
                String headline = result.get("Headline").toString();
                //価格
                int priceLabel = Integer.valueOf(((Map<String, Object>)result.get("PriceLabel")).get("DefaultPrice").toString());
                //レビュー数
                double review = Double.parseDouble(((Map<String, Object>)result.get("Review")).get("Rate").toString());
                
  
                product.name = name;
                product.uri = imageUrl;
                product.description = description;
                product.headline = headline;
                product.price = priceLabel;
                product.review = review;
                
               
                SearchData data2 = new SearchData();
                data2.setName(product.name);
                data2.setUri(product.uri);
                data2.setDescription(product.description);
                data2.setHeadline(product.headline);
                data2.setPrice(product.price);
                data2.setReview(product.review);
                data2.setSearch(product.search);
                data2.setCode(product.code);
                
                
                
                productdata1.add(data2);
         //   }  
        
        return productdata1;
        
   
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        //セッションスタート
        HttpSession session = request.getSession();
        
        try{
            //リクエストパラメータの文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");
            
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");   
            }
            
            Product product = new Product();
            product.search = request.getParameter("search");
            product.code = request.getParameter("code"); 
            Item.productData(product,request);
            
            //registration画面にフォワード
            request.getRequestDispatcher("/item.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
 
