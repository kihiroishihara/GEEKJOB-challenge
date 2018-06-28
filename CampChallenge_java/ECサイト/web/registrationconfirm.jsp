<%@page contentType="text/html"
        pageEncoding="UTF-8"
        import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
        import="ec.ECHelper"
        import="ec.UserData" 
        import="ec.UserDataDTO"%>
<%
    HttpSession hs = request.getSession();
    ECHelper jh = ECHelper.getInstance();
    UserData ud = (UserData)hs.getAttribute("ud");
    ArrayList<String> chkList = ud.chkproperties();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>会員登録-確認画面</title>
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
                <div class="col-lg-12">
                    <div class="page-header">
                        <h1 id="forms">新規会員登録</h1>
                    </div>
                </div>
                
                <% if(chkList.size()==0){ %>
                    <div class="row">
                       <div class="col-lg-12">
                            <div class="well bs-component">
                                <form class="form-horizontal"  action="RegistrationComplete" method="POST">
                                    <fieldset>
                                        <legend>登録確認</legend>
                                        <div class="form-group">
                                            <label for="inputEmail" class="col-lg-2 control-label">ユーザー名</label>
                                            <div class="col-lg-10"><%= ud.getName()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputEmail" class="col-lg-2 control-label">パスワード</label>
                                            <div class="col-lg-10"><%= ud.getPassword()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputEmail" class="col-lg-2 control-label">メールアドレス</label>
                                            <div class="col-lg-10"><%= ud.getMail()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputEmail" class="col-lg-2 control-label">住所</label>
                                            <div class="col-lg-10"><%= ud.getAddress1() + ud.getAddress2() + ud.getAddress3()%></div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-lg-2 control-label"></label>
                                            <div class="col-lg-10"><%= "上記の内容で登録します。よろしいですか？"%>　　<button type="submit" class="btn btn-primary">はい</button></div>
                                        </div>
                                    </fieldset>
                                    <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">    
                           　   </form>
                                <% }else{ %>
                                <div class="row">
                                    <div class="col-lg-7">
                                        <div class="well bs-component">
                                            <fieldset>
                                                <legend>入力が不完全です</legend>
                                                <div class="form-group">
                                                    <div class="col-lg-7 col-lg-offset-1">
                                                        <%=jh.chkinput(chkList) %><br>
                                                    </div>
                                                </div>   
                                            </fieldset>
                                            <% } %>
                                            <form class="form-horizontal"  action="Registration" method="POST">
                                                <fieldset>
                                                    <div class="form-group">
                                                        <div class="col-lg-4 col-lg-offset-7">
                                                             <button type="submit" class="btn btn-primary">登録画面に戻る</button>
                                                        </div>
                                                    </div>
                                                </fieldset>
                                                <input type="hidden" name="mode" value="REINPUT">
                                                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">     
                                            </form>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-lg-offset-1"></div>
                                </div>
                            </div>                
                        </div>
                    </div>
             </div>                
        </div>
    </body>
</html>