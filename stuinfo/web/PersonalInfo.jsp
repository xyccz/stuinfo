<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/6/20
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="domain.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <style type="text/css">
        div{
            height: auto;
            width: 260px;
            background-color: aliceblue;
            font-size: smaller;
            padding: 50px;
            position: absolute;
            top:50%;
            left: 50%;
            transform: translate(-50%,-50%);
        }
    </style>
</head>
<body>
<%--Student s = (Student)session.getAttribute("per") ;
--%>
<div>
    <p>学号：<%--=s.getID() --%>${sessionScope.per.ID}</p>
    <p>姓名：<%--=s.getname() --%>${sessionScope.per.name}</p>
    <p>年龄：<%--=s.getage() --%>${sessionScope.per.age}</p>
    <p>性别：<%--=s.getsex() --%>${sessionScope.per.sex}</p>
    <p>身高：<%--=s.getheight() --%>${sessionScope.per.height}</p>
    <p>体重：<%--=s.getweight() --%>${sessionScope.per.weight}</p>
    <p>籍贯：<%--=s.getaddress() --%>${sessionScope.per.address}</p>
    <p>电话：<%--=s.getphone() --%>${sessionScope.per.phone}</p>
    <a href="index.jsp">返回首页</a>
</div>
</body>
</html>
