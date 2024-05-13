package ar.edu.utn.frbb.tup.bancokinter.datos;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cuenta {
    protected Cliente cliente;
    protected String cbu;
    protected TipoCuenta tipo;
    protected float saldo;
    protected ZonedDateTime fechaApertura;
    protected ArrayList<Movimiento> movimientos;
    DateTimeFormatter myFormatObj;

    public Cuenta(Cliente cliente, TipoCuenta tipo){
        this.cliente = cliente;
        int contador = 1;
        boolean existe = true;
        String cbuRegistro;
        while (existe) {
            cbuRegistro = "226"+ cliente.dni + String.valueOf(contador);
            if (cliente.cuentas.size() == 0){
                this.cbu = cbuRegistro;
                existe = false;
            }
            else{
                for (Cuenta cuenta : cliente.cuentas){
                    if (cbuRegistro.equals(cuenta.cbu)){
                        contador += 1;
                        cbuRegistro = "226"+ cliente.dni + String.valueOf(contador);
                    }
                    else{
                        this.cbu = cbuRegistro;
                        existe = false;
                    }
                }
            }
        }
        this.tipo = tipo;
        this.saldo = 0;
        this.fechaApertura = ZonedDateTime.now();
        this.movimientos = new ArrayList<>();
        myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("CBU: " + this.cbu);
    }

    public void mostrarDatos(){
        System.out.println("Cliente: " + cliente.nombre + " " + cliente.apellido);
        System.out.println("CBU: " + cbu);
        System.out.println("Tipo: " + tipo.getNombre());
        System.out.println("Saldo: $" + saldo);
        System.out.println("Fecha de apertura: " + fechaApertura.format(myFormatObj));
    }

    private void agregarMovimiento(Movimiento movimiento){
        movimientos.add(movimiento);
    }

    public void realizarDeposito(float deposito){
        saldo = saldo + deposito;
        System.out.println("La operación se ha realizado con éxito.");
        Movimiento movimiento = new Movimiento(this, this, deposito, "Depósito");
        agregarMovimiento(movimiento);
    }

    public void realizarRetiro(float retiro){
        if (saldo < retiro){
            System.out.println("No se dispone del monto suficiente para realizar la operación.");
        }
        else{
            saldo = saldo - retiro;
            System.out.println("La operación se ha realizado con éxito.");
            Movimiento movimiento = new Movimiento(this, this, retiro, "Retiro");
            agregarMovimiento(movimiento);
        }
    }

    public void realizarTransferencia(ListaClientes listaClientes, String cbuTransferencia, float transferencia){
        if (cbuTransferencia.equals(cbu)) {
            System.out.println("No se puede realizar una transferencia de una cuenta a si misma.");
        }
        else {
            if (saldo < transferencia){
                System.out.println("No se dispone del monto suficiente para realizar la operación.");
            }
            else{
                Cuenta cuentaTransferencia;
                cuentaTransferencia = listaClientes.localizarCuenta(cbuTransferencia);
                if (cuentaTransferencia == null){
                    System.out.println("El CBU indicado no corresponde a una cuenta en servicio.");
                }
                else{
                    if (tipo.getDivisa() == cuentaTransferencia.tipo.getDivisa()){
                        saldo = saldo - transferencia;
                        cuentaTransferencia.saldo = cuentaTransferencia.saldo + transferencia;
                        System.out.println("La operación se ha realizado con éxito.");
                        Movimiento movimiento = new Movimiento(this, cuentaTransferencia, transferencia, "Transferencia");
                        agregarMovimiento(movimiento);
                        cuentaTransferencia.agregarMovimiento(movimiento);
                    }
                    else{
                        System.out.println("Las transferencias sólo pueden realizarse entre cuentas con el mismo tipo de divisa.");
                    }
                }
            }
        }
    }

    public void mostrarMovimientos(){
        System.out.println("Movimientos: ");
        for (Movimiento movimiento : movimientos){
            System.out.println("");
            System.out.println("Fecha: " + fechaApertura.format(myFormatObj));
            if ((movimiento.tipo.equals("Transferencia") && this.cbu.equals(movimiento.cuentaEmisor.cbu)) || (movimiento.tipo.equals("Retiro"))){
                System.out.println("Modificación saldo: -$" + movimiento.modificacionSaldo);
            }
            else{
                System.out.println("Modificación saldo: $" + movimiento.modificacionSaldo);
            }
            System.out.println("Tipo de movimiento: " + movimiento.tipo);
            if (movimiento.tipo.equals("Transferencia")){
                System.out.println("Cuenta emisora: " + movimiento.cuentaEmisor.cbu);
                System.out.println("Cuenta receptora: " + movimiento.cuentaReceptor.cbu);
            }
        }
    }
}
