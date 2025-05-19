package com.mack.clinica.model;

/**
 * Modelo que representa o usuário do sistema.
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String celular;
    private String tipo; // paciente ou admin

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
     
    public void setEmail(String string) {
        this.email = string;
    }

    public String getEmail() {
        return email;
    }

    public void setCpf(String string) {
        this.cpf = string;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCelular(String string) {
        this.celular = string;
    }

    public String getCelular() {
        return celular;
    }
}
