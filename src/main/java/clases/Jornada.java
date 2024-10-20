package clases;

import java.sql.Date;
import java.util.List;

public class Jornada {
    private int idJornada;
    private Date fecha;
    private List<Partido> partidos; 

    public Jornada(int idJornada, Date fecha) {
        this.idJornada = idJornada;
        this.fecha = fecha;
    }

    // Getters y Setters para partidos
    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

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
