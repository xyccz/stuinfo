<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/6/20
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>add</title>
    <style type="text/css">
        form {
            width: 300px;
            background-color: aliceblue;
            font-size: smaller;
            position: absolute;
            top:50%;
            left: 50%;
            transform: translate(-50%,-50%);
            text-align:center;

        }
    </style>
</head>
<body>

<form action="/task/AddUserServlet">
    <fieldset>
        <legend>添加用户</legend>
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="uname" /></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="text" name="upassword" /></td>
            </tr>
            <tr>
                <td>身份：</td>
                <td><input type="radio" name = "role" value = "user"/>普通用户<input type="radio" name = "role" value = "manager"/>学生管理员</td>
            </tr>
            <tr>
                <td></td>
                <td><button type ="submit">添加</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
