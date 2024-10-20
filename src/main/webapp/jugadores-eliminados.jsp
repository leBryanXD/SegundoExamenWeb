<%-- 
    Document   : jugadores-eliminados.jsp
    Created on : 11 oct 2024, 12:48:13
    Author     : bryan
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Jugadores Eliminados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Lista de Jugadores Eliminados</h2>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre del Jugador</th>
                        <th>Dorsal</th>
                        <th>Estatura</th>
                        <th>Posición</th>
                        <th>Acción</th>
                        <th>Fecha de Eliminación</th>
                        <th>Recuperar</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="jugador" items="${listJugadoresEliminados}">
                        <tr>
                            <td>${jugador.idJugador}</td>
                            <td>${jugador.nombreJugador}</td>
                            <td>${jugador.dorsal}</td>
                            <td>${jugador.estatura}</td>
                            <td>${jugador.posicion}</td>
                            <td>${jugador.accion}</td>
                            <td>${jugador.fecha}</td>
                            <td>
                                <a href="jugadores?action=restore&id=${jugador.idJugador}" class="btn btn-success">Recuperar</a>
                            </td>
                        </tr>
                    </c:forEach>

                    <c:if test="${empty listJugadoresEliminados}">
                        <tr>
                            <td colspan="8">No hay jugadores eliminados.</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
            <a href="jugadores" class="btn btn-primary">Volver a Jugadores</a>
        </div>
    </body>
</html>



