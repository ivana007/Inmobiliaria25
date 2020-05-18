package com.example.inmobiliaria2.ui.perfil;

public class Propietario {
    private String dni;
   private String nombre;
   private String Apellido;
   private String telefono;
   private String Email;
   private  String pass;

    public Propietario(String dni, String nombre, String apellido, String telefono, String email, String pass) {
        this.dni = dni;
        this.nombre = nombre;
        Apellido = apellido;
        this.telefono = telefono;
        Email = email;
        this.pass = pass;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
