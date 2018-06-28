<%@page contentType="text/html"
        pageEncoding="UTF-8"
        import="javax.servlet.http.HttpSession"
        import="ec.UserDataDTO"
        import="java.net.URLDecoder"
        import="java.util.ArrayList"
        import="java.net.URLEncoder"
        import="ec.ECHelper"
        import="ec.SearchData" %>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>結果一覧</title>
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
                            HttpSession hs = request.getSession();
                            ArrayList<SearchData> udl = (ArrayList<SearchData>)hs.getAttribute("data");
                            UserDataDTO ud = (UserDataDTO)hs.getAttribute("login");
                            //リクエストパラメータの文字コードをUTF-8に変更
                            request.setCharacterEncoding("UTF-8");
                            //アクセスルートチェック
                            if(hs.getAttribute("login") == null){
                        %>
                                <li><a href="Login?url=<%= url%>">ログイン</a></li>      
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
                        <% for(SearchData udll : udl){if(udll.getQuery()!=null){%>
                        <% String target = udll.getQuery();
                           String decodedResult = URLDecoder.decode(target, "UTF-8");%>
                        <h1 id="forms">検索ワード「<%= decodedResult%><% break;}}%>」の検索結果一覧</h1>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-lg-12">
                        <div class="well bs-component">
                            <form class="form-horizontal"  action="" method="POST">
                                <% for(SearchData udll : udl){if(udll.getTotalResultsAvailable()!=0){%>
                                    <div><legend>検索結果数 <%= udll.getTotalResultsAvailable()%> 件</legend><% break;}}%>
                                        <fieldset>
                                        <% for(SearchData udll : udl){%>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label"><img src=<%= udll.getUri()%>></label>
                                            <div class="col-lg-9"><a href="Item?search=<%= udll.getSearch()%>&code=<%= udll.getCode()%>&ac=<%= hs.getAttribute("ac")%>"><%= udll.getName()%></a></div>
                                            <div class="col-lg-9">　</div>
                                            <div class="col-lg-8">価格：<%= udll.getPrice()%></div>
                                        </div><legend></legend>
                                        </fieldset>
                                        <% }%>
                                    </div>  
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-4 col-lg-offset-1">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
                                 