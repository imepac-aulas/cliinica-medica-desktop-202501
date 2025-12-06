package br.edu.imepac.clinica.entidades;

import java.time.LocalDateTime;

public class Consulta {
    private Long id;
    private Medico medico;
    private Pessoa paciente;
    private LocalDateTime dataHora;
    private String motivo;

    public Consulta() {
    }

    public Consulta(Long id, Medico medico, Pessoa paciente, LocalDateTime dataHora, String motivo) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.dataHora = dataHora;
        this.motivo = motivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Pessoa getPaciente() {
        return paciente;
    }

    public void setPaciente(Pessoa paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
