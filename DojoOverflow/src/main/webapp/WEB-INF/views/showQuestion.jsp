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
<title>Question Profile</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- for Bootstrap JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row py-3">
			<div class="col">
				<h1>
					<c:out value="${question.question}"></c:out>
				</h1>
			</div>
			<div class="col text-end">
				<a href="/" class="btn btn-outline-success">atrás</a>
			</div>
		</div>
		<div class="row pb-3">
			<div class="col-1">
				<p>tags:</p>
			</div>
			<c:forEach items="${question.tags}" var="tag">
				<div class="col-1">
					<button class="btn btn-warning">
						<c:out value="${tag.name}"></c:out>
					</button>
				</div>
			</c:forEach>
		</div>
		<div class="row">
			<div class="col-4 me-5">
				<table class="table table-hover border">
					<thead>
						<tr>
							<th>Answers</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${question.answers}" var="answer">
							<tr>
								<td><c:out value="${answer.answer}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-4">
				<h3>Add your answer</h3>
				<form:form action="/answers/new" method="post"
					modelAttribute="newAnswer">
					<input type="hidden" name="question" value="${question.id}" />
					<div class="form-group row mb-3">
						<label for="answer" class="col-sm-3 col-form-label">Answer:</label>
						<div class="col-sm-9">
							<textarea name="answer" class="form-control" id="answer" required></textarea>
						</div>
					</div>
					<button class="btn btn-outline-success">submit</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>