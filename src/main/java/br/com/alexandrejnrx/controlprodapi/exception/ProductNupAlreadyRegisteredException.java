package br.com.alexandrejnrx.controlprodapi.exception;

public class ProductNupAlreadyRegisteredException extends RuntimeException {

    public ProductNupAlreadyRegisteredException() {
        super("NUP já cadastrado!");
    }
}
