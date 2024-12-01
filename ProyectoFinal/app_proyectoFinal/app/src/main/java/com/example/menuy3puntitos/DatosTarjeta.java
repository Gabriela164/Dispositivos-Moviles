package com.example.menuy3puntitos;

public class DatosTarjeta {
    private int id;
    private String total;
    private String metodoDePago;
    private String numTarjeta;
    private String vencimiento;
    private String cvv;
    private String propietario;
    private String guardarDatos;

    public DatosTarjeta() {}

    public DatosTarjeta(String total, String metodoDePago, String numTarjeta, String vencimiento, String cvv, String propietario, String guardarDatos){
        this.total = total;
        this.metodoDePago = metodoDePago;
        this.numTarjeta = numTarjeta;
        this.vencimiento = vencimiento;
        this.cvv = cvv;
        this.propietario = propietario;
        this.guardarDatos = guardarDatos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getGuardarDatos() {
        return guardarDatos;
    }

    public void setGuardarDatos(String guardarDatos) {
        this.guardarDatos = guardarDatos;
    }
}
