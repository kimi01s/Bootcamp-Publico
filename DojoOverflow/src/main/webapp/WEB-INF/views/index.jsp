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
<title>questions dashboard</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row py-3">
			<div class="col">
				<h1>Question dashboard</h1>
			</div>
			<div class="col text-end">
				<a href="/questions/new" class="btn btn-outline-success">nueva
					pregunta</a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Question</th>
							<th>Tags</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${questions}" var="question">
							<tr>
								<td><a href="/questions/show/${question.id}"><c:out
											value="${question.question}"></c:out></a></td>
								<td><c:forEach items="${question.tags}" var="tag">
										<c:out value="${tag.name}"></c:out>
									</c:forEach></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>