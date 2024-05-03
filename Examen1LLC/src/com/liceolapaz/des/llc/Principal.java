package com.liceolapaz.des.llc;

import java.util.Random;
import java.util.Scanner;

public class Principal {
    private static int raza=0;
    private static int clase=0;
    //RAZA
    private static final int HUMANO=1;
    private static final int ELFO=2;
    private static final int ENANO=3;
    private static final int ORCO=4;
    private static final int TROLL=5;
    private static final int GNOMO=6;
    //CLASE
    private static final int GUERRERO=1;
    private static final int CAZADOR=2;
    private static final int CLERIGO=3;
    private static final int MAGO=4;
    private static final int DRUIDA=5;
    private static final int PALADIN=6;
    private  static final int BARDO=7;
    //HABILIDADES
    private static int fuerza=0;
    private static int destreza=0;
    private static int inteligencia=0;
    private static int sabiduria=0;
    private static int carisma=0;
    //PUNTOS
    private static int puntos=5;


    public static void main(String[] args) {
        while (true){
            menu();
            opciones();
        }

    }

    private static void menu() {
        System.out.println("""
                CREACIÓN PERSONAJE ROL
                1.Raza
                2.Clase
                3.Habilidades
                4.Puntos extras
                5.Mostrar personaje
                0.Salir
                Escoja una opción:
                """);
    }
    private static void opciones() {
        int opcion=leerInt();
        switch (opcion){
            case 1: elegirRaza();
                break;
            case 2:elegirClase();
                break;
            case 3: habilidades();
                break;
            case 4:puntosExtra();
                break;
            case 5:mostrarPersonaje();
                break;
            case 0: System.exit(0);
                break;
            default:
                System.out.println("ERROR: opcion introducida no válida.\n");
                break;
        }
    }

    private static void mostrarPersonaje() {
        String razaCadena=leerRaza();
        String claseCadena=leerClase();
        System.out.println("Raza: "+razaCadena+"\n"
                + "Clase: "+claseCadena+ "\n"+ "Fuerza: "+fuerza+
                "\n"+ "Destreza: "+ destreza+ "\n" + "Inteligencia: "+inteligencia+ "\n"+
                "Sabiduria: "+sabiduria+ "\n"+ "Carisma: "+ carisma+"\n"
        );

    }

    private static String leerClase() {
        String claseCadena;
        if (clase==GUERRERO){
            claseCadena="Guerrero";
        } else if (clase==CAZADOR) {
            claseCadena="Cazador";
        } else if (clase==CLERIGO) {
            claseCadena="Clérigo";
        } else if (clase==MAGO) {
            claseCadena="Mago";
        } else if (clase==DRUIDA) {
            claseCadena="Druida";
        } else if (clase==PALADIN) {
            claseCadena="Paladín";
        } else if (clase==BARDO) {
            claseCadena="Bardo";
        }else {
            claseCadena="No ha seleccionado ninguna clase.";
        }
        return claseCadena;
    }

    private static String leerRaza() {
        String razaCadena;
        if(raza==HUMANO){
            razaCadena="Humano";
        } else if (raza==ELFO) {
            razaCadena="Elfo";
        } else if (raza==ENANO) {
            razaCadena="Enano";
        } else if (raza==ORCO) {
            razaCadena="Orco";
        } else if (raza==TROLL) {
            razaCadena="Troll";
        } else if (raza==GNOMO) {
            razaCadena="Gnomo";
        }else {
            razaCadena="No has seleccionado una raza.";
        }
        return razaCadena;
    }

