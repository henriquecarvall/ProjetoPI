/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author usuario
 */
public class Projeto {
    private String nome;
    private String descricao;
    private String porcetagem;
    private Date data_inicio;
    private Date data_final;
    
    List<Atividade> lista_atividades = new ArrayList<>();
    private Empresa empresa;

    public Projeto() {
    }

    public Projeto(String nome, String descricao, String porcetagem, Date data_inicio, Date data_final, Empresa empresa) {
        this.nome = nome;
        this.descricao = descricao;
        this.porcetagem = porcetagem;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.empresa = empresa;
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

    public String getPorcetagem() {
        return porcetagem;
    }

    public void setPorcetagem(String porcetagem) {
        this.porcetagem = porcetagem;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public List<Atividade> getLista_atividades() {
        return lista_atividades;
    }
    public void addLista_atividades(Atividade atividade) {
        lista_atividades.add(atividade);
    }

    public void removeLista_atividades(Atividade atividade) {
        lista_atividades.remove(atividade);
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public int definirPorcentagem(){
        int porcentagemTotal = 0;
        int cont = 0;
        for (Atividade atividade : lista_atividades)
        {
            porcentagemTotal += atividade.getPorcentagem();
            cont++;
        }
        return porcentagemTotal / cont;
    }
        public long calcularDuracao() {
        long duracao = data_final.getTime() - data_inicio.getTime();
        return TimeUnit.DAYS.convert(duracao, TimeUnit.DAYS);
    }
}
