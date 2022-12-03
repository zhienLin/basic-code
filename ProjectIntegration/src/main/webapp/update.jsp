<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/11/22
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改数据</title>
</head>
<body>
<h2>${name},请修改信息</h2>
<form action="/ProjectIntegration/updateServlet" method="post">
<h3>修改信息</h3>
<%--隐藏域，提交id--%>
<input type="hidden" name="id" value="${brand.id}">
品牌名称：<input name="brandName" value="${brand.brandName}"><br>
企业名称：<input name="companyName" value="${brand.companyName}"><br>
排序：<input name="ordered" value="${brand.ordered}" ><br>
描述信息：<textarea rows="5" cols="20" name="description">${brand.description}</textarea><br>
状态：
<c:if test="${brand.status == 0}">
    <input type="radio" name="status" value="0" checked>禁用
    <input type="radio" name="status" value="1">启用<br>
</c:if>

    <input type="submit">

</form>

</body>
</html>