    private static void puntosExtra() {
        if (puntos==0){
            System.out.println("ERROR: no tienes puntos extra disponibles.");
        }else {
            System.out.println("¿A que habilidad quieres asignarle puntos extras?");
            String habilidadEscogida=leerString().toLowerCase();
            System.out.println("¿Cuantos puntos extra quieres asignarle? Actualmente tienes "+puntos+" puntos extras disponibles");
            int puntosAsignados=leerInt();
            if (habilidadEscogida.equals("fuerza")){
                if((fuerza+puntosAsignados)<=20&&puntos>=puntosAsignados){

                    fuerza+=puntosAsignados;
                    puntos-=puntosAsignados;
                    System.out.println("Te queda/n "+ puntos+ " punto/s.");
                } else {
                    if (puntos<puntosAsignados){
                        System.out.println("ERROR: solo tienes "+ puntos+ " puntos extra. No tienes suficientes.");
                    }else {
                        System.out.println("ERROR: la suma de los puntos no puede ser mayor a 20 puntos. ");
                    }
                }

            } else if (habilidadEscogida.equals("destreza")) {
                if((destreza+puntosAsignados)<=20&&puntos>=puntosAsignados){
                    destreza+=puntosAsignados;
                    puntos-=puntosAsignados;
                    System.out.println("Te queda/n "+ puntos+ " punto/s.");
                } else {
                    if (puntos<puntosAsignados){
                        System.out.println("ERROR: solo tienes "+ puntos+ " puntos extra. No tienes suficientes.");
                    }else {
                        System.out.println("ERROR: la suma de los puntos no puede ser mayor a 20 puntos. ");
                    }

                }

            } else if (habilidadEscogida.equals("inteligencia")) {
                if((inteligencia+puntosAsignados)<=20&&puntos>=puntosAsignados){
                    inteligencia+=puntosAsignados;
                    puntos-=puntosAsignados;
                    System.out.println("Te queda/n "+ puntos+ " punto/s.");
                } else {
                     if (puntos<puntosAsignados){
                        System.out.println("ERROR: solo tienes "+ puntos+ " puntos extra. No tienes suficientes.");
                    }else {
                        System.out.println("ERROR: la suma de los puntos no puede ser mayor a 20 puntos. ");
                    }
                }

            } else if (habilidadEscogida.equals("sabiduria")) {
                if((sabiduria+puntosAsignados)<=20&&puntos>=puntosAsignados){
                    sabiduria+=puntosAsignados;
                    puntos-=puntosAsignados;
                    System.out.println("Te queda/n "+ puntos+ " punto/s.");
                } else {
                    if (puntos<puntosAsignados){
                        System.out.println("ERROR: solo tienes "+ puntos+ " puntos extra. No tienes suficientes.");
                    }else {
                        System.out.println("ERROR: la suma de los puntos no puede ser mayor a 20 puntos. ");
                    }
                }

            } else if (habilidadEscogida.equals("carisma")) {
                if((carisma+puntosAsignados)<=20&&puntos>=puntosAsignados){
                    carisma+=puntosAsignados;
                    puntos-=puntosAsignados;
                    System.out.println("Te queda/n "+ puntos+ " punto/s.");
                } else {
                    if (puntos<puntosAsignados){
                        System.out.println("ERROR: solo tienes "+ puntos+ " puntos extra. No tienes suficientes.");
                    }else {
                        System.out.println("ERROR: la suma de los puntos no puede ser mayor a 20 puntos. ");
                    }
                }

            }
        }
    }



    private static String leerString() {
        return new Scanner(System.in).next();
    }

    private static void habilidades() {
        int valor=20;
        fuerza=numeroAleatorio(valor);
        destreza=numeroAleatorio(valor);
        inteligencia=numeroAleatorio(valor);
        sabiduria=numeroAleatorio(valor);
        carisma=numeroAleatorio(valor);
        if (puntos!=5){
            puntos=5;
        }
        System.out.println("Se han asignado aleatoriamente puntos a las habilidades.\n");

    }

    private static void elegirClase() {
        int aleatorio=numeroAleatorio(7);
        if (aleatorio==GUERRERO){
            clase=GUERRERO;
        } else if (aleatorio==CAZADOR) {
            clase=CAZADOR;
        } else if (aleatorio==CLERIGO) {
            clase=CLERIGO;
        } else if (aleatorio==MAGO) {
            clase=MAGO;
        } else if (aleatorio==DRUIDA) {
            clase=DRUIDA;
        } else if (aleatorio==PALADIN) {
            clase=PALADIN;
        } else if (aleatorio==BARDO) {
            clase=BARDO;
        }
        System.out.println("Se ha elegido una clase aleatoriamente.\n");

    }

    private static void elegirRaza() {
        int aleatorio=numeroAleatorio(6);

        if (aleatorio==HUMANO){
            raza=HUMANO;
        } else if (aleatorio==ELFO) {
            raza=ELFO;
        } else if (aleatorio==ENANO) {
            raza=ENANO;
        } else if (aleatorio==ORCO) {
            raza=ORCO;
        } else if (aleatorio==TROLL) {
            raza=TROLL;
        } else if (aleatorio==GNOMO) {
            raza=GNOMO;
        }
        System.out.println("Se ha elegido una raza aleatoriamente.\n");

    }

    private static int numeroAleatorio(int num) {
        return new Random().nextInt(num)+1;

    }

    private static int leerInt() {
        return new Scanner(System.in).nextInt();
    }

}
