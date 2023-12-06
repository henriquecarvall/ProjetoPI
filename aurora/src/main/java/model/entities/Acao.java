/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.Date;
import model.entities.enums.Situacao;
import model.entities.enums.Status;

/**
 *
 * @author usuario
 */
public class Acao {

    // Atributos
    private String nomeAcao;
    private Date dataInicioAcao;
    private Date dataFimAcao;
    private String descricaoAcao;
    private int porcentagemAcao;

    // Relacionamentos
    private Funcionario funcionario;
    private Atividade atividade;

    // Enums
    private Status statusAcao;
    private Situacao situacaoAcao;

    public Acao() {
    }

    public Acao(String nomeAcao, Date dataInicioAcao, Date dataFimAcao, String descricaoAcao, int porcentagemAcao, Funcionario funcionario, Atividade atividade) {
        this.nomeAcao = nomeAcao;
        this.dataInicioAcao = dataInicioAcao;
        this.dataFimAcao = dataFimAcao;
        this.descricaoAcao = descricaoAcao;
        this.porcentagemAcao = porcentagemAcao;
        this.funcionario = funcionario;
        this.atividade = atividade;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    public Date getDataInicioAcao() {
        return dataInicioAcao;
    }

    public void setDataInicioAcao(Date dataInicioAcao) {
        this.dataInicioAcao = dataInicioAcao;
    }

    public Date getDataFimAcao() {
        return dataFimAcao;
    }

    public void setDataFimAcao(Date dataFimAcao) {
        this.dataFimAcao = dataFimAcao;
    }

    public String getDescricaoAcao() {
        return descricaoAcao;
    }

    public void setDescricaoAcao(String descricaoAcao) {
        this.descricaoAcao = descricaoAcao;
    }

    public int getPorcentagemAcao() {
        return porcentagemAcao;
    }

    public void setPorcentagemAcao(int porcentagemAcao) {
        this.porcentagemAcao = porcentagemAcao;
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

    public Status getStatusAcao() {
        return statusAcao;
    }

    public void setStatusAcao(Status statusAcao) {
        this.statusAcao = statusAcao;
    }

    public Situacao getSituacaoAcao() {
        return situacaoAcao;
    }

    public void setSituacaoAcao(Situacao situacaoAcao) {
        this.situacaoAcao = situacaoAcao;
    }

    public int atualizarPercentual(int percent) {
        porcentagemAcao = percent;
        return porcentagemAcao;
    }

    public String validarData() {
        if (!dataFimAcao.after(dataInicioAcao))
        {
            return "Data do fim não pode ser antes da data de início";
        }
        // VERIFICAÇÃO DA DATA INICIO
        // Verificar os mêses de 31 dias
        if (dataInicioAcao.getMonth() == 1
                || dataInicioAcao.getMonth() == 3
                || dataInicioAcao.getMonth() == 5
                || dataInicioAcao.getMonth() == 7
                || dataInicioAcao.getMonth() == 8
                || dataInicioAcao.getMonth() == 10
                || dataInicioAcao.getMonth() == 12)
        {
            if (dataInicioAcao.getDay() < 0 || dataInicioAcao.getDay() > 31)
            {
                return "Data inválida";
            }
        }
        // Verificar os mêses de 30 dias
        if (dataInicioAcao.getMonth() == 4
                || dataInicioAcao.getMonth() == 6
                || dataInicioAcao.getMonth() == 9
                || dataInicioAcao.getMonth() == 11)
        {
            if (dataInicioAcao.getDay() < 0 || dataInicioAcao.getDay() > 30)
            {
                return "Data inválida";
            }
        }
        // Verificar expecificamente Fevereiro(Ano bissexto)
        if (dataInicioAcao.getMonth() == 2)
        {
            if (dataInicioAcao.getYear() % 4 != 0)
            {
                if (dataInicioAcao.getDay() < 0 || dataInicioAcao.getDay() > 28)
                {
                    return "Data inválida";
                }
            }
            if (dataInicioAcao.getYear() % 4 == 0)
            {
                if (dataInicioAcao.getDay() < 0 || dataInicioAcao.getDay() > 29)
                {
                    return "Data inválida";
                }
            }
        }
        // VERIFICACAO DA DATA FIM
        if (dataFimAcao.getMonth() == 1
                || dataFimAcao.getMonth() == 3
                || dataFimAcao.getMonth() == 5
                || dataFimAcao.getMonth() == 7
                || dataFimAcao.getMonth() == 8
                || dataFimAcao.getMonth() == 10
                || dataFimAcao.getMonth() == 12)
        {
            if (dataFimAcao.getDay() < 0 || dataFimAcao.getDay() > 31)
            {
                return "Data inválida";
            }
        }
        // Verificar os mêses de 30 dias
        if (dataFimAcao.getMonth() == 4
                || dataFimAcao.getMonth() == 6
                || dataFimAcao.getMonth() == 9
                || dataFimAcao.getMonth() == 11)
        {
            if (dataFimAcao.getDay() < 0 || dataFimAcao.getDay() > 30)
            {
                return "Data inválida";
            }
        }
        // Verificar expecificamente Fevereiro(Ano bissexto)
        if (dataFimAcao.getMonth() == 2)
        {
            if (dataFimAcao.getYear() % 4 != 0)
            {
                if (dataFimAcao.getDay() < 0 || dataFimAcao.getDay() > 28)
                {
                    return "Data inválida";
                }
            }
            if (dataFimAcao.getYear() % 4 == 0)
            {
                if (dataFimAcao.getDay() < 0 || dataFimAcao.getDay() > 29)
                {
                    return "Data inválida";
                }
            }
        }
        return null;
    }
}
