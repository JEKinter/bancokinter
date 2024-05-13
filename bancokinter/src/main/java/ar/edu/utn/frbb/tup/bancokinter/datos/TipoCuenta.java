package ar.edu.utn.frbb.tup.bancokinter.datos;

public enum TipoCuenta {
    CajaAhorro("Caja de Ahorro", "Pesos"),
    CuentaCorriente("Cuenta Corriente", "Pesos"),
    CajaAhorroDolares("Caja de ahorro en dólares", "Dólares"),
    CuentaCorrienteDolares("Cuenta Corriente en dólares", "Dólares");

    private String nombre;
    private String divisa;

    private TipoCuenta(String nombre, String divisa){
        this.nombre = nombre;
        this.divisa = divisa;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDivisa(){
        return divisa;
    }
}
