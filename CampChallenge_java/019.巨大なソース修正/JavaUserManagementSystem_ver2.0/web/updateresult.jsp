<%@page import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper" 
        import="jums.UserDataBeans"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udbu = (UserDataBeans)request.getAttribute("udbu");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <h1>変更結果</h1><br>
        名前:<%= udbu.getName()%><br>
        生年月日:<%= udbu.getYear()+"年"+udbu.getMonth()+"月"+udbu.getDay()+"日"%><br>
        種別:<%= jh.exTypenum(udbu.getType())%><br>
        電話番号:<%= udbu.getTell()%><br>
        自己紹介:<%= udbu.getComment()%><br><br>
        以上の内容で変更しました。<br>
    </body><br>
     <%--検索画面に戻るボタンを追加--%>
        <form action="Search" method="POST">
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="search" value="検索画面へ戻る"style="width:120px">
        </form><br>
    <%=jh.home()%>
    </body>
</html>
