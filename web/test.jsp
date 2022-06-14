<%--
  Created by IntelliJ IDEA.
  User: smreo
  Date: 2022-06-04
  Time: 오후 6:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ajax_test02" %>
<html>
<script>
    function fn_process() {
        alert("에러발생")
    }
</script>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="전송하기" onclick="fn_process()">
</body>
</html>
