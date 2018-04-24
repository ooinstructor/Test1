<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstracdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<link href="${contextPath}/resources/dist/css/bootstrap.css" rel="stylesheet">
<link href="${contextPath}/resources/dist/css/login.css" rel="stylesheet">

<title>Employee Management Screen</title>

</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
<!-- Login Form -->
				<form:form action="login" class="form-horizontal" method="post" modelAttribute="user">
	<!-- Username Input Form -->
					<div class="form-group">
						<label for="username" class="cols-sm-2 control-label">Username</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
								<form:input path="username" placeholder="username" type="text" class="form-control" />
							</div>
						</div>
					</div>
	<!-- Password Input Form -->
					<div class="form-group">
						<label for="password" class="cols-sm-2 control-label">Password</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
								<form:input path="password" type="password" class="form-control" placeholder="password" />
							</div>
						</div>
					</div>
					<br />
					<br />
					<input type="submit" value="login" class="btn btn-success btn-block">
				</form:form>
<!-- Error message for incorrect login info -->
				<br />
				<c:if test="${not empty error}">
				<table>
					<tr>
						<td class="alert alert-danger">${error}</td>
					</tr>
				</table>
				</c:if>
			</div>
		</div>
	</div>

</body>
</html>