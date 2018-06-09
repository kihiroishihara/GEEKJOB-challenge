<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
     HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <body>
        <h1>削除確認</h1>
        以下の内容を削除します。よろしいですか？<br>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= udd.getType()%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br><br>
    
        <form action="DeleteResult" method="POST">
            <input type="hidden" name="id" value="<%= udd.getUserID() %>">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="YES" value="はい"style="width:60px">
        </form>
        <br>
        <form action="ResultDetail" method="POST">
            <input type="hidden" name="id" value="<%= udd.getUserID() %>">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="NO" value="詳細画面に戻る"style="width:120px">
        </form>
    </body>
    <br>
    <%--ホームへ戻るリンクの追加--%>
    <%=jh.home()%>
</html>
