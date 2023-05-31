package org.example;

import java.util.*;

public class Repository {

    private final List<Cuenta> baseDeDatos = new ArrayList<>();


    public boolean add(Cuenta cuenta) {
        if (findByEmail(cuenta.getEmail())!=null) return false;
        else return baseDeDatos.add(cuenta);
    }

    public Cuenta findByEmail(String email) {
        return baseDeDatos.stream().filter(e -> e.getEmail().equals(email)).findAny().orElse(null);
    }

    public void ingresarDinero(String emailOrigen, float cantidad) {
        findByEmail(emailOrigen).sumarASaldo(cantidad);
    }

    /**
     *
     * @param emailDestino
     * @param cantidad
     * @throws CantidadMayorQueSaldoException
     */
    public void sacarDinero(String emailDestino, float cantidad) throws CantidadMayorQueSaldoException {
        findByEmail(emailDestino).restarASaldo(cantidad);
    }
}
