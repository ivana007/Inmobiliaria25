package com.example.inmobiliaria2.ui.contratos;

import android.icu.util.LocaleData;

import com.example.inmobiliaria2.ui.inquilinos.Inquilino;
import com.example.inmobiliaria2.ui.propiedades.Inmueble;

import java.time.LocalDate;

public class Contrato {
  private int numeroContrato;
  private LocalDate fechaAlta;
  private LocalDate fechaBaja;
  private String dniGarante;
  private int idInmueble;
  private int idInquilino;
  private Inmueble inmueble;
  private Inquilino inquilino;
  private double precio;

  public Contrato(int numeroContrato, LocalDate fechaAlta, LocalDate fechaBaja, String dniGarante, int idInmueble, int idInquilino, Inmueble inmueble, Inquilino inquilino, double precio) {
    this.numeroContrato = numeroContrato;
    this.fechaAlta = fechaAlta;
    this.fechaBaja = fechaBaja;
    this.dniGarante = dniGarante;
    this.idInmueble = idInmueble;
    this.idInquilino = idInquilino;
    this.inmueble = inmueble;
    this.inquilino = inquilino;
    this.precio = precio;
  }

  public String getDniGarante() {
    return dniGarante;
  }

  public void setDniGarante(String dniGarante) {
    this.dniGarante = dniGarante;
  }

  public Inmueble getInmueble() {
    return inmueble;
  }

  public void setInmueble(Inmueble inmueble) {
    this.inmueble = inmueble;
  }

  public Inquilino getInquilino() {
    return inquilino;
  }

  public void setInquilino(Inquilino inquilino) {
    this.inquilino = inquilino;
  }

  public int getNumeroContrato() {
    return numeroContrato;
  }

  public void setNumeroContrato(int numeroContrato) {
    this.numeroContrato = numeroContrato;
  }

  public LocalDate getFechaAlta() {
    return fechaAlta;
  }

  public void setFechaAlta(LocalDate fechaAlta) {
    this.fechaAlta = fechaAlta;
  }

  public LocalDate getFechaBaja() {
    return fechaBaja;
  }

  public void setFechaBaja(LocalDate fechaBaja) {
    this.fechaBaja = fechaBaja;
  }

  public int getIdInmueble() {
    return idInmueble;
  }

  public void setIdInmueble(int idInmueble) {
    this.idInmueble = idInmueble;
  }

  public int getIdInquilino() {
    return idInquilino;
  }

  public void setIdInquilino(int idInquilino) {
    this.idInquilino = idInquilino;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }
}
