package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("<!--        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">-->\n");
      out.write("        <title>Login con Google Drive</title>\n");
      out.write("        <meta name=\"google-signin-client_id\" content=\"826136231825-kbotigap15d90tvtt2hpeflrge8at6ie.apps.googleusercontent.com\">\n");
      out.write("        <script src=\"https://apis.google.com/js/client:platform.js?onload=renderButton\" async defer></script>\n");
      out.write("        <script src=\"jquery.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            function onSuccess(googleUser) {\n");
      out.write("                var profile = googleUser.getBasicProfile();\n");
      out.write("                gapi.client.load('plus', 'v1', function () {\n");
      out.write("                    var request = gapi.client.plus.people.get({\n");
      out.write("                        'userId': 'me'\n");
      out.write("                    });\n");
      out.write("                    //Display the user details\n");
      out.write("                    request.execute(function (resp) {\n");
      out.write("                        var profileHTML = '<div class=\"profile\"><div class=\"head\">Welcome ' + resp.name.givenName + '! <a href=\"javascript:void(0);\" onclick=\"signOut();\">Sign out</a></div>';\n");
      out.write("                        profileHTML += '<img src=\"' + resp.image.url + '\"/><div class=\"proDetails\"><p>' + resp.displayName + '</p><p>' + resp.emails[0].value + '</p><p>' + resp.gender + '</p><p>' + resp.id + '</p><p><a href=\"' + resp.url + '\">View Google+ Profile</a></p></div></div>';\n");
      out.write("                        $('.userContent').html(profileHTML);\n");
      out.write("                        $('#gSignIn').slideUp('slow');\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("            function onFailure(error) {\n");
      out.write("                alert(error);\n");
      out.write("            }\n");
      out.write("            function renderButton() {\n");
      out.write("                gapi.signin2.render('gSignIn', {\n");
      out.write("                    'scope': 'profile email',\n");
      out.write("                    'width': 240,\n");
      out.write("                    'height': 50,\n");
      out.write("                    'longtitle': true,\n");
      out.write("                    'theme': 'dark',\n");
      out.write("                    'onsuccess': onSuccess,\n");
      out.write("                    'onfailure': onFailure\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("            function signOut() {\n");
      out.write("                var auth2 = gapi.auth2.getAuthInstance();\n");
      out.write("                auth2.signOut().then(function () {\n");
      out.write("                    $('.userContent').html('');\n");
      out.write("                    $('#gSignIn').slideDown('slow');\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- HTML for render Google Sign-In button -->\n");
      out.write("        <div id=\"gSignIn\"></div>\n");
      out.write("        <!-- HTML for displaying user details -->\n");
      out.write("        <div class=\"userContent\"></div>\n");
      out.write("        <style>\n");
      out.write("            .profile{\n");
      out.write("                border: 3px solid #B7B7B7;\n");
      out.write("                padding: 10px;\n");
      out.write("                margin-top: 10px;\n");
      out.write("                width: 350px;\n");
      out.write("                background-color: #F7F7F7;\n");
      out.write("                height: 160px;\n");
      out.write("            }\n");
      out.write("            .profile p{margin: 0px 0px 10px 0px;}\n");
      out.write("            .head{margin-bottom: 10px;}\n");
      out.write("            .head a{float: right;}\n");
      out.write("            .profile img{width: 100px;float: left;margin: 0px 10px 10px 0px;}\n");
      out.write("            .proDetails{float: left;}\n");
      out.write("        </style>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
