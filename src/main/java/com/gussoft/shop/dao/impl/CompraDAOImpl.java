package com.gussoft.shop.dao.impl;

import com.gussoft.shop.config.Conexion;
import com.gussoft.shop.dao.CompraDAO;
import com.gussoft.shop.dto.CarritoDTO;
import com.gussoft.shop.dto.CompraDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompraDAOImpl implements CompraDAO {

    Connection con;
    //con = Conexion.getInstance().getConnection();
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    @Override
    public int GenerarCompra(CompraDTO compra) {
        int idcompras;
        String sql = "insert into compras(idCliente, FechaCompras, Monto, Estado, idPago) values(?,?,?,?,?)";
        try {
            con = Conexion.getInstance().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, compra.getCliente().getId());
            ps.setString(2, compra.getFecha());
            ps.setDouble(3, compra.getMonto());
            ps.setString(4, compra.getEstado());
            ps.setInt(5, compra.getIdpago());
            r = ps.executeUpdate();

            sql = "select @@IDENTITY AS idCompras";
            rs = ps.executeQuery(sql);
            rs.next();
            idcompras = rs.getInt("idCompras");
            rs.close();

            for (CarritoDTO detalle : compra.getDetallecompras()) {
                sql = "insert into detalle_compras(idProducto, idCompras, Cantidad, PrecioCompra) values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, detalle.getIdProducto());
                ps.setInt(2, idcompras);
                ps.setInt(3, detalle.getCantidad());
                ps.setDouble(4, detalle.getPrecioc());
                r = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

}
