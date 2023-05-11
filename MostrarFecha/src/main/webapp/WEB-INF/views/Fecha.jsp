<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fecha</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div>
	<h3 class="fecha">
		<c:out value="${fecha}" />
	</h3>
	</div>
</body>
<script type="text/javascript" src="/js/fecha.js"></script>
</html>