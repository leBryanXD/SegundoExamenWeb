package clases;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/equipos")
public class EquipoServlet extends HttpServlet {

    private EquipoDAO equipoDAO;

    public void init() {
        equipoDAO = new EquipoDAO();
    }

    // Método doGet para manejar solicitudes GET
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");

    if (action == null) {
        action = "list"; // Acción por defecto: listar equipos
    }

    switch (action) {
        case "new":
            showNewForm(request, response);
            break;
        case "edit":
            showEditForm(request, response);
            break;
        case "delete":
            deleteEquipo(request, response);
            break;
        default:
            listEquipos(request, response); // Llamar al método para listar equipos
            break;
    }
}

    // Nuevo método doPost para manejar solicitudes POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "insert";
        }

        switch (action) {
            case "insert":
                insertEquipo(request, response);
                break;
            case "update":
                updateEquipo(request, response);
                break;
            default:
                listEquipos(request, response);
                break;
        }
    }

    private void listEquipos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Equipo> listEquipos = equipoDAO.listarEquipos();
        request.setAttribute("listEquipos", listEquipos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("equipos.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("equipo-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEquipo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nombreEquipo = request.getParameter("nombre_equipo");
        String sede = request.getParameter("sede");
        Equipo nuevoEquipo = new Equipo(0, nombreEquipo, sede);
        equipoDAO.agregarEquipo(nuevoEquipo);
        response.sendRedirect("equipos");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idEquipo = Integer.parseInt(request.getParameter("id"));
        Equipo equipoExistente = equipoDAO.buscarEquipoPorId(idEquipo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("equipo-form.jsp");
        request.setAttribute("equipo", equipoExistente);
        dispatcher.forward(request, response);
    }

    private void updateEquipo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEquipo = Integer.parseInt(request.getParameter("id"));
        String nombreEquipo = request.getParameter("nombre_equipo");
        String sede = request.getParameter("sede");

        Equipo equipo = new Equipo(idEquipo, nombreEquipo, sede);
        equipoDAO.actualizarEquipo(equipo);
        response.sendRedirect("equipos");
    }

    private void deleteEquipo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEquipo = Integer.parseInt(request.getParameter("id"));
        equipoDAO.eliminarEquipo(idEquipo);
        response.sendRedirect("equipos");
    }
}
