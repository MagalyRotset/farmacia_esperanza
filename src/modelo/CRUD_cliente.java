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
public class CRUD_cliente {
    Connection con;
    conexion cn = new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
   //****************LISTAR LOS DATOS DE LOS CLIENTES*********************
    public List listarCliente() {
        String sql = "select * from cliente";
        List<cliente> listaCliente = new ArrayList<>();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente cli = new cliente();
                cli.setId_cliente(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                cli.setApellidos(rs.getString(3));
                cli.setTelefono(rs.getString(4));
                cli.setRfc(rs.getString(5));
                cli.setCorreo(rs.getString(6));
                cli.setDireccion(rs.getString(7));
                listaCliente.add(cli);
            }
        } catch (Exception e) {
        }
        return listaCliente;
    }
    
  //*************AGREGAR CLIENTES**********************
     public int agregarCliente(cliente cli) {
        int r = 0;
        String sql = "insert into cliente(nombre,apellidos,dir,tel,rfc,correo)values(?,?,?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellidos());
            ps.setString(3, cli.getTelefono());
            ps.setString(4, cli.getRfc());
            ps.setString(5, cli.getCorreo());
            ps.setString(6, cli.getDireccion());

            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     
  //*********ELIMINAR CLIENTES************************
     public int eliminarCliente(int id) {
        int r = 0;
        String sql = "delete from cliente where id_cliente=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     
  //**********ACTUALIZAR CLIENTES**************
     public int actualizarCliente(cliente cli) {
        int r = 0;
        String sql = "update cliente set nombre=?, apellidos=?,tel=?, rfc=?, correo=?,direccion=? where id_cliente=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellidos());
            ps.setString(3, cli.getTelefono());
            ps.setString(4, cli.getRfc());
            ps.setString(5, cli.getCorreo());
            ps.setString(6, cli.getDireccion());
            ps.setInt(7, cli.getId_cliente());
            
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
     
  //**************BUSCAR CLIENTE****************************
    
   public List BuscarCliente(int valor) { 
        String sql="select * from cliente where id_cliente='"+valor+"'";
       // String sql = "SELECT p.id_producto, p.nombre,p.caducidad,p.nombre,p.stock, pro.nombre from producto as p, proveedor as pro where id_producto='"+valor+"'";
        List<cliente> listaCliente = new ArrayList<>();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
           // ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente cli = new cliente();
                cli.setId_cliente(rs.getInt(1));
                cli.setNombre(rs.getString(2));
                cli.setApellidos(rs.getString(3));
                cli.setTelefono(rs.getString(4));
                cli.setRfc(rs.getString(5));
                cli.setCorreo(rs.getString(6));
                cli.setDireccion(rs.getString(7));
                listaCliente.add(cli);
            }
        } catch (Exception e) {
        }
        return listaCliente;
    }
   //*********BUSQUEDA DE CLIENTE PARA VENTAS*******************
   public cliente busquedaCli(int id) {
        cliente c = new cliente();
        String sql = "select * from cliente where id_cliente=?";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId_cliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellidos(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return c;
    }
     }
    

