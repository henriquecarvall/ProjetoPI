/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package application;

import java.util.Scanner;

/**
 *
 * @author Pedro Queiroz <pqlb1512@gmail.com>
 * @date 06/12/2023
 * @brief Class Program
 */
public class Program {
    Scanner sc = new Scanner(System.in);
    
    public void menuInicial(){
        System.out.println("*************MENU************");
        System.out.println("1 - Vizualizar Quadro Kanaban");
        System.out.println("2 ----------------- Cadastrar");
        System.out.println("3 ---------------------- Sair");
    }
    
    public void menuCadastro(){
        System.out.println("O que Deseja Cadastrar?");
                System.out.println("1 ------------- Empresa");
                System.out.println("2 -------- Departamento");
                System.out.println("3 --------- Funcionario");
                System.out.println("4 ------------- Projeto");
                System.out.println("5 ----------- Atividade");
                System.out.println("6 ---------------- Ação");
                System.out.println("7 ---------------- Sair");
    }
}
