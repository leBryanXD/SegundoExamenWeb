<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
    <head>
        <title>Lista de Jornadas</title>
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
            <h2>Lista de Jornadas</h2>
            <a href="calendario?action=new" class="btn btn-primary mb-3">Crear Nueva Jornada</a>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>ID Jornada</th>
                        <th>Fecha de la Jornada</th>
                    </tr>
                </thead>
                <tbody>
                
                <c:forEach var="jornada" items="${listJornadas}">
                    <tr>
                        <td>${jornada.idJornada}</td>
                        <td>${jornada.fecha}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
