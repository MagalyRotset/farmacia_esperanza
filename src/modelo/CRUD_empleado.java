/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Magaly García
 */
public class CRUD_empleado {
     PreparedStatement ps;
     ResultSet rs;
     conexion acceso = new conexion();
    Connection con;
    
    // ***************Validar usuario en login**************************
    public Empleado validarUsuario(String correo,String contrasenia){
        Empleado em= new Empleado();
        String sql = "select * from empleado where correo=? and pass=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getInt(1));
                em.setCorreo(rs.getString(2));
                em.setPuesto(rs.getString(3));
                em.setContrasenia(rs.getString(4));
          }
        } catch (Exception e) {
        }
        return em;
    }
    
    //********LISTADO DE EMPLEADOS**************

    public List listarEmpleado() {
        String sql = "select * from empleado";
        List<Empleado> listaEmpleado = new ArrayList<>();
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setNombre(rs.getString(2));
                em.setApellidop(rs.getString(3));
                em.setApellidom(rs.getString(4));
                em.setTelefono(rs.getString(5));
                em.setPuesto(rs.getString(6));
                em.setCorreo(rs.getString(7));
                em.setContrasenia(rs.getString(8));
                listaEmpleado.add(em);
            }
        } catch (Exception e) {
        }
        return listaEmpleado;
    }
    
    
    //*************Agregar empleados**********************
     public int agregarEmpleado(Empleado em) {
        int r = 0;
        String sql = "insert into empleado(Nombre,a_paterno,a_materno,tel,cargo,correo,pass)values(?,?,?,?,?,?,?)";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getApellidop());
            ps.setString(3, em.getApellidom());
            ps.setString(4, em.getTelefono());
            ps.setString(5, em.getPuesto());
            ps.setString(6, em.getCorreo());
            ps.setString(7, em.getContrasenia());

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     
    //*********ELIMINAR EMPLEADOS************************
     public int eliminarEmpleado(int id) {
        int r = 0;
        String sql = "delete from empleado where id_emple=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     
     
    //**********ACTUALIZAR EMPLEADOS**************
     public int actualizarEmpleado(Empleado em) {
        int r = 0;
        String sql = "update empleado set nombre=?, a_paterno=?, a_materno=?, tel=?, cargo=?, correo=?,pass=? where id_emple=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getNombre());
            ps.setString(2, em.getApellidop());
            ps.setString(3, em.getApellidom());
            ps.setString(4, em.getTelefono());
            ps.setString(5, em.getPuesto());
            ps.setString(6, em.getCorreo());
            ps.setString(7, em.getContrasenia());
            ps.setInt(8, em.getId());
            
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.err.println("" + e);
        }
        return r;
    }
}
