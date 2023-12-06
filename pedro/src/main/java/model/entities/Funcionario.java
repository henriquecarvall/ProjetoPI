/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Funcionario {

    private String nome_completo;
    private String cpnj;
    private String usuario;
    private String senha;

    private Departamento departamento;
    List<Acao> lista_acoes = new ArrayList<>();

    public Funcionario() {
    }

    public Funcionario(String nome_completo, String cpnj, String usuario, String senha, Departamento departamento, Acao acao) {
        this.nome_completo = nome_completo;
        this.cpnj = cpnj;
        this.usuario = usuario;
        this.senha = senha;
        this.departamento = departamento;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Acao> getLista_acoes() {
        return lista_acoes;
    }

    public void addLista_acoes(Acao acao) {
        lista_acoes.add(acao);
    }

    public void removeLista_acoes(Acao acao) {
        lista_acoes.remove(acao);
    }
}
