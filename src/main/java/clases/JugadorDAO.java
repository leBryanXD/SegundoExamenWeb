package clases;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {

    // Método para listar jugadores (usando vista)
    public List<VistaJugador> listarJugadores() {
        List<VistaJugador> jugadores = new ArrayList<>();
        String sql = "SELECT * FROM `vista_consultar_jugadores_por_equipo`";  // Usamos la vista para obtener el nombre del equipo
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                VistaJugador jugador = new VistaJugador(
                        rs.getInt("id_jugador"),
                        rs.getString("nombre_jugador"),
                        rs.getInt("dorsal"),
                        rs.getDouble("estatura"),
                        rs.getString("posicion"),
                        rs.getString("nombre_equipo") // Utilizamos el nombre del equipo en lugar del id
                );
                jugadores.add(jugador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }

    //Este hace que el filtro 
    public List<VistaJugador> listarJugadoresPorEquipo(int idEquipo) {
        List<VistaJugador> jugadores = new ArrayList<>();
        String sql = "SELECT * FROM `vista_consultar_jugadores_por_equipo` WHERE id_equipo = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                VistaJugador jugador = new VistaJugador(
                        rs.getInt("id_jugador"),
                        rs.getString("nombre_jugador"),
                        rs.getInt("dorsal"),
                        rs.getDouble("estatura"),
                        rs.getString("posicion"),
                        rs.getString("nombre_equipo") // Utilizamos el nombre del equipo
                );
                jugadores.add(jugador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }
    
     public List<VistaAuditoriaJugador> listarJugadoresEliminados() {
        List<VistaAuditoriaJugador> jugadoresEliminados = new ArrayList<>();
        String sql = "SELECT * FROM Auditoria_Jugadores WHERE accion = 'DELETE'";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                VistaAuditoriaJugador jugador = new VistaAuditoriaJugador(
                    rs.getInt("id_jugador"),
                    rs.getString("nombre_jugador"),
                    rs.getInt("dorsal"),
                    rs.getDouble("estatura"),
                    rs.getString("posicion"),
                    rs.getString("accion"),  // acción de eliminación
                    rs.getTimestamp("fecha")  // fecha de eliminación
                );
                jugadoresEliminados.add(jugador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadoresEliminados;
    }

    // Método para recuperar jugador eliminado usando procedimiento almacenado
    public boolean recuperarJugadorEliminado(int idJugador) {
    String sql = "{CALL proc_recuperar_jugador_eliminado(?)}";
    try (Connection con = DBConnection.getConnection(); CallableStatement cs = con.prepareCall(sql)) {
        cs.setInt(1, idJugador);
        cs.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.err.println("Error al recuperar jugador: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}


    public boolean agregarJugador(Jugador jugador) {
        String sql = "{CALL proc_agregar_jugador(?, ?, ?, ?, ?)}"; // Llamada al procedimiento almacenado
        try (Connection con = DBConnection.getConnection(); CallableStatement cs = con.prepareCall(sql)) {

            // Asignar los parámetros al procedimiento almacenado
            cs.setString(1, jugador.getNombreJugador());
            cs.setInt(2, jugador.getDorsal());
            cs.setDouble(3, jugador.getEstatura());
            cs.setString(4, jugador.getPosicion());
            cs.setInt(5, jugador.getIdEquipo());

            cs.executeUpdate(); // Ejecutar el procedimiento almacenado
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarJugador(int idJugador) {
        String sql = "{CALL proc_eliminar_jugador(?)}";  // Llamada al procedimiento almacenado
        try (Connection con = DBConnection.getConnection(); CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, idJugador);  // Pasamos el ID del jugador al procedimiento
            cs.executeUpdate();  // Ejecutamos la eliminación
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
