package clases;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/jugadores")
public class JugadorServlet extends HttpServlet {

    private JugadorDAO jugadorDAO;
    private EquipoDAO equipoDAO;

    public void init() {
        jugadorDAO = new JugadorDAO();
        equipoDAO = new EquipoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "delete":  // Aquí agregamos el caso para eliminar jugadores
                deleteJugador(request, response);
                break;
            case "recuperar":  //  acción para recuperar jugadores eliminados
                listJugadoresEliminados(request, response);
                break;
            case "restore":  //  acción para restaurar un jugador
                restoreJugador(request, response);
                break;
            default:
                listJugadores(request, response);
                break;
        }
    }

    // Método para listar jugadores eliminados desde la auditoría
    private void listJugadoresEliminados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<VistaAuditoriaJugador> listJugadoresEliminados = jugadorDAO.listarJugadoresEliminados();
        request.setAttribute("listJugadoresEliminados", listJugadoresEliminados);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jugadores-eliminados.jsp");
        dispatcher.forward(request, response);
    }

    // Método para restaurar un jugador eliminado
    private void restoreJugador(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idJugador = Integer.parseInt(request.getParameter("id"));
        boolean success = jugadorDAO.recuperarJugadorEliminado(idJugador);

        if (success) {
            System.out.println("Jugador con ID " + idJugador + " restaurado con éxito.");
            // Redirigir a la lista de jugadores 
        } else {
            System.err.println("Error al intentar restaurar el jugador con ID " + idJugador);
        }
        response.sendRedirect("jugadores");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            insertJugador(request, response);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Pasar la lista de equipos a la JSP para seleccionar un equipo
        List<Equipo> listEquipos = equipoDAO.listarEquipos();
        request.setAttribute("listEquipos", listEquipos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("jugador-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertJugador(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombreJugador = request.getParameter("nombre_jugador");
        int dorsal = Integer.parseInt(request.getParameter("dorsal"));
        double estatura = Double.parseDouble(request.getParameter("estatura"));
        String posicion = request.getParameter("posicion");
        int idEquipo = Integer.parseInt(request.getParameter("id_equipo"));

        Jugador nuevoJugador = new Jugador(0, nombreJugador, dorsal, estatura, posicion, idEquipo);
        jugadorDAO.agregarJugador(nuevoJugador);
        response.sendRedirect("jugadores");
    }

    private void listJugadores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idEquipo = request.getParameter("equipo");

        List<Equipo> listEquipos = equipoDAO.listarEquipos();
        request.setAttribute("listEquipos", listEquipos);

        List<VistaJugador> listJugadores;  // Cambiamos el tipo a VistaJugador
        if (idEquipo == null || idEquipo.isEmpty()) {
            listJugadores = jugadorDAO.listarJugadores(); // Todos los jugadores (VistaJugador)
        } else {
            listJugadores = jugadorDAO.listarJugadoresPorEquipo(Integer.parseInt(idEquipo)); // Filtrar por equipo (VistaJugador)
        }

        request.setAttribute("listJugadores", listJugadores);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jugadores.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteJugador(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idJugador = Integer.parseInt(request.getParameter("id"));  // Obtener el ID del jugador
        jugadorDAO.eliminarJugador(idJugador);  // Llamada al DAO para eliminar el jugador
        response.sendRedirect("jugadores");  // Redirigir a la lista de jugadores
    }

}
