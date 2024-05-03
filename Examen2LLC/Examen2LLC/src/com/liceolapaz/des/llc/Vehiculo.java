package com.liceolapaz.des.llc;

public class Vehiculo {
    String tipo;
    String matricula;
    String dni;
    String fechaHora;

    public Vehiculo(String tipo, String matricula, String dni, String fechaHora) {
        this.tipo = tipo;
        this.matricula = matricula;
        this.dni = dni;
        this.fechaHora = fechaHora;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return tipo+ " "+ dni+" "+matricula+" "+fechaHora;
    }
}
