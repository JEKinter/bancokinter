package ar.edu.utn.frbb.tup.bancokinter.datos;

import java.util.ArrayList;

public class ListaClientes {
    private ArrayList<Cliente> clientes;

    public ListaClientes(){
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente){
        if (cliente.cuentas.size() == 0){
            clientes.remove(cliente);
        }
        else{
            System.out.println("Para eliminar un cliente primero debe eliminar sus cuentas.");
        }
    }

    public Cliente localizarCliente(String dni){
        for (Cliente cliente : clientes){
            if (cliente.dni.equals(dni)){
                return cliente;
            }
        }
        System.out.println("No se ha encontrado al cliente.");
        return null;
    }

    public Cuenta localizarCuenta(String cbu){
        Cuenta cuenta;
        for (Cliente cliente : clientes){
            cuenta = cliente.localizarCuenta(cbu);
            if (cuenta != null){
                return cuenta;
            }
        }
        return null;
    }

}

