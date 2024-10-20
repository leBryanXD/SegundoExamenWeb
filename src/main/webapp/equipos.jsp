<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- Importar JSTL -->
<html>
<head>
    <title>Lista de Equipos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
   <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp">Liga de Baloncesto</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="equipos">Gestionar Equipos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="jugadores">Gestionar Jugadores</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="partidos">Partidos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="calendario">Crear Jornada</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container mt-5">
        
        <h2>Lista de Equipos</h2>
        <a href="equipos?action=new" class="btn btn-primary mb-3">Agregar Nuevo Equipo</a>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre del Equipo</th>
                    <th>Sede</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="equipo" items="${listEquipos}">
                    <tr>
                        <td>${equipo.idEquipo}</td>
                        <td>${equipo.nombreEquipo}</td>
                        <td>${equipo.sede}</td>
                        <td>
                            <a href="equipos?action=edit&id=${equipo.idEquipo}" class="btn btn-warning">Editar</a>
                            <a href="equipos?action=delete&id=${equipo.idEquipo}" class="btn btn-danger" onclick="return confirm('¿Estás seguro de eliminar este equipo?')">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty listEquipos}">
                    <tr>
                        <td colspan="4">No hay equipos registrados.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</body>
</html>
