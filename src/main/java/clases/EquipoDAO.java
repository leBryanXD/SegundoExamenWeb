package clases;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO {

    // Método para listar equipos (usando vista)
   public List<Equipo> listarEquipos() {
    List<Equipo> equipos = new ArrayList<>();
    String sql = "SELECT * FROM `vista_consultar_equipos`"; // Vista en la DB
    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql); // Cambiado a PreparedStatement
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Equipo equipo = new Equipo(rs.getInt("id_equipo"), rs.getString("nombre_equipo"), rs.getString("sede"));
            equipos.add(equipo);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return equipos;
}

    // Método para agregar equipo usando procedimiento almacenado
    public boolean agregarEquipo(Equipo equipo) {
        String sql = "{CALL proc_agregar_equipo(?, ?)}";
        try (Connection con = DBConnection.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setString(1, equipo.getNombreEquipo());
            cs.setString(2, equipo.getSede());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar equipo usando procedimiento almacenado
    public boolean actualizarEquipo(Equipo equipo) {
        String sql = "{CALL proc_actualizar_equipo(?, ?, ?)}";
        try (Connection con = DBConnection.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, equipo.getIdEquipo());
            cs.setString(2, equipo.getNombreEquipo());
            cs.setString(3, equipo.getSede());
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar equipo usando procedimiento almacenado
    public boolean eliminarEquipo(int idEquipo) {
        String sql = "{CALL proc_eliminar_equipo(?)}";
        try (Connection con = DBConnection.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, idEquipo);
            cs.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
     // Método para buscar un equipo por su ID
    public Equipo buscarEquipoPorId(int idEquipo) {
        Equipo equipo = null;
        String sql = "SELECT * FROM equipos WHERE id_equipo = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                equipo = new Equipo(rs.getInt("id_equipo"), rs.getString("nombre_equipo"), rs.getString("sede"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipo;
    }
}
