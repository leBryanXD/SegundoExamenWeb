package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JornadaDAO {

    public List<Jornada> listarJornadas() {
    List<Jornada> jornadas = new ArrayList<>();
    String sql = "SELECT * FROM Jornadas";  // Obtiene todas las jornadas

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Jornada jornada = new Jornada(
                rs.getInt("id_jornada"),
                rs.getDate("fecha")
            );
            jornadas.add(jornada);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return jornadas;
}

    
    
}
