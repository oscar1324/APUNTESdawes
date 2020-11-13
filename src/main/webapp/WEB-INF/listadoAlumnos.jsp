<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Familiarizarse con BBDD</title>
</head>
<body>
	<h1>Listado de alumnos:</h1>
	
	<ul>  <!-- items es lo que le va a pasar el controller -->
	<c:forEach items="${lista}" var="alumno">
			<li> ${alumno.id} - ${alumno.nombre } </li>
	</c:forEach>
	</ul>
</body>
</html>