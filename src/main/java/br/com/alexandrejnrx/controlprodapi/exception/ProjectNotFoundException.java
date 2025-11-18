package br.com.alexandrejnrx.controlprodapi.exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException() {
        super("Projeto não encontrado!");
    }
}
