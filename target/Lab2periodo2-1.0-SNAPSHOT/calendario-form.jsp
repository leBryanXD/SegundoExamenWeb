<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Jornada</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Crear Jornada</h2>
        <form action="calendario" method="post">
            <!-- Eliminado el campo de ID de la jornada -->
            
            <!-- Fecha de la Jornada -->
            <div class="mb-3">
                <label for="fechaJornada" class="form-label">Fecha de la Jornada</label>
                <input type="date" class="form-control" id="fechaJornada" name="fecha" required>
            </div>
            
            <!-- Botones de acción -->
            <button type="submit" class="btn btn-success">Crear Jornada</button>
            <a href="calendario" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>

    <!-- Bootstrap JS (opcional) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
