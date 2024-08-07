package com.grupo11.hootel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Refeicao {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "conteudo")
    @NotNull(message = "O campo prato deve ser preenchido")
    @NotEmpty(message = "Preencha o campo prato corretamente")
    private String conteudo;

    public Refeicao() {
    }

    public Refeicao(Integer id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public boolean validar() {
        return conteudo != null && validarEspecifico();
    }

    protected abstract boolean validarEspecifico();

    @Override
    public String toString() {
        return "Cardapio{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
