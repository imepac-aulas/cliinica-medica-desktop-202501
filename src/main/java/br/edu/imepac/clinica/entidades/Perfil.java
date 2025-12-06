package br.edu.imepac.clinica.entidades;

import java.util.Set;

public class Perfil {
    private String nome;
    private Set<EnumFuncionalidades> funcionalidades;

    public Perfil() {
    }

    public Perfil(String nome, Set<EnumFuncionalidades> funcionalidades) {
        this.nome = nome;
        this.funcionalidades = funcionalidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<EnumFuncionalidades> getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(Set<EnumFuncionalidades> funcionalidades) {
        this.funcionalidades = funcionalidades;
    }
}
