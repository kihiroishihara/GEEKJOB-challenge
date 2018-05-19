<% 
// 受け取るパラメータの文字コード
request.setCharacterEncoding("UTF-8");

// テキストボックスの情報
String Name = request.getParameter("Name");
String Sex = request.getParameter("Sex");
String Text = request.getParameter("Text");
   
// セッションへ"X"という名前で"現在時刻"を登録
HttpSession N = request.getSession();
HttpSession S = request.getSession();
HttpSession T = request.getSession();

N.setAttribute("Name", request.getParameter(Name));
S.setAttribute("Sex", request.getParameter(Sex));
T.setAttribute("Text", request.getParameter(Text));

// セッションから情報を取得
String NN = request.getParameter("Name");
String SS = request.getParameter("Sex");
String TT = request.getParameter("Text");           

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力フィールドの作成と実装</title>
    </head>
    <body>
         <form action="./data8.jsp" method="post">
         <!-- 名前情報（テキストボックスで作成 -->
         <p>氏名<input type="text" name="Name" value=<%out.print(NN);%>></p>
         <!-- 性別情報（ラジオボタンで作成） -->
         <p>男<input type="radio" name="Sex" value="men" checked = <%if(SS == "men")out.print("checked"); %>></p>
         <p>女<input type="radio" name="Sex" value="rady" checked = <%if(SS == "rady")out.print("checked"); %>></p><br>
         <!-- 趣味情報（テキストエリアで作成） --> 
         <p>趣味<textarea name="Text"><%out.print(TT);%></textarea></p>
         <!-- 送信 --> 
         <input type="submit" name="submit" value="送信"
         </form>
     </body>
</html>
