/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author arman
 */
public class Usuario {
    
    //En esta clase ira todo lo relacionado con el cliente
    //atributos
    private int id;
    private String usuario;
    private String email;
    private String pasword;
    private double saldo; //cuanto dinero se ha gastado en comprar juegos 
    private int ajoloCoins;//sirve para comprar juegos en la plataforma
    private String imagenPerfil;
    private int idBiblioteca;
    private int idTarjetaCredito;

    //contructores
    public Usuario(){}

    public Usuario(int id_,String usuario_,String email_,String pasword_, double saldo_, int ajoloCoins_ ,String imagenPerfil_,int idBiblioteca_,int idTarjetaCredito_){
        
        this.id = id_;
        this.usuario = usuario_;
        this.email = email_;
        this.pasword = pasword_;
        this.saldo = saldo_;
        this.ajoloCoins = ajoloCoins_;
        this.imagenPerfil = imagenPerfil_;
        this.idBiblioteca = idBiblioteca_;
        this.idTarjetaCredito = idTarjetaCredito_;

    }

    //getter y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public int getIdTarjetaCredito() {
        return idTarjetaCredito;
    }

    public void setIdTarjetaCredito(int idTarjetaCredito) {
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

    public int getAjoloCoins(){
        return ajoloCoins;
    }

    public void setAjoloCoins(int coins){
        this.ajoloCoins = coins;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    @Override
    public String toString() {
        return "Cliente [usuario=" + usuario + ", email=" + email + ", pasword=" + pasword + ", saldo=" + saldo
                + ", imagenPerfil=" + imagenPerfil + "]";
    }
    
}
