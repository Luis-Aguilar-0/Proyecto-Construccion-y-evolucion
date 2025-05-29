package logic;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList; 
import java.util.List;

/**
 *
 * @author arman
 */
public class Usuario {

    // En esta clase ira todo lo relacionado con el cliente
    private int id;
    private String usuario;
    private String email;
    private String pasword;
    private double saldo; 
    private Integer ajoloCoins;
    private byte[] imagenPerfil;
    private List<Juego> juegos;
    private List<Tarjeta> tarjetasGuardadas; 
    private Date fechaNacimiento;
    private Integer idTarjetaCredito; 

    // contructores
    public Usuario() {
        this.juegos = new ArrayList<>();
        this.tarjetasGuardadas = new ArrayList<>();
    }

    public Usuario(int id_, String usuario_, String email_, String pasword_, double saldo_, Integer ajoloCoins_,
                   byte[] imagenPerfil_) {
        this(); 
        this.id = id_;
        this.usuario = usuario_;
        this.email = email_;
        this.pasword = pasword_;
        this.saldo = saldo_;
        this.ajoloCoins = ajoloCoins_;
        this.imagenPerfil = imagenPerfil_;
    }

    /**
     * Constructor usado cuando se crea registra un nuevo usuario en la base de datos
     * @param usuario
     * @param email
     * @param pasword
     * @param fechaNacimiento
     */
    public Usuario(String usuario, String email, String pasword, Date fechaNacimiento) throws IOException, URISyntaxException {
        this.usuario = usuario;
        this.email = email;
        this.pasword = pasword;
        this.fechaNacimiento = fechaNacimiento;
        this.ajoloCoins = 100; // Regalamos 100 ajoloCoins a cada usuario nuevo
        this.saldo = 0.0;
        //obtenemos la direccion de la imgen de perfil por defecto
        URL url = getClass().getResource("/imagenes/imagesPerfil/perfil4.png");
        if (url != null) {
            try {
                System.out.println(url);
                Path path = Paths.get(url.toURI());
                this.imagenPerfil = Files.readAllBytes(path);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }


    public Usuario(String usuario, String email, String pasword) {
        this(); 
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

    public List<Juego> getJuegos() {
        if (this.juegos == null) {
            this.juegos = new ArrayList<>();
        }
        return juegos;
    }

    public void setJuegos(List<Juego> juegos) {
        this.juegos = juegos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setIdTarjetaCredito(Integer idTarjetaCredito) {
        this.idTarjetaCredito = idTarjetaCredito;
    }

    public Integer getIdTarjetaCredito() {
        return idTarjetaCredito;
    }

    //  Metodos para gestionar la lista de tarjetas guardadas
    /**
     * Obtiene la lista de tarjetas de credito/debito guardadas por el usuario
     * @return Una lista de objetos Tarjeta. La lista estara vacía si no hay tarjetas
     */
    public List<Tarjeta> getTarjetasGuardadas() {
        if (this.tarjetasGuardadas == null) {
            this.tarjetasGuardadas = new ArrayList<>();
        }
        return tarjetasGuardadas;
    }

    /**
     * Establece la lista de tarjetas de credito - debito para el usuario
     * Si la lista proporcionada es null, se inicializa como una lista vacia
     * @param tarjetasGuardadas La nueva lista de tarjetas.
     */
    public void setTarjetasGuardadas(List<Tarjeta> tarjetasGuardadas) {
        this.tarjetasGuardadas = (tarjetasGuardadas != null) ? tarjetasGuardadas : new ArrayList<>();
    }

    /**
     * Agrega una tarjeta a la lista de tarjetas guardadas del usuario
     * si no existe ya una tarjeta con el mismo ID
     * @param tarjeta La tarjeta a agregar
     */
    public void agregarTarjetaGuardada(Tarjeta tarjeta) {
        if (this.tarjetasGuardadas == null) {
            this.tarjetasGuardadas = new ArrayList<>();
        }
        if (tarjeta != null) {
            boolean existe = false;
            for (Tarjeta tExistente : this.tarjetasGuardadas) {
                if (tExistente.getIdTarjeta() == tarjeta.getIdTarjeta()) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                this.tarjetasGuardadas.add(tarjeta);
            }
        }
    }

    /**
     * Remueve una tarjeta de la lista de tarjetas guardadas del usuario
     * basandose en ID
     * @param idTarjetaAEliminar El ID de la tarjeta que se desea eliminar
     */
    public void removerTarjetaGuardada(int idTarjetaAEliminar) {
        if (this.tarjetasGuardadas != null) {
            this.tarjetasGuardadas.removeIf(tarjeta -> tarjeta.getIdTarjeta() == idTarjetaAEliminar);
        }
    }

    @Override
    public String toString() {
        return "Cliente [usuario=" + usuario + ", email=" + email + ", pasword=" + pasword + ", saldo=" + saldo
                + ", imagenPerfil=" + imagenPerfil + "]";
    }
}
