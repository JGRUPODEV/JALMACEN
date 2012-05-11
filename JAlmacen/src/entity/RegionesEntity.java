/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Conect;

/**
 *
 * @author FYANES
 */
public class RegionesEntity {
    private String REG_PK;
    private String REG_NOMBRE;
    
    

    public String getREG_NOMBRE() {
        return REG_NOMBRE;
    }
    public String getREG_PK() {
        return REG_PK;
    }

    public void setREG_NOMBRE(String REG_NOMBRE) {
        this.REG_NOMBRE = REG_NOMBRE;
    }
    public void setREG_PK(String REG_PK) {
        this.REG_PK = REG_PK;
    }
    public ArrayList listREG_NOMBRE() throws SQLException {
        Statement stm;
        Conect cnx = new Conect();
        PreparedStatement pstm = null;
        stm = (Statement) cnx.getConnection().createStatement();
        String seleccion = "SELECT * FROM regiones";
        pstm = cnx.getConnection().prepareStatement(seleccion);
        ArrayList<String> ls = new ArrayList<>();
        ResultSet rs = pstm.executeQuery();
       
        while(rs.next()){
            //datos de la tabla
            ls.add(rs.getString("REG_PK"));
            ls.add(rs.getString("REG_NOMBRE"));//nombre es el campo de la base de datos
            
            
        }
        
        return ls;
    }
    public ArrayList findREG_NOMBRE(String REG_PK, String REG_NOMBRE) throws SQLException {
        Statement stm;
        Conect cnx = new Conect();
        PreparedStatement pstm = null;
        stm = (Statement) cnx.getConnection().createStatement();
        String seleccion = "SELECT * FROM regiones";
        pstm = cnx.getConnection().prepareStatement(seleccion);
        ArrayList<String> ls = new ArrayList<>();
        ResultSet rs = pstm.executeQuery();
       
        while(rs.next()){
            //datos de la tabla
            if ((REG_PK.equals(rs.getString("REG_PK"))) || (REG_NOMBRE.equals(rs.getString("REG_NOMBRE")))){
            ls.add(rs.getString("REG_PK"));
            ls.add(rs.getString("REG_NOMBRE"));//nombre es el campo de la base de datos
            }
            
        }
        
        return ls;
    
    }
}
