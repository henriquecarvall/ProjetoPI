/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import model.entities.enums.Situacao;

/**
 *
 * @author usuario
 */
public class Atividade {
    
    //Atributos
    private String nomeAtividade;
    private String descricaoAtividade;
    private Date dataInicioAtividade;
    private Date dataFimAtividade;
    private int porcentagemAtividade;
    
    //Relacionamentos
    private Projeto projeto;
    List<Acao> lista_acoes = new ArrayList<>();
    
    //Enums
    private Situacao situacaoAtividade;

    public Atividade() {
    }

    public Atividade(String nomeAtividade, String descricaoAtividade, Date dataInicioAtividade, Date dataFimAtividade, int porcentagemAtividade, Projeto projeto) {
        this.nomeAtividade = nomeAtividade;
        this.descricaoAtividade = descricaoAtividade;
        this.dataInicioAtividade = dataInicioAtividade;
        this.dataFimAtividade = dataFimAtividade;
        this.porcentagemAtividade = porcentagemAtividade;
        this.projeto = projeto;
    }

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    public Date getDataInicioAtividade() {
        return dataInicioAtividade;
    }

    public void setDataInicioAtividade(Date dataInicioAtividade) {
        this.dataInicioAtividade = dataInicioAtividade;
    }

    public Date getDataFimAtividade() {
        return dataFimAtividade;
    }

    public void setDataFimAtividade(Date dataFimAtividade) {
        this.dataFimAtividade = dataFimAtividade;
    }

    public int getPorcentagemAtividade() {
        return porcentagemAtividade;
    }

    public void setPorcentagemAtividade(int porcentagemAtividade) {
        this.porcentagemAtividade = porcentagemAtividade;
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

    public void addLista_acoes(Acao acao) {
        lista_acoes.add(acao);

    }

    public void removeLista_acoes(Acao acao) {
        lista_acoes.remove(acao);
    }

    public String validarData() {
        if (!dataFimAtividade.after(dataInicioAtividade))
        {
            return "Data do fim não pode ser antes da data de início";
        }
        // VERIFICAÇÃO DA DATA INICIO
        // Verificar os mêses de 31 dias
        if (dataInicioAtividade.getMonth() == 1
                || dataInicioAtividade.getMonth() == 3
                || dataInicioAtividade.getMonth() == 5
                || dataInicioAtividade.getMonth() == 7
                || dataInicioAtividade.getMonth() == 8
                || dataInicioAtividade.getMonth() == 10
                || dataInicioAtividade.getMonth() == 12)
        {
            if (dataInicioAtividade.getDay() < 0 || dataInicioAtividade.getDay() > 31)
            {
                return "Data inválida";
            }
        }
        // Verificar os mêses de 30 dias
        if (dataInicioAtividade.getMonth() == 4
                || dataInicioAtividade.getMonth() == 6
                || dataInicioAtividade.getMonth() == 9
                || dataInicioAtividade.getMonth() == 11)
        {
            if (dataInicioAtividade.getDay() < 0 || dataInicioAtividade.getDay() > 30)
            {
                return "Data inválida";
            }
        }
        // Verificar expecificamente Fevereiro(Ano bissexto)
        if (dataInicioAtividade.getMonth() == 2)
        {
            if (dataInicioAtividade.getYear() % 4 != 0)
            {
                if (dataInicioAtividade.getDay() < 0 || dataInicioAtividade.getDay() > 28)
                {
                    return "Data inválida";
                }
            }
            if (dataInicioAtividade.getYear() % 4 == 0)
            {
                if (dataInicioAtividade.getDay() < 0 || dataInicioAtividade.getDay() > 29)
                {
                    return "Data inválida";
                }
            }
        }
        // VERIFICACAO DA DATA FIM
        if (dataFimAtividade.getMonth() == 1
                || dataFimAtividade.getMonth() == 3
                || dataFimAtividade.getMonth() == 5
                || dataFimAtividade.getMonth() == 7
                || dataFimAtividade.getMonth() == 8
                || dataFimAtividade.getMonth() == 10
                || dataFimAtividade.getMonth() == 12)
        {
            if (dataFimAtividade.getDay() < 0 || dataFimAtividade.getDay() > 31)
            {
                return "Data inválida";
            }
        }
        // Verificar os mêses de 30 dias
        if (dataFimAtividade.getMonth() == 4
                || dataFimAtividade.getMonth() == 6
                || dataFimAtividade.getMonth() == 9
                || dataFimAtividade.getMonth() == 11)
        {
            if (dataFimAtividade.getDay() < 0 || dataFimAtividade.getDay() > 30)
            {
                return "Data inválida";
            }
        }
        // Verificar expecificamente Fevereiro(Ano bissexto)
        if (dataFimAtividade.getMonth() == 2)
        {
            if (dataFimAtividade.getYear() % 4 != 0)
            {
                if (dataFimAtividade.getDay() < 0 || dataFimAtividade.getDay() > 28)
                {
                    return "Data inválida";
                }
            }
            if (dataFimAtividade.getYear() % 4 == 0)
            {
                if (dataFimAtividade.getDay() < 0 || dataFimAtividade.getDay() > 29)
                {
                    return "Data inválida";
                }
            }
        }
        return null;
    }

    public int definirPorcentagem() {
        int porcentagemTotal = 0;
        int cont = 0;
        for (Acao acao : lista_acoes)
        {
            porcentagemTotal += acao.getPorcentagemAcao();
            cont++;
        }
        return porcentagemTotal / cont;
    }
}
