<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataDTO udo = (UserDataDTO)session.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        名前:<%= udo.getName()%><br>
        生年月日:<%= udo.getBirthday()%><br>
        種別:<%= jh.exTypenum(udo.getType())%><br>
        電話番号:<%=udo.getTell()%><br>
        自己紹介:<%= udo.getComment()%><br>
        登録日時:<%= udo.getNewDate()%><br><br>
        
        <%--変更.削除ボタンを横並びに変更--%>
        <div style="display:inline-flex">
        <form action="Update" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="update" value="変更"style="width:60px">
        </form><form action="Delete" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="delete" value="削除"style="width:60px">
        </form>
        </div><br><br>
        <%--検索画面へ戻るボタンを追加--%>
        <form action="Search" method="POST">
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="hidden" name="mode" value="REINPUT">
        <input type="submit" name="search" value="検索画面へ戻る"style="width:120px">
        </form><br>
    </body>
    <%=jh.home()%>
</html>
