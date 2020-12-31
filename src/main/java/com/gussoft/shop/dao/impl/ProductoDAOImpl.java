package com.gussoft.shop.dao.impl;

import com.gussoft.shop.config.Conexion;
import com.gussoft.shop.dao.ProductoDAO;
import com.gussoft.shop.dto.ProductoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listar() {
        List<ProductoDTO> pro = new ArrayList();
        String sql = "select * from producto";
        try {
            con = Conexion.getInstance().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO p = new ProductoDTO();
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setFoto(rs.getString(3));
                p.setDesc(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
                pro.add(p);
            }

        } catch (Exception e) {
        }
        return pro;
    }

    @Override
    public ProductoDTO listarId(int id) {
        String sql = "select *from producto where idproducto=" + id;
        ProductoDTO p = new ProductoDTO();
        try {
            con= Conexion.getInstance().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setFoto(rs.getString(3));
                p.setDesc(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
                p.setStock(rs.getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

}
