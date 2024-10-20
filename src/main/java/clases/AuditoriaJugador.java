package clases;

import java.sql.Timestamp;

public class AuditoriaJugador {
    private int idAuditoria;
    private int idJugador;
    private String accion;
    private Timestamp fecha;
    private String nombreJugador;
    private int dorsal;
    private double estatura;
    private String posicion;
    private int idEquipo;

    // Constructor
    public AuditoriaJugador(int idAuditoria, int idJugador, String accion, Timestamp fecha, String nombreJugador, int dorsal, double estatura, String posicion, int idEquipo) {
        this.idAuditoria = idAuditoria;
        this.idJugador = idJugador;
        this.accion = accion;
        this.fecha = fecha;
        this.nombreJugador = nombreJugador;
        this.dorsal = dorsal;
        this.estatura = estatura;
        this.posicion = posicion;
        this.idEquipo = idEquipo;
    }

    // Constructor vacío
    public AuditoriaJugador() {
    }

    // Getters y Setters
    public int getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(int idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
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
