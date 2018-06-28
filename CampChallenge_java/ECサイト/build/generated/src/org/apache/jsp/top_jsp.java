package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import ec.UserDataDTO;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("    \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>トップページ</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("        body { padding-top: 100px; }\n");
      out.write("        @media ( min-width: 768px ) {\n");
      out.write("            #banner {\n");
      out.write("                min-height: 100px;\n");
      out.write("                border-bottom: none;\n");
      out.write("            }\n");
      out.write("            .bs-docs-section {\n");
      out.write("                margin-top: 5em;\n");
      out.write("            }\n");
      out.write("            .bs-component {\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("            .bs-component .modal {\n");
      out.write("                position: relative;\n");
      out.write("                top: auto;\n");
      out.write("                right: auto;\n");
      out.write("                left: auto;\n");
      out.write("                bottom: auto;\n");
      out.write("                z-index: 1;\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("            .bs-component .modal-dialog {\n");
      out.write("                width: 90%;\n");
      out.write("            }\n");
      out.write("            .bs-component .popover {\n");
      out.write("                position: relative;\n");
      out.write("                display: inline-block;\n");
      out.write("                width: 220px;\n");
      out.write("                margin: 20px;\n");
      out.write("            }\n");
      out.write("            .nav-tabs {\n");
      out.write("                margin-bottom: 15px;\n");
      out.write("            }\n");
      out.write("            .progress {\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"navbar navbar-default navbar-fixed-top\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <a href=\"Top\" class=\"navbar-brand\">Top</a>\n");
      out.write("                        <button class=\"navbar-toggle\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar-main\">\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                            <span class=\"icon-bar\"></span>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"navbar-collapse collapse\" id=\"navbar-main\">\n");
      out.write("                        <ul class=\"nav navbar-nav\">\n");
      out.write("                        ");

                            //現在のページの取得
                            StringBuffer url = request.getRequestURL();
                            url.append("?").append(request.getQueryString());
                            //セッションスタート
                            HttpSession hs = request.getSession();
                            //ログアウト処理
                            if(request.getParameter("login") != null){
                                session.removeAttribute("login");
                            }
                            UserDataDTO ud = (UserDataDTO)hs.getAttribute("login");
                            //リクエストパラメータの文字コードをUTF-8に変更
                            request.setCharacterEncoding("UTF-8");
                            //アクセスルートチェック
                            if(hs.getAttribute("login") == null){
                        
      out.write("\n");
      out.write("                                <li><a href=\"Login?url=Top\">ログイン</a></li>        \n");
      out.write("                        ");
   }else{    
      out.write("\n");
      out.write("                                <li><a href=\"MyData?ac=");
      out.print( hs.getAttribute("ac"));
      out.write("\">ようこそ <font Color=\"DC143C\">");
      out.print( ud.getName());
      out.write("</font> さん！</a></li>\n");
      out.write("                                <li><a href=\"Cart\">買い物かご</a></li>\n");
      out.write("                                <li><a href=\"Login\">ログアウト</a></li>\n");
      out.write("                        ");
   }    
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("            <!-- BootstrapのCSS読み込み -->\n");
      out.write("            <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("            <!-- jQuery読み込み -->\n");
      out.write("            <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("            <!-- BootstrapのJS読み込み -->\n");
      out.write("            <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"bs-docs-section\">\n");
      out.write("                <div class=\"jumbotron special\">\n");
      out.write("                    <div class=\"honoka\"></div>\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-xs-12 outline\">\n");
      out.write("                                <h1>KIHIRO SHOPPING</h1>\n");
      out.write("                                <p>yahooAPIを利用して作成したECサイトです。</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("                                <form class=\"navbar-form navbar-left\" role=\"search\" action=\"Search\" method=\"GET\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" name=\"search\" placeholder=\"search\">\n");
      out.write("                                    <input type=\"hidden\" name=\"ac\"  value=\"");
      out.print( hs.getAttribute("ac"));
      out.write("\"> \n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-default\">検索</button>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
