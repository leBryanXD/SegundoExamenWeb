<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Agregar Jugador</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Agregar Nuevo Jugador</h2>
        <form action="jugadores?action=insert" method="post">
            <div class="mb-3">
                <label for="nombreJugador" class="form-label">Nombre del Jugador</label>
                <input type="text" class="form-control" id="nombreJugador" name="nombre_jugador" required>
            </div>
            <div class="mb-3">
                <label for="dorsal" class="form-label">Dorsal</label>
                <input type="number" class="form-control" id="dorsal" name="dorsal" required>
            </div>
            <div class="mb-3">
                <label for="estatura" class="form-label">Estatura</label>
                <input type="number" step="0.01" class="form-control" id="estatura" name="estatura" required>
            </div>
            <div class="mb-3">
                <label for="posicion" class="form-label">Posición</label>
                <input type="text" class="form-control" id="posicion" name="posicion" required>
            </div>
            <div class="mb-3">
                <label for="equipo" class="form-label">Equipo</label>
                <select class="form-select" id="equipo" name="id_equipo" required>
                    <!-- Recorrer la lista de equipos -->
                    <c:forEach var="equipo" items="${listEquipos}">
                        <option value="${equipo.idEquipo}">${equipo.nombreEquipo}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-success">Agregar Jugador</button>
            <a href="jugadores" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
