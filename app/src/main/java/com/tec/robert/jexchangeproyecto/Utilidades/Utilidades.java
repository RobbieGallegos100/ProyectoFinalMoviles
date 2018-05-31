package com.tec.robert.jexchangeproyecto.Utilidades;

public class Utilidades {

    //Constantes campos tabla seeker

    public static final String TABLA_SEEKER="seeker";

    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_SEXO="sexo";
    public static final String CAMPO_NACIMIENTO="fechaNacimiento";
    public static final String CAMPO_DIRECCION="direccion";
    public static final String CAMPO_CORREO="correo";
    public static final String CAMPO_TELEFONO="telefono";
    public static final String CAMPO_ESTUDIOS="estudios";
    public static final String CAMPO_EXPERIENCIA="experienciaLaboral";
    public static final String CAMPO_AUTO="auto";
    public static final String CAMPO_INGLES="ingles";
    public static final String CAMPO_APTITUDES="aptitudes";
    public static final String CAMPO_CONTRASEÑA="contraseña";

    public static final String CREAR_TABLA_SEEKER="CREATE TABLE "+TABLA_SEEKER+" ("+CAMPO_NOMBRE+" TEXT,"+CAMPO_APELLIDO+" TEXT, "+CAMPO_SEXO+" TEXT, "+CAMPO_NACIMIENTO+" TEXT,"+CAMPO_DIRECCION+" TEXT, "+CAMPO_CORREO+" TEXT, "+CAMPO_TELEFONO+" TEXT, "+CAMPO_ESTUDIOS+" TEXT, "+CAMPO_EXPERIENCIA+" TEXT, "+CAMPO_AUTO+" TEXT, "+CAMPO_INGLES+" TEXT, "+CAMPO_APTITUDES+" TEXT, "+CAMPO_CONTRASEÑA+" INTEGER)";

    // Constantes campos tabla finder

    public static final String TABLA_FINDER="finder";

    public static final String CAMPO_NOMBRE_FINDER="nombreEmpresa";
    public static final String CAMPO_TIPOEMPRESA="tipoEmpresa";
    public static final String CAMPO_AMBITO="ambito";
    public static final String CAMPO_UBICACION="ubicacion";
    public static final String CAMPO_CIUDAD="ciudad";
    public static final String CAMPO_CORREO_FINDER="correoFinder";
    public static final String CAMPO_TELEFONO_FINDER="telefonoFinder";
    public static final String CAMPO_ESPECIALISTA="especialista";
    public static final String CAMPO_DESCRIPCION_EMPRESA="descripcionEmpresa";
    public static final String CAMPO_PORQUE="porque";
    public static final String CAMPO_COMUNICARSECON="comunicarseCon";
    public static final String CAMPO_SEBUSCA="sebusca";
    public static final String CAMPO_EXPERIENCIA_FINDER="experienciaFinder";
    public static final String CAMPO_INGLES_FINDER="inglesFinder";
    public static final String CAMPO_CONTRASEÑA_FINDER="contraseñaFinder";

    public static final String CREAR_TABLA_FINDER="CREATE TABLE "+TABLA_FINDER+" ("+CAMPO_NOMBRE_FINDER+" TEXT,"+CAMPO_TIPOEMPRESA+" TEXT, "+CAMPO_AMBITO+" TEXT, "+CAMPO_UBICACION+" TEXT,"+CAMPO_CIUDAD+" TEXT, "+CAMPO_CORREO_FINDER+" TEXT, "+CAMPO_TELEFONO_FINDER+" TEXT, "+CAMPO_ESPECIALISTA+" TEXT, "+CAMPO_DESCRIPCION_EMPRESA+" TEXT, "+CAMPO_PORQUE+" TEXT, "+CAMPO_COMUNICARSECON+" TEXT, "+CAMPO_SEBUSCA+" TEXT, "+CAMPO_EXPERIENCIA_FINDER+" TEXT, "+CAMPO_INGLES_FINDER+" TEXT, "+CAMPO_CONTRASEÑA_FINDER+" INTEGER)";
}
