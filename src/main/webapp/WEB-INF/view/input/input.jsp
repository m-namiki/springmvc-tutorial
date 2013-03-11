<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Input - Input</title>
</head>
<body>
	<form:form modelAttribute="inputCommand" action="input.html" method="POST">
		Please input your name.<br>
		<form:input path="name" /><br>
		<input type="submit" />
	</form:form>
</body>
</html>