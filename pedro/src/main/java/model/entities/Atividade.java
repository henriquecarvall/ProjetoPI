/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


/**
 *
 * @author usuario
 */
public class Atividade {
    private String nome;
    private String descricao; 
    private Date data_inicio;
    private Date data_fim;
    private int porcentagem;
    
    private Projeto projeto;
    List<Acao> lista_acoes = new ArrayList<>();

    public Atividade() {
    }

    public Atividade(String nome, String descricao, Date data_inicio, Date data_fim, int porcentagem, Projeto projeto) {
        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.porcentagem = porcentagem;
        this.projeto = projeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public int getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Acao> getLista_acoes() {
        return lista_acoes;
    }
    
    public void addLista_acoes(Acao acao){
        lista_acoes.add(acao);
        
    }
    
    public void removeLista_acoes(Acao acao) {
        lista_acoes.remove(acao);
    }
    
    public String validarData(){
        if(!data_fim.after(data_inicio)){
            return "Data do fim não pode ser antes da data de início";
        }
        return null;
    }
    
    public int definirPorcentagem(){
        int porcentagemTotal = 0;
        int cont = 0;
        for (Acao acao : lista_acoes)
        {
            porcentagemTotal += acao.getPorcentagem();
            cont++;
        }
        return porcentagemTotal / cont;
    }
    
    
}

