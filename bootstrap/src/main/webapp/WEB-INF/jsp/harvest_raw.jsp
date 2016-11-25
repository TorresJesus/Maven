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
					<li><a href="new-harvest-raw">New Harvest Raw</a></li>
					<li><a href="all-harvest-raws">All Harvest Raws</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Harvest Raw Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode=='MODE_HARVEST_RAWS'}">
			<div class="container text-center" id="harvestRawDiv">
				<h3>My Harvest Raws</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Site</th>
								<th>Station</th>
								<th>Sample Date</th>
								<th>Variable</th>
								<th>flag</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="harvestRaw" items="${harvestRaws}">
								<tr>
									<td>${harvestRaw.id}</td>
									<td>${harvestRaw.site}</td>
									<td>${harvestRaw.station}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${harvestRaw.sampleDate}" /></td>
									<td>${harvestRaw.variable}</td>
									<td>${harvestRaw.flag==true?"YES":"NO"}</td>
									<td><a href="update-harvest-raw?id=${harvestRaw.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-harvest-raw?id=${harvestRaw.id}"> <span
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
				<h3>Manage Harvest Raw</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-harvest-raw">
					<input type="hidden" name="id" value="${harvestRaw.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Site:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="site"
								value="${harvestRaw.site}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Station:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="station"
								value="${harvestRaw.station}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Sample Date:</label>
						<div class="col-sm-7">
							<input type="date" class="form-control" name="sampleDate"
								value="${harvestRaw.sampleDate}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Variable:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="variable"
								value="${harvestRaw.variable}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Flag:</label>
						<div class="col-sm-7">
							<input type="radio" class="col-sm-1" name="flag"
								value="true" />
								<div class="col-sm-2">YES</div>
							<input type="radio" class="col-sm-1" name="flag"
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