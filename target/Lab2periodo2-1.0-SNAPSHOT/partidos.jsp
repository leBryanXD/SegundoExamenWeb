<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Partidos</title>
    
    <!-- CDN Bootstrap 5.3 -->
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

    <!-- Contenedor principal -->
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2>Lista de Partidos por Jornada</h2>
            <a href="partidos?action=new" class="btn btn-primary">Agregar Nuevo Partido</a> <!-- Botón para ir a partido-form.jsp -->
        </div>

        <!-- Tabla de partidos agrupados por jornada -->
        <c:forEach var="jornada" items="${listJornadas}">
            <h4>Jornada: ${jornada.fecha}</h4>
            <table class="table table-bordered table-striped mb-5">
                <thead>
                    <tr>
                        <th>Equipo Local</th>
                        <th>Equipo Visitante</th>
                        <th>Fecha del Partido</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="partido" items="${jornada.partidos}">
                        <tr>
                            <td>${partido.equipoLocal}</td>
                            <td>${partido.equipoVisitante}</td>
                            
                            <td>${partido.fecha}</td>
                        </tr>
                    </c:forEach>

                    <!-- Si no hay partidos en esta jornada -->
                    <c:if test="${empty jornada.partidos}">
                        <tr>
                            <td colspan="4">No hay partidos programados en esta jornada.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </c:forEach>

        <!-- Si no hay jornadas -->
        <c:if test="${empty listJornadas}">
            <p>No hay jornadas disponibles.</p>
        </c:if>
    </div>

    <!-- Bootstrap JS (opcional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
