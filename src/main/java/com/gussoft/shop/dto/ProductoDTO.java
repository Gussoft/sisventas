
package com.gussoft.shop.dto;

import java.io.InputStream;

public class ProductoDTO {
    private int id;
    private String nombres;
    private String foto;
    private String desc;
    private double precio;
    private int stock;

    public ProductoDTO() {
    }

    public ProductoDTO(int id, String nombres, String foto, String desc, double precio, int stock) {
        this.id = id;
        this.nombres = nombres;
        this.foto = foto;
        this.desc = desc;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
