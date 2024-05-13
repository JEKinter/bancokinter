package ar.edu.utn.frbb.tup.bancokinter.datos;

import java.time.ZonedDateTime;

public class Movimiento {
    protected Cuenta cuentaEmisor;
    protected Cuenta cuentaReceptor;
    protected float modificacionSaldo;
    protected String tipo;
    protected ZonedDateTime fechaMovimiento;

    public Movimiento(Cuenta cuentaEmisor, Cuenta cuentaReceptor, float modificacionSaldo, String tipo){
        this.cuentaEmisor = cuentaEmisor;
        this.cuentaReceptor = cuentaReceptor;
        this.modificacionSaldo = modificacionSaldo;
        this.tipo = tipo;
        this.fechaMovimiento = ZonedDateTime.now();
    }
}
