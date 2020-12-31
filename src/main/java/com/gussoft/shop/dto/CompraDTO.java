package com.gussoft.shop.dto;

import java.util.List;

public class CompraDTO {
    private int id;
    private ClienteDTO cliente;
    private int idpago;
    private String fecha;
    private double monto;
    private String estado;

    private List<CarritoDTO>detallecompras;
    
    public CompraDTO() {
    }

    public CompraDTO(ClienteDTO cliente, int idpago, String fecha, double monto, String estado, List<CarritoDTO> detallecompras) {
        this.cliente = cliente;
        this.idpago = idpago;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
        this.detallecompras = detallecompras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<CarritoDTO> getDetallecompras() {
        return detallecompras;
    }

    public void setDetallecompras(List<CarritoDTO> detallecompras) {
        this.detallecompras = detallecompras;
    }

}
