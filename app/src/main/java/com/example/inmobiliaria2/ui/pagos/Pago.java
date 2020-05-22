package com.example.inmobiliaria2.ui.pagos;

import com.example.inmobiliaria2.ui.contratos.Contrato;
import com.example.inmobiliaria2.ui.propiedades.Inmueble;

import java.time.LocalDate;

public class Pago {
    private int idPago;
    private String fechaPago;
    private int numeroPago;
    private int idContrato;
    private Contrato contrato;
    private double Importe;

    public Pago(int idPago, String fechaPago, int numeroPago, int idContrato, Contrato contrato, double importe) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.numeroPago = numeroPago;
        this.idContrato = idContrato;
        this.contrato = contrato;
        Importe = importe;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getNumeroPago() {
        return numeroPago;
    }

    public void setNumeroPago(int numeroPago) {
        this.numeroPago = numeroPago;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(double importe) {
        Importe = importe;
    }
}
