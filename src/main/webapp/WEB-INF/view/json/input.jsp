<%@ page language="java" trimDirectiveWhitespaces="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
	$(document).ready(function() {
		$('#jsonReq').click(function() {
			var form = $("#jsonCommand");
			var param = {};
			$(form.serializeArray()).each(function(i, v) {
				param[v.name] = v.value;
			});
			var data = $.toJSON(param);
			$.ajax({
				type: "POST",
				url: "json.html",
				contentType: "application/json",
				data: data,
				dataType: 'json',
				success: function(data) {
					$("#responseName").empty();
					$("#responseAge").empty();
					$("#departmentName").empty();

					$("<span/>").append('名前 = ' + data.name)
							.appendTo("#responseName");
					$("<span/>").append('年齢  = ' + data.age).appendTo("#responseAge");
					$("<span/>").append('所属部署 = ' + data.departmentName)
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
<div id="responseName"></div>
<div id="responseAge"></div>
<div id="departmentName"></div>
