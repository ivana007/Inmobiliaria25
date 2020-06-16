package com.example.inmobiliaria2.ui.propiedades;

public class Inmueble {
    private int idInmueble;
   // private int foto;
    private String direccion;
    private String estado;
    private String tipoInmueble;
    private String uso;
    private int cantHambientes;
    private double precio;
    private int idPropietario;

    public Inmueble() {
    }

    public Inmueble(String direccion, String estado, String tipoInmueble, String uso, int cantHambientes, double precio) {
        this.direccion = direccion;
        this.estado = estado;
        this.tipoInmueble = tipoInmueble;
        this.uso = uso;
        this.cantHambientes = cantHambientes;
        this.precio = precio;
    }

    public Inmueble(int idInmueble, String direccion, String estado, String tipoInmueble, String uso, int cantHambientes, double precio, int idPropietario) {
        this.idInmueble = idInmueble;
        this.direccion = direccion;
        this.estado = estado;
        this.tipoInmueble = tipoInmueble;
        this.uso = uso;
        this.cantHambientes = cantHambientes;
        this.precio = precio;
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