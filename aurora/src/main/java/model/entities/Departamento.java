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
public class Departamento {

    private String nomeDepartamento;
    private int id_departamento;

    private Empresa empresa;
    List<Funcionario> lista_funcionarios = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String nomeDepartamento, int id_departamento, Empresa empresa) {
        this.nomeDepartamento = nomeDepartamento;
        this.id_departamento = id_departamento;
        this.empresa = empresa;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Funcionario> getLista_funcionarios() {
        return lista_funcionarios;
    }

    public void addLista_funcionarios(Funcionario funcionario) {
        lista_funcionarios.add(funcionario);
    }

    public void removeLista_funcionarios(Funcionario funcionario) {
        lista_funcionarios.remove(funcionario);
    }

}
