package clases;

import java.sql.Timestamp;

public class VistaAuditoriaJugador {

    private int idJugador;
    private String nombreJugador;
    private int dorsal;
    private double estatura;
    private String posicion;
    private String accion;
    private Timestamp fecha;

    public VistaAuditoriaJugador(int idJugador, String nombreJugador, int dorsal, double estatura, String posicion, String accion, Timestamp fecha) {
        this.idJugador = idJugador;
        this.nombreJugador = nombreJugador;
        this.dorsal = dorsal;
        this.estatura = estatura;
        this.posicion = posicion;
        this.accion = accion;
        this.fecha = fecha;
    }

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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    
}
