<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/6/20
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Login</title>

    <style>
        form {
            height: 200px;
            width: 350px;
            background-color: aliceblue;
            font-size: smaller;
            padding: 50px;
            position: absolute;
            top:50%;
            left: 50%;
            transform: translate(-50%,-50%);

        }

        .wel,a{
            font-size:larger;
            font-style:italic;
            color:cornflowerblue;
        }
        table td{
            padding-bottom: 10px;
        }

    </style>
</head>
<body>
<form name="logForm" action="/task/LoginServlet" method="post"><!-- action里的路径很重要 -->
    <table>
        <tr>
            <td class="wel">欢迎登录</td>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name" id="one"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password" id="two"/></td>
        </tr>
        <tr>
            <td>身份</td>
            <td><input type="radio" name = "role" value = "student"/>学生<input type="radio" name = "role" value = "user"/>普通用户<input type="radio" name = "role" value = "manager"/>学生管理员<input type="radio" name = "role" value = "admin"/>管理员</td>
        </tr>
        <tr>
            <td class="bt1"><input type="submit" value="登录" /></td>
            <td><a href="userRegister.jsp">用户注册</a></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    document.getElementById("one").innerText="201909000134";
    document.getElementById("two").innerText="王悦";
</script>
</body>

</html>
