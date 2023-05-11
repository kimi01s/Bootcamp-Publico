<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hora</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h3 class="hora">
					<c:out value="${hora}" />
				</h3>
</body>
<script type="text/javascript" src="/js/hora.js"></script>
</html>