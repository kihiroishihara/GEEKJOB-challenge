package ec;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t (name,password,mail,address,newDate,daleteFlg) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());System.out.print(ud.getPassword());
            st.setString(3, ud.getMail());System.out.print(ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.setInt(6, 0);
            st.executeUpdate();
            System.out.println("登録完了");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * Nameによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO login(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try{
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("SELECT password,name,userID,total,daleteFlg FROM user_t WHERE name = ?");
            st.setString(1, ud.getName());
            
            rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setPassword(rs.getString("password"));
            resultUd.setUserID(rs.getInt("userID"));
            resultUd.setName(rs.getString("name"));
            resultUd.setDaleteFlg(rs.getInt("daleteFlg"));
            resultUd.setTotal(rs.getInt("total"));
            
            System.out.println("パスワード検索完了");
            
            return resultUd;    
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * Nameによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO mydata(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("SELECT password,name,mail,address,total,newDate,daleteFlg FROM user_t WHERE name = ?");
            st.setString(1, ud.getName());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setPassword(rs.getString("password"));
            resultUd.setMail(rs.getString("mail"));
            resultUd.setName(rs.getString("name"));
            resultUd.setAddress(rs.getString("address"));
            resultUd.setTotal(rs.getInt("total"));
            resultUd.setNewDate(rs.getTimestamp("newDate"));
            resultUd.setDaleteFlg(rs.getInt("daleteFlg"));
            
            System.out.println("情報取り出し完了");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
     /**
     * 更新。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void update(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            // DBManagerによる接続
            con = DBManager.getConnection();
            //PreparedStatementの取得
            st =  con.prepareStatement("UPDATE user_t SET name=?, password=?, mail=?, address=?, newDate=? WHERE userID=?");
            //「？」の置き換え
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.setInt(6, ud.getUserID());
            //SQL文の実行
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * 削除。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void delete(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            // DBManagerによる接続
            con = DBManager.getConnection();
            //PreparedStatementの取得
            st =  con.prepareStatement("UPDATE user_t SET daleteFlg = ? WHERE userID = ?");
            //「？」の置き換え
            st.setInt(1, 1);
            st.setInt(2,  ud.getUserID());
            //SQL文の実行
            st.executeUpdate();
            System.out.println("delete completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void item(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO buy_t (userID,itemCode,type,buyDate) VALUES(?,?,?,?)");
            st.setInt(1, ud.getUserID());
            st.setString(2, ud.getItemCode());
            st.setInt(3, ud.getType());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("登録完了");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    public void updatetotal(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            // DBManagerによる接続
            con = DBManager.getConnection();
            //PreparedStatementの取得
            st =  con.prepareStatement("UPDATE user_t SET total=? WHERE userID=?");
            //「？」の置き換え
            st.setInt(1, ud.getTotal());
            st.setInt(2, ud.getUserID());
            //SQL文の実行
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    public ArrayList<String> history(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try{
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("SELECT itemCode FROM buy_t WHERE userID = ?");
            st.setInt(1, ud.getUserID());
            
            rs = st.executeQuery();
            
            ArrayList<String> ucd = new ArrayList<String>();
            
            while(rs.next()){
            ucd.add(rs.getString("itemcode"));
            }
            
            return ucd; 
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
}
    

    