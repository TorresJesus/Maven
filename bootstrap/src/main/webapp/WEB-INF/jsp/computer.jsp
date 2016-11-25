<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Boot Sample | Home</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-computer">New Computer</a></li>
					<li><a href="all-computers">All Computers</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Computer Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_COMPUTERS'}">
			<div class="container text-center" id="computersDiv">
				<h3>My Computers</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Type</th>
								<th>Model</th>
								<th>Processor</th>
								<th>Enable</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="computer" items="${computers}">
								<tr>
									<td>${computer.id}</td>
									<td>${computer.type}</td>
									<td>${computer.model}</td>
									<td>${computer.processor}</td>
									<td>${computer.enable==true?"YES":"NO"}</td>
									<td><a href="update-computer?id=${computer.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-computer?id=${computer.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Computer</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-computer">
					<input type="hidden" name="id" value="${computer.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Type:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="type"
								value="${computer.type}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Model:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="model"
								value="${computer.model}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Processor:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="processor"
								value="${computer.processor}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Enable:</label>
						<div class="col-sm-7">
							<input type="radio" class="col-sm-1" name="enable"
								value="true" />
								<div class="col-sm-2">YES</div>
							<input type="radio" class="col-sm-1" name="enable"
								value="false" checked="checked"/>
								<div class="col-sm-2">NO</div>
						</div>
					</div>
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
	</c:choose>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
</body>
</html>