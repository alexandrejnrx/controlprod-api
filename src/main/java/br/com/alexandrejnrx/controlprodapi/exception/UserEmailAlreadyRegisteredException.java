package br.com.alexandrejnrx.controlprodapi.exception;

public class UserEmailAlreadyRegisteredException extends RuntimeException {

    public UserEmailAlreadyRegisteredException() {
        super("Email já cadastrado!");
    }
}
