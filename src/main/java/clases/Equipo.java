package clases;

public class Equipo {
    private int idEquipo;
    private String nombreEquipo;
    private String sede;

    // Constructor
    public Equipo(int idEquipo, String nombreEquipo, String sede) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.sede = sede;
    }

    // Constructor vacío
    public Equipo() {
    }

    // Getters y Setters
    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
}
