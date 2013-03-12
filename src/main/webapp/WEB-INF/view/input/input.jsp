<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:hasBindErrors name="inputCommand">
	<div class="text-error">
		<spring:message code="errors.invalid" />
	</div>
</spring:hasBindErrors>

<form:form modelAttribute="inputCommand" action="input.html"
	method="POST">
		メールアドレスとパスワードを入力してください。<br>
	<form:input path="mailAddress" class="input-large"
		placeholder="メールアドレス" />
	<form:errors path="mailAddress" class="text-error" />
	<br>
	<form:password path="password" class="input-large" placeholder="パスワード" />
	<form:errors path="password" class="text-error" />
	<br>
	<input type="submit" value="送信" class="btn btn-primary" />
</form:form>
