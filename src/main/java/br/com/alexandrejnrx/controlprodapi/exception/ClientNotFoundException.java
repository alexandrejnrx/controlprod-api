package br.com.alexandrejnrx.controlprodapi.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException() {
        super("Cliente não encontrado.");
    }
}
