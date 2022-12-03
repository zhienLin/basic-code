<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<input type="button" value="新增" id="add"><br>
<hr>

<div id = "app" >


<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>
    <tr  v-for="(brand,i) in brands" align="center">
        <td>{{i+1}}</td>
        <td>{{brand.brandName}}</td>
        <td>{{brand.companyName}}</td>
        <td>{{brand.ordered}}</td>
        <td>{{brand.description}}</td>
        <td>{{brand.status}}</td>
        <td>
            <a href="/brand_demo1/selectByIdServlet?id={{brand.id}}">修改</a>
            <a href="/brand_demo1/deleteServlet?id={{brand.id}}">删除</a>
        </td>
    </tr>
</table>

</div>


<script src="js/vue.js"></script>
<script src="js/axios-0.18.0.js"></script>


<script>
new Vue({
    el: "#app",//需要绑定的元素
    data() {//用来存放动态关联的数据
        return {
            brands:[]
        }
    },
    //界面加载完成之后，发送异步的请求，查询数据
    mounted(){
        var _this= this;
        axios({
            method:"get",
            url:"http://localhost:8080/brand_demo1/selectAllServlet"
        }).then(function (resp) {
            _this.brands=resp.data;
        })
    }

})


</script>


</body>
</html>