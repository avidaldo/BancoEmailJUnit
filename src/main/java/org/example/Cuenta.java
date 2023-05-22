package org.example;


public class Cuenta {

    private final String email;
    public String getEmail() { return email; }

    private float saldo;
    public float getSaldo() { return saldo; }

    public Cuenta(String email, float saldo) {
        this.email = email;
        this.saldo = saldo;
    }

    public void restarASaldo(float cantidad) throws CantidadMayorQueSaldoException {
        if (cantidad > saldo) throw new CantidadMayorQueSaldoException();
        this.saldo -= cantidad;
    }

    public void sumarASaldo(float cantidad) {
        this.saldo += cantidad;
    }

}
