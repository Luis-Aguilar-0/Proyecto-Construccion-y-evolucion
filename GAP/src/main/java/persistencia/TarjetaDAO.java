package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.Tarjeta;

public class TarjetaDAO {

    private Connection conexion;

    public TarjetaDAO() throws SQLException {
        this.conexion = Conexion.gConnection();
    }

    public int agregarTarjeta(Tarjeta tarjeta) throws SQLException {
        String sql = "INSERT INTO tarjetacredito (numTarjeta, tipoTarjeta, fExpiracion, cSeguridad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setLong(1, tarjeta.getNumTarjeta());
            pstmt.setString(2, tarjeta.getTipoTarjeta());
            pstmt.setDate(3, tarjeta.getFechaExpiracion());
            pstmt.setInt(4, tarjeta.getCodSeguridad());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No se pudo guardar la tarjeta.");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Devuelve el ID generado
                } else {
                    throw new SQLException("No se pudo obtener el ID de la tarjeta guardada.");
                }
            }
        }
    }
    
    // Metodo para asociar una tarjeta a un usuario 
    public boolean asociarTarjetaAUsuario(int idUsuario, int idTarjeta) throws SQLException {
        String sql = "INSERT INTO usuario_tarjetas_guardadas (idUsuario, idTarjetaCredito) VALUES (?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idTarjeta);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            if (e.getMessage().contains("Violation of PRIMARY KEY constraint")) {
                System.out.println("TarjetaDAO: Tarjeta ID " + idTarjeta + " ya esta asociada al usuario ID " + idUsuario);
                return true; 
            }
            throw e; 
        }
    }

    // obtener todas las tarjetas de un usuario
    public List<Tarjeta> obtenerTarjetasPorUsuario(int idUsuario) throws SQLException {
        List<Tarjeta> tarjetas = new ArrayList<>();
        String sql = "SELECT t.* FROM tarjetacredito t " +
                     "JOIN usuario_tarjetas_guardadas utg ON t.idTarjetaCredito = utg.idTarjetaCredito " +
                     "WHERE utg.idUsuario = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Tarjeta tarjeta = new Tarjeta();
                    tarjeta.setIdTarjeta(rs.getInt("idTarjetaCredito"));
                    tarjeta.setNumTarjeta(rs.getLong("numTarjeta"));
                    tarjeta.setTipoTarjeta(rs.getString("tipoTarjeta"));
                    tarjeta.setFechaExpiracion(rs.getDate("fExpiracion"));
                    tarjeta.setCodSeguridad(rs.getInt("cSeguridad"));
                    tarjetas.add(tarjeta);
                }
            }
        }
        return tarjetas;
    }
    

    // eliminar asociación y la tarjeta)
    public boolean eliminarAsociacionTarjeta(int idUsuario, int idTarjeta) throws SQLException {
        String sqlDeleteAsociacion = "DELETE FROM usuario_tarjetas_guardadas WHERE idUsuario = ? AND idTarjetaCredito = ?";
        int affectedRowsAsociacion;
        try (PreparedStatement pstmt = conexion.prepareStatement(sqlDeleteAsociacion)) {
            pstmt.setInt(1, idUsuario);
            pstmt.setInt(2, idTarjeta);
            affectedRowsAsociacion = pstmt.executeUpdate();
        }

        if (affectedRowsAsociacion > 0) {

            String sqlDeleteTarjeta = "DELETE FROM tarjetacredito WHERE idTarjetaCredito = ?";

            try (PreparedStatement pstmtTarjeta = conexion.prepareStatement(sqlDeleteTarjeta)) {
                pstmtTarjeta.setInt(1, idTarjeta);
                pstmtTarjeta.executeUpdate(); 
            }
            return true;
        }
        return false; 
    }
}