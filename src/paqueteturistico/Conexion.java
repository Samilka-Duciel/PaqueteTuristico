/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paqueteturistico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    //inicializo las variables a usar.
  private static final String URL="jdbc:mariadb://localhost/";
    private static final String BASEDATOS="paqueteturistico";
    private static final String USUARIO="root";
    private static final String CONTRASENA="";
    //inicializo el objeto connection
    private static Connection conexion;
    
    private Conexion(){}
    //para conectarse a la base de datos llamo al metodo Conexion.getConexion();
        public static Connection getConexion(){
    if (conexion == null) {
        try {
            //cargar driver
            Class.forName("org.mariadb.jdbc.Driver");
            //conectar a la base de datos
            conexion = DriverManager.getConnection(URL+BASEDATOS,USUARIO,CONTRASENA);
           JOptionPane.showMessageDialog(null, "Conectado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la Base de Datos"+ex.getMessage());
           
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Driver"+ex.getMessage());
          
        }
    }
    return conexion;
}
    }
    

