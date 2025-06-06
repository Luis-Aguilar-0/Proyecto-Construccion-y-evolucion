package logic;

import java.sql.Date;

public class Juego {

    private int idJuego;
    private String nombreJuego;
    private String rMininos; // requisitos minimos del juego
    private String rRecomendados; // requisitos recomendados
    private double precio;
    private Integer precioAjoloCoins;// moneda recargable
    private String desarrollador;
    private Date fechaLanzamiento;
    private String[] imagenes = new String[4]; // se almacenan solo las direccines en forma de string
    private int categoria;
    private String descripcion;


    public Juego() {
    }

    public Juego(int id_, String nombre, String rMinimos_, String rRecomendados_, String desarrollador_,Date fechaLanzamiento_, String[] imagenes_, double precio_, Integer precionAjoloCoins_, int categoria_, String descripcion_) {
        this.idJuego = id_;
        this.nombreJuego = nombre;
        this.rMininos = rMinimos_;
        this.rRecomendados = rRecomendados_;
        this.desarrollador = desarrollador_;
        this.fechaLanzamiento = fechaLanzamiento_;
        this.imagenes[0] = imagenes_[0];
        this.imagenes[1] = imagenes_[1];
        this.imagenes[2] = imagenes_[2];
        this.imagenes[3] = imagenes_[3];
        this.precio = precio_;
        this.precioAjoloCoins = precionAjoloCoins_;
        this.categoria = categoria_;
        this.descripcion = descripcion_;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public String getrMininos() {
        return rMininos;
    }

    public void setrMininos(String rMininos) {
        this.rMininos = rMininos;
    }

    public String getrRecomendados() {
        return rRecomendados;
    }

    public void setrRecomendados(String rRecomendados) {
        this.rRecomendados = rRecomendados;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precion) {
        this.precio = precion;
    }

    public Integer getPrecioAjoloCoins() {
        return precioAjoloCoins;
    }

    public void setPrecioAjoloCoins(Integer precioAjoloCoins) {
        this.precioAjoloCoins = precioAjoloCoins;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(String[] imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public String toString() {
        return "idJuego=" + idJuego + ", " + nombreJuego;
    }
    public String getPortada() {
        return imagenes[0]; //obtener portada del juego(1era imagen)
    }
    

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
