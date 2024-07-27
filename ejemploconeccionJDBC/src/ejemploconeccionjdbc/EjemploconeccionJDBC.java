/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploconeccionjdbc;

/**
 *
 * @author juand
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EjemploconeccionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "";
        String Url = "jdbc:mysql://localhost:3306/ejercicio_coneccion";
        //proceso para establecer conexion
        Connection coneccion; //permite establecer la conexion con la tabla de datos
        Statement statement; //permite ejecutar sentencias sql a traves de la coneccion
        ResultSet rs; //va a recibir la respuesta
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // TODO code application logic here
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EjemploconeccionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        // en estas lineas de codigo podemos guardar-registrar datos en la tabla
        try {
            coneccion = DriverManager.getConnection(Url,usuario,password);
            statement = coneccion.createStatement();
            statement.executeUpdate("INSERT INTO novedades(descripcion,ubicacion) Values('prueba3','prueba4')");
            //en la linea anterior podemos introducir los datos que queremos registrar en la tabla
            rs = statement.executeQuery("SELECT * FROM novedades");
            rs.next();
            do{
                System.out.println(rs.getInt("ID")+" : "+rs.getString("descripcion")+ " : "+rs.getString("ubicacion"));
                //el comando anterior imprimira los registros de la tabla
            }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EjemploconeccionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /*en estas lineas podemos mostrar registros de la base de datos , en el caso siguiente, usando el ID
        try {
            coneccion = DriverManager.getConnection(Url,usuario,password);
            statement = coneccion.createStatement();
            
            rs = statement.executeQuery("SELECT * FROM novedades WHERE ID = '1'");
            rs.next();
            do{
                System.out.println(rs.getInt("ID")+" : "+rs.getString("descripcion")+ " : "+rs.getString("ubicacion"));
                //el comando anterior imprimira los registros de la tabla
            }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EjemploconeccionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
        /* aqui cambiamos los datos insertados en un registro , y luego mostramos los registros
        de la tabla
        
        try {
            coneccion = DriverManager.getConnection(Url,usuario,password);
            statement = coneccion.createStatement();
            statement.executeUpdate("update novedades set descripcion = 'pruebacambiada1',"
                    + " ubicacion = 'pruebacambiada2' where ID = '2' ");
            //en la linea anterior podemos introducir los datos que queremos registrar en la tabla
            rs = statement.executeQuery("SELECT * FROM novedades");
            rs.next();
            do{
                System.out.println(rs.getInt("ID")+" : "+rs.getString("descripcion")+ " : "+rs.getString("ubicacion"));
                //el comando anterior imprimira los registros de la tabla
            }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EjemploconeccionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        /* por ultimo en estas lineas borramos registros que coincidan con el dato que buscamos(ID)
        try {
            coneccion = DriverManager.getConnection(Url,usuario,password);
            statement = coneccion.createStatement();
            statement.executeUpdate("DELETE FROM novedades WHERE ID = '2'");
            //en la linea anterior podemos introducir los datos que queremos registrar en la tabla
            rs = statement.executeQuery("SELECT * FROM novedades");
            rs.next();
            do{
                System.out.println(rs.getInt("ID")+" : "+rs.getString("descripcion")+ " : "+rs.getString("ubicacion"));
                //el comando anterior imprimira los registros de la tabla
            }while(rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EjemploconeccionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } */

    }
    
}
