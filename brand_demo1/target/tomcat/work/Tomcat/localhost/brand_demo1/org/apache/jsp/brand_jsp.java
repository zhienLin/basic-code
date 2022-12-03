/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-11-25 08:18:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class brand_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Title</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<input type=\"button\" value=\"新增\" id=\"add\"><br>\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<div id = \"app\" >\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border=\"1\" cellspacing=\"0\" width=\"80%\">\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th>序号</th>\r\n");
      out.write("        <th>品牌名称</th>\r\n");
      out.write("        <th>企业名称</th>\r\n");
      out.write("        <th>排序</th>\r\n");
      out.write("        <th>品牌介绍</th>\r\n");
      out.write("        <th>状态</th>\r\n");
      out.write("        <th>操作</th>\r\n");
      out.write("\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr  v-for=\"(brand,i) in brands\" align=\"center\">\r\n");
      out.write("        <td>{{i+1}}</td>\r\n");
      out.write("        <td>{{brand.brandName}}</td>\r\n");
      out.write("        <td>{{brand.companyName}}</td>\r\n");
      out.write("        <td>{{brand.ordered}}</td>\r\n");
      out.write("        <td>{{brand.description}}</td>\r\n");
      out.write("        <td>{{brand.status}}</td>\r\n");
      out.write("        <td>\r\n");
      out.write("            <a href=\"/brand_demo1/selectByIdServlet?id={{brand.id}}\">修改</a>\r\n");
      out.write("            <a href=\"/brand_demo1/deleteServlet?id={{brand.id}}\">删除</a>\r\n");
      out.write("        </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/vue.js\"></script>\r\n");
      out.write("<script src=\"js/axios-0.18.0.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("new Vue({\r\n");
      out.write("    el: \"#app\",//需要绑定的元素\r\n");
      out.write("    data() {//用来存放动态关联的数据\r\n");
      out.write("        return {\r\n");
      out.write("            brands:[]\r\n");
      out.write("        }\r\n");
      out.write("    },\r\n");
      out.write("    //界面加载完成之后，发送异步的请求，查询数据\r\n");
      out.write("    mounted(){\r\n");
      out.write("        var _this= this;\r\n");
      out.write("        axios({\r\n");
      out.write("            method:\"get\",\r\n");
      out.write("            url:\"http://localhost:8080/brand_demo1/selectAllServlet\"\r\n");
      out.write("        }).then(function (resp) {\r\n");
      out.write("            _this.brands=resp.data;\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("})\r\n");
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