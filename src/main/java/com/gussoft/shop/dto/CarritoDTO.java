package com.gussoft.shop.dto;

public class CarritoDTO {

    private int item;
    private int idProducto;
    private String desc;
    private String nombres;
    private String foto;
    private double precioc;
    private int cantidad;
    private double subtotal;

    public CarritoDTO() {
    }

    public CarritoDTO(int item, int idProducto, String desc, String nombres, String foto, double precioc, int cantidad, double subtotal) {
        this.item = item;
        this.idProducto = idProducto;
        this.desc = desc;
        this.nombres = nombres;
        this.foto = foto;
        this.precioc = precioc;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getPrecioc() {
        return precioc;
    }

    public void setPrecioc(double precioc) {
        this.precioc = precioc;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
