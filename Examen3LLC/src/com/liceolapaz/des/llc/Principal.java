package com.liceolapaz.des.llc;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {

    private static HashMap<String,Piloto> pilotoHashMap=new HashMap<>();
    public static void main(String[] args) {
        while (true){
            menu();
            int opcion=leerInt();
            switch (opcion){
                case 1:{
                    System.out.println("Introduzca la ruta del fichero:");
                    String ruta=leeString();
                    importarPilotos(ruta);
                    break;}
                case 2:
                    Piloto pilotoNuevo=añadirPiloto();
                    String driverId=pilotoNuevo.getDriverid();
                    if (pilotoHashMap.containsKey(driverId)){
                        System.err.println("El piloto con id "+driverId+" ya existe.");
                    }else {
                        pilotoHashMap.put(driverId,pilotoNuevo);
                    }
                    break;
                case 3:
                    Piloto pilotoModificado=añadirPiloto();
                    String id=pilotoModificado.getDriverid();
                    if (!pilotoHashMap.containsKey(id)){
                        System.err.println("El piloto con id "+id+" no existe.");
                    }else {
                        pilotoHashMap.replace(id,pilotoModificado);
                    }
                    break;
                case 4:
                    System.out.println("Introduzca el id del piloto:");
                    String idPiloto=leeString();
                    if (pilotoHashMap.containsKey(idPiloto)){
                        pilotoHashMap.remove(idPiloto);
                    }else {
                        System.err.println("El piloto con id "+idPiloto+" no existe.");
                    }
                    break;

                case 5:{
                    System.out.println("Introduzca la ruta del fichero:");
                    String ruta=leeString();
                    exportarPilotos(ruta);

                    break;}
                case 0:System.exit(0);
                    break;
                default:
                    System.err.println("Opcion no válida.");
                    break;
            }
        }
    }

    private static void exportarPilotos(String ruta) {
        try {
            FileWriter fw=new FileWriter(ruta);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
             String linea= "drivers:";
             pw.println(linea);
            for (Piloto pilotos: pilotoHashMap.values()) {
                linea="- driverId: "+pilotos.getDriverid();
                pw.println(linea);

                linea="  permanentNumber: "+"\""+pilotos.getPermanentNumber()+"\"";
                pw.println(linea);

                linea="  code: "+pilotos.getCode();
                pw.println(linea);

                linea="  url: "+pilotos.getUrl();
                pw.println(linea);

                linea="  givenName: "+pilotos.getGivenName();
                pw.println(linea);

                linea="  familyName: "+pilotos.getFamilyName();
                pw.println(linea);


                LocalDateTime fecha=pilotos.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                linea="  dateOfBirth: "+"\""+fecha.getYear()+"-"+fecha.getMonthValue()+"-"+fecha.getDayOfMonth()+"\"";

                pw.println(linea);

                linea="  nationality: "+pilotos.getNationality();
                pw.println(linea);



                
            }
            pw.close();
            bw.close();
            fw.close();

        } catch (IOException e) {
            System.err.println("Error al escribir el fichero.");
        }

    }

    private static Piloto añadirPiloto() {

        pedirDatos("id");
        String driverId=leeString();
        pedirDatos("permanent number");
        String numberString=leeString();
        int permanentNumber=0;
        try {
            permanentNumber=Integer.parseInt(numberString);
        }catch (NumberFormatException e){
            System.err.println("Formato de número incorrecto.");
            return null;
        }
        pedirDatos("codigo");
        String code=leeString();

        pedirDatos("url");
        String urlString=leeString();
        URL url=null;
        try {
            url=new URL(urlString);

        } catch (MalformedURLException e) {
            System.err.println("El avatar tiene que ser una URL");
            return null;
        }

        pedirDatos("nombre");
        String name=leeString();

        pedirDatos("nombre de familia");
        String familyName=leeString();

        pedirDatos("fecha de nacimiento");
        String fechaString=leeString();
        Date dateOfBirth=null;
        try {
            dateOfBirth=new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);

        } catch (ParseException e) {  System.out.println("La fecha tiene que estar en formato yyyy/mm/dd");
            return null;
        }

        pedirDatos("nacionalidad");
        String nacionality=leeString();

        Piloto piloto=new Piloto(driverId,permanentNumber,code,url,name,familyName,dateOfBirth,nacionality);

        return piloto;
    }

    private static void pedirDatos(String dato) {
        System.out.println("Introduzca el dato "+dato);
    }

    private static void importarPilotos(String ruta) {
        File fichero=new File(ruta);
        if (fichero.isFile()){
            try {
                Scanner scanner=new Scanner(fichero);
                scanner.nextLine();

                while (scanner.hasNext()){
                    String linea=scanner.nextLine();
                    String[]datos=linea.split(": ");
                    String driverid=datos[1];

                    linea=scanner.nextLine();
                    datos=linea.split(": ");
                    int permanentNumber=0;
                    try{
                        permanentNumber=Integer.parseInt(datos[1].substring(1,datos[1].length()-1));
                    }catch (NumberFormatException e){
                        System.err.println("Formato de permanent number incorrecto.");
                        continue;
                    }

                    linea=scanner.nextLine();
                    datos=linea.split(": ");
                    String code=datos[1];

                    linea=scanner.nextLine();
                    datos=linea.split(": ");
                    String urlString=datos[1];
                    URL url;
                    try {
                        url=new URL(urlString);
                    }catch (MalformedURLException e){
                        System.err.println("El avatar tiene que ser una URL");
                       continue;

                    }

                    linea=scanner.nextLine();
                    datos=linea.split(": ");
                    String givenName=datos[1];

                    linea=scanner.nextLine();
                    datos=linea.split(": ");
                    String familyName=datos[1];

                    linea=scanner.nextLine();
                    datos=linea.split(": ");
                    String fechaString=datos[1].substring(1,datos[1].length()-1);
                    System.out.println(fechaString);
                    Date dateOfbirth=null;
                    try {
                        dateOfbirth=new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);

                    } catch (ParseException e) {
                        System.out.println("La fecha tiene que estar en formato yyyy-mm-dd");
                        continue;

                    }
                    System.out.println(dateOfbirth);
                    linea=scanner.nextLine();
                    datos=linea.split(": ");
                    String nationality=datos[1];

                    Piloto piloto=new Piloto(driverid,permanentNumber,code,url,givenName,familyName,dateOfbirth,nationality);

                    pilotoHashMap.put(driverid,piloto);




                }
            } catch (FileNotFoundException e) {
                System.err.println("La ruta "+fichero+" no existe.");
            }


        }else {
            System.err.println("La ruta "+fichero+" no existe.");
        }
    }

    private static String leeString() {
        return new Scanner(System.in).nextLine();
    }

    private static int leerInt() {
        Scanner scanner=new Scanner(System.in);
        try {
            return scanner.nextInt();
        }catch (NumberFormatException e){
            return -1;
        }
    }

    private static void menu() {
        System.out.println("""
                GESTOR PILOTOS
                1. Importar pilotos
                2. Añadir piloto
                3. Modificar piloto
                4. Eliminar piloto
                5. Exportar pilotos
                0. Salir
                Escoja una opción:
                """);
    }
}
