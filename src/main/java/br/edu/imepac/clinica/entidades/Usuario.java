package br.edu.imepac.clinica.entidades;

public class Usuario {
    private String login;
    private String senha;
    private Perfil perfil;
    private EnumStatusUsuario status;

    public Usuario() {
    }

    public Usuario(String login, String senha, Perfil perfil, EnumStatusUsuario status) {
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public EnumStatusUsuario getStatus() {
        return status;
    }

    public void setStatus(EnumStatusUsuario status) {
        this.status = status;
    }
}
