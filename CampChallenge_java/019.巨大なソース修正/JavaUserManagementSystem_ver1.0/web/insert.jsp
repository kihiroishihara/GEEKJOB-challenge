<%--HttpSession--%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = new UserDataBeans();
    udb = (UserDataBeans) hs.getAttribute("udb"); 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.*" %>
<% 
// 受け取るパラメータの文字コードx
request.setCharacterEncoding("UTF-8");
//初期値
String n = "";
String y = "";
String m = "";
String d = "";
String ty = "";
String te = "";
String c = "";
//udbにデータがあるか否か
if(udb != null){
n = udb.getName();
y = udb.getYear();
m = udb.getMonth();
d = udb.getDay();
ty = udb.getType();
te = udb.getTell();
c = udb.getComment();
}
//種別のボタン処理
String type1 ="";
String type2 ="";
String type3 ="";
if(ty.equals("1")){type1="checked";}
else if(ty.equals("2")){type2="checked";}
else if(ty.equals("3")){type3="checked";}
//生年月日

%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value=<%=n%>>
        <br><br>

        生年月日:
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){%>
            <option value="<%=i%>"> <%=i%> </option>
           <%}if(udb != null){%><option value="<%=y%>" selected> <%=y%> </option><%}%>
            
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <%}if(udb != null){%><option value="<%=m%>" selected> <%=m%> </option><%}%>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"><%=i%></option>
            <%}if(udb != null){%><option value="<%=d%>" selected> <%=d%> </option><%}%>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" <%=type1%>>エンジニア<br>
        <input type="radio" name="type" value="2" <%=type2%>>営業<br>
        <input type="radio" name="type" value="3" <%=type3%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value=<%=te%>>
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard" value=><%=c%></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
        
    </form>
        <br>
        <%--トップページへのリンク--%>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
