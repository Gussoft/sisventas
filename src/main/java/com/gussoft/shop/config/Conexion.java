package com.gussoft.shop.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    Connection con;
    private static Conexion instancia;

    private Conexion() {

    }

    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/shop";
        String user = "root";
        String pass = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void cerrarConnection(Connection cn) {
        try {
            if (cn != null) {
                cn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
