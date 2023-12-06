/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.entities.Acao;
import model.entities.Atividade;
import model.entities.Departamento;
import model.entities.Empresa;
import model.entities.Funcionario;
import model.entities.Projeto;
import model.entities.enums.ClassificacaoFuncionario;

/**
 *
 * @author usuario
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String nomeEmpresa = "Teste";
        String cnpj = "00000000000000";
        Empresa empresa = new Empresa(nomeEmpresa, cnpj);
        String nomeDepartamento = "Administração";
        int id_departamento = 1;
        Departamento departamento = new Departamento(nomeDepartamento, id_departamento, empresa);
        empresa.addLista_departamentos(departamento);
        String nomeFuncionario = "administrador";
        String cpf = "00000000000";
        String usuarioFuncionario = "admin";
        String senhaFuncionario = "admin";
        ClassificacaoFuncionario classificacaoFuncionario = ClassificacaoFuncionario.ADMINISTRADOR;
        Funcionario adm = new Funcionario(nomeFuncionario, cpf, usuarioFuncionario, senhaFuncionario, departamento, classificacaoFuncionario);
        String nomeProjeto = "Projeto 1";
        String descricaoProjeto = "";
        int porcentagemProjeto = 0;
        Date dataInicioProjeto = sdf.parse("06/12/2023");
        Date dataFimProjeto = sdf.parse("06/12/2023");
        Projeto projeto = new Projeto(nomeProjeto, descricaoProjeto, porcentagemProjeto, dataInicioProjeto, dataFimProjeto, empresa);
        String nomeAtividade = "Atividade 1";
        String descricaoAtividade = "";
        Date dataInicioAtividade = sdf.parse("06/12/2023");
        Date dataFimAtividade = sdf.parse("06/12/2023");
        int porcentagemAtividade = 0;
        Atividade atividade = new Atividade(nomeAtividade, descricaoAtividade, dataInicioAtividade, dataFimAtividade, porcentagemAtividade, projeto);
        String nomeAcao = "Ação 1";
        Date dataInicioAcao = sdf.parse("06/12/2023");
        Date dataFimAcao = sdf.parse("06/12/2023");
        String descricaoAcao = "";
        int porcentagemAcao = 0;
        Acao acao = new Acao(nomeAcao, dataInicioAcao, dataFimAcao, descricaoAcao, porcentagemAcao, adm, atividade);
        List<Empresa> listaEmpresas = new ArrayList<>();
        Program program = new Program();
        Scanner sc = new Scanner(System.in);
        System.out.println("******BEM VINDO!!******");
        System.out.println("*********LOGIN*********");
        String login = "";
        String senha = "";
        while (adm.login(login, senha) != true) {
            System.out.println("Informe seu Login: ");
            login = sc.next();
            System.out.println("Informe sua senha: ");
            senha = sc.next();
            if (adm.login(login, senha) == true) {
                int opcmenuInicial = 0;
                while (opcmenuInicial != 3) {  // Loop externo com 3 opções
                    program.menuInicial();
                    opcmenuInicial = sc.nextInt();

                    switch (opcmenuInicial) {
                        case 1 -> {
                            System.out.println("****PROJETOS****");
                            for (int i = 0; i != empresa.getLista_projetos().size(); i++) {
                                System.out.println("Projeto #"+(i+1)+
                                        "\nNome: " + projeto.getNomeProjeto()+
                                        "\nPorcentagem: " + projeto.getPorcentagemProjeto()+
                                        "\nDuração: "+ projeto.calcularDuracao() +" Dias");
                            }
                            System.out.println("***ATIVIDADES***");
                            for (int i = 0; i != projeto.getLista_atividades().size(); i++) {
                                System.out.println("Atividade #"+(i+1)+
                                        "\nNome: " + atividade.getNomeAtividade()+
                                        "\nPorcentagem: "+ atividade.definirPorcentagem());
                            }
                            System.out.println("*****AÇÕES*****");
                            for (int i = 0; i != atividade.getLista_acoes().size(); i++) {
                                System.out.println("Ação #"+(i+1)+
                                        "\nNome: "+acao.getNomeAcao()+
                                        "\nPorcentagem: "+acao.getPorcentagemAcao());
                            }
                            break;
                        }
                        case 2 -> {
                            int opcCadastro = 0;
                            while (opcCadastro != 7) {
                                program.menuCadastro();
                                opcCadastro = sc.nextInt();
                                switch (opcCadastro) {
                                    case 1 -> {
                                        System.out.println("!!!CADASTRO DE EMPRESA!!!");
                                        System.out.println("Informe o nome da empresa: ");
                                        nomeEmpresa = sc.next();
                                        System.out.println("Informe o CNPJ da empresa: ");
                                        cnpj = sc.next();
                                        empresa = new Empresa(nomeEmpresa, cnpj);
                                        while (empresa.validarCNPJ(cnpj) != true) {
                                            System.out.println("CNPJ inválido, insira um cnpj válido: ");
                                            cnpj = sc.next();
                                            empresa = new Empresa(nomeEmpresa, cnpj);
                                        }
                                        if (empresa.validarCNPJ(cnpj) == true) {
                                            listaEmpresas.add(empresa);
                                            System.out.println("Empresa cadastrada com sucesso !!!");

                                        }
                                        break;
                                    }
                                    case 2 -> {
                                        System.out.println("!!!CADASTRO DE DEPARTAMENTO!!!");
                                        System.out.println("Informe o nome do departamento: ");
                                        nomeDepartamento = sc.next();
                                        System.out.println("Informe o ID do departamento: ");
                                        id_departamento = sc.nextInt();
                                        System.out.println("Informe a qual empresa esse departamento pertecence: (Insira o número da empresa)");
                                        for (int i = 0; i != listaEmpresas.size(); i++) {
                                            System.out.println((i + 1) + "ª Empresa: " + empresa.getNomeEmpresa());
                                        }
                                        int numeroEmpresa = sc.nextInt();
                                        empresa = listaEmpresas.get(numeroEmpresa - 1);
                                        departamento = new Departamento(nomeDepartamento, id_departamento, empresa);
                                        empresa.addLista_departamentos(departamento);
                                        System.out.println("Departamento cadastrado com sucesso !!!");
                                        break;
                                    }
                                    case 3 -> {
                                        System.out.println("!!!CADASTRO DE FUNCIONÁRIO!!!");
                                        System.out.println("Informe o nome do funcionário: ");
                                        nomeFuncionario = sc.next();
                                        System.out.println("Informe o CPF do funcionário: ");
                                        cpf = sc.next();
                                        System.out.println("Crie um Login para o funcionário: ");
                                        usuarioFuncionario = sc.next();
                                        System.out.println("Crie uma senha para o funcionário: ");
                                        senhaFuncionario = sc.next();
                                        System.out.println("Informe o departamento de qual este funcionário faz parte: (Insira o número do departamento)");
                                        for (int i = 0; i != empresa.getLista_departamentos().size(); i++) {
                                            System.out.println((i + 1) + "º Departamento: " + departamento.getNomeDepartamento());
                                        }
                                        int numeroDepartamento = sc.nextInt();
                                        departamento = empresa.getLista_departamentos().get(numeroDepartamento - 1);
                                        System.out.println("Informe a classificação do funcionario: ");
                                        System.out.println("1 - Administrador");
                                        System.out.println("2 - Líder");
                                        System.out.println("3 - Funcionário");
                                        int tipofuncionario = sc.nextInt();
                                        if (tipofuncionario == 1) {
                                            classificacaoFuncionario = ClassificacaoFuncionario.ADMINISTRADOR;
                                        }
                                        if (tipofuncionario == 2) {
                                            classificacaoFuncionario = ClassificacaoFuncionario.LIDER;
                                        }
                                        if (tipofuncionario == 3) {
                                            classificacaoFuncionario = ClassificacaoFuncionario.FUNCIONARIO;
                                        }
                                        Funcionario funcionario = new Funcionario(nomeFuncionario, cpf, usuarioFuncionario, senhaFuncionario, departamento, classificacaoFuncionario);
                                        departamento.addLista_funcionarios(funcionario);
                                        System.out.println("Funcionário cadastrado com sucesso !!!");
                                        break;
                                    }
                                    case 4 -> {
                                        System.out.println("!!!CADASTRO DE PROJETO!!!");
                                        System.out.println("Informe o nome do projeto: ");
                                        nomeProjeto = sc.next();
                                        System.out.println("Adicione uma descrição ao projeto: ");
                                        descricaoProjeto = sc.next();
                                        System.out.println("Adicione uma data de início ao projeto: (dd/mm/aaaa)");
                                        dataInicioProjeto = sdf.parse(sc.next());
                                        System.out.println("Adicione uma data de fim ao projeto: (dd/mm/aaaa)");
                                        dataFimProjeto = sdf.parse(sc.next());
                                        System.out.println("Informe a qual Empresa esse projeto pertence: ");
                                        for (int i = 0; i != listaEmpresas.size(); i++) {
                                            System.out.println((i + 1) + "ª Empresa: " + empresa.getNomeEmpresa());
                                        }
                                        int numeroEmpresa = sc.nextInt();
                                        empresa = listaEmpresas.get(numeroEmpresa - 1);
                                        porcentagemProjeto = 0;
                                        projeto = new Projeto(nomeProjeto, descricaoProjeto, porcentagemProjeto, dataInicioProjeto, dataFimProjeto, empresa);
                                        empresa.addLista_projetos(projeto);
                                        System.out.println("Projeto cadastrado com sucesso !!!");
                                        break;
                                    }
                                    case 5 -> {
                                        System.out.println("!!!CADASTRO DE ATIVIDADE!!!");
                                        System.out.println("Informe nome da atividade: ");
                                        nomeAtividade = sc.next();
                                        System.out.println("Adicione uma descrição à atividade: ");
                                        descricaoAtividade = sc.next();
                                        System.out.println("Adicione uma data de início à atividade: (dd/mm/aaaa)");
                                        dataInicioAtividade = sdf.parse(sc.next());
                                        System.out.println("Adicione uma data de fim à atividade: (dd/mm/aaaa)");
                                        dataFimAtividade = sdf.parse(sc.next());
                                        porcentagemAtividade = 0;
                                        System.out.println("Informe a qual projeto a atividade pertence: ");
                                        for (int i = 0; i != empresa.getLista_projetos().size(); i++) {
                                            System.out.println((i + 1) + "º Projeto: " + projeto.getNomeProjeto());
                                        }
                                        int numeroProjeto = sc.nextInt();
                                        projeto = empresa.getLista_projetos().get(numeroProjeto - 1);
                                        atividade = new Atividade(nomeAtividade, descricaoAtividade, dataInicioAtividade, dataFimAtividade, porcentagemAtividade, projeto);
                                        projeto.addLista_atividades(atividade);
                                        System.out.println("Atividade cadastrada com sucesso");
                                        break;
                                    }
                                    case 6 -> {
                                        System.out.println("!!!CADASTRO DE AÇÃO!!!");
                                        System.out.println("Informe o nome da ação: ");
                                        nomeAcao = sc.next();
                                        System.out.println("Adicione uma data de início à ação: (dd/mm/aaaa)");
                                        dataInicioAcao = sdf.parse(sc.next());
                                        System.out.println("Adicione uma data de fim à ação: (dd/mm/aaaa)");
                                        dataFimAcao = sdf.parse(sc.next());
                                        System.out.println("Adicione uma descrição à ação: ");
                                        descricaoAcao = sc.next();
                                        System.out.println("Informe o nome do funcionário responsável pela ação: ");
                                        for (int i = 0; i != departamento.getLista_funcionarios().size(); i++) {
                                            System.out.println((i + 1) + "º Funcionário " + adm.getNomeFuncionario());
                                        }
                                        int numeroFuncionario = sc.nextInt();
                                        Funcionario funcionario = departamento.getLista_funcionarios().get(numeroFuncionario - 1);
                                        System.out.println("Informe a atividade à qual a ação faz parte: ");
                                        for (int i = 0; i != projeto.getLista_atividades().size(); i++) {
                                            System.out.println((i + 1) + "ª Atividade " + atividade.getNomeAtividade());
                                        }
                                        int numeroAtividade = sc.nextInt();
                                        atividade = projeto.getLista_atividades().get(numeroAtividade - 1);
                                        acao = new Acao(nomeAcao, dataInicioAcao, dataFimAcao, descricaoAcao, porcentagemAcao, funcionario, atividade);
                                        break;
                                    }
                                    case 7 -> {
                                        break;
                                    }
                                    default -> {
                                        System.out.println("Opção inválida. Tente novamente.");
                                    }
                                }
                            }
                            break;
                        }
                        case 3 -> {
                            // Opção 3
                            System.out.println("!!!FIM DO PROGRAMA!!!");
                            break;
                        }
                        default -> {
                            System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                }
            }
        }
    }
}
