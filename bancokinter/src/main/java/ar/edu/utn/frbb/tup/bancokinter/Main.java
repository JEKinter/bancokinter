package ar.edu.utn.frbb.tup.bancokinter;

import java.util.Scanner;

import ar.edu.utn.frbb.tup.bancokinter.datos.ListaClientes;
import ar.edu.utn.frbb.tup.bancokinter.menus.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaClientes listaClientes = new ListaClientes();
        MenuPrincipal menuPrincipal = new MenuPrincipal(scanner, listaClientes);

        menuPrincipal.abrirMenuPrincipal();
    }
}