package ar.edu.utn.frbb.tup.bancokinter.menus;

import java.util.Scanner;
import ar.edu.utn.frbb.tup.bancokinter.datos.*;
import ar.edu.utn.frbb.tup.bancokinter.utils.Validador;

public class MenuCuenta {
    private Scanner scanner;
    private ListaClientes listaClientes;
    private Cliente cliente;
    private Cuenta cuenta;

    public MenuCuenta(Scanner scanner, ListaClientes listaClientes, Cliente cliente, Cuenta cuenta){
        this.scanner = scanner;
        this.listaClientes = listaClientes;
        this.cliente = cliente;
        this.cuenta = cuenta;
    }

    public void abrirMenuCuenta(){
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("");
            System.out.println("Seleccione:");
            System.out.println("1- Realizar depósito.");
            System.out.println("2- Realizar retiro.");
            System.out.println("3- Realizar transferencia.");
            System.out.println("4- Consultar datos de cuenta.");
            System.out.println("5- Consultar movimientos.");
            System.out.println("6- Eliminar cuenta.");
            System.out.println("7- Salir.");
            opcion = Validador.ingresarInt(scanner);
            switch (opcion) {
                case 1:
                    System.out.println("\u000C");
                    System.out.println("Ingrese el monto a depositar:");
                    float deposito = Validador.ingresarFloat(scanner);
                    cuenta.realizarDeposito(deposito);
                    break;
                
                case 2:
                    System.out.println("\u000C");
                    System.out.println("Ingrese el monto a retirar:");
                    float retiro = Validador.ingresarFloat(scanner);
                    cuenta.realizarRetiro(retiro);
                    break;
                
                case 3:
                    System.out.println("\u000C");
                    System.out.println("Ingrese el CBU al que desea transferirle:");
                    String cbuTransferencia = scanner.nextLine();
                    System.out.println("Ingrese el monto a transferir:");
                    float transferencia = Validador.ingresarFloat(scanner);
                    cuenta.realizarTransferencia(listaClientes, cbuTransferencia, transferencia);
                    break;

                case 4:
                    System.out.println("\u000C");
                    cuenta.mostrarDatos();
                    break;

                case 5:
                    System.out.println("\u000C");
                    cuenta.mostrarMovimientos();
                    break;

                case 6:
                    System.out.println("\u000C");
                    eliminarCuenta();
                    salir = true;
                    break;

                case 7:
                    System.out.println("\u000C");
                    salir = true;
                    break;
            
                default:
                    System.out.println("\u000C");
                    System.out.println("Ingrese una opción válida (1-7).");
                    break;
            }
        }
    }

    private void eliminarCuenta(){
        int opcion;
        boolean salir = false;
        while (!salir) {
            cuenta.mostrarDatos();
            System.out.println("¿Está seguro que desea eliminar esta cuenta?");
            System.out.println("1- Sí.");
            System.out.println("2- No.");
            opcion = Validador.ingresarInt(scanner);
            switch (opcion) {
                case 1:
                    cliente.eliminarCuenta(cuenta);
                    salir = true;
                    break;
            
                case 2:
                    salir = true;
                    break;

                default:
                    System.out.println("Ingrese una opción válida (1-2).");
                    break;
            }
        }
    }
}
