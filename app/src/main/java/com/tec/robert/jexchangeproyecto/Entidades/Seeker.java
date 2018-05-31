package com.tec.robert.jexchangeproyecto.Entidades;

import java.io.Serializable;

public class Seeker implements Serializable {

    private String nombre;
    private String apellido;
    private String sexo;
    private String fechaNacimiento;
    private String direccion;
    private String correo;
    private String telefono;
    private String estudios;
    private String experienciaLaboral;
    private String auto;
    private String ingles;
    private String aptitudes;
    private int contraseña;

    public Seeker(String nombre, String apellido, String sexo, String fechaNacimiento, String direccion, String correo, String telefono, String estudios, String experienciaLaboral, String auto, String ingles, String aptitudes, int contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.estudios = estudios;
        this.experienciaLaboral = experienciaLaboral;
        this.auto = auto;
        this.ingles = ingles;
        this.aptitudes = aptitudes;
        this.contraseña = contraseña;
    }

    public Seeker() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(String experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getAptitudes() {
        return aptitudes;
    }

    public void setAptitudes(String aptitudes) {
        this.aptitudes = aptitudes;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }
}
