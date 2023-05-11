<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<c:forEach items="${actividades}" var="actividad">
	<c:if test="${actividad.contains('ganaste')}">
		<p class="text-success">
			<c:out value="${actividad}" />
		</p>
	</c:if>
	<c:if test="${actividad.contains('perdiste')}">
		<p class="text-danger">
			<c:out value="${actividad}" />
		</p>
	</c:if>
</c:forEach>