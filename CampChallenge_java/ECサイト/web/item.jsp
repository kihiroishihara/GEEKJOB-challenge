<%@page import="ec.SearchData"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html"
        pageEncoding="UTF-8"
        import="javax.servlet.http.HttpSession"
        import="ec.UserDataDTO" %>

<!DOCTYPE html>
<%  //セッションスタート
    HttpSession hs = request.getSession();
 %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>商品詳細</title>
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
                            ArrayList<SearchData> udll = (ArrayList<SearchData>)session.getAttribute("datass");
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
                        <h1 id="forms">商品詳細</h1>
                    </div>
                </div>
                <form class="form-horizontal" action="Add"  method="POST">
                    
                            <div class="form-group">
                                <div align="right">
                                    <button type="submit" class="btn btn-primary">カートに追加</button>
                                    <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                                    <% for(SearchData udl : udll){%>
                                    <input type="hidden" name="name"  value="<%= udl.getName()%>">
                                    <input type="hidden" name="price"  value="<%= udl.getPrice()%>">
                                    <input type="hidden" name="uri"  value="<%= udl.getUri()%>">
                                    <input type="hidden" name="code"  value="<%= udl.getCode()%>">
                                    <input type="hidden" name="search"  value="<%= udl.getSearch()%>"><%}%>
                                </div>
                             </div>
                        </form>
                
                <div class="row">
                    <div class="col-lg-12">
                        <div class="well bs-component">
                            <% for(SearchData udl : udll){%>
                            <% if(hs.getAttribute("cart")!=null){%>
                            <form class="form-horizontal" action="Search?search=<%= udl.getSearch()%>"  method="POST">
                            <% }else{%>
                            <form class="form-horizontal" action="Cart"  method="POST">
                            <%}%>
                                 <legend>
                                    <label class="col-lg-2 control-label"><img src=<%= udl.getUri()%>><br><br></label>
                                    <div class="col-lg-9"><br><%= udl.getName()%></div>
                                    
                                </legend>
                                    <fieldset>
                                        <div class="form-group">
                                            <div class="col-lg-9 col-lg-offset-1"><h3><%= udl.getHeadline()%></h3></div>
                                            <div class="col-lg-9 col-lg-offset-1"><h4></h4></div>
                                            <div class="col-lg-9 col-lg-offset-1">【商品説明】</div>
                                            <div class="col-lg-9 col-lg-offset-1"><%= udl.getDescription()%></div>
                                            <div class="col-lg-9 col-lg-offset-1"><h4></h4></div>
                                            <div class="col-lg-9 col-lg-offset-1">【通常販売価格】<%= udl.getPrice()%> 円</div>
                                            <div class="col-lg-9 col-lg-offset-1"><h4></h4></div>
                                            <div class="col-lg-9 col-lg-offset-1">【レビュー平均評価】<%= udl.getReview()%></div>
                                         </div>
                                         <% if(hs.getAttribute("cart")!=null){%>
                                         <div class="form-group">
                                            <div class="col-lg-10 col-lg-offset-1">
                                                <button type="submit" class="btn btn-primary">検索結果一覧へ戻る</button>
                                                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>"> 
                                            </div>
                                    　　　</div>
                                         <% }else{%>
                                         <div class="form-group">
                                            <div class="col-lg-10 col-lg-offset-1">
                                                <button type="submit" class="btn btn-primary">カートへ戻る</button>
                                                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>"> 
                                            </div>
                                    　　　</div>
                                         <%}%>
                                </fieldset>
                                <%}%>
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




 
        