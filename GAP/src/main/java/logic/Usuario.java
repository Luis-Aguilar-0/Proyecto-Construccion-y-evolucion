package logic;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author arman
 */
public class Usuario {

    // En esta clase ira todo lo relacionado con el cliente
    // atributos
    private int id;
    private String usuario;
    private String email;
    private String pasword;
    private double saldo; // cuanto dinero se ha gastado en comprar juegos
    private Integer ajoloCoins;// sirve para comprar juegos en la plataforma
    private byte[] imagenPerfil;
    private Integer idTarjetaCredito;
    private List<Juego> juegos;
    private Tarjeta tarjetaUser;
    private Date fechaNacimiento;

    // contructores
    public Usuario() {
    }

    public Usuario(int id_, String usuario_, String email_, String pasword_, double saldo_, Integer ajoloCoins_,
            byte[] imagenPerfil_, Integer idTarjetaCredito_) {

        this.id = id_;
        this.usuario = usuario_;
        this.email = email_;
        this.pasword = pasword_;
        this.saldo = saldo_;
        this.ajoloCoins = ajoloCoins_;
        this.imagenPerfil = imagenPerfil_;
        this.idTarjetaCredito = idTarjetaCredito_;

    }
    
    /**
     * Constructor usado cuando se crea registra un nuevo usuario en la base de datos
     * @param usuario
     * @param email
     * @param pasword
     * @param fechaNacimiento
     */
    public Usuario(String usuario, String email, String pasword, Date fechaNacimiento) {
        this.usuario = usuario;
        this.email = email;
        this.pasword = pasword;
        this.fechaNacimiento = fechaNacimiento;
        this.ajoloCoins = 0;
        this.saldo = 0.0;
    }
    
    
    public Usuario(String usuario, String email, String pasword) {
        this.usuario = usuario;
        this.email = email;
        this.pasword = pasword;
    }

    // getter y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdTarjetaCredito() {
        return idTarjetaCredito;
    }

    public void setIdTarjetaCredito(Integer idTarjetaCredito) {
        this.idTarjetaCredito = idTarjetaCredito;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Integer getAjoloCoins() {
        return ajoloCoins;
    }

    public void setAjoloCoins(Integer coins) {
        this.ajoloCoins = coins;
    }

    public byte[] getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(byte[] imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    @Override
    public String toString() {
        return "Cliente [usuario=" + usuario + ", email=" + email + ", pasword=" + pasword + ", saldo=" + saldo
                + ", imagenPerfil=" + imagenPerfil + "]";
    }

    public List<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }

    public Tarjeta getTarjetaUser() {
        return tarjetaUser;
    }

    public void setTarjetaUser(Tarjeta tarjetaUser) {
        this.tarjetaUser = tarjetaUser;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
