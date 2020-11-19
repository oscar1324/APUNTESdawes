<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Familiarizarse con BBDD</title>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/formularios.css">
<link rel="stylesheet" href="css/tablas.css">
</head>
<body>
	<h1>Listado de alumnos:</h1>
	<%@include file="/menu.html"%>

	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/Colegio/listadoAlumnos" method="post"> <!-- corregir -->
				<label for="id">Id Alumno</label> <input type="text" id="id"
					name="id"> <label for="nombre">Nombre Alumno</label> <input
					type="text" id="nombre" name="nombre"><br> <input
					type="submit" value="Enviar">
			</form>
		</div>
	</div>
	
	<table>
		<tr>
			<th>ID</th>
			<th>NOMBRE</th>
		</tr>
	
	</table>
</body>
</html>