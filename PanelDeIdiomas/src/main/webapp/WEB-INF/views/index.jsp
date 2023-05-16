<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add title here</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<div class="row">
	<div class="col">
	<a href="/language/new">nuevo lenguaje</a>
	</div>
	</div>
		<div class="row">
			<div class="col">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>Creator</th>
							<th>Version</th>
							<th>action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${langs}" var="lang">
							<tr>
								<td><a href="/language/${lang.id}"><c:out
											value="${lang.name}" /></a></td>
								<td><c:out value="${lang.creator}" /></td>
								<td><c:out value="${lang.currentVersion}" /></td>
								<td><a href="/language/delete/${lang.id}">delete</a> <a
									href="/language/edit/${lang.id}">edit</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
	</div>
</body>
</html>