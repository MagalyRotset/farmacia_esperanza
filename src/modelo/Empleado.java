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
public class Empleado {
    
    int id;
    String nombre;
    String apellidop;
    String apellidom;
    String telefono;
    String puesto;
    String correo;
    String contrasenia;
    
    
    public Empleado(){}
    
    public Empleado(int id,String nombre,String apellidop,String apellidom,String telefono,String puesto,String correo,String contrasenia ){
        this.id=id;
        this.nombre=nombre;
        this.apellidop=apellidop;
        this.apellidom=apellidom;
        this.telefono=telefono;
        this.puesto=puesto;
        this.correo=correo;
        this.contrasenia=contrasenia;   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
}


