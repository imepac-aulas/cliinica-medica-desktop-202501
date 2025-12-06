package br.edu.imepac.clinica.entidades;

public class Medico extends Pessoa {
    private String crm;
    private Especialidade especialidade;

    public Medico() {
    }

    public Medico(Long id, String nome, String telefone, String email, String crm, Especialidade especialidade) {
        super(id, nome, telefone, email);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
