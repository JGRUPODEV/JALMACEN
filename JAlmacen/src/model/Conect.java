/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SDOG
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
* Clase que permite conectar con la base de datos
* @author alejo
*/
public class Conect {
   static String login = "root";
   static String password = "";
   static String url = "jdbc:mysql://localhost/jalmacen";

   Connection conn = null;

   /** Constructor de DbConnection */
   public Conect() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("Conección a base de datos jalmacen OK");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }

}

