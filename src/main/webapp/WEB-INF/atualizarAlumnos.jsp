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
	<h1>Actualizar Alumnos</h1>
	<%@include file="/menu.html"%>s

	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/Colegio/formularioactualizaralumnos" method="post"> <!-- corregir -->
			  
				<label for="id">Id Alumno</label> 
				<input type="text" id="id" name="id">
				<label for="nombre">Nombre Alumno</label> 
				<input type="text" id="nombre" name="nombre"><br>
			    <input type="submit" value="Enviar">
			</form>
		</div>
	</div>
	
	<c:if test="${empty lista}">
		<h1>No hay resultados con estos filtros</h1>
	</c:if>
	
	<c:forEach items="${lista}" var="alumno">
		<form action="http://localhost:8080/Colegio/actualizaralumnos" method="post">
		  <input class="hidden" type="text" id="idOld" value="${alumno.id}"> <!-- completar -->
			<label for="id">Id Alumno</label> 
			<input type="text" id="id" name="name" value="${alumno.id}">
			<label for="nombre">Nombre Alumno</label> 
			<input type="text" id="nombre" name="nombre">
			
			
			<label for="nombre">Nombre Alumno</label> 
			<select name="municipios" id="municipios" form="formulario">
				<c:forEach items="${comboMunicipios}"  var="municipio"> 
					<option value="${alumno.idMunicipio}" selected> """
				</c:forEach>
			</select>
		</form>
	
	</c:forEach>
	
		


</body>
</html>