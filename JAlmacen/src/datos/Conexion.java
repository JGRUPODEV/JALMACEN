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
    private String pass = "";
    private Connection cnx = null;
    private Connection crear() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cnx = DriverManager.getConnection(dsn, user, pass);  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error conexion");
            return null;
        }
        return cnx;
    }

    public Connection getInstancia() {
        if (cnx == null) {
            return crear();
        }
        return cnx;
    }

    public static void main(String args[]) {
        Conexion c = new Conexion();
        Connection cn = c.getInstancia();
        try {
            Statement st;
            st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet r = st.executeQuery("select * from empresas");
            r.next();
            JOptionPane.showMessageDialog(null, r.getString("EMP_RAZON"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error consulta");
        }
        System.out.println("Un despliegue de Datos");
    }
}
