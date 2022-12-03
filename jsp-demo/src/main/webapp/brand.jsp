<%@ page import="com.itheima.pojo.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/11/21
  Time: 19:33
  To change this template use File | Settings | File Templates.
  这一部分就是html+java代码在一个jsp中进行展示，避比之前的直接使用Servlet的方法好了很多，
  但是还存在代码复杂、不宜查看的缺点。

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>


<input type="button" value="新增"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>



    <tr align="center">
        <td><%=brand.getId()%>
        </td>
        <td><%=brand.getBrandName()%>
        </td>
        <td><%=brand.getCompanyName()%>
        </td>
        <td><%=brand.getOrdered()%>
        </td>
        <td><%=brand.getDescription()%>
        </td>
        <td><%=brand.getStatus() == 1 ? "启用" : "禁用"%>
        </td>


        <td><a href="#">修改</a> <a href="#">删除</a></td>
    </tr>

    <%
        }
    %>


</table>
</body>
</html>