package clases;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalendarioDAO {

    // Método para crear una nueva jornada (calendario) usando el procedimiento almacenado
    public boolean crearCalendario(String fechaJornada) {
        String sql = "{CALL proc_crear_calendario(?)}";  // Llamada al procedimiento almacenado

        try (Connection con = DBConnection.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1, fechaJornada);  // Solo pasamos la fecha al procedimiento
            cs.executeUpdate();  // Ejecutar el procedimiento
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Jornada> listarJornadas() {
    List<Jornada> jornadas = new ArrayList<>();
    String sql = "SELECT * FROM Jornadas";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Jornada jornada = new Jornada(
                rs.getInt("id_jornada"),
                rs.getDate("fecha")
            );
            System.out.println("Jornada obtenida desde el DAO - ID: " + jornada.getIdJornada() + ", Fecha: " + jornada.getFecha());
            jornadas.add(jornada);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return jornadas;
}

}
