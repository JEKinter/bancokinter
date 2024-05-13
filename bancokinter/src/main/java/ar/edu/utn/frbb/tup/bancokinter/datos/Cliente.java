package ar.edu.utn.frbb.tup.bancokinter.datos;

import java.util.ArrayList;

public class Cliente {
    protected String nombre;
    protected String apellido;
    protected String dni;
    private String clave;
    protected String direccion;
    protected String telefono;
    protected ArrayList<Cuenta> cuentas;

    public Cliente (String nombre, String apellido, String dni, String clave, String direccion, String telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.clave = clave;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuentas = new ArrayList<>();
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setDni(String dni){
        this.dni = dni;
    }
    
    public void setClave(String clave){
        this.clave = clave;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void agregarCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }

    public void eliminarCuenta(Cuenta cuenta){
        if (cuenta.saldo == 0){
            cuentas.remove(cuenta);
        }
        else{
            System.out.println("No puede eliminar una cuenta con saldo distinto de $0.");
        }
    }

    public void mostrarDatos(){
        System.out.println("Cliente: " + nombre + " " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Clave: " + clave);
        System.out.println("Dirección: " + direccion);
        System.out.println("Telefono: " + telefono);
    }

    public void listarCuentas(){
        if (cuentas.size() == 0){
            System.out.println("El cliente seleccionado no dispone de ninguna cuenta.");
        }
        else{
            for (Cuenta cuenta : cuentas) {
                System.out.println("CBU: " + cuenta.cbu + " /Tipo de cuenta: " + cuenta.tipo.getNombre());
            }
        }
    }

    public Cuenta localizarCuenta(String cbu){
        for (Cuenta cuenta : cuentas){
            if (cuenta.cbu.equals(cbu)){
                return cuenta;
            }
        }
        return null;
    }

    public boolean verificarClave(String clave){
        if (this.clave.equals(clave)){
            return true;
        }
        return false;
    }
}
