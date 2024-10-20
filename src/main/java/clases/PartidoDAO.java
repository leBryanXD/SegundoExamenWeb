package clases;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidoDAO {

    // Método para agregar un partido usando el procedimiento almacenado
    public boolean agregarPartido(int idJornada, int equipoLocalID, int equipoVisitanteID, String fechaPartido) {
        String sql = "{CALL proc_agregar_partido(?, ?, ?, ?)}";
        try (Connection con = DBConnection.getConnection(); CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, idJornada);
            cs.setInt(2, equipoLocalID);
            cs.setInt(3, equipoVisitanteID);
            cs.setString(4, fechaPartido);
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Partido> listarPartidosPorJornada(int idJornada) {
        List<Partido> partidos = new ArrayList<>();
        String sql = "SELECT p.*, e1.nombre_equipo AS equipo_local, e2.nombre_equipo AS equipo_visitante "
                + "FROM Partidos p "
                + "JOIN Equipos e1 ON p.equipo_local_id = e1.id_equipo "
                + "JOIN Equipos e2 ON p.equipo_visitante_id = e2.id_equipo "
                + "WHERE p.id_jornada = ?";  // Filtrar por jornada

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idJornada);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Partido partido = new Partido(
                        rs.getInt("id_jornada"),
                        rs.getString("equipo_local"),
                        rs.getString("equipo_visitante"),
                        rs.getDate("fecha")
                );
                partidos.add(partido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partidos;
    }

}
