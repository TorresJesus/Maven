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
					<li><a href="new-friend">New Friend</a></li>
					<li><a href="all-friends">All Friends</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Friend Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_FRIENDS'}">
			<div class="container text-center" id="friendsDiv">
				<h3>My Friends</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Age</th>
								<th>Email</th>
								<th>Phone</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="friend" items="${friends}">
								<tr>
									<td>${friend.id}</td>
									<td>${friend.name}</td>
									<td>${friend.age}</td>
									<td>${friend.email}</td>
									<td>${friend.phone}</td>
									<td><a href="update-friend?id=${friend.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-friend?id=${friend.id}"> <span
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
				<h3>Manage Friend</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-friend">
					<input type="hidden" name="id" value="${friend.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								value="${friend.name}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Age:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="age"
								value="${friend.age}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Email:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="email"
								value="${friend.email}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Phone:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="phone"
								value="${friend.phone}" />
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