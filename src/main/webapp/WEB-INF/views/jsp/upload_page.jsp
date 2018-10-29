<%--
  Created by IntelliJ IDEA.
  User: huynhnguyen
  Date: 10/29/18
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Upload Page</title>
</head>
<body>
<spring:url value="/upload" var="uploadURL"/>
<form:form modelAttribute="formUpload" method="post" action="${uploadURL}" enctype="multipart/form-data">
    <form:input path="files" type="file" multiple="multiple"/>
    <form:errors path="files" cssClass="color: red"/>
    <button type="submit">Upload</button>
</form:form>
</body>
</html>
