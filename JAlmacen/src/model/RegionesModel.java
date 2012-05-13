/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SDOG
 */
import com.mysql.jdbc.Statement;
import entity.RegionesEntity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
* Clase que permite conectar con la base de datos
* @author alejo
*/
public class RegionesModel {
    
    
    public ArrayList listREG_NOMBRE() throws SQLException {
        Statement stm;
        Conect cnx = new Conect();
        PreparedStatement pstm = null;
        stm = (Statement) cnx.getConnection().createStatement();
        String seleccion = "SELECT * FROM regiones";
        pstm = cnx.getConnection().prepareStatement(seleccion);
        ArrayList<RegionesEntity> ls = new ArrayList<>();
        ResultSet rs = pstm.executeQuery();
        RegionesEntity obj = new RegionesEntity(); 
        
        while(rs.next()){
            
            //datos de la tabla
            obj.setREG_PK((rs.getString("REG_PK")));
            obj.setREG_NOMBRE(rs.getString("REG_NOMBRE"));//nombre es el campo de la base de datos
            ls.add(obj);
            
        }
        
        return ls;
    }
    
    
    public RegionesEntity findREG_NOMBRE(String REG_PK, String REG_NOMBRE) throws SQLException {
        
        Statement stm;
        Conect cnx = new Conect();
        PreparedStatement pstm = null;
        stm = (Statement) cnx.getConnection().createStatement();
        String seleccion = "SELECT * FROM regiones";
        pstm = cnx.getConnection().prepareStatement(seleccion);
        ArrayList<String> ls = new ArrayList<>();
        ResultSet rs = pstm.executeQuery();
        RegionesEntity obj = new RegionesEntity();
        
        while(rs.next()){
            //datos de la tabla
            if ((REG_PK.equals(rs.getString("REG_PK"))) || (REG_NOMBRE.equals(rs.getString("REG_NOMBRE")))){
            obj.setREG_PK(rs.getString("REG_PK"));
            obj.setREG_NOMBRE((rs.getString("REG_NOMBRE")));//nombre es el campo de la base de datos
            }
            
        }
        
        return obj;
    
    }
    
    public void  editREG_NOMBRE(RegionesEntity obj) throws SQLException {
        
        Statement stm;
        Conect cnx = new Conect();
        PreparedStatement pstm = null;
        stm = (Statement) cnx.getConnection().createStatement();
        String seleccion = "update regiones set regiones.REG_NOMBRE="+obj.getREG_NOMBRE()+"";
        pstm = cnx.getConnection().prepareStatement(seleccion);
            
    }
    
}

