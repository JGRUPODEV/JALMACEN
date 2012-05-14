/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author FYANES
 */
public class EmpresasEntity {

    private long EMP_PK;
    private String EMP_RAZON;
    private String EMP_RUT;
    private String EMP_TELEFONO1;
    private String EMP_TELEFONO2;
    private String EMP_FAX;
    private String EMP_SITIO;
    private String EMP_CORREO;

    public void setEMP_PK(long EMP_PK) {
        this.EMP_PK = EMP_PK;
    }

    public long getEMP_PK() {
        return EMP_PK;
    }

    public String getEMP_CORREO() {
        return EMP_CORREO;
    }

    public void setEMP_CORREO(String EMP_CORREO) {
        this.EMP_CORREO = EMP_CORREO;
    }

    public String getEMP_FAX() {
        return EMP_FAX;
    }

    public void setEMP_FAX(String EMP_FAX) {
        this.EMP_FAX = EMP_FAX;
    }

    public String getEMP_RAZON() {
        return EMP_RAZON;
    }

    public void setEMP_RAZON(String EMP_RAZON) {
        this.EMP_RAZON = EMP_RAZON;
    }

    public String getEMP_RUT() {
        return EMP_RUT;
    }

    public void setEMP_RUT(String EMP_RUT) {
        this.EMP_RUT = EMP_RUT;
    }

    public String getEMP_SITIO() {
        return EMP_SITIO;
    }

    public void setEMP_SITIO(String EMP_SITIO) {
        this.EMP_SITIO = EMP_SITIO;
    }

    public String getEMP_TELEFONO1() {
        return EMP_TELEFONO1;
    }

    public void setEMP_TELEFONO1(String EMP_TELEFONO1) {
        this.EMP_TELEFONO1 = EMP_TELEFONO1;
    }

    public String getEMP_TELEFONO2() {
        return EMP_TELEFONO2;
    }

    public void setEMP_TELEFONO2(String EMP_TELEFONO2) {
        this.EMP_TELEFONO2 = EMP_TELEFONO2;
    }
}
