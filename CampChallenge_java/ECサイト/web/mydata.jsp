<%@page contentType="text/html"
        pageEncoding="UTF-8"
        import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
        import="ec.ECHelper"
        import="ec.UserData" 
        import="ec.UserDataDTO"%>

<%
    HttpSession hs = request.getSession();
    UserDataDTO md = (UserDataDTO)hs.getAttribute("mydataresult");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>会員情報-閲覧画面</title>
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
                        <h1 id="forms">会員情報</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="well bs-component">
                            <form class="form-horizontal"   method="POST">
                               <fieldset>
                                    <legend>登録内容</legend>
                                        <div class="form-group">
                                            <label for="inputEmail" class="col-lg-3 control-label">ユーザー名</label>
                                            <div class="col-lg-8"><%= md.getName()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword" class="col-lg-3 control-label">パスワード</label>
                                            <div class="col-lg-8"><%= md.getPassword()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword" class="col-lg-3 control-label">メール</label>
                                            <div class="col-lg-8"><%= md.getMail()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword" class="col-lg-3 control-label">住所</label>
                                            <div class="col-lg-8"><%= md.getAddress()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword" class="col-lg-3 control-label">総購入金額</label>
                                            <div class="col-lg-8"><%= md.getTotal()%> 円</div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword" class="col-lg-3 control-label">登録日時</label>
                                            <div class="col-lg-8"><%= md.getNewDate()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputPassword" class="col-lg-3 control-label">削除フラグ</label>
                                            <div class="col-lg-8"><%= md.getDaleteFlg()%></div>
                                        </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                    <div class="bs-docs-section">
                        <div class="col-lg-7">
                            <div class="page-header">
                                <h1 id="forms"></h1>
                            </div>
                        </div>
                        <p class="bs-component">
                            <form  action="MyHistory" method="POST">
                                <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
                                <input type="hidden" name="id" value="<%= udq.getUserID()%>">
                                <input class="btn btn-primary btn-lg" type="submit" name="btnSubmit" value="購入履歴">
                            </form>
                        </p>
                        <p class="bs-component">
                            <form  action="MyUpdate" method="POST">
                                <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
                                <input type="hidden" name="id" value="<%= udq.getUserID()%>">
                                <input class="btn btn-primary btn-lg" type="submit" name="btnSubmit" value="登録情報更新">
                            </form>
                        </p>
                        <p class="bs-component">
                            <form  action="MyDelete" method="POST">
                                <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
                                <input type="hidden" name="id" value="<%= udq.getUserID()%>">
                                <input class="btn btn-primary btn-lg" type="submit" name="btnSubmit" value="登録情報削除">
                            </form>
                        </p>
                    </div>
                </div>
        </div>
    </body>
</html>
