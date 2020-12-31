package com.gussoft.shop.dto;

public class PagoDTO {
    private int id;
    private double monto;
    
    public PagoDTO(){
    
    }

    public PagoDTO(int id, double monto) {
        this.id = id;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
