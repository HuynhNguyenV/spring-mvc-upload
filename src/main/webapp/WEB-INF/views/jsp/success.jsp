<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 10/29/18
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>success</title>
</head>
<body>
    <c:forEach items="${fileNames}" var="fileName">
        File <b>${fileName}</b> uploaded successfully <br/>
    </c:forEach>
</body>
</html>
