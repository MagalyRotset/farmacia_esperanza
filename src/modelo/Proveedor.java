/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Magaly García
 */
public class Proveedor {
    int id_proveedor;
    String nombrep;
    String dir;
    String tel;

    public Proveedor(){}
    public Proveedor(int id_proveedor, String nombrep, String dir, String tel) {
        this.id_proveedor = id_proveedor;
        this.nombrep = nombrep;
        this.dir = dir;
        this.tel = tel;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    
}
