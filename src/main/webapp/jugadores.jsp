<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Lista de Jugadores</title>
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
                            <a class="nav-link" href="partidos"> Partidos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="calendario">Crear Jornada</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container mt-5">
            <h2>Lista de Jugadores</h2>
            <form method="GET" action="jugadores" class="p-3 shadow-sm rounded bg-light">
                <div class="mb-2">
                    <label for="equipo" class="form-label fw-semibold">Filtrar por equipo</label>
                    <select class="form-select" name="equipo" id="equipo">
                        <option value="">Todos los Equipos</option>
                        <c:forEach var="equipo" items="${listEquipos}">
                            <option value="${equipo.idEquipo}">${equipo.nombreEquipo}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-primary btn-md px-4">Filtrar</button>
                </div>
            </form>
            <section class="d-flex justify-content-evenly">
                <a href="jugadores?action=new" class="btn btn-primary mb-3">Agregar Nuevo Jugador</a>
                <a href="jugadores?action=recuperar" class="btn btn-warning mb-3">Recuperar Jugador</a>
            </section>


            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre del Jugador</th>
                        <th>Dorsal</th>
                        <th>Estatura</th>
                        <th>Posición</th>
                        <th>Equipo</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Asegúrate de que la lista se está recorriendo correctamente -->
                    <c:forEach var="jugador" items="${listJugadores}">
                        <tr>
                            <td>${jugador.idJugador}</td>
                            <td>${jugador.nombreJugador}</td>
                            <td>${jugador.dorsal}</td>
                            <td>${jugador.estatura}</td>
                            <td>${jugador.posicion}</td>
                            <td>${jugador.nombreEquipo}</td> <!-- Mostrando el nombre del equipo desde la vista -->
                            <td>
                                <a href="jugadores?action=delete&id=${jugador.idJugador}" class="btn btn-danger" onclick="return confirm('¿Estás seguro de eliminar este jugador?')">Eliminar</a>
                            </td>
                        </tr>
                    </c:forEach>

                    <c:if test="${empty listJugadores}">
                        <tr>
                            <td colspan="7">No hay jugadores registrados.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </body>
</html>
