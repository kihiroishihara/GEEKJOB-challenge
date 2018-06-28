package ec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.arnx.jsonic.JSON;



public class Search extends HttpServlet {
 
    // Yahoo!ディベロッパーのAPPIDとYahoo!ショッピングAPIのベースURI
    private static String APP_ID = "dj00aiZpPTlaY2EybDZiZ0J4YSZzPWNvbnN1bWVyc2VjcmV0Jng9MzE-";
    private static String BASE_URI = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
 
    /**
     * YahooショッピングAPIを使って商品データを検索し、Productインスタンスの該当フィールドを補足する
     * @param product
     * @throws IOException
    */
    public static void productData(Product product,HttpServletRequest request) throws IOException{
        HttpSession session = request.getSession();
        
        if(product != null && product.query != null){
            URL url = new URL(BASE_URI+"?appid="+APP_ID+"&query="+product.query);
            HttpURLConnection urlconn = (HttpURLConnection)url.openConnection();
            urlconn.setRequestMethod("GET");
            urlconn.setInstanceFollowRedirects(false);
            urlconn.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlconn.getInputStream(),"UTF-8"));
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
            ArrayList<SearchData> data = parse(product, response);
            session.setAttribute("data",data);
        }
    }
    
    /**
     * JSONテキストをパースして、Productインスタンスの該当フィールドに追加
     * @param product
     * @param jsonText
    */
    private static ArrayList<SearchData> parse(Product product, String jsonText){
        Map<String, Map<String, Object>> json = JSON.decode(jsonText);
        ArrayList<SearchData> productdata = new ArrayList<>();
       
        if( !Integer.valueOf((String) json.get("ResultSet").get("totalResultsAvailable")).equals(0) ){
            for(int i=0; i<10; i++){
                String s = String.valueOf(i);
                @SuppressWarnings("unchecked")
                Map<String, Object> result = ((Map<String, Object>)(
                (Map<String, Map<String, Object>>)json.get("ResultSet").get("0")
                ).get("Result").get(s)
                );
                //名前
                String name = result.get("Name").toString();
                //画像
                @SuppressWarnings("unchecked")
                String imageUrl = ((Map<String, Object>)result.get("Image")).get("Medium").toString();
                //ヒット数
                int available = Integer.valueOf((String) json.get("ResultSet").get("totalResultsAvailable"));
                //商品説明
                String description = result.get("Description").toString();
                //ニックネーム
                String headline = result.get("Headline").toString();
                //価格
                int priceLabel = Integer.valueOf(((Map<String, Object>)result.get("PriceLabel")).get("DefaultPrice").toString());
                //レビュー数
                double review = Double.parseDouble(((Map<String, Object>)result.get("Review")).get("Rate").toString());
                //コード
                String code = result.get("Code").toString();
                
  
                product.name = name;
                product.uri = imageUrl;
                product.totalresultsavailable = available;
                product.description = description;
                product.headline = headline;
                product.price = priceLabel;
                product.review = review;
                product.code = code;
                
                SearchData data = new SearchData();
                data.setTotalResultsAvailable(product.totalresultsavailable);
                data.setQuery(product.query);
                data.setName(product.name);
                data.setUri(product.uri);
                data.setDescription(product.description);
                data.setHeadline(product.headline);
                data.setPrice(product.price);
                data.setReview(product.review);
                data.setCode(product.code);
                data.setSearch(product.search);
                System.out.print(product.code);
                
                productdata.add(data);
            }  
        }
        return productdata;
        
   
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
            }else if(request.getParameter("search").equals("")){
                request.setAttribute("error", "未入力です。");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }else{
                Product product = new Product();
                String target = request.getParameter("search");
                String encodedResult = URLEncoder.encode(target, "UTF-8");
                System.out.println("エンコード結果:" + encodedResult);
                product.search = request.getParameter("search");
                product.query = encodedResult;
                Search.productData(product,request);
                session.setAttribute("search", request.getParameter("search"));
                //search画面にフォワード
                request.getRequestDispatcher("/search.jsp").forward(request, response);
            }
        
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
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
    @Override
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
 
/**
 * 商品データを受け取るクラス
 */
class Product {
    public String query;
    public String name;
    public String uri;
    public int totalresultsavailable;
    public String description;
    public String headline;
    public int price;
    public double review;
    public String code;
    public String search;
}