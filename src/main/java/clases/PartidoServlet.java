package clases;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/partidos")
public class PartidoServlet extends HttpServlet {

    private PartidoDAO partidoDAO;
    private EquipoDAO equipoDAO;  // Declarar e inicializar equipoDAO
    private JornadaDAO jornadaDAO;  // Declarar e inicializar jornadaDAO

    public void init() {
        partidoDAO = new PartidoDAO();
        equipoDAO = new EquipoDAO();  // Inicializar equipoDAO
        jornadaDAO = new JornadaDAO();  // Inicializar jornadaDAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);  // Mostrar el formulario de creación
                break;
            default:
                listPartidos(request, response);  // Listar partidos
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Jornada> listJornadas = jornadaDAO.listarJornadas();  // Obtener las jornadas existentes
        List<Equipo> listEquipos = equipoDAO.listarEquipos();  // Obtener los equipos disponibles

        request.setAttribute("listJornadas", listJornadas);
        request.setAttribute("listEquipos", listEquipos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("partido-form.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insert".equals(action)) {
            insertPartido(request, response);
        }
    }

    private void insertPartido(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idJornada = Integer.parseInt(request.getParameter("id_jornada"));
        int equipoLocalID = Integer.parseInt(request.getParameter("equipoLocalID"));
        int equipoVisitanteID = Integer.parseInt(request.getParameter("equipoVisitanteID"));
        String fechaPartido = request.getParameter("fechaPartido");

        // Llamada al DAO pasando los parámetros separados
        partidoDAO.agregarPartido(idJornada, equipoLocalID, equipoVisitanteID, fechaPartido);

        response.sendRedirect("partidos");
    }

    private void listPartidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener todas las jornadas
        List<Jornada> listJornadas = jornadaDAO.listarJornadas();

        // Para cada jornada, obtenemos los partidos de esa jornada
        for (Jornada jornada : listJornadas) {
            List<Partido> partidos = partidoDAO.listarPartidosPorJornada(jornada.getIdJornada());
            jornada.setPartidos(partidos);  // Agregar los partidos a la jornada
        }

        // Pasamos la lista de jornadas con sus partidos al JSP
        request.setAttribute("listJornadas", listJornadas);

        // Redirigimos a partidos.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("partidos.jsp");
        dispatcher.forward(request, response);
    }

}
