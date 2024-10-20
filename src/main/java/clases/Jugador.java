package clases;

public class Jugador {
    private int idJugador;
    private String nombreJugador;
    private int dorsal;
    private double estatura;
    private String posicion;
    private int idEquipo; // Relación con Equipo

    // Constructor
    public Jugador(int idJugador, String nombreJugador, int dorsal, double estatura, String posicion, int idEquipo) {
        this.idJugador = idJugador;
        this.nombreJugador = nombreJugador;
        this.dorsal = dorsal;
        this.estatura = estatura;
        this.posicion = posicion;
        this.idEquipo = idEquipo;
    }

    // Constructor vacío
    public Jugador() {
    }

    // Getters y Setters
    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }
}
