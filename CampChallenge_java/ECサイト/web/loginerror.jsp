<%@page contentType="text/html"
        pageEncoding="UTF-8"
        import="javax.servlet.http.HttpSession" 
        import="ec.UserDataDTO"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ログインページ</title>
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
                        <h1 id="forms">ログイン</h1>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-lg-8">
                        <div class="well bs-component">
                            <fieldset>
                                <form class="form-horizontal"  action="LoginCheck" method="POST">
                                    <div class="form-group">
                                        <label for="inputEmail" class="col-lg-2 control-label">ユーザー名</label>
                                        <div class="col-lg-10">
                                            <input type="text" name="name" class="form-control" id="inputName" placeholder="Name">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPassword" class="col-lg-2 control-label">パスワード</label>
                                        <div class="col-lg-10">
                                            <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-10 col-lg-offset-2">
                                            <button type="reset" class="btn btn-default">キャンセル</button>
                                            <button type="submit" class="btn btn-primary">送信</button>
                                            <input type="hidden" name="url"  value="<%= hs.getAttribute("url")%>">
                                            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                                        </div>
                                    </div>
                                    <br>
                                </form>
                                <form class="form-horizontal"  action="Registration" method="POST">
                                    <div class="form-group">
                                        <label for="inputEmail" class="col-lg-2 control-label"></label>
                                        <div class="col-lg-10">登録がお済でない方は　<button type="submit" class="btn btn-primary">こちら</button></div>
                                        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                                    </div>
                                </form>
                            </fieldset>
                        </div>
                    </div>
                    <div class="col-lg-4 col-lg-offset-1">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
