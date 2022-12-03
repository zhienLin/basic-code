<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>
<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <form id="reg-form" action="/ProjectIntegration/signupServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg">${register_msg}</span>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display:none">密码格式有误</span>
                </td>
            </tr>
            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="/ProjectIntegration/change">
                    <a href="#" id="changeImg">看不清？</a><br>
                     <span id="checkCode_err" class="err_msg">${checkCode_msg}</span>
                </td>
            </tr>

            <script>
                document.getElementById("changeImg").onclick = function () {
                    //路径后面添加时间戳的目的是避免浏览器进行缓存静态资源
                    document.getElementById("checkCodeImg").src = "/ProjectIntegration/change?" + new Date().getMilliseconds();
                }
            </script>

        </table>
        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
</div>
</body>
</html>


<%--
关于验证码：
首先点击看不清的时候，界面是不能发生变化的，所以路径直接就是“#”
由于直接生成在磁盘上的时候会产生跟新的问题，导没有办法动态的切换，因此我们考虑把图片输出在网页上。
然后图片的可以通过监听点击的时间进行路径的更改，这个时候路径的源头就是图片输出的那个网页。
这个时候因为你更改路径的时候，也相当于进行了对这个更改图片的Servet的访问，所以会进行图片的切换。

--%>