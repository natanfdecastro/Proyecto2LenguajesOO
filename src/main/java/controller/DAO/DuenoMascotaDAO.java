/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.DuenoMascota;

/**
 *
 * @author windows10
 */
public class DuenoMascotaDAO {
    
    public static void insertarValoresDuenoMascota(int cedula, String nombre, String apellidos, String direccion, int telefono){
          
        Connection c;
        Statement stmt;
        
        String comando = "INSERT INTO ";
        String atributos = "DuenoMascota (CEDULA,NOMBRE,APELLIDOS,DIRECCION,TELEFONO) ";
        String valores =  "VALUES (" + cedula + ", '" + nombre + "', '" + apellidos + "', '"+ direccion + "', "+ telefono +" );";
        
        OperacionesBaseDatos.operacionesValoresTabla(comando, atributos, valores);

    }
    
     
    public static void borrarValoresDuenoMascota(int cedula){
    
        String comando = "DELETE from ";
        String atributos = "DuenoMascota where ID=";
        String valores = cedula + ";";

        
        OperacionesBaseDatos.operacionesValoresTabla(comando, atributos, valores);
  
    }

    
    public static ArrayList<DuenoMascota> listarDuenosMascota(ArrayList<DuenoMascota> duenosMascotas){
    
            Connection c;
            Statement stmt;
            
            try {
               Class.forName("org.sqlite.JDBC");
               c = DriverManager.getConnection("jdbc:sqlite:tienda.db");
               c.setAutoCommit(false);
               System.out.println("[ Base de Datos Abierta CORRECTAMENTE ]");

               stmt = c.createStatement();
               ResultSet rs = stmt.executeQuery( "SELECT * FROM DuenoMascota;" );


               while ( rs.next() ) {
                   
                  DuenoMascota duenoMascota = new DuenoMascota();

                  int cedula = rs.getInt("Cedula");
                  String nombre = rs.getString("Nombre");
                  String apellidos = rs.getString("Apellidos");
                  String direccion = rs.getString("Direccion");
                  int telefono = rs.getInt("Telefono");
                  
                  duenoMascota.setCedula(cedula);
                  duenoMascota.setNombre(nombre);
                  duenoMascota.setApellidos(apellidos);
                  duenoMascota.setDireccion(direccion);
                  duenoMascota.setTelefono(telefono);
                  
                  duenosMascotas.add(duenoMascota);

                  System.out.print( " | CEDULA: " + cedula );
                  System.out.print( " | NOMBRE: " + nombre );
                  System.out.print( " | APELLIDOS: " + apellidos );
                  System.out.print( " | DIRECCION: " + direccion);
                  System.out.print( " | TELEFONO: " + telefono + " |");
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
            
            return duenosMascotas;
            
       }    
    
}
