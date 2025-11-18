package br.com.alexandrejnrx.controlprodapi.exception;

public class UserUsernameAlreadyRegisteredException extends RuntimeException {

    public UserUsernameAlreadyRegisteredException() {
        super("Nome de usuário já cadastrado!");
    }
}
