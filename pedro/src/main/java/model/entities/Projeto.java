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

    private String nomeProjeto;
    private String descricaoProjeto;
    private int porcentagemProjeto;
    private Date dataInicioProjeto;
    private Date dataFimProjeto;

    List<Atividade> lista_atividades = new ArrayList<>();
    private Empresa empresa;

    public Projeto() {
    }

    public Projeto(String nomeProjeto, String descricaoProjeto, int porcentagemProjeto, Date dataInicioProjeto, Date dataFimProjeto, Empresa empresa) {
        this.nomeProjeto = nomeProjeto;
        this.descricaoProjeto = descricaoProjeto;
        this.porcentagemProjeto = porcentagemProjeto;
        this.dataInicioProjeto = dataInicioProjeto;
        this.dataFimProjeto = dataFimProjeto;
        this.empresa = empresa;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricaoProjeto() {
        return descricaoProjeto;
    }

    public void setDescricaoProjeto(String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
    }

    public int getPorcentagemProjeto() {
        return porcentagemProjeto;
    }

    public void setPorcentagemProjeto(int porcentagemProjeto) {
        this.porcentagemProjeto = porcentagemProjeto;
    }

    public Date getDataInicioProjeto() {
        return dataInicioProjeto;
    }

    public void setDataInicioProjeto(Date dataInicioProjeto) {
        this.dataInicioProjeto = dataInicioProjeto;
    }

    public Date getDataFimProjeto() {
        return dataFimProjeto;
    }

    public void setDataFimProjeto(Date dataFimProjeto) {
        this.dataFimProjeto = dataFimProjeto;
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

    public int definirPorcentagem() {
        int porcentagemTotal = 0;
        int cont = 0;
        for (Atividade atividade : lista_atividades)
        {
            porcentagemTotal += atividade.getPorcentagemAtividade();
            cont++;
        }
        return porcentagemTotal / cont;
    }

    public String validarData() {
        if (!dataFimProjeto.after(dataInicioProjeto))
        {
            return "Data do fim não pode ser antes da data de início";
        }
        // VERIFICAÇÃO DA DATA INICIO
        // Verificar os mêses de 31 dias
        if (dataInicioProjeto.getMonth() == 1
                || dataInicioProjeto.getMonth() == 3
                || dataInicioProjeto.getMonth() == 5
                || dataInicioProjeto.getMonth() == 7
                || dataInicioProjeto.getMonth() == 8
                || dataInicioProjeto.getMonth() == 10
                || dataInicioProjeto.getMonth() == 12)
        {
            if (dataInicioProjeto.getDay() < 0 || dataInicioProjeto.getDay() > 31)
            {
                return "Data inválida";
            }
        }
        // Verificar os mêses de 30 dias
        if (dataInicioProjeto.getMonth() == 4
                || dataInicioProjeto.getMonth() == 6
                || dataInicioProjeto.getMonth() == 9
                || dataInicioProjeto.getMonth() == 11)
        {
            if (dataInicioProjeto.getDay() < 0 || dataInicioProjeto.getDay() > 30)
            {
                return "Data inválida";
            }
        }
        // Verificar expecificamente Fevereiro(Ano bissexto)
        if (dataInicioProjeto.getMonth() == 2)
        {
            if (dataInicioProjeto.getYear() % 4 != 0)
            {
                if (dataInicioProjeto.getDay() < 0 || dataInicioProjeto.getDay() > 28)
                {
                    return "Data inválida";
                }
            }
            if (dataInicioProjeto.getYear() % 4 == 0)
            {
                if (dataInicioProjeto.getDay() < 0 || dataInicioProjeto.getDay() > 29)
                {
                    return "Data inválida";
                }
            }
        }
        // VERIFICACAO DA DATA FIM
        if (dataFimProjeto.getMonth() == 1
                || dataFimProjeto.getMonth() == 3
                || dataFimProjeto.getMonth() == 5
                || dataFimProjeto.getMonth() == 7
                || dataFimProjeto.getMonth() == 8
                || dataFimProjeto.getMonth() == 10
                || dataFimProjeto.getMonth() == 12)
        {
            if (dataFimProjeto.getDay() < 0 || dataFimProjeto.getDay() > 31)
            {
                return "Data inválida";
            }
        }
        // Verificar os mêses de 30 dias
        if (dataFimProjeto.getMonth() == 4
                || dataFimProjeto.getMonth() == 6
                || dataFimProjeto.getMonth() == 9
                || dataFimProjeto.getMonth() == 11)
        {
            if (dataFimProjeto.getDay() < 0 || dataFimProjeto.getDay() > 30)
            {
                return "Data inválida";
            }
        }
        // Verificar expecificamente Fevereiro(Ano bissexto)
        if (dataFimProjeto.getMonth() == 2)
        {
            if (dataFimProjeto.getYear() % 4 != 0)
            {
                if (dataFimProjeto.getDay() < 0 || dataFimProjeto.getDay() > 28)
                {
                    return "Data inválida";
                }
            }
            if (dataFimProjeto.getYear() % 4 == 0)
            {
                if (dataFimProjeto.getDay() < 0 || dataFimProjeto.getDay() > 29)
                {
                    return "Data inválida";
                }
            }
        }
        return null;
    }

    public long calcularDuracao() {
        long duracao = dataFimProjeto.getTime() - dataInicioProjeto.getTime();
        return TimeUnit.DAYS.convert(duracao, TimeUnit.DAYS);
    }
}
