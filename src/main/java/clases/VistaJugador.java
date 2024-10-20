/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author bryan
 */
public class VistaJugador extends Jugador {
    
    private String nombreEquipo;  // Reemplaza el id por el nombre del equipo

    public VistaJugador(int idJugador, String nombreJugador, int dorsal, double estatura, String posicion, String nombreEquipo) {
        super(idJugador, nombreJugador, dorsal, estatura, posicion, 0);  // Pasamos 0 como idEquipo ya que no lo usamos aquí
        this.nombreEquipo = nombreEquipo;
    }

    // Getters y setters para nombreEquipo
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
}


