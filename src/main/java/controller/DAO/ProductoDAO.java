package controller.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductoDAO {
    
    
    public static void insertarValoresProducto(int idProducto, String nombre, String descripcion, int cantidadExistente){
    
        
        Connection c;
        Statement stmt;
        
        String valores =  "VALUES (" + idProducto + ", '" + nombre + "', '" + descripcion + "', '"+ cantidadExistente + "' );";
        
        
        try {
           Class.forName("org.sqlite.JDBC");
           c = DriverManager.getConnection("jdbc:sqlite:tienda.db");
           c.setAutoCommit(false);
           
           stmt = c.createStatement();
           
           String sql = "INSERT INTO Producto (IDPRODUCTO,NOMBRE,DESCRIPCION,CANTIDADEXISTENTE) " + valores; 
           stmt.executeUpdate(sql);
           
           stmt.close();
           c.commit();
           c.close();
        } 
        catch ( ClassNotFoundException | SQLException e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           System.exit(0);
        }
        
        System.out.println("[ Valores insertados EXITOSAMENTE ]");
    
    
    }
    
    public static void listarProductos(){
    
            Connection c;
            Statement stmt;
            try {
               Class.forName("org.sqlite.JDBC");
               c = DriverManager.getConnection("jdbc:sqlite:tienda.db");
               c.setAutoCommit(false);
               System.out.println("[ Base de Datos Abierta CORRECTAMENTE ]");

               stmt = c.createStatement();
               ResultSet rs = stmt.executeQuery( "SELECT * FROM Producto;" );


               while ( rs.next() ) {

                  int idProducto = rs.getInt("IdProducto");
                  String nombre = rs.getString("Nombre");
                  String descripcion = rs.getString("Descripcion");
                  int cantidadExistente = rs.getInt("CantidadExistente");

                  System.out.print( " | ID PRODUCTO: " + idProducto );
                  System.out.print( " | NOMBRE: " + nombre );
                  System.out.print( " | DESCRIPCION: " + descripcion );
                  System.out.print( " | CANTIDAD EXISTENTE: " + cantidadExistente + " |");
                  System.out.println();
               }
               rs.close();
               stmt.close();
               c.close();
            } 
            catch ( Exception e ) {
               System.err.println( e.getClass().getName() + ": " + e.getMessage() );
               System.exit(0);
            }
       

       }
    
}
