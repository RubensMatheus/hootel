package com.grupo11.hootel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Evento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "O campo horaário deve ser preenchido")
    @NotEmpty(message = "Preencha o campo horário corretamente")
    @Column(name = "horario")
    private String horario;

    @NotNull(message = "O campo lugar deve ser preenchido")
    @NotEmpty(message = "Preencha o campo lugar corretamente")
    @Column(name = "lugar")
    private String lugar;

    @NotNull(message = "O campo nome deve ser preenchido")
    @NotEmpty(message = "Preencha o campo nome corretamente")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "O campo data deve ser preenchido")
    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @NotNull(message = "O campo descricao deve ser preenchido")
    @NotEmpty(message = "Preencha o campo descricao corretamente")
    @Column(name = "descricao")
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "participantes_eventos",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "reserva_pin")
    )
    private List<Reserva> reservas;

    public boolean validar() {
        return horario != null && lugar != null && nome != null && dataInicio != null && descricao != null && validarEspecifico();
    }

    protected abstract boolean validarEspecifico();

    public Integer quantidadeReservas() {
        return reservas.size();
    }

    public Evento() {
        this.reservas = new ArrayList<>();
    }

    public Evento(Integer id, String horario, String lugar, String nome, LocalDate dataInicio, String descricao, List<Reserva> reservas) {
        this.id = id;
        this.horario = horario;
        this.lugar = lugar;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.descricao = descricao;
        this.reservas = reservas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void removeReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", horario='" + horario + '\'' +
                ", lugar='" + lugar + '\'' +
                ", nome='" + nome + '\'' +
                ", dataInicio=" + dataInicio +
                ", descricao='" + descricao + '\'' +
                ", reservas=" + reservas +
                '}';
    }

}
