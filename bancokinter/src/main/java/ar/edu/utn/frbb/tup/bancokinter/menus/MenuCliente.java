package ar.edu.utn.frbb.tup.bancokinter.menus;

import java.util.Scanner;
import ar.edu.utn.frbb.tup.bancokinter.datos.*;
import ar.edu.utn.frbb.tup.bancokinter.utils.Validador;


public class MenuCliente {
    private Scanner scanner;
    private ListaClientes listaClientes;
    private Cliente cliente;

    public MenuCliente(Scanner scanner, ListaClientes listaClientes, Cliente cliente){
        this.scanner = scanner;
        this.listaClientes = listaClientes;
        this.cliente = cliente;
    }

    public void abrirMenuCliente(){
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("");
            System.out.println("Seleccione:");
            System.out.println("1- Acceder a cuenta.");
            System.out.println("2- Crear cuenta.");
            System.out.println("3- Mostrar cuentas.");
            System.out.println("4- Mostrar datos cliente.");
            System.out.println("5- Eliminar cliente.");
            System.out.println("6- Salir.");
            opcion = Validador.ingresarInt(scanner);
            switch (opcion) {
                case 1:
                    System.out.println("\u000C");
                    accederCuenta();
                    break;
                
                case 2:
                    System.out.println("\u000C");
                    crearCuenta();
                    break;
                
                case 3:
                    System.out.println("\u000C");
                    cliente.listarCuentas();
                    break;

                case 4:
                    System.out.println("\u000C");
                    mostrarDatos();
                    break;

                case 5:
                    System.out.println("\u000C");
                    eliminarCliente();
                    salir=true;
                    break;

                case 6:
                    salir = true;
                    break;
            
                default:
                    System.out.println("\u000C");
                    System.out.println("Ingrese una opción válida (1-6).");
                    break;
            }
        }
    }

    private void accederCuenta(){
        String cbuIngreso;
        System.out.println("Ingrese CBU de la cuenta:");
        cbuIngreso = String.valueOf(Validador.ingresarInt(scanner));
        Cuenta cuenta = cliente.localizarCuenta(cbuIngreso);
        if (cuenta!= null){
            MenuCuenta menuCuenta = new MenuCuenta(scanner, listaClientes, cliente, cuenta);
            menuCuenta.abrirMenuCuenta();
        }
        else{
            System.out.println("El CBU indicado no corresponde a una cuenta de este cliente.");
        }
    }

    private void crearCuenta(){
        boolean salir = false;
        TipoCuenta tipoCuenta = null;
        Cuenta cuenta;
        int opcion;
        while (!salir) {
            System.out.println("\u000C");
            System.out.println("Seleccione el tipo de cuenta:");
            System.out.println("1- Caja de ahorro.");
            System.out.println("2- Cuenta corriente.");
            System.out.println("3- Caja de ahorro en dólares.");
            System.out.println("4- Cuenta corriente en dólares.");
            System.out.println("5- Volver.");
            opcion = Validador.ingresarInt(scanner);
            switch (opcion) {
                case 1:
                    tipoCuenta = TipoCuenta.CajaAhorro;
                    cuenta = new Cuenta(cliente, tipoCuenta);
                    cliente.agregarCuenta(cuenta);
                    salir = true;
                    break;
    
                case 2:
                    tipoCuenta = TipoCuenta.CuentaCorriente;
                    cuenta = new Cuenta(cliente, tipoCuenta);
                    cliente.agregarCuenta(cuenta);
                    salir = true;
                    break;
    
                case 3:
                    tipoCuenta = TipoCuenta.CajaAhorroDolares;
                    cuenta = new Cuenta(cliente, tipoCuenta);
                    cliente.agregarCuenta(cuenta);
                    salir = true;
                    break;
    
                case 4:
                    tipoCuenta = TipoCuenta.CuentaCorrienteDolares;
                    cuenta = new Cuenta(cliente, tipoCuenta);
                    cliente.agregarCuenta(cuenta);
                    salir = true;
                    break;
    
                case 5:
                    salir = true;
                    break;
            
                default:
                    System.out.println("Ingrese una opción válida (1-5).");
                    break;
            }
        }   
    }

    private void mostrarDatos(){
        int opcion;
        boolean salir = false;
        while (!salir) {
            cliente.mostrarDatos();
            System.out.println("¿Desea modificar algún dato?");
            System.out.println("1- Sí.");
            System.out.println("2- No.");
            opcion = Validador.ingresarInt(scanner);
            switch (opcion) {
                case 1:
                    modificarDatos();
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

    private void modificarDatos(){
        int opcion;
        boolean salir = false;
        while (!salir) {
            cliente.mostrarDatos();
            System.out.println("Seleccione el dato a modificar:");
            System.out.println("1- Nombre.");
            System.out.println("2- Apellido.");
            System.out.println("3- DNI.");
            System.out.println("4- Clave.");
            System.out.println("5- Dirección.");
            System.out.println("6- Telefono.");
            System.out.println("7- Ninguno.");
            opcion = Validador.ingresarInt(scanner);
            switch (opcion) {
                case 1:
                    String nombreNuevo;
                    System.out.println("Ingrese sus nombres:");
                    nombreNuevo = scanner.nextLine();
                    cliente.setNombre(nombreNuevo);
                    salir = true;
                    break;
            
                case 2:
                    String apellidoNuevo;
                    System.out.println("Ingrese sus apellidos:");
                    apellidoNuevo = scanner.nextLine();
                    cliente.setApellido(apellidoNuevo);
                    salir = true;
                    break;

                case 3:
                    String dniNuevo;
                    System.out.println("Ingrese su DNI:");
                    dniNuevo = String.valueOf(Validador.ingresarInt(scanner));
                    cliente.setDni(dniNuevo);
                    salir = true;
                    break;

                case 4:
                    String claveNueva;
                    System.out.println("Ingrese una contraseña numérica:");
                    claveNueva = String.valueOf(Validador.ingresarInt(scanner));
                    cliente.setClave(claveNueva);
                    salir = true;
                    break;

                case 5:
                    String direccionNueva;
                    System.out.println("Ingrese su dirección:");
                    direccionNueva = scanner.nextLine();
                    cliente.setDireccion(direccionNueva);
                    salir = true;
                    break;

                case 6:
                    String telefonoNuevo;
                    System.out.println("Ingrese su teléfono (Sin '-' ni '+')");
                    telefonoNuevo = String.valueOf(Validador.ingresarInt(scanner));
                    cliente.setTelefono(telefonoNuevo);
                    salir = true;
                    break;

                case 7:
                    salir = true;
                    break;

                default:
                    System.out.println("Ingrese una opción válida (1-7).");
                    break;
            }
        }
    }

    private void eliminarCliente(){
        int opcion;
        boolean salir = false;
        while (!salir) {
            cliente.mostrarDatos();
            System.out.println("¿Está seguro que desea dejar de ser cliente de BancoKinter?");
            System.out.println("1- Sí.");
            System.out.println("2- No.");
            opcion = Validador.ingresarInt(scanner);
            switch (opcion) {
                case 1:
                    listaClientes.eliminarCliente(cliente);
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
