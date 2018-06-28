<%@page import="ec.SearchData"%>
<%@page import="ec.ECHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html"
        pageEncoding="UTF-8"
        import="javax.servlet.http.HttpSession"
        import="ec.UserDataDTO"
        import="ec.CartData" %>

<!DOCTYPE html>
<%
    HttpSession hs = request.getSession();
    ArrayList<SearchData> udl = (ArrayList<SearchData>)hs.getAttribute("cl");
%>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>買い物かご</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <style type="text/css">
        body { padding-top: 0px; }
        @media ( min-width: 768px ) {
            #banner {
                min-height: 100px;
                border-bottom: none;
            }
            .bs-docs-section {
                margin-top: 5em;
            }
            .bs-component {
                position: relative;
            }
            .bs-component .modal {
                position: relative;
                top: auto;
                right: auto;
                left: auto;
                bottom: auto;
                z-index: 1;
                display: block;
            }
            .bs-component .modal-dialog {
                width: 90%;
            }
            .bs-component .popover {
                position: relative;
                display: inline-block;
                width: 220px;
                margin: 20px;
            }
            .nav-tabs {
                margin-bottom: 15px;
            }
            .progress {
                margin-bottom: 10px;
            }
        }
        </style>
    </head>
    <body>
        <header>
            <div class="navbar navbar-default navbar-fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <a href="Top" class="navbar-brand">Top</a>
                        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="navbar-collapse collapse" id="navbar-main">
                        <ul class="nav navbar-nav">
                        <%
                            //現在のページの取得
                            StringBuffer url = request.getRequestURL();
                            url.append("?").append(request.getQueryString());
                            //セッションスタート
                            UserDataDTO ud = (UserDataDTO)hs.getAttribute("login");
                            //リクエストパラメータの文字コードをUTF-8に変更
                            request.setCharacterEncoding("UTF-8");
                            //アクセスルートチェック
                            if(hs.getAttribute("login") == null){
                        %>
                                <li><a href="Login?url=Top">ログイン</a></li>         
                        <%   }else{    %>
                                <li><a href="MyData?ac=<%= hs.getAttribute("ac")%>">ようこそ <font Color="DC143C"><%= ud.getName()%></font> さん！</a></li>
                                <li><a href="Cart?ac=<%= hs.getAttribute("ac")%>">買い物かご</a></li>
                                <li><a href="Login">ログアウト</a></li>
                        <%   }    %>
                        </ul>
                    </div>
                </div>
            </div>
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <!-- BootstrapのCSS読み込み -->
            <link href="css/bootstrap.min.css" rel="stylesheet">
            <!-- jQuery読み込み -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
            <!-- BootstrapのJS読み込み -->
            <script src="js/bootstrap.min.js"></script>
        </header>

        <div class="container">
            
            <div class="bs-docs-section">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h1 id="forms">購入確認</h1>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-lg-12">
                        <div class="well bs-component">
                            <% int all = 0;%>
                            <% for(int i=0; i<udl.size(); i++){%>
                            <form class="form-horizontal" action="Cart" method="POST">
                                <fieldset>
                                    <div class="form-group">
                                        <label class="col-lg-10 control-label"><%= udl.get(i).getName()%></label>
                                        <div class="col-lg-2" align="center"><h5>価格：<%= udl.get(i).getPrice()%></h5></div>
                                    </div>
                                    <legend></legend>
                                </fieldset>
                            </form>
                            <% int price = udl.get(i).getPrice();
                               all += price;
                            }%>
                            <fieldset>
                                <form class="form-horizontal" action="BuyComplete" method="POST">
                                    <div class="form-group">
                                    <label class="col-lg-2 control-label"><h4>合計金額　 <%= all%>円</h4></label>
                                        <div class="col-lg-10">
                                            <label class="col-lg-2 control-label"><h5></h5></label>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios" id="optionsRadios1" value="1" checked="">
                                                    クロネコ宅急便
                                                </label>
                                            </div>
                                            <label class="col-lg-2 control-label">配送方法</label>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios" id="optionsRadios2" value="2">
                                                    ゆうパック
                                                </label>
                                            </div>
                                            <label class="col-lg-2 control-label"><h5></h5></label>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="optionsRadios" id="optionsRadios3" value="3">
                                                    店舗で受け取り
                                                </label>
                                            </div>
                                        </div>
                                        <div align="right"class="col-lg-10">
                                            <button type="submit" class="btn btn-primary" >上記の内容で購入する</button>
                                            <input type="hidden" name="name"  value="<%= ud.getName()%>">
                                            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>"> 
                                            <input type="hidden" name="total"  value="<%= all%>">
                                        </div>   
                                    </div> 
                                </form>
                                <div align="right"class="col-lg-10">
                                    <p class="bs-component">
                                         <a href="Cart?ac=<%= hs.getAttribute("ac")%>" class="btn btn-primary">買い物かごへ戻る</a>
                                    </p>
                                </div>
                            </fieldset>
                        </div>
                    </div>
                </div>  
        　　</div>
        </div>
    </body>
</html>








