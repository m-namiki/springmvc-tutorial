<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
			</a> 
			<a class="brand" href="#">SpringMVC-Tutorial</a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="active"><a href='<s:url value="/input.html"></s:url>'>Input</a></li>					
					<li class="active"><a href='<s:url value="/json.html"></s:url>'>Json</a></li>
					<security:authorize access="isAuthenticated()">
						<li><a href='<s:url value="/logout"></s:url>'>Logout</a></li>
					</security:authorize>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>