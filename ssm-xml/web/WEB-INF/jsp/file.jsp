<%--
  Created by IntelliJ IDEA.
  User: My
  Date: 2023/4/6
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    出现问题，页面不刷新--%>
<%--    <script src="https://code.jquery.com/jquery-3.1.1.min.js"/>--%>
</head>
<body>

<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
  <input type="file" name="file"/>
  <input type="submit" value="upload">
</form>

<form action="${pageContext.request.contextPath}/upload2" enctype="multipart/form-data" method="post">
  <input type="file" name="file"/>
  <input type="submit" value="upload">
</form>

<a href="${pageContext.request.contextPath}/download">点击下载</a>
</body>
<%--<script>--%>
<%--    function a1(){--%>
<%--        $.post({--%>
<%--            url:"${pageContext.request.contextPath}/a1",--%>
<%--            data:{'name':$("#txtName").val()},--%>
<%--            success:function (data,status) {--%>
<%--                alert(data);--%>
<%--                alert(status);--%>
<%--            }--%>
<%--        });--%>
<%--    }--%>
<%--</script>--%>
</html>
