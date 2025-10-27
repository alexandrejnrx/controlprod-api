package br.com.alexandrejnrx.controlprodapi.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Produto não encontrado.");
    }
}
