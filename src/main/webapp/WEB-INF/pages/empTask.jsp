<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--accepts an array of task from the controller and list on page -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${contextPath}/resources/dist/css/bootstrap.css"
	rel="stylesheet">

<title>Employee Task Management Screen</title>
</head>
<body>
	<div class="container">
		<div class="row col-lg-6 col-md-offset-2 custyle">
<!-- Here is the table to display the tasks -->
			<table class="table table-striped custab">		
				<thead>
					<tr>
						<th>Task ID</th>
						<th>Task Description</th>
						<th>Status</th>
						<th>Assigned To</th>
					</tr>
				</thead>
<!-- This is where we are rendering from the array task and displaying on table with help of spring framework -->
				<c:forEach var="task" items="${taskList}">
				<tr>
<!-- The TaskID is hyperlinked and reroutes to the update task page -->
				<td><a href="${contextPath}/viewTask/${task.taskID}/${username}">${task.taskID}</a></td>
				<td>${task.description}</td>
				<td>${task.status}</td>
				<td>${task.assignedTo}</td>
				</tr>
				</c:forEach>
			</table>
<!-- button to go back to homepage -->
			<a href="${contextPath}/" class="btn btn-default btn-block">
					<i class="glyphicon glyphicon-home"></i> Back to Login</a>
		</div>
	</div>
</body>
</html>