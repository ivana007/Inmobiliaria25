package com.example.inmobiliaria2.ui.inquilinos;

public class Inquilino {
    private int idInquilino;
    private String dni;
    private String nombre;
    private String Apellido;
    private String telefono;

    public Inquilino(int idInquilino, String dni, String nombre, String apellido, String telefono) {
        this.idInquilino = idInquilino;
        this.dni = dni;
        this.nombre = nombre;
        Apellido = apellido;
        this.telefono = telefono;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
