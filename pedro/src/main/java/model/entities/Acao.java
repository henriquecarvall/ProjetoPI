/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.Date;

/**
 *
 * @author usuario
 */
public class Acao {
    private String nome;
    private Date dataInicio;
    private Date dataFim;
    private String descricao;
    private int porcentagem;
    private String responsavel;
    
    private Funcionario funcionario;
    private Atividade atividade;

    public Acao() {
    }
    
    public Acao(String nome, Date dataInicio, Date dataFim, String descricao, int porcentagem, String responsavel, Funcionario funcionario, Atividade atividade) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
        this.porcentagem = porcentagem;
        this.responsavel = responsavel;
        this.funcionario = funcionario;
        this.atividade = atividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
    
    public int atualizarPercentual(int percent){
        porcentagem = percent;
        return porcentagem;
    }
    
    public String validarData(){
        if(!dataFim.after(dataInicio)){
            return "Data do fim não pode ser antes da data de início";
        }
        
        return null;
    } 
}
