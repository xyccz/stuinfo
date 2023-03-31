<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/5/18
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ page import="domain.Student" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Index</title>
  <style type="text/css">
    .out{
      height: auto;
      width: 350px;
      background-color: aliceblue;
      font-size: smaller;
      padding: 50px;
      position: absolute;
      top:50%;
      left: 50%;
      transform: translate(-50%,-50%);
    }
    .wel{
      font-size:larger;
      font-style:italic;
      color:cornflowerblue;
    }

    .in{

      display:flex;

    }

  </style>
</head>
<body>
<%--Student s = (Student)session.getAttribute("log"); --%>
<div class="out">
  <p>欢迎进入！<%--=s.getname() --%>${sessionScope.log.name}同学</p>
  <div class="in">
    <form name="form1" action="/task/PersonalInfo" method="post" class="f1"><!-- action里的路径很重要 -->
      <table>
        <tr>
          <td><input type="text" name="sid" placeholder="请输入要查询的学号"/></td>
          <td><input type="submit" value="查询" /></td>
        </tr>
      </table>
    </form>
    <form name="Form" action="/task/SearchInfo" method="post"><!-- action里的路径很重要 -->
      <table>
        <tr><td><input type="submit" value="查看班级信息"/></td></tr>
      </table>
    </form>
  </div>
</div>
</body>
</html>
