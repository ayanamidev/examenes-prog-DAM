package com.liceolapaz.des.llc;

import java.util.Scanner;

public class Principal {

    static Scanner scanner=new Scanner(System.in);
    static Vehiculo[] cochesGasolina=new Vehiculo[50];
    static int cocheGas=0;
    static Vehiculo[]cochesDiesel=new Vehiculo[30];
    static int cocheDie=0;

    static Vehiculo[]cochesElectrico=new Vehiculo[5];
    static int cocheElec=0;
    static Vehiculo[]cochesHibrido=new Vehiculo[15];
    static int cocheHib=0;
    static Vehiculo[]motosGasolina=new Vehiculo[35];
    static  int motosGas=0;
    static Vehiculo[]motosElectrica=new Vehiculo[15];
    static int motosElec=0;
    static Vehiculo[]furgonetas=new Vehiculo[20];
    static int furgo=0;
    public static void main(String[] args) {
        do {
            menu();
            int opcion=leerInt();
            switch (opcion){
                case 1: alquilarVehiculo();
                    break;
                case 2:devolucionVehiculo();
                    break;
                case 3:listarDatos();
                    break;
                case 4:vehiculosSinAlquilar();
                    break;
                case 0:System.exit(0);
                    break;
                default:
                    System.out.println("ERROR: opcion incorrecta");
                    break;
            }
        }while (true);



    }

    private static void vehiculosSinAlquilar() {
        System.out.println("Coches gasolina: "+(cochesGasolina.length-cocheGas));
        System.out.println("Coches diesel: "+(cochesDiesel.length-cocheDie));
        System.out.println("Coches electrico: "+(cochesElectrico.length-cocheElec));
        System.out.println("Coches hibrido: "+ (cochesHibrido.length-cocheHib));
        System.out.println("Motos gasolina: "+(motosGasolina.length-motosGas));
        System.out.println("Motos electricas: "+(motosElectrica.length-motosElec));
        System.out.println("Furgonetas: "+(furgonetas.length-furgo));

    }

    private static void listarDatos() {
        if (cocheGas>0){
            for (int i=0;i<cochesGasolina.length;i++){
                if (cochesGasolina[i]!=null){
                    System.out.println(cochesGasolina[i].toString());

                }
            }
        }else {
            System.out.println("No hay vehiculos alquilados de tipo coche gasolina");

        }
        if (cocheDie>0){
            for (int i=0; i<cochesDiesel.length;i++){
                if (cochesDiesel[i]!=null){
                    System.out.println(cochesDiesel[i].toString());
                }
            }
        }else {
            System.out.println("No hay vehiculos alquilados de tipo coche diesel");

        }
        if (cocheElec>0){
            for (int i=0;i<cochesElectrico.length;i++){
                if (cochesElectrico[i]!=null){
                    System.out.println(cochesElectrico[i].toString());
                }
            }
        }else {
            System.out.println("No hay vehiculos alquilados de tipo coche electrico");

        }
        if (cocheHib>0){
            for (int i=0; i<cochesHibrido.length;i++){
                if (cochesHibrido[i]!=null){
                    System.out.println(cochesHibrido[i].toString());
                }
            }
        }else {
            System.out.println("No hay vehiculos alquilados de tipo coche hibrido");

        }
        if (motosGas>0){
            for (int i=0;i<motosGasolina.length;i++){
                if (motosGasolina[i]!=null){
                    System.out.println(motosGasolina[i].toString());
                }
            }
        }else {
            System.out.println("No hay vehiculos alquilados de tipo moto gasolina");

        }
        if (motosElec>0){
            for (int i=0;i<motosElectrica.length;i++){
                if (motosElectrica[i]!=null){
                    System.out.println(motosElectrica[i].toString());
                }
            }
        }else {
            System.out.println("No hay vehiculos alquilados de tipo moto electrica");

        }
        if (furgo>0){
            for (int i=0;i<furgonetas.length;i++){
                if (furgonetas[i]!=null){
                    System.out.println(furgonetas[i].toString());
                }
            }
        }else {
            System.out.println("No hay vehiculos alquilados de tipo furgoneta");
        }
    }

