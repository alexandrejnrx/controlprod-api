package br.com.alexandrejnrx.controlprodapi.exception;

public class ProductTypeNotFoundException extends RuntimeException {

    public ProductTypeNotFoundException() {
        super("Tipo produto não encontrado.");
    }
}
