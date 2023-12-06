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
public class Empresa {

    private String nomeEmpresa;
    private String cnpj;

    List<Departamento> lista_departamentos = new ArrayList<>();
    List<Projeto> lista_projetos = new ArrayList<>();

    public Empresa() {
    }

    public Empresa(String nomeEmpresa, String cnpj) {
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Departamento> getLista_departamentos() {
        return lista_departamentos;
    }

    public void setLista_departamentos(List<Departamento> lista_departamentos) {
        this.lista_departamentos = lista_departamentos;
    }

    public List<Projeto> getLista_projetos() {
        return lista_projetos;
    }
    
    public void addLista_departamentos(Departamento departamento) {
        lista_departamentos.add(departamento);
    }

    public void removeLista_departamentos(Departamento departamento) {
        lista_departamentos.remove(departamento);
    }

    public void addLista_projetos(Projeto projeto) {
        lista_projetos.add(projeto);
    }

    public void removeLista_projetos(Projeto projeto) {
        lista_projetos.remove(projeto);
    }

    public boolean validarCNPJ(String cnpj) {
        // Remover caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verificar se o CNPJ tem 14 dígitos
        if (cnpj.length() != 14)
        {
            return false;
        }

        // Calcular o primeiro dígito verificador
        int soma = 0;
        int peso = 5;
        for (int i = 0; i < 12; i++)
        {
            soma += Character.getNumericValue(cnpj.charAt(i)) * peso;
            peso = (peso == 2) ? 9 : peso - 1;
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : (11 - resto);

        // Verificar o primeiro dígito verificador
        if (digito1 != Character.getNumericValue(cnpj.charAt(12)))
        {
            return false;
        }

        // Calcular o segundo dígito verificador
        soma = 0;
        peso = 6;
        for (int i = 0; i < 13; i++)
        {
            soma += Character.getNumericValue(cnpj.charAt(i)) * peso;
            peso = (peso == 2) ? 9 : peso - 1;
        }
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : (11 - resto);

        // Verificar o segundo dígito verificador
        return (digito2 == Character.getNumericValue(cnpj.charAt(13)));
    }

}
