 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entities;

import java.util.ArrayList;
import java.util.List;
import model.entities.enums.ClassificacaoFuncionario;

/**
 *
 * @author usuario
 */
public class Funcionario {

    // Atributos
    private String nomeFuncionario;
    private String cpf;
    private String usuarioFuncionario;
    private String senhaFuncionario;

    //Relacionamentos
    private Departamento departamento;
    List<Acao> lista_acoes = new ArrayList<>();

    //Enums
    private ClassificacaoFuncionario classificacaoFuncionario;

    public Funcionario() {
    }

    public Funcionario(String nomeFuncionario, String cpf, String usuarioFuncionario, String senhaFuncionario, Departamento departamento, ClassificacaoFuncionario classificacaoFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.cpf = cpf;
        this.usuarioFuncionario = usuarioFuncionario;
        this.senhaFuncionario = senhaFuncionario;
        this.departamento = departamento;
        this.classificacaoFuncionario = classificacaoFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsuarioFuncionario() {
        return usuarioFuncionario;
    }

    public void setUsuarioFuncionario(String usuarioFuncionario) {
        this.usuarioFuncionario = usuarioFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
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

    public ClassificacaoFuncionario getClassificacaoFuncionario() {
        return classificacaoFuncionario;
    }

    public void setClassificacaoFuncionario(ClassificacaoFuncionario classificacaoFuncionario) {
        this.classificacaoFuncionario = classificacaoFuncionario;
    }

    public boolean validarCPF(String cpf) {
        this.cpf = cpf;

        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF tem 11 dígitos
        if (cpf.length() != 11)
        {
            return false;
        }

        if ("00000000000".equals(cpf)
                || "11111111111".equals(cpf)
                || "22222222222".equals(cpf)
                || "33333333333".equals(cpf)
                || "44444444444".equals(cpf)
                || "55555555555".equals(cpf)
                || "66666666666".equals(cpf)
                || "77777777777".equals(cpf)
                || "88888888888".equals(cpf)
                || "99999999999".equals(cpf))
        {
            return false;
        }

        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++)
        {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : (11 - resto);

        // Verificar o primeiro dígito verificador
        if (digito1 != Character.getNumericValue(cpf.charAt(9)))
        {
            return false;
        }

        // Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++)
        {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : (11 - resto);

        // Verificar o segundo dígito verificador
        return (digito2 == Character.getNumericValue(cpf.charAt(10)));
    }
    
    public boolean login(String login, String senha){
        if(!login.equals(usuarioFuncionario)){
            return false;
        }
        if(!senha.equals(senhaFuncionario)){
            return false;
        }
        return true;
    }
}
