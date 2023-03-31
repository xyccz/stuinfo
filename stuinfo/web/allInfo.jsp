<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/6/20
  Time: 0:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="domain.Student" %>
<%@ page import="service.StudentService" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Info</title>
    <style>
        div{
            margin:0 auto;
            height: auto;
            width: 400px;
            background-color: aliceblue;
            font-size: smaller;
            padding-top:5px;
            text-align:center;
            padding-bottom:5px;
        }
        table{
            width: 300px;
            height: 800px;
            border: 1px solid #ccc;
            text-align: center;
            border-spacing: 0;
            border-collapse: collapse;
            margin:50px;
        }
        td{
            border:1px solid #ccc;
            width:150px;
        }
    </style>
</head>
<body>
<%
    List<Student> list = new StudentService().QueryAllStu();
    pageContext.setAttribute("list", list);
%>
<div>
    <h3>软工一班学生信息</h3>
    <a href="index.jsp">返回首页</a>
    <table border="1">
        <%--
        for(int i=0;i<list.size();i++){
        --%>
        <c:forEach var="s" items="${list}">
            <tr>
                <td>
                        <%--=list.get(i).getID() --%>
                        ${s.ID}
                </td>
                <td>
                        <%--=list.get(i).getname() --%>
                        ${s.name}
                </td>
            </tr>
        </c:forEach>
        <%--}--%>
    </table>
</div>
</body>
</html>
