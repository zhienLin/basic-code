<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加品牌</title>
</head>
<body>


<div id="app">
    <form action="/brand_demo1/addServlet" method="post">

        <h3>添加品牌</h3>
        品牌名称：<input name="brandName" v-model="brand.brandName">{{brand.brandName}}<br>
        企业名称：<input name="companyName" v-model="brand.companyName">{{brand.companyName}}<br>
        排序：<input name="ordered" v-model="brand.ordered">{{brand.ordered}}<br>
        描述信息：<textarea rows="5" cols="20" name="description" v-model="brand.description"></textarea>{{brand.description}}<br>
        状态： <input type="radio" name="status" value="0" v-model="brand.status">禁用
        <input type="radio" name="status" value="1" v-model="brand.status">启用{{brand.status}}<br>
        <input type="button" value="提交" @click="submit()">

    </form>
</div>


<script src="js/vue.js"></script>
<script src="js/axios-0.18.0.js"></script>

<script>

/*    var brand = {
        brandName:"",
        companyName: "",
        ordered:"",
        description:"",
        status:""
    };//这是一个js的brand对象*/

    //1. 创建Vue核心对象
    new Vue({
        el: "#app",
        data() {
            return {
                brand:{}
            }
        },
        methods: {
            submit() {
                var _this=this;
                axios({
                    method: "post",
                    url: "http://localhost:8080/brand_demo1/addServlet",
                    data: this.brand
                }).then(function (resp) {
                    if (resp.data == "success") {
                        location.href = "http://localhost:8080/brand_demo1/brand.jsp";
                    }
                })
            }
        }
    })


</script>


</body>
</html>