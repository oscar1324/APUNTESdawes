<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	<link rel="stylesheet" href="css/index.css">
	<link rel="stylesheet" href="css/formularios.css">
</head>
<body>
<header>
<h2>Insertar alumnos</h2>
</header>
	<%@include file="/menu.html"%>
	
		<div class="container">
		<div class="form">
			<form action="http://localhost:8080/Colegio/insertaralumno" method="post" id="formulario"> 
				<label for="id">DNI Alumno</label>
				 <input type="text" id="id"name="id"> 
					<label for="nombre">Nombre Alumno</label> 
					<input type="text" id="nombre" name="nombre"><br> 
				
					
					<select name="municipios" id="municipios" form="formulario">
					
						<c:forEach items="${comboMunicipios}" var="municipio">
						
							<option value="${municipio.id}"> ${municipio.descripcion}</option>
						
						</c:forEach>
					</select>
						<input type="submit" value="Enviar">
						
					<c:if test="${resultado == 1}">
						<h1>Alumno insertado correctamente</h1>
					</c:if>
			</form>
		</div>
	</div>
	


</body>
</html>



