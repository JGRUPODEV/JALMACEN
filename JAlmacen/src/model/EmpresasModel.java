/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.PreparedStatement;
import entity.EmpresasEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FYANES
 */
public class EmpresasModel {
    public List<EmpresasEntity> listado(){
         List<EmpresasEntity> emp = new ArrayList<>();
        try {
            Conect cnx = new Conect();
            Connection cn = cnx.getConnection();
            Statement st;
            st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet r = st.executeQuery("select * from empresas");
            while(r.next()){
                EmpresasEntity objEmp = new EmpresasEntity();
                objEmp.setEMP_PK(r.getLong("EMP_PK"));
                objEmp.setEMP_RAZON(r.getString("EMP_RAZON"));
                objEmp.setEMP_RUT(r.getString("EMP_RUT"));
                objEmp.setEMP_TELEFONO1(r.getString("EMP_TELEFONO1"));
                objEmp.setEMP_TELEFONO2(r.getString("EMP_TELEFONO2"));
                objEmp.setEMP_CORREO(r.getString("EMP_CORREO"));
                emp.add(objEmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emp;
    }
    
    public void insertar(EmpresasEntity emp){
        try {
            Conect cnx = new Conect();
            Connection cn = cnx.getConnection();
            PreparedStatement ins;
            ins = (PreparedStatement) cn.prepareStatement("INSERT INTO EMPRESAS(EMP_RAZON,EMP_RUT,EMP_TELEFONO1,EMP_TELEFONO2,EMP_FAX,EMP_SITIO,EMP_CORREO) VALUES(?,?,?,?,?,?,?)");
            ins.setString(1,emp.getEMP_RAZON());
            ins.setString(2, emp.getEMP_RUT());
            ins.setString(3, emp.getEMP_TELEFONO1());
            ins.setString(4,emp.getEMP_TELEFONO2());
            ins.setString(5, emp.getEMP_FAX());
            ins.setString(6, emp.getEMP_SITIO());
            ins.setString(7, emp.getEMP_CORREO());
            ins.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpresasModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
