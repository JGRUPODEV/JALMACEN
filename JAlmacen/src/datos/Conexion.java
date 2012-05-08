/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author FYANES
 */
public class Conexion {
    private String dsn = "jdbc:mysql://localhost:3306/jalmacen";
    private String user = "root";
    private String pass= "";
    private Connection cnx;
    public Statement st;
    private Conexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cnx= DriverManager.getConnection(dsn,user,pass);
            st = cnx.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error conexion");
        }
    }
    
    public static Conexion getInstance() {
        return ConexionHolder.INSTANCE;
    }
    
    private static class ConexionHolder {

        private static final Conexion INSTANCE = new Conexion();
    }
    public static void main(String args[]) {
        Conexion c = new Conexion();
        try {
            ResultSet r = c.st.executeQuery("select * from empresas");
            r.next();
            JOptionPane.showMessageDialog(null, r.getString("EMP_RAZON"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error consulta");
        }
	System.out.println("Un despliegue de Datos");
    }
}
