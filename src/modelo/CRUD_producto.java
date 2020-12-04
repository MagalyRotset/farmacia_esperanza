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
public class CRUD_producto {
    PreparedStatement ps;
     ResultSet rs;
     conexion acceso = new conexion();
    Connection con;
    int r;
   // producto p = new producto();
    
    
  //*************MOSTRAR LOS PRODUCTOS DEL INVENTARIO*****************************  
    public List listarProducto() {
        String sql="select * from productos";
        //String sql = "SELECT p.id_producto, p.nombre,p.caducidad,p.nombre,p.stock, pro.nombre from producto as p, proveedor as pro"; 
        List<producto> listaprod = new ArrayList<>();
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto p = new producto();
                p.setId_prod(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setFcaducidad(rs.getString(4));
                p.setPrecio(rs.getFloat(5));
                p.setStock(rs.getInt(6));
                p.setProveedor(rs.getString(7));
                listaprod.add(p);
            }
        } catch (Exception e) {
        }
        return listaprod;
    }
    
  //********************BUSCAR PRODUCTO************************************
    public List buscarProducto(String valor) { 
        String sql="select * from productos where nombre like'"+valor+"'";
       // String sql = "SELECT p.id_producto, p.nombre,p.caducidad,p.nombre,p.stock, pro.nombre from producto as p, proveedor as pro where id_producto='"+valor+"'";
        List<producto> listaproducto = new ArrayList<>();
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
           // ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                producto p = new producto();
                p.setId_prod(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setDescripcion(rs.getString(3));
                p.setFcaducidad(rs.getString(4));
                p.setPrecio(rs.getFloat(5));
                p.setStock(rs.getInt(6));
                p.setProveedor(rs.getString(7));
                listaproducto.add(p);
            }
        } catch (Exception e) {
        }
        return listaproducto;
    }
    
    //*************AGREGAR PRODUCTOS**********************
     public int agregarProducto(producto p) {
        int r = 0;
        String sql = "insert into productos(nombre,descripcion,caducidad,precio,stock,proveedor)values(?,?,?,?,?,?)";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setString(3, p.getFcaducidad());
            ps.setDouble(4, p.getPrecio());
            ps.setInt(5, p.getStock());
            ps.setString(6, p.getProveedor());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     //***************ACTUALIZAR PRODUCTOS***************************
      public int actualizarProducto(producto p) {
        int r = 0;
        String sql = "update productos set nombre=?, descripcion=?,caducidad=?, precio=?, stock=?,proveedor=? where id_produccto=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDescripcion());
            ps.setString(3, p.getFcaducidad());
            ps.setFloat(4, p.getPrecio());
            ps.setInt(5, p.getStock());
            ps.setString(6, p.getProveedor());
            ps.setInt(7, p.getId_prod());
            
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
     //*************ELIMINAR PRODUCTO***********************
      public int eliminarProducto(int id) {
        int r = 0;
        String sql = "delete from productos where id_produccto=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    //**************LISTAR PRODUCTOS*******************  
      public producto listarID(int id) {
       producto p = new producto();
        String sql = "select * from productos where id_produccto=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setId_prod(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getFloat(5));
                p.setStock(rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return p;
    }
     //*********************ACTUALIZAR STOCK**************************
      public int actualizarStock(int cant, int idp) {
        String sql = "update productos set stock=? where id_produccto=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setInt(2, idp);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

}
