<%@page contentType="text/html"
        pageEncoding="UTF-8"
        import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
        import="ec.ECHelper"
        import="ec.UserData" 
        import="ec.UserDataDTO"%>

<%
   UserData ud = (UserData)request.getAttribute("ud");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>会員登録-完了画面</title>
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
                            UserDataDTO udq = (UserDataDTO)hs.getAttribute("login");
                            //リクエストパラメータの文字コードをUTF-8に変更
                            request.setCharacterEncoding("UTF-8");
                            //アクセスルートチェック
                            if(hs.getAttribute("login") == null){
                        %>
                                <li><a href="Login?url=Top">ログイン</a></li>        
                        <%   }else{    %>
                                <li><a href="MyData?ac=<%= hs.getAttribute("ac")%>">ようこそ <font Color="DC143C"><%= udq.getName()%></font> さん！</a></li>
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
                <div class="col-lg-7"
                    <div class="page-header">
                        <h1 id="forms">新規会員登録</h1>
                    </div>
                </div>
                        
                <div class="row">
                    <div class="col-lg-10">
                        <div class="well bs-component">
                            <fieldset>
                                <form class="form-horizontal"  action="RegistrationConfirm" method="POST">
                                    <legend>登録完了</legend>
                                        <div class="form-group">
                                            <label for="inputEmail" class="col-lg-2 control-label">ユーザー名</label>
                                            <div class="col-lg-10"><%= ud.getName()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword" class="col-lg-2 control-label">パスワード</label>
                                            <div class="col-lg-10"><%= ud.getPassword()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword" class="col-lg-2 control-label">メールアドレス</label>
                                            <div class="col-lg-10"><%= ud.getMail()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword" class="col-lg-2 control-label">住所</label>
                                            <div class="col-lg-10"><%= ud.getAddress1() + ud.getAddress2() + ud.getAddress3()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label"></label>
                                            <div class="col-lg-10"><%= "以上の内容で登録しました。"%></div>
                                        </div>
                                </form>
                                <div  align="center">
                                    <div style="display:inline-flex">
                                        <form class="form-horizontal"  action="Top" method="POST">
                                            <button type="submit" class="btn btn-primary">トップページへ</button>
                                            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>"> 
                                        </form>
                                        <form class="form-horizontal"  action="Login" method="POST">
                                            <button type="submit" class="btn btn-primary">ログインページへ</button>
                                            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
                                        </form>
                                    </div>
                                </div>
                            </fieldset>
                        </div>
                    </div>
                    <div class="col-lg-4 col-lg-offset-1"></div>
                </div>
            </div>
        </div>
    </body>
</html>
