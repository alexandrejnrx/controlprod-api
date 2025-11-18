package br.com.alexandrejnrx.controlprodapi.exception;

public class ProjectNameAlreadyRegisteredException extends RuntimeException {

    public ProjectNameAlreadyRegisteredException() {
        super("Projeto já cadastrado!");
    }
}
