<%--HttpSession--%>
<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%--JumsHelper--%>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <br>
    <% if(!udb.getName().equals("")&&
          !udb.getYear().equals("")&&
          !udb.getMonth().equals("")&&
          !udb.getDay().equals("")&&
          !udb.getType().equals("")&&
          !udb.getTell().equals("")&&
          !udb.getComment().equals("")){
    %>
    　　<h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <%}else{%>
        <% if(udb.getName().equals("")){ %>・名前<br>
        <% }if(udb.getYear().equals("")||udb.getMonth().equals("")||udb.getDay().equals("")){ %>・生年月日<br>
        <% }if(udb.getTell().equals("")){ %>・電話番号<br>
        <% }if(udb.getType().equals("")){ %>・種別<br>
        <% }if(udb.getComment().equals("")){ %>・自己紹介<br>
        <% }%><p>が未入力です。</p><%}%>
        
        <form action="insert" method="POST">
            
         <br>   <input type="submit" name="no" value="登録画面に戻る">
        </form>
    <br>
        <%--トップページへのリンク--%>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
