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
public class cliente {
    int id_cliente;
    String nombre;
    String apellidos;
    String direccion;
    String telefono;
    String rfc;
    String correo;
    
    
    public cliente(){}
    public cliente(int id_cliente,String nombre,String apellidos,String direccion,String telefono,String rfc, String correo){
    this.id_cliente=id_cliente;
    this.nombre=nombre;
    this.apellidos=apellidos;
    this.direccion=direccion;
    this.telefono=telefono;
    this.rfc=rfc;
    this.correo=correo;
    
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}
