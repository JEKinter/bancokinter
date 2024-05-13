package ar.edu.utn.frbb.tup.bancokinter.utils;

import java.util.Scanner;

public class Validador {

    public static int ingresarInt(Scanner scanner){
        int numeroInt = 0;
        boolean repetir;
        do{
            try {
                numeroInt = scanner.nextInt();
                scanner.nextLine();
                repetir = false;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("El valor ingresado no es válido, por favor vuelta a intentarlo.");
                repetir = true;
            }
        }while(repetir);
        return numeroInt;
    }

    public static float ingresarFloat(Scanner scanner){
        float numeroFloat = 0;
        boolean repetir;
        do{
            try {
                numeroFloat = scanner.nextFloat();
                scanner.nextLine();
                repetir = false;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("El valor ingresado no es válido, por favor vuelta a intentarlo.");
                repetir = true;
            }
        }while(repetir);
        return numeroFloat;
    }

}
