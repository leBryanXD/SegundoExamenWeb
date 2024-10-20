package clases;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/calendario")
public class CalendarioServlet extends HttpServlet {

    private CalendarioDAO calendarioDAO;

    public void init() {
        calendarioDAO = new CalendarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action == null) {
            action = "list";  // Acción por defecto para listar jornadas
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "list":
            default:
                listJornadas(request, response);  // Llamar al método para listar jornadas
                break;
        }
    }

    // Método para mostrar el formulario de creación de jornada
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("calendario-form.jsp");
        dispatcher.forward(request, response);
    }

    // Método para crear una nueva jornada
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        crearCalendario(request, response);
    }

   private void crearCalendario(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String fechaJornada = request.getParameter("fecha");

    calendarioDAO.crearCalendario(fechaJornada);  // Crear la jornada
    response.sendRedirect("calendario?action=list");  // Redirigir a la lista de jornadas
}


    // Método para listar las jornadas
   private void listJornadas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    List<Jornada> listJornadas = calendarioDAO.listarJornadas();

    request.setAttribute("listJornadas", listJornadas);
    RequestDispatcher dispatcher = request.getRequestDispatcher("calendario.jsp");
    dispatcher.forward(request, response);
}

}
