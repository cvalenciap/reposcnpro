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
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("      // Your Client ID can be retrieved from your project in the Google\n");
      out.write("      // Developer Console, https://console.developers.google.com\n");
      out.write("      var CLIENT_ID = '826136231825-kbotigap15d90tvtt2hpeflrge8at6ie.apps.googleusercontent.com';\n");
      out.write("\n");
      out.write("      var SCOPES = ['https://www.googleapis.com/auth/drive.metadata.readonly'];\n");
      out.write("\n");
      out.write("      /**\n");
      out.write("       * Check if current user has authorized this application.\n");
      out.write("       */\n");
      out.write("      function checkAuth() {\n");
      out.write("        gapi.auth.authorize(\n");
      out.write("          {\n");
      out.write("            'client_id': CLIENT_ID,\n");
      out.write("            'scope': SCOPES.join(' '),\n");
      out.write("            'immediate': true\n");
      out.write("          }, handleAuthResult);\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      /**\n");
      out.write("       * Handle response from authorization server.\n");
      out.write("       *\n");
      out.write("       * @param {Object} authResult Authorization result.\n");
      out.write("       */\n");
      out.write("      function handleAuthResult(authResult) {\n");
      out.write("        var authorizeDiv = document.getElementById('authorize-div');\n");
      out.write("        if (authResult && !authResult.error) {\n");
      out.write("          // Hide auth UI, then load client library.\n");
      out.write("          authorizeDiv.style.display = 'none';\n");
      out.write("          loadDriveApi();\n");
      out.write("        } else {\n");
      out.write("          // Show auth UI, allowing the user to initiate authorization by\n");
      out.write("          // clicking authorize button.\n");
      out.write("          authorizeDiv.style.display = 'inline';\n");
      out.write("        }\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      /**\n");
      out.write("       * Initiate auth flow in response to user clicking authorize button.\n");
      out.write("       *\n");
      out.write("       * @param {Event} event Button click event.\n");
      out.write("       */\n");
      out.write("      function handleAuthClick(event) {\n");
      out.write("        gapi.auth.authorize(\n");
      out.write("          {client_id: CLIENT_ID, scope: SCOPES, immediate: false},\n");
      out.write("          handleAuthResult);\n");
      out.write("        return false;\n");
      out.write("      }\n");
      out.write("      \n");
      out.write("      \n");
      out.write("      /**\n");
      out.write("       * Load Drive API client library.\n");
      out.write("       */\n");
      out.write("      function loadDriveApi() {\n");
      out.write("        gapi.client.load('drive', 'v3', listFiles);\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      /**\n");
      out.write("       * Print files.\n");
      out.write("       */\n");
      out.write("      function listFiles() {\n");
      out.write("        var request = gapi.client.drive.files.list({\n");
      out.write("            'pageSize': 10,\n");
      out.write("            'fields': \"nextPageToken, files(id, name)\"\n");
      out.write("          });\n");
      out.write("\n");
      out.write("          request.execute(function(resp) {\n");
      out.write("            appendPre('Files:');\n");
      out.write("            var files = resp.files;\n");
      out.write("            if (files && files.length > 0) {\n");
      out.write("              for (var i = 0; i < files.length; i++) {\n");
      out.write("                var file = files[i];\n");
      out.write("                appendPre(file.name + ' (' + file.id + ')');          }\n");
      out.write("            } else {\n");
      out.write("              appendPre('No files found.');\n");
      out.write("            }\n");
      out.write("          });\n");
      out.write("      }\n");
      out.write("      \n");
      out.write("      /*function descargarArchivo(id){\n");
      out.write("        //String fileId = \"0BwwA4oUTeiV1UVNwOHItT0xfa2M\";\n");
      out.write("        OutputStream outputStream = new ByteArrayOutputStream();\n");
      out.write("        driveService.files().get(id)\n");
      out.write("        .executeMediaAndDownloadTo(outputStream);\n");
      out.write("      }\n");
      out.write("\n");
      out.write("      /**\n");
      out.write("       * Append a pre element to the body containing the given message\n");
      out.write("       * as its text node.\n");
      out.write("       *\n");
      out.write("       * @param {string} message Text to be placed in pre element.\n");
      out.write("       */\n");
      out.write("      function appendPre(message) {\n");
      out.write("        var pre = document.getElementById('output');\n");
      out.write("        var textContent = document.createTextNode(message + '\\n');\n");
      out.write("        pre.appendChild(textContent);\n");
      out.write("      }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("    <script src=\"https://apis.google.com/js/client.js?onload=checkAuth\">\n");
      out.write("    </script>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div id=\"authorize-div\" style=\"display: none\">\n");
      out.write("      <span>Authorize access to Drive API</span>\n");
      out.write("      <!--Button for the user to click to initiate auth sequence -->\n");
      out.write("      <button id=\"authorize-button\" onclick=\"handleAuthClick(event)\">\n");
      out.write("        Authorize\n");
      out.write("      </button>\n");
      out.write("    </div>\n");
      out.write("    <pre id=\"output\"></pre>\n");
      out.write("  </body>\n");
      out.write("</html>");
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
