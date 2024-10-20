<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestión de Liga de Baloncesto</title>
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
        <div class="jumbotron">
            <h1 class="display-4">Bienvenido a la Gestión de la Liga de Baloncesto</h1>
            <p class="lead">Desde aquí puedes gestionar los equipos, jugadores, partidos y calendarios de la liga.</p>
            <hr class="my-4">
            <p>Utiliza el menú de navegación para acceder a las diferentes secciones de la aplicación.</p>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
