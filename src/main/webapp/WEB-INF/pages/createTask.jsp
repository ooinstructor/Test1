<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"/>
<!-- link bootstrap style sheet -->
<link href="${contextPath}/resources/dist/css/bootstrap.css" rel="stylesheet">

<title>Create Task</title>
 <h4> Create New Task</h4>
</head>

<body style="margin:30;padding:30">

<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>
<div class="container">
	<div class="row">
<!-- here is the form to create a new task - only allows admin to add description attribute from this page -->
		<form:form action="createTask" modelAttribute="task" method="post">
                  	<div class="row">
                  		<div class="col-md-12">
                  		<div class="form-group">
                            <form:textarea path="description" class="form-control textarea" rows="3" name="Description" id="Description" placeholder="Describe task here"/>
                  		</div>
                  	</div>
                    </div>
                    <div class="row">
                    <div class="col-md-12">
<!-- submit button -->
                    <input type="submit" value="Submit" class="btn main-btn btn-success pull-right">
                  </div>
                  </div>
                </form:form>
	</div>
<!-- button to go back to homepage -->
	<div class="row col-lg-6 col-md-offset-2 custyle">
		<a href="${contextPath}/" class="btn btn-default btn-block">
					<i class="glyphicon glyphicon-home"></i> Back to Login</a>
	</div>
</div>

</body>
</html>