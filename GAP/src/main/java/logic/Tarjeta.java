package logic;

import java.sql.Date;

public class Tarjeta {

    private int idTarjeta;
    private long numTarjeta;
    private String tipoTarjeta;
    private Date fechaExpiracion;
    private int codSeguridad;

    public Tarjeta(){}

    public Tarjeta(int idTarjeta, long numTarjeta, String tipoTarjeta, Date fechaExpiracion, int codSeguridad) {
        this.idTarjeta = idTarjeta;
        this.numTarjeta = numTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.codSeguridad = codSeguridad;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public long getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(long numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public int getCodSeguridad() {
        return codSeguridad;
    }

    public void setCodSeguridad(int codSeguridad) {
        this.codSeguridad = codSeguridad;
    }

    


    
}
