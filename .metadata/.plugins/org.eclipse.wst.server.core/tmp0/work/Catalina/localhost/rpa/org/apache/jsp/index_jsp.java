/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.23
 * Generated at: 2017-12-15 06:59:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import rpa.models.UserAccount;
import com.google.gson.Gson;
import rpa.models.UserAccount;
import com.google.gson.Gson;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/includes.html", Long.valueOf(1513254035736L));
    _jspx_dependants.put("/in.jsp", Long.valueOf(1513254153146L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1513315730599L));
    _jspx_dependants.put("/footer.html", Long.valueOf(1512923751132L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.google.gson.Gson");
    _jspx_imports_classes.add("rpa.models.UserAccount");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Home</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/css/site.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"assets/js/jquery-3.2.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"assets/js/split.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"assets/js/jquery.tmpl.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"assets/js/jquery.tmplPlus.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"assets/js/site.js\"></script>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 	
	if(session.getAttribute("userinfo")==null){		
		String redirectURL = "login.jsp";
        response.sendRedirect(redirectURL);
	}else{
		String ujson =  String.valueOf(session.getAttribute("userinfo"));
		UserAccount account = new Gson().fromJson(ujson, UserAccount.class);
	}		

      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 	
	UserAccount account = null;
	if(session.getAttribute("userinfo")!=null){				
		String ujson =  String.valueOf(session.getAttribute("userinfo"));
		account = new Gson().fromJson(ujson, UserAccount.class);
	}

      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("\t<nav class=\"navbar navbar-inverse\">\r\n");
      out.write("\t\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<img style=\"height: auto; width: 40%; margin-top: 5px;\"\r\n");
      out.write("\t\t\t\t\t\tsrc=\"assets/images/logo.png\">\r\n");
      out.write("\t\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t<li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"dashboard.jsp\">Dashboard</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"config.jsp\">Config</a></li>\r\n");
      out.write("\t\t\t\t");
			
					if(account!=null){
						String role = account.getRole();						
						if(role == "Administrator"){				
		 					out.println("<li><a href=\"admin.jsp\">Administration</a></li>");		 		
						}
					}
			 	
      out.write("\r\n");
      out.write("\t\t\t\t<li><a role=\"button\" class=\"changepwd\" data-toggle=\"modal\" data-target=\"#changePasswordModal\">Change Password</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">Sign Out</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("\t<div class=\"container-fluid\" id=\"placeholder\">\r\n");
      out.write("\t\t<div class=\"row\" style=\"background-color: #f9f3f4;\">\r\n");
      out.write("\t\t\t<div class=\"col-lg-4 col-md-4\" style=\"margin-top: 15px\"\r\n");
      out.write("\t\t\t\tid=\"FunctionArea\">\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<select title=\"Select Function\" id=\"FunctionId\" name=\"FunctionId\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control input-sm\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"\">Select Function</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-lg-4 col-md-4\" style=\"margin-top: 15px\">\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<select title=\"Select Lob\" id=\"LobId\" name=\"LobId\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control input-sm\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"\">Select Lob</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"col-lg-4 col-md-4\" style=\"margin-top: 15px\">\r\n");
      out.write("\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t<select title=\"Select Process\" id=\"ProcessId\" name=\"ProcessId\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"form-control input-sm\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"\">Select Process</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"example-1\" style=\"padding-top: 15px; overflow-x:hidden; overflow-y:auto;\">\r\n");
      out.write("\t\t\t<table class=\"table table-bordered table-condensed table-hover\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>Process</th>\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<th>Status</th>\r\n");
      out.write("\t\t\t\t\t<th>Actions</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tbody id=\"home_tbody\">\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
      out.write("<footer>\r\n");
      out.write("\t<div class=\"container-fluid\">\r\n");
      out.write("\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"col-lg-12 col-md-12 text-uppercase\"\r\n");
      out.write("\t\t\t\tstyle=\"padding-top: 3px;\">&copy; Copyright Aditya Birla\r\n");
      out.write("\t\t\t\tCapital</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</footer>\r\n");
      out.write("<div id=\"changePasswordModal\" class=\"modal fade\" role=\"dialog\"\r\n");
      out.write("\tdata-backdrop=\"static\">\r\n");
      out.write("\t<div class=\"modal-dialog modal-sm\">\r\n");
      out.write("\t\t<!-- Modal content-->\r\n");
      out.write("\t\t<form id=\"changePasswordForm\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\">Change Password</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<input id=\"type\" name=\"type\" type=\"hidden\" value=\"1\" /> <input\r\n");
      out.write("\t\t\t\t\t\tid=\"id\" name=\"id\" type=\"hidden\" />\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-12 col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>New Password</label> <input type=\"password\" id=\"Password\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"Password\" placeholder=\"New Password\" title=\"New Password\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"form-control input-sm\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\toninvalid=\"this.setCustomValidity('New Password can\\'t left empty!');\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\toninput=\"this.setCustomValidity('')\" required />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-12 col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label>Confirm Password</label> <input type=\"password\" id=\"ConfirmPassword\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"ConfirmPassword\" placeholder=\"Confirm Password\" title=\"Confirm Password\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"form-control input-sm\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\toninvalid=\"this.setCustomValidity('Confirm Password can\\'t left empty!');\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\toninput=\"this.setCustomValidity('')\" required />\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" id=\"Change\" class=\"btn btn-default btn-sm\">Submit</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-danger btn-sm\"\r\n");
      out.write("\t\t\t\t\t\tdata-dismiss=\"modal\">Cancel</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\tvar url = window.location;\r\n");
      out.write("\t\t$('ul.nav a[href=\"' + url + '\"]').parent().addClass('active');\r\n");
      out.write("\t\t$('ul.nav a').filter(function() {\r\n");
      out.write("\t\t\treturn this.href == url;\r\n");
      out.write("\t\t}).parent().addClass('active');\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".changepwd\").click(function(){\r\n");
      out.write("\t\t\t$(\"#Password\").val(\"\");\r\n");
      out.write("\t\t\t$(\"#ConfirmPassword\").val(\"\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"assets/js/home.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
