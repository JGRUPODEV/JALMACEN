/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.EmpresasEntity;
import java.util.List;
import model.EmpresasModel;

/**
 *
 * @author FYANES
 */
public class EmpresasController {
    public List<EmpresasEntity> listado(){
        EmpresasModel emp = new EmpresasModel();
        return emp.listado();        
    }
    
    public void insertar(EmpresasEntity emp){
        EmpresasModel empModel = new EmpresasModel();
        empModel.insertar(emp);
    }
}
