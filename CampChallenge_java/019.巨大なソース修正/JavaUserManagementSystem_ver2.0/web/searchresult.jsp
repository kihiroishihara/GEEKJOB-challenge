<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" 
        import="jums.UserDataDAO" 
        import="java.text.SimpleDateFormat" 
        import="java.util.ArrayList"
        import="java.util.List"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    List<UserDataDTO> udl = (ArrayList<UserDataDTO>) request.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <% for(UserDataDTO ud : udl) { %>
            <tr>
                <td><a href="ResultDetail?id=<%= ud.getUserID()%>"><%= ud.getName()%></a></td>
                <%--生年月日表示から生年表示に変更。--%>
                <td><%= new SimpleDateFormat("yyyy").format(ud.getBirthday())%></td>
                <%--種別を番号ではなく種別名で表示するように変更。--%>
                <td><%= jh.exTypenum(ud.getType())%></td>
                <td><%= ud.getNewDate()%></td>
            </tr>
            <%}%>
        </table><br>
        <%--検索画面に戻るボタンを追加--%>
        <form action="Search" method="POST">
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="hidden" name="mode" value="REINPUT">
        <input type="submit" name="search" value="検索画面へ戻る"style="width:120px">
        </form><br>
    </body>
    <%=jh.home()%>
</html>
