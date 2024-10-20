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
        <div class="container mt-5">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h4 class="card-title mb-0">Agregar Partido</h4>
                </div>
                <div class="card-body">
                    <form action="partidos?action=insert" method="post">

                        <!-- Jornada -->
                        <div class="mb-3">
                            <label for="jornada" class="form-label">Jornada</label>
                            <select class="form-select" id="jornada" name="id_jornada" required>
                                <c:forEach var="jornada" items="${listJornadas}">
                                    <option value="${jornada.idJornada}">${jornada.fecha}</option>  <!-- Puedes mostrar otra información de la jornada si lo deseas -->
                                </c:forEach>
                            </select>
                        </div>

                        <!-- Equipo Local -->
                        <div class="mb-3">
                            <label for="equipoLocal" class="form-label">Equipo Local</label>
                            <select class="form-select" id="equipoLocal" name="equipoLocalID" required>
                                <c:forEach var="equipo" items="${listEquipos}">
                                    <option value="${equipo.idEquipo}">${equipo.nombreEquipo}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <!-- Equipo Visitante -->
                        <div class="mb-3">
                            <label for="equipoVisitante" class="form-label">Equipo Visitante</label>
                            <select class="form-select" id="equipoVisitante" name="equipoVisitanteID" required>
                                <c:forEach var="equipo" items="${listEquipos}">
                                    <option value="${equipo.idEquipo}">${equipo.nombreEquipo}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <!-- Fecha del Partido -->
                        <div class="mb-3">
                            <label for="fechaPartido" class="form-label">Fecha del Partido</label>
                            <input type="date" class="form-control" id="fechaPartido" name="fechaPartido" required>
                        </div>

                        <!-- Botón de envío -->
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary btn-block">Agregar Partido</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Bootstrap JS (opcional) -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    </body>
</html>
