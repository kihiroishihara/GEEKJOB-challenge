    <%@page contentType="text/html"
           pageEncoding="UTF-8"
           import="javax.servlet.http.HttpSession"
           import="ec.UserDataDTO" %>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>トップページ</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <style type="text/css">
        body { padding-top: 100px; }
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
                            HttpSession hs = request.getSession();
                            if(request.getParameter("login") != null){
                                session.removeAttribute("login");
                                session.removeAttribute("cl");
                            }
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
                <div class="jumbotron special">
                    <div class="honoka"></div>
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-12 outline">
                                <h1>KIHIRO SHOPPING</h1>
                                <p>yahooAPIを利用して作成したECサイトです。</p>
                            </div>
                            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                <form class="navbar-form navbar-left" role="search" action="Search" method="GET">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="search" placeholder="search">
                                    <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>"> 
                                </div>
                                <button type="submit" class="btn btn-default">検索</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

























