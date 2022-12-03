<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2022/11/21
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${brands}

<c:if test="${status == 1}">
    启用
</c:if>

<c:if test="${status == 0}">
    禁用
</c:if>


<c:forEach items="${brands}" var="brand">
    <tr align="center">
        <td>${brand.id}</td>
        <td>${brand.brandName}</td>
        <td>${brand.companyName}</td>
        <td>${brand.description}</td>
    </tr>
</c:forEach>


<c:forEach begin="0" end="9" step="2" var="i">
    i
</c:forEach>
</body>
</html>
