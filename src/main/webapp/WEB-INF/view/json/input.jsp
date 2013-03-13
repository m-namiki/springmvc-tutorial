<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#jsonReq').click(function() {
			$.ajax({
				type: "POST",
				url: "json.html",
				contentType: "application/json",
				data: '{"name":"John Deo", "age":"30"}',
				dataType: 'json',
				success: function(data) {
					$("#name").empty();
					$("#age").empty();
					$("#departmentName").empty();

					$("<span/>").append('name = ' + data.name)
							.appendTo("#name");
					$("<span/>").append('age  = ' + data.age).appendTo("#age");
					$("<span/>").append('deptName = ' + data.departmentName)
							.appendTo("#departmentName");
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					alert("textStatus=" + textStatus);
					alert("errorThrown=" + errorThrown);
				}
			});
		});
	});
</script>

<form:form modelAttribute="jsonCommand" action="json.html" method="POST">
	<form:input path="name" class="input-large" placeholder="名前" />
	<form:errors path="name" class="text-error" />
	<br>
	<form:input path="age" class="input-large" placeholder="年齢" />
	<form:errors path="age" class="text-error" />
	<br>
	<input type="button" id="jsonReq" class="btn btn-primary" value="送信"/>
</form:form>
<div id="name"></div>
<div id="age"></div>
<div id="departmentName"></div>
