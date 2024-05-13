package ar.edu.utn.frbb.tup.bancokinter.menus;

import java.util.Scanner;
import ar.edu.utn.frbb.tup.bancokinter.datos.*;
import ar.edu.utn.frbb.tup.bancokinter.utils.Validador;

public class MenuPrincipal{
    private Scanner scanner;
    private ListaClientes listaClientes;

    public MenuPrincipal(Scanner scanner, ListaClientes listaClientes){
        this.scanner = scanner;
        this.listaClientes = listaClientes;
    }

    public void abrirMenuPrincipal(){
        boolean salir = false;
        int opcion;
        while(!salir){
            System.out.println("\u000C");
            System.out.println("Bienvenido a la aplicación de BancoKinter");
            System.out.println("Seleccione:");
            System.out.println("1- Acceder como cliente.");
            System.out.println("2- Registrarme como cliente.");
            System.out.println("3- Salir.");
            opcion = Validador.ingresarInt(scanner);
            switch (opcion) {
                case 1:
                    accederCliente();
                    break;
            
                case 2:
                    crearCliente();
                    break;
                    
                case 3:
                    salir = true;
                    break;

                default:
                    System.out.println("Ingrese una opción válida (1-3).");
                    break;
            }
        }
    }

    private void accederCliente(){
        String dniIngreso;
        System.out.println("Ingrese su DNI:");
        dniIngreso = String.valueOf(Validador.ingresarInt(scanner));
        Cliente cliente = listaClientes.localizarCliente(dniIngreso);
        if (cliente != null){
            String claveIngreso;
            System.out.println("Ingrese la clave de acceso:");
            claveIngreso = String.valueOf(Validador.ingresarInt(scanner));
            if (cliente.verificarClave(claveIngreso)){
                MenuCliente menuCliente = new MenuCliente(scanner, listaClientes, cliente);
                menuCliente.abrirMenuCliente();
            }
            else{
                System.out.println("Clave incorrecta.");
            }
        }
    }

    private void crearCliente(){
        String nombreNuevo;
        String apellidoNuevo;
        String dniNuevo;
        String claveNueva;
        String direccionNueva;
        String telefonoNuevo;
        System.out.println("Ingrese sus nombres:");
        nombreNuevo = scanner.nextLine();
        System.out.println("Ingrese sus apellidos:");
        apellidoNuevo = scanner.nextLine();
        System.out.println("Ingrese su DNI:");
        dniNuevo = String.valueOf(Validador.ingresarInt(scanner));
        System.out.println("Ingrese una contraseña numérica:");
        claveNueva = String.valueOf(Validador.ingresarInt(scanner));
        System.out.println("Ingrese su dirección:");
        direccionNueva = scanner.nextLine();
        System.out.println("Ingrese su teléfono (Sin '-' ni '+')");
        telefonoNuevo = String.valueOf(Validador.ingresarInt(scanner));
        Cliente cliente = new Cliente(nombreNuevo, apellidoNuevo, dniNuevo, claveNueva, direccionNueva, telefonoNuevo);
        listaClientes.agregarCliente(cliente);
    }

}