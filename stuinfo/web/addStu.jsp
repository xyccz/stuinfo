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
<div>
    <form action="/task/AddServlet">
        <fieldset>
            <legend>添加学生</legend>
            <table>
                <tr>
                    <td>学号：</td>
                    <td><input type="text" name="sno" /></td>
                </tr>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" name="sname" /></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td><input type="text" name="ssex" /></td>
                </tr>
                <tr>
                    <td>年龄：</td>
                    <td><input type="text" name="sage" /></td>
                </tr>
                <tr>
                    <td>身高：</td>
                    <td><input type="text" name="sheight" /></td>
                </tr>
                <tr>
                    <td>体重：</td>
                    <td><input type="text" name="sweight" /></td>
                </tr>
                <tr>
                    <td>籍贯：</td>
                    <td><input type="text" name="saddress" /></td>
                </tr>
                <tr>
                    <td>电话：</td>
                    <td><input type="text" name="sphone" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button type ="submit">添加</button></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
