<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de Equipo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>${equipo == null ? "Agregar Nuevo Equipo" : "Editar Equipo"}</h2>
        <form action="equipos?action=${equipo == null ? 'insert' : 'update'}" method="post">
            <input type="hidden" name="id" value="${equipo != null ? equipo.idEquipo : 0}">
            <div class="mb-3">
                <label for="nombreEquipo" class="form-label">Nombre del Equipo</label>
                <input type="text" class="form-control" id="nombreEquipo" name="nombre_equipo" value="${equipo != null ? equipo.nombreEquipo : ''}" required>
            </div>
            <div class="mb-3">
                <label for="sede" class="form-label">Sede</label>
                <input type="text" class="form-control" id="sede" name="sede" value="${equipo != null ? equipo.sede : ''}" required>
            </div>
            <button type="submit" class="btn btn-success">${equipo == null ? "Agregar" : "Actualizar"}</button>
            <a href="equipos" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>
</body>
</html>