    private static void devolucionVehiculo() {
        System.out.println("""
                Que tipo de vehículo dese devolver?
                1. Coche de gasolina
                2. Coche diésel
                3. Coche eléctrico
                4. Coche híbrido
                5. Moto de gasolina
                6. Moto eléctrica
                7. Furgoneta
                0. Salir
                Escoja una opcion:
                """);
        int opcion=leerInt();

        System.out.println("Escriba la matricula del vehiculo que va a devolver: ");
        String matricula=leerString();
        boolean nomatri=true;


        switch (opcion){
            case 1:
                for (int i=0;i<cochesGasolina.length;i++){
                    if (cochesGasolina[i]!=null){
                        if (cochesGasolina[i].getMatricula().equals(matricula)){
                            cochesGasolina[i]=null;
                            cocheGas--;
                            nomatri=false;
                            break;

                        }
                    }



                }
                if (nomatri){
                    System.out.println("ERROR, no se ha encontra la matricula");
                }
                break;
            case 2:
                for (int i=0; i<cochesDiesel.length;i++){
                    if (cochesDiesel[i] != null) {
                        if (cochesDiesel[i].getMatricula().equals(matricula)){
                            cochesDiesel[i]=null;
                            cocheDie--;
                            nomatri=false;
                            break;
                        }
                    }

                }
                if (nomatri){
                    System.out.println("ERROR, no se ha encontra la matricula");
                }
                break;

            case 3:
                for (int i=0;i<cochesElectrico.length;i++){
                    if (cochesElectrico[i] != null) {
                        if (cochesElectrico[i].getMatricula().equals(matricula)){
                            cochesElectrico[i]=null;
                            cocheElec--;
                            nomatri=false;
                            break;
                        }

                    }


                }
                if (nomatri){
                    System.out.println("ERROR, no se ha encontra la matricula");
                }
                break;
            case 4:
                for(int i=0; i<cochesHibrido.length;i++){
                    if (cochesHibrido[i]!=null){
                        if (cochesHibrido[i].getMatricula().equals(matricula)){
                            cochesHibrido[i]=null;
                            cocheHib--;
                            nomatri=false;
                            break;
                        }
                    }

                }
                if (nomatri){
                    System.out.println("ERROR, no se ha encontra la matricula");
                }
                break;
            case 5:
                for (int i=0; i<motosGasolina.length;i++){
                    if (motosGasolina[i]!=null){
                        if (motosGasolina[i].getMatricula().equals(matricula)){
                            motosGasolina[i]=null;
                            motosGas--;
                            nomatri=false;
                            break;
                        }
                    }

                }
                if (nomatri){
                    System.out.println("ERROR, no se ha encontra la matricula");
                }
                break;
            case 6:
                for(int i=0; i<motosElectrica.length;i++){
                    if (motosElectrica[i]!=null){
                        if (motosElectrica[i].getMatricula().equals(matricula)){
                            motosElectrica[i]=null;
                            motosElec--;
                            nomatri=false;
                            break;
                        }
                    }

                }
                if (nomatri){
                    System.out.println("ERROR, no se ha encontra la matricula");
                }
                break;
            case 7:
                for (int i=0;i<furgonetas.length;i++){
                    if (furgonetas[i]!=null){
                        if (furgonetas[i].getMatricula().equals(matricula)){
                            furgonetas[i]=null;
                            furgo--;
                            nomatri=false;
                            break;
                        }
                    }

                }
                if (nomatri){
                    System.out.println("ERROR, no se ha encontra la matricula");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("ERROR:opcion incorrecta");
                break;



        }



    }

    private static void alquilarVehiculo() {
        System.out.println("""
                Que tipo de vehiculo quiere alquilar?
                1. Coche de gasolina
                2. Coche diésel
                3. Coche eléctrico
                4. Coche híbrido
                5. Moto de gasolina
                6. Moto eléctrica
                7. Furgoneta
                0. Salir
                Escoja una opcion:
                """);

        int opcion=leerInt();
        switch (opcion) {
            case 1:
                if (cocheGas < 50) {
                    for (int i = 0; i < cochesGasolina.length; i++) {

                        if (cochesGasolina[i] == null) {
                            System.out.println("Escriba el dni:");
                            String dni = leerString();
                            System.out.println("Escriba la mátricula del vehículo: ");
                            String matricula = leerString();
                            System.out.println("Escriba la fecha y hora del alquiler:fecha:(--/--/----) hora:(--:--");
                            String fechaHora = leerString();
                            cochesGasolina[i] = new Vehiculo("Coche gasolina", matricula, dni, fechaHora);
                            cocheGas++;
                            break;
                        }
                    }
                } else {
                    System.out.println("ERROR: no quedan vehiculos de ese tipo.");
                }

                break;
            case 2:
                if (cocheDie < 30) {

                    for (int i = 0; i < cochesDiesel.length; i++) {
                        if (cochesDiesel[i]==null){
                            System.out.println("Escriba el dni:");
                            String dni = leerString();
                            System.out.println("Escriba la mátricula del vehículo: ");
                            String matricula = leerString();
                            System.out.println("Escriba la fecha y hora del alquiler:fecha:(--/--/----) hora:(--:--");
                            String fechaHora = leerString();
                            cochesDiesel[i] = new Vehiculo("Coche diesel", matricula, dni, fechaHora);
                            cocheDie++;
                            break;
                        }

                    }
                }else {
                    System.out.println("ERROR: no quedan vehiculos de ese tipo.");
                }

                break;
            case 3:
                    if (cocheElec<5){
                        for (int i=0;i<cochesElectrico.length;i++){
                            if (cochesElectrico[i]==null){
                                System.out.println("Escriba el dni:");
                                String dni = leerString();
                                System.out.println("Escriba la mátricula del vehículo: ");
                                String matricula = leerString();
                                System.out.println("Escriba la fecha y hora del alquiler:fecha:(--/--/----) hora:(--:--");
                                String fechaHora = leerString();
                                cochesElectrico[i]=new Vehiculo("Coche eléctrico", matricula,dni,fechaHora);
                                cocheElec++;
                                break;
                            }


                        }


                    }else {
                        System.out.println("ERROR: no quedan vehiculos de ese tipo.");

                    }
                break;
            case 4:
                if (cocheHib<15){
                    for (int i=0;i<cochesHibrido.length;i++){
                        if (cochesHibrido[i]==null){
                            System.out.println("Escriba el dni:");
                            String dni = leerString();
                            System.out.println("Escriba la mátricula del vehículo: ");
                            String matricula = leerString();
                            System.out.println("Escriba la fecha y hora del alquiler:fecha:(--/--/----) hora:(--:--");
                            String fechaHora = leerString();
                            cochesHibrido[i]=new Vehiculo("Coche híbrido",matricula,dni,fechaHora);
                            cocheHib++;
                            break;
                        }


                    }

                }else {
                    System.out.println("ERROR: no quedan vehiculos de ese tipo.");
                }
                break;
            case 5:
                if (motosGas<35){
                    for (int i=0; i<motosGasolina.length;i++){
                        if (motosGasolina[i]==null){
                            System.out.println("Escriba el dni:");
                            String dni = leerString();
                            System.out.println("Escriba la mátricula del vehículo: ");
                            String matricula = leerString();
                            System.out.println("Escriba la fecha y hora del alquiler:fecha:(--/--/----) hora:(--:--");
                            String fechaHora = leerString();
                            motosGasolina[i]=new Vehiculo("Moto gasolina",matricula,dni,fechaHora);
                            motosGas++;
                            break;
                        }



                    }

                }else {
                    System.out.println("ERROR: no quedan vehiculos de ese tipo.");
                }
                break;
            case 6:
                if (motosElec<15){
                    for (int i=0;i<motosElectrica.length;i++){
                        if (motosElectrica[i]==null){
                            System.out.println("Escriba el dni:");
                            String dni = leerString();
                            System.out.println("Escriba la mátricula del vehículo: ");
                            String matricula = leerString();
                            System.out.println("Escriba la fecha y hora del alquiler:fecha:(--/--/----) hora:(--:--");
                            String fechaHora = leerString();
                            motosElectrica[i]=new Vehiculo("Moto eléctrica",matricula,dni,fechaHora);
                            motosElec++;
                            break;

                        }

                    }

                }else {
                    System.out.println("ERROR: no quedan vehiculos de ese tipo.");
                }
                break;
            case 7:
                if (furgo<20){
                    for (int i=0;i<furgonetas.length;i++){
                        if (furgonetas[i]==null){
                            System.out.println("Escriba el dni:");
                            String dni = leerString();
                            System.out.println("Escriba la mátricula del vehículo: ");
                            String matricula = leerString();
                            System.out.println("Escriba la fecha y hora del alquiler:fecha:(--/--/----) hora:(--:--");
                            String fechaHora = leerString();
                            furgonetas[i]=new Vehiculo("Furgoneta",matricula,dni,fechaHora);
                            furgo++;
                            break;

                        }
                    }

                }else {

                }
                break;
            case 0:
                break;
            default:
                System.out.println("ERROR:opcion incorrecta.");
                break;
        }
    }

    private static String leerString() {
        return scanner.next();
    }

    private static int leerInt() {
        return scanner.nextInt();
    }

    private static void menu() {
        System.out.println("""
                ALQUILERES
                1. Alquiler vehículo
                2. Devolución vehículo
                3. Listar vehículos alquilados
                4. Mostrar número de vehículos sin alquilar
                0. Salir
                Escoja una opción:
                """);
    }
}
