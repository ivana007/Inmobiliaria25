package com.example.inmobiliaria2.ui.propiedades;

public class Inmueble {
    private int idInmueble;
   // private int foto;
    private String direccion;
    private int cantHambientes;
    private String tipoInmueble;
    private String uso;
    private double precio;
    private String estado;
    private int idPropietario;

    public Inmueble() {
    }

    public Inmueble(int idInmueble, String direccion, int cantHambientes, String tipoInmueble, String uso, double precio, String estado, int idPropietario) {
        this.idInmueble = idInmueble;
        this.direccion = direccion;
        this.cantHambientes = cantHambientes;
        this.tipoInmueble = tipoInmueble;
        this.uso = uso;
        this.precio = precio;
        this.estado = estado;
        this.idPropietario = idPropietario;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantHambientes() {
        return cantHambientes;
    }

    public void setCantHambientes(int cantHambientes) {
        this.cantHambientes = cantHambientes;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
}