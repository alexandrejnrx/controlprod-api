package br.com.alexandrejnrx.controlprodapi.model;

public enum PerfilUsuario {

    ADMIN("admin"),
    USER("user");

    private String perfil;

    PerfilUsuario(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }
}
