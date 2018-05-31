package com.tec.robert.jexchangeproyecto.Entidades;

import java.io.Serializable;

public class Finder implements Serializable {

    private String nombreEmpresa;
    private String tipoEmpresa;
    private String ambito;
    private String ubicacion;
    private String ciudad;
    private String correoFinder;
    private String telefonoFinder;
    private String especialista;
    private String descripcionEmpresa;
    private String porque;
    private String comunicarseCon;
    private String sebusca;
    private String experienciaFinder;
    private String inglesFinder;
    private int contraseñaFinder;

    public Finder(String nombreEmpresa, String tipoEmpresa, String ambito, String ubicacion, String ciudad, String correoFinder, String telefonoFinder, String especialista, String descripcionEmpresa, String porque, String comunicarseCon, String sebusca, String experienciaFinder, String inglesFinder, int contraseñaFinder) {
        this.nombreEmpresa = nombreEmpresa;
        this.tipoEmpresa = tipoEmpresa;
        this.ambito = ambito;
        this.ubicacion = ubicacion;
        this.ciudad = ciudad;
        this.correoFinder = correoFinder;
        this.telefonoFinder = telefonoFinder;
        this.especialista = especialista;
        this.descripcionEmpresa = descripcionEmpresa;
        this.porque = porque;
        this.comunicarseCon = comunicarseCon;
        this.sebusca = sebusca;
        this.experienciaFinder = experienciaFinder;
        this.inglesFinder = inglesFinder;
        this.contraseñaFinder = contraseñaFinder;
    }

    public Finder() {

    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreoFinder() {
        return correoFinder;
    }

    public void setCorreoFinder(String correoFinder) {
        this.correoFinder = correoFinder;
    }

    public String getTelefonoFinder() {
        return telefonoFinder;
    }

    public void setTelefonoFinder(String telefonoFinder) {
        this.telefonoFinder = telefonoFinder;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

    public String getDescripcionEmpresa() {
        return descripcionEmpresa;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        this.descripcionEmpresa = descripcionEmpresa;
    }

    public String getPorque() {
        return porque;
    }

    public void setPorque(String porque) {
        this.porque = porque;
    }

    public String getComunicarseCon() {
        return comunicarseCon;
    }

    public void setComunicarseCon(String comunicarseCon) {
        this.comunicarseCon = comunicarseCon;
    }

    public String getSebusca() {
        return sebusca;
    }

    public void setSebusca(String sebusca) {
        this.sebusca = sebusca;
    }

    public String getExperienciaFinder() {
        return experienciaFinder;
    }

    public void setExperienciaFinder(String experienciaFinder) {
        this.experienciaFinder = experienciaFinder;
    }

    public String getInglesFinder() {
        return inglesFinder;
    }

    public void setInglesFinder(String inglesFinder) {
        this.inglesFinder = inglesFinder;
    }

    public int getContraseñaFinder() {
        return contraseñaFinder;
    }

    public void setContraseñaFinder(int contraseñaFinder) {
        this.contraseñaFinder = contraseñaFinder;
    }
}
