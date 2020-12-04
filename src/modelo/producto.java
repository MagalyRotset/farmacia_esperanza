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
public class producto {
    int id_prod;
    String nombre;
    String descripcion;
    float precio;
    String fcaducidad;
    int stock;
    String proveedor;
    
    public producto(){}
    public producto(int id_prod,String nombre,String descripcion,String fcaducidad, float precio, int stock, String proveedor){
       
       this.id_prod=id_prod;
       this.nombre=nombre;
       this.descripcion=descripcion;
       this.precio=precio;
       this.fcaducidad=fcaducidad;
       this.stock=stock;
       this.proveedor=proveedor;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getFcaducidad() {
        return fcaducidad;
    }

    public void setFcaducidad(String fcaducidad) {
        this.fcaducidad = fcaducidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor =proveedor;
    }
    
    
}
