package clases;
import java.sql.Date;

public class Partido {
    private int idJornada;
    private int equipoLocalID;
    private int equipoVisitanteID;
    private Date fecha;
    private String equipoLocal;  // Este es el nombre del equipo local
    private String equipoVisitante;  // Este es el nombre del equipo visitante

    // Constructor con nombres de equipos
    public Partido(int idJornada, String equipoLocal, String equipoVisitante, Date fecha) {
        this.idJornada = idJornada;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
    }

    // Getters y setters para los nuevos campos
    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    // Otros getters y setters...
    public int getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(int idJornada) {
        this.idJornada = idJornada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
