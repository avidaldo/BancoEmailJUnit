package org.example;

public class Controller {
    private final Repository repository = new Repository();

    private static final float MIN_CANTIDAD_TRANSACCION = 0.50f;
    private static final float MAX_CANTIDAD_TRANSACCION = 500f;

    public boolean registrarCuenta(String emailRegistro, float cantidadInicial)
            throws CantidadInicialMenorOIgualQueCeroException {
        if (cantidadInicial <= 0) throw new CantidadInicialMenorOIgualQueCeroException();
        return repository.add(new Cuenta(emailRegistro, cantidadInicial));
    }

    public float consultarSaldo(String email) throws CuentaNoExisteException {
        Cuenta cuenta = repository.findByEmail(email);
        if (cuenta==null) throw new CuentaNoExisteException();
        else return cuenta.getSaldo();
    }

    public void ingresarDinero(String emailOrigen, float cantidad)
            throws CantidadInicialMenorOIgualQueCeroException, CantidadInIntervaloValidoException {
        if (cantidad <= 0) throw new CantidadInicialMenorOIgualQueCeroException();
        if ((cantidad < MIN_CANTIDAD_TRANSACCION) || (cantidad > MAX_CANTIDAD_TRANSACCION))
            throw new CantidadInIntervaloValidoException();
        repository.ingresarDinero(emailOrigen,cantidad);
    }

    public void sacarDinero(String emailDestino, float cantidad)
            throws CantidadInicialMenorOIgualQueCeroException, CantidadInIntervaloValidoException,
            CantidadMayorQueSaldoException {
        if (cantidad <= 0) throw new CantidadInicialMenorOIgualQueCeroException();
        if ((cantidad < MIN_CANTIDAD_TRANSACCION) || (cantidad > MAX_CANTIDAD_TRANSACCION))
            throw new CantidadInIntervaloValidoException();
        repository.findByEmail(emailDestino).restarASaldo(cantidad);
    }


}
