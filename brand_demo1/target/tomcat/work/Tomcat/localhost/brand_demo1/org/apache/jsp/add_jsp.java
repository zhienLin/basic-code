/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-11-25 09:12:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>添加品牌</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"app\">\r\n");
      out.write("    <form action=\"/brand_demo1/addServlet\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("        <h3>添加品牌</h3>\r\n");
      out.write("        品牌名称：<input name=\"brandName\" v-model=\"brand.brandName\">{{brand.brandName}}<br>\r\n");
      out.write("        企业名称：<input name=\"companyName\" v-model=\"brand.companyName\">{{brand.companyName}}<br>\r\n");
      out.write("        排序：<input name=\"ordered\" v-model=\"brand.ordered\">{{brand.ordered}}<br>\r\n");
      out.write("        描述信息：<textarea rows=\"5\" cols=\"20\" name=\"description\" v-model=\"brand.description\"></textarea>{{brand.description}}<br>\r\n");
      out.write("        状态： <input type=\"radio\" name=\"status\" value=\"0\" v-model=\"brand.status\">禁用\r\n");
      out.write("        <input type=\"radio\" name=\"status\" value=\"1\" v-model=\"brand.status\">启用{{brand.status}}<br>\r\n");
      out.write("        <input type=\"button\" value=\"提交\" @click=\"submit()\">\r\n");
      out.write("\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/vue.js\"></script>\r\n");
      out.write("<script src=\"js/axios-0.18.0.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("/*    var brand = {\r\n");
      out.write("        brandName:\"\",\r\n");
      out.write("        companyName: \"\",\r\n");
      out.write("        ordered:\"\",\r\n");
      out.write("        description:\"\",\r\n");
      out.write("        status:\"\"\r\n");
      out.write("    };//这是一个js的brand对象*/\r\n");
      out.write("\r\n");
      out.write("    //1. 创建Vue核心对象\r\n");
      out.write("    new Vue({\r\n");
      out.write("        el: \"#app\",\r\n");
      out.write("        data() {\r\n");
      out.write("            return {\r\n");
      out.write("                brand:{}\r\n");
      out.write("            }\r\n");
      out.write("        },\r\n");
      out.write("        methods: {\r\n");
      out.write("            submit() {\r\n");
      out.write("                var _this=this;\r\n");
      out.write("                axios({\r\n");
      out.write("                    method: \"post\",\r\n");
      out.write("                    url: \"http://localhost:8080/brand_demo1/addServlet\",\r\n");
      out.write("                    data: this.brand\r\n");
      out.write("                }).then(function (resp) {\r\n");
      out.write("                    if (resp.data == \"success\") {\r\n");
      out.write("                        location.href = \"http://localhost:8080/brand_demo1/brand.jsp\";\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
