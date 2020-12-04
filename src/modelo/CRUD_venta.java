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
public class CRUD_venta {
     conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;
    
    
    //***************NUMERO DE SERIE DE LA VENTA********************************
    
     public String NumSerieVentas() {
        String serie = "";
        String sql = "select max(serie) from venta";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                serie = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return serie;
    }
    
    //************ID DE LAS VENTAS**************************
     public String IdVentas() {
        String idv = "";
        String sql = "select max(id_venta) from venta";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idv = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idv;
    }
   //****************GUARDAR VENTA****************************
     public int GuardarVentas(Ventas v) {
        String sql = "insert into venta(serie,fecha,monto,id_emple,id_cliente)values(?,?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getSerie());
            ps.setString(2, v.getFecha());
            ps.setDouble(3, v.getMonto());
            ps.setInt(4, v.getId_empleado());
            ps.setInt(5, v.getIdCliente());
            r = ps.executeUpdate();
        } catch (Exception e) {
        }

        return r;
    }
    //*******************DETALLE  VENTA*****************
     public int GuardarDetalleVentas(DetalleVentas dv) {
        String sql = "insert into detalleventa(id_venta,id_producto,cantidad,preVenta)values(?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getIdVentas());
            ps.setInt(2, dv.getIdProducto());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPreVenta());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
   
   //**************LISTAR VENTAS**********************
      public List listarVentas() {
        String sql = "select IdVentas, NumeroSerie, FechaVentas, Monto from ventas";
        List<Ventas> ventasp = new ArrayList<>();
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ventas ventas = new Ventas();
                ventas.setId(rs.getInt(1));
                ventas.setSerie(rs.getString(2));
                ventas.setFecha(rs.getString(3));
                ventas.setMonto(rs.getDouble(4));
                ventasp.add(ventas);
            }
        } catch (Exception e) {
        }
        return ventasp;
    }
     
}
