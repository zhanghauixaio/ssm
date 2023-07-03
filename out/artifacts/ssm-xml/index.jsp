<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.net.URLDecoder" %>

<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2022/6/11
  Time: 11:55
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%--<sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver"--%>
<%--                   url="jdbc:mysql://localhost:3307/demo?useSSL=true&userUnicode=true&serverTimezone=UTC"--%>
<%--                   user="root" password="123456"/>--%>
<%= request.getServletPath() + "请求IP地址"%>
<%
    Arrays.asList(request.getCookies()).stream().forEach(cookie -> System.out.println(URLDecoder.decode(cookie.getValue())));
%>
<h1>Hello World!</h1>

<h2>HTTP 头部请求实例</h2>
<table width="100%" border="1" align="center">
    <tr bgcolor="#949494">
        <th>Header Name</th>
        <th>Header Value(s)</th>
    </tr>
<%
   Enumeration headerNames = request.getHeaderNames();
   while(headerNames.hasMoreElements()) {
      String paramName = (String)headerNames.nextElement();
      out.print("<tr><td>" + paramName + "</td>\n");
      String paramValue = request.getHeader(paramName);
      out.println("<td> " + paramValue + "</td></tr>\n");
   }
%>
<h2>自动刷新实例</h2>
<%
   // 设置每隔5秒自动刷新
   response.setIntHeader("Refresh", 5);
   // 获取当前时间
   Calendar calendar = new GregorianCalendar();
   String am_pm;
   int hour = calendar.get(Calendar.HOUR);
   int minute = calendar.get(Calendar.MINUTE);
   int second = calendar.get(Calendar.SECOND);
   if(calendar.get(Calendar.AM_PM) == 0)
      am_pm = "AM";
   else
      am_pm = "PM";
   String CT = hour+":"+ minute +":"+ second +" "+ am_pm;
   out.println("当前时间: " + CT + "\n");
%>
</body>
</html>
