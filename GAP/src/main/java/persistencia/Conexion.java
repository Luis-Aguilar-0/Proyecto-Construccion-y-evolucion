package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

    /*conexion con la base de datos en SQL Server
    nombre de la base de datos: gapdb
    Driver jdbc: mssql-jdbc.jar
    usuario : laac
    contraseña : slt-
    puerto : 1433
    */

    public static Connection connexion = null; //usada para hacer la conexion a la base
    private static Properties propiedades = new Properties(); //usada para almacenar los datos de conexion a la base

    /**
     * metodo configuracion
     * Usado para definir las configuraciones para la conexion a la base
     * como el usuario, la contraseña y la url
     */
    private static void configura(){
        propiedades.put("user","laac");
        propiedades.put("password","slt-");//cambiar 1600 por 1433 para que la usen los demas
        propiedades.put("url","jdbc:sqlserver://localhost:1600;databaseName=gapbd;encrypt=false;trustServerCertificate=true;");

    }

    public static Connection gConnection(){
        try {
            if(connexion == null || connexion.isClosed()) {
                try{              
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                }catch(ClassNotFoundException e){
                    throw new RuntimeException("Driver JDBC no encontrado", e);
                }

                configura(); //se cargan las configuraciones a la variable propiedades
                // 1) Muéstrame exactamente qué URL estás usando:
                System.out.println(">>> JDBC URL: " + propiedades.getProperty("url"));
                System.out.println(">>> Usuario : " + propiedades.getProperty("user"));
                try{//se asignan las configuraciones a la variable conexion
                    connexion = DriverManager.getConnection(propiedades.getProperty("url"),  
                                                            propiedades.getProperty("user"), 
                                                            propiedades.getProperty("password"));
                }catch(SQLException e){
                    throw new RuntimeException("Error al conectar a la base de datos", e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error comprobando el estado de la conexión", e);
        }
        return connexion;
    }


    
}
