<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <!DOCTYPE html>
 <html lang="en">
 <head>
<meta charset="UTF-8">
<title>login</title>
<link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
<form action="/ProjectIntegration/loginServlet" method="post" id="form">
<h1 id="loginMsg">LOGIN IN</h1>
<div id="errorMsg">${login_msg}${register_msg}</div>
<p>Username:<input id="username" name="username" type="text" value="${cookie.userName.value}" ></p>
<p>Password:<input id="password" name="password" type="password" value="${cookie.Pwd.value}"></p>
<p>Remember:<input id="remember" name="remember" type="checkbox" ></p>
<div id="subDiv">
<input type="submit" class="button" value="login up">
<input type="reset" class="button"value="reset">
<a href="register.jsp">没有账号？</a>
</div>
</form>
</div>
</body>
</html>