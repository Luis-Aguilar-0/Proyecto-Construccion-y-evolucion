package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

    /*conexion con la base de datos GAPBD
    uando MariaDb y HeidiSQL
    nombre de la base de datos: gapdb
    libreria : libmariadb.dll
    usuario : root
    contraseña : slt-
    puerto : 3306
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
        propiedades.put("password","slt-");
        propiedades.put("url","jdbc:sqlserver://localhost:1433;databaseName=gapbd;encrypt=false;trustServerCertificate=true;");

    }

    public static Connection gConnection(){

        if(connexion == null){//si es null aun no se establese la conexion a la base
            try{              
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            }catch(ClassNotFoundException e){
                throw new RuntimeException();
            }

            configura(); //se cargan las configuraciones a la variable propiedades

            try{//se asignan las configuraciones a la variable conexion
                connexion = DriverManager.getConnection(propiedades.getProperty("url"), propiedades.getProperty("user"), propiedades.getProperty("password"));
            }catch(SQLException e){
            
                throw new RuntimeException();
            }
        }
        
        return connexion;
    }


    
}
