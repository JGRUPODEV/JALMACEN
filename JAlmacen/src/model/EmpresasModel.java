/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
}
