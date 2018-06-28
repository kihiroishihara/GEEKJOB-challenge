<%@page contentType="text/html"
        pageEncoding="UTF-8"
        import="javax.servlet.http.HttpSession"
        import="ec.UserData" 
        import="ec.UserDataDTO"%>
<%
    HttpSession hs = request.getSession();
    UserData ud = null;
    boolean reinput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reinput = true;
        ud = (UserData)hs.getAttribute("ud");
    }  
    
    
%>


<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>会員登録-入力画面</title>
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
                
                <div class="row">
                    <div class="col-lg-10">
                        <div class="well bs-component">
                            <form class="form-horizontal"  action="RegistrationConfirm" method="POST">
                                <fieldset>
                                    <legend>会員情報</legend>
                                    <div class="form-group">
                                        <label for="inputEmail" class="col-lg-2 control-label">ユーザー名</label>
                                        <div class="col-lg-10">
                                            <input type="text" name="name" class="form-control" placeholder="Name" value="<% if(reinput){out.print(ud.getName());}%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPassword" class="col-lg-2 control-label">パスワード</label>
                                        <div class="col-lg-10">
                                            <input type="password" name="password" class="form-control" placeholder="Password" value="<% if(reinput){out.print(ud.getPassword());}%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPassword" class="col-lg-2 control-label">メールアドレス</label>
                                        <div class="col-lg-10">
                                            <input type="email" name="mail" class="form-control" placeholder="Email" value="<% if(reinput){out.print(ud.getMail());}%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPassword" class="col-lg-2 control-label">住所</label>
                                        <div class="col-lg-2">
                                        <select class="form-control" id="select" name="address1">
                                            <option value="">都道府県</option>
                                            <option value="北海道" <% if(reinput && ud.getAddress1().equals("北海道")){out.print("selected = \"selected\"");}%>>北海道</option>
                                            <option value="青森県" <% if(reinput && ud.getAddress1().equals("青森県")){out.print("selected = \"selected\"");}%>>青森県</option>
                                            <option value="岩手県" <% if(reinput && ud.getAddress1().equals("岩手県")){out.print("selected = \"selected\"");}%>>岩手県</option>
                                            <option value="宮城県" <% if(reinput && ud.getAddress1().equals("宮城県")){out.print("selected = \"selected\"");}%>>宮城県</option>
                                            <option value="秋田県" <% if(reinput && ud.getAddress1().equals("秋田県")){out.print("selected = \"selected\"");}%>>秋田県</option>
                                            <option value="山形県" <% if(reinput && ud.getAddress1().equals("山形県")){out.print("selected = \"selected\"");}%>>山形県</option>
                                            <option value="福島県" <% if(reinput && ud.getAddress1().equals("福島県")){out.print("selected = \"selected\"");}%>>福島県</option>
                                            <option value="茨城県" <% if(reinput && ud.getAddress1().equals("茨城県")){out.print("selected = \"selected\"");}%>>茨城県</option>
                                            <option value="栃木県" <% if(reinput && ud.getAddress1().equals("栃木県")){out.print("selected = \"selected\"");}%>>栃木県</option>
                                            <option value="群馬県" <% if(reinput && ud.getAddress1().equals("群馬県")){out.print("selected = \"selected\"");}%>>群馬県</option>
                                            <option value="埼玉県" <% if(reinput && ud.getAddress1().equals("埼玉県")){out.print("selected = \"selected\"");}%>>埼玉県</option>
                                            <option value="千葉県" <% if(reinput && ud.getAddress1().equals("千葉県")){out.print("selected = \"selected\"");}%>>千葉県</option>
                                            <option value="東京都" <% if(reinput && ud.getAddress1().equals("東京都")){out.print("selected = \"selected\"");}%>>東京都</option>
                                            <option value="神奈川県" <% if(reinput && ud.getAddress1().equals("神奈川県")){out.print("selected = \"selected\"");}%>>神奈川県</option>
                                            <option value="新潟県" <% if(reinput && ud.getAddress1().equals( "新潟県")){out.print("selected = \"selected\"");}%>>新潟県</option>
                                            <option value="富山県" <% if(reinput && ud.getAddress1().equals("富山県")){out.print("selected = \"selected\"");}%>>富山県</option>
                                            <option value="石川県" <% if(reinput && ud.getAddress1().equals("石川県")){out.print("selected = \"selected\"");}%>>石川県</option>
                                            <option value="福井県" <% if(reinput && ud.getAddress1().equals("福井県")){out.print("selected = \"selected\"");}%>>福井県</option>
                                            <option value="山梨県" <% if(reinput && ud.getAddress1().equals("山梨県")){out.print("selected = \"selected\"");}%>>山梨県</option>
                                            <option value="長野県" <% if(reinput && ud.getAddress1().equals("長野県")){out.print("selected = \"selected\"");}%>>長野県</option>
                                            <option value="岐阜県" <% if(reinput && ud.getAddress1().equals("岐阜県")){out.print("selected = \"selected\"");}%>>岐阜県</option>
                                            <option value="静岡県" <% if(reinput && ud.getAddress1().equals("静岡県")){out.print("selected = \"selected\"");}%>>静岡県</option>
                                            <option value="愛知県" <% if(reinput && ud.getAddress1().equals("愛知県")){out.print("selected = \"selected\"");}%>>愛知県</option>
                                            <option value="三重県" <% if(reinput && ud.getAddress1().equals("三重県")){out.print("selected = \"selected\"");}%>>三重県</option>
                                            <option value="滋賀県" <% if(reinput && ud.getAddress1().equals("滋賀県")){out.print("selected = \"selected\"");}%>>滋賀県</option>
                                            <option value="京都府" <% if(reinput && ud.getAddress1().equals("京都府")){out.print("selected = \"selected\"");}%>>京都府</option>
                                            <option value="大阪府" <% if(reinput && ud.getAddress1().equals("大阪府")){out.print("selected = \"selected\"");}%>>大阪府</option>
                                            <option value="兵庫県" <% if(reinput && ud.getAddress1().equals("兵庫県")){out.print("selected = \"selected\"");}%>>兵庫県</option>
                                            <option value="奈良県" <% if(reinput && ud.getAddress1().equals("奈良県")){out.print("selected = \"selected\"");}%>>奈良県</option>
                                            <option value="和歌山県" <% if(reinput && ud.getAddress1().equals("和歌山県")){out.print("selected = \"selected\"");}%>>和歌山県</option>
                                            <option value="鳥取県" <% if(reinput && ud.getAddress1().equals("鳥取県")){out.print("selected = \"selected\"");}%>>鳥取県</option>
                                            <option value="島根県" <% if(reinput && ud.getAddress1().equals("島根県")){out.print("selected = \"selected\"");}%>>島根県</option>
                                            <option value="岡山県" <% if(reinput && ud.getAddress1().equals("岡山県")){out.print("selected = \"selected\"");}%>>岡山県</option>
                                            <option value="広島県" <% if(reinput && ud.getAddress1().equals("広島県")){out.print("selected = \"selected\"");}%>>広島県</option>
                                            <option value="山口県" <% if(reinput && ud.getAddress1().equals("山口県")){out.print("selected = \"selected\"");}%>>山口県</option>
                                            <option value="徳島県" <% if(reinput && ud.getAddress1().equals("徳島県")){out.print("selected = \"selected\"");}%>>徳島県</option>
                                            <option value="香川県" <% if(reinput && ud.getAddress1().equals("香川県")){out.print("selected = \"selected\"");}%>>香川県</option>
                                            <option value="愛媛県" <% if(reinput && ud.getAddress1().equals("愛媛県")){out.print("selected = \"selected\"");}%>>愛媛県</option>
                                            <option value="高知県" <% if(reinput && ud.getAddress1().equals("高知県")){out.print("selected = \"selected\"");}%>>高知県</option>
                                            <option value="福岡県" <% if(reinput && ud.getAddress1().equals("福岡県")){out.print("selected = \"selected\"");}%>>福岡県</option>
                                            <option value="佐賀県" <% if(reinput && ud.getAddress1().equals("佐賀県")){out.print("selected = \"selected\"");}%>>佐賀県</option>
                                            <option value="長崎県" <% if(reinput && ud.getAddress1().equals("長崎県")){out.print("selected = \"selected\"");}%>>長崎県</option>
                                            <option value="熊本県" <% if(reinput && ud.getAddress1().equals("熊本県")){out.print("selected = \"selected\"");}%>>熊本県</option>
                                            <option value="大分県" <% if(reinput && ud.getAddress1().equals("大分県")){out.print("selected = \"selected\"");}%>>大分県</option>
                                            <option value="宮崎県" <% if(reinput && ud.getAddress1().equals("宮崎県")){out.print("selected = \"selected\"");}%>>宮崎県</option>
                                            <option value="鹿児島県" <% if(reinput && ud.getAddress1().equals("鹿児島県")){out.print("selected = \"selected\"");}%>>鹿児島県</option>
                                            <option value="沖縄県" <% if(reinput && ud.getAddress1().equals("沖縄県")){out.print("selected = \"selected\"");}%>>沖縄県</option>
                                        </select>
                                        </div>
                                        <div class="col-lg-4">
                                            <input type="text" name="address2" class="form-control" placeholder="市区町村番地" value="<% if(reinput){out.print(ud.getAddress2());}%>">
                                        </div>
                                        <div class="col-lg-4">
                                            <input type="text" name="address3" class="form-control" placeholder="マンション名，部屋番号" value="<% if(reinput){out.print(ud.getAddress3());}%>">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-10 col-lg-offset-2">
                                            <button type="reset" class="btn btn-default">キャンセル</button>
                                            <button type="submit" class="btn btn-primary">送信</button>
                                        </div>
                                    </div>
                                </fieldset>
                                <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">        
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
