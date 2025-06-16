package academia.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlunoDAO alunoDAO = new AlunoDAO();
        TreinoDAO treinoDAO = new TreinoDAO();

        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Listar alunos.");
            System.out.println("2 - Editar informações do aluno.");
            System.out.println("3 - Excluir aluno do sistema.");
            System.out.println("4 - Buscar aluno por nome ou CPF.");
            System.out.println("5 - Cadastrar um novo aluno.");
            System.out.println("6 - Listar treinos de um aluno.");
            System.out.println("7 - Cadastrar treino de um aluno.");
            System.out.println("8 - Excluir treino de um aluno.");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    ArrayList<Aluno> lista = alunoDAO.listarTodos();
                    System.out.println("\n--- Lista de Alunos ---");
                    for (Aluno a : lista) {
                        System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome() + " | CPF: " + a.getCpf());
                    }
                }

                case 2 -> {
                    System.out.print("Informe o ID do aluno a ser editado: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();
                    System.out.print("Novo CPF: ");
                    String novoCpf = scanner.nextLine();
                    System.out.print("Nova data de nascimento (XX-XX-XXXXMM-DD): ");
                    String novaData = scanner.nextLine();
                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();

                    Aluno alunoAtualizado = new Aluno(idEditar, novoNome, novoEmail, novoCpf, novaData, novoTelefone);
                    if (alunoDAO.atualizar(alunoAtualizado)) {
                        System.out.println("Aluno atualizado com sucesso!");
                    } else {
                        System.out.println("Erro ao atualizar aluno.");
                    }
                }

                case 3 -> {
                    System.out.print("Informe o ID do aluno a ser excluído: ");
                    int idExcluir = scanner.nextInt();
                    scanner.nextLine();
                    if (alunoDAO.excluir(idExcluir)) {
                        System.out.println("Aluno excluído com sucesso!");
                    } else {
                        System.out.println("Erro ao excluir aluno.");
                    }
                }

                case 4 -> {
                    System.out.print("Digite o nome ou CPF para buscar: ");
                    String busca = scanner.nextLine().toLowerCase();
                    ArrayList<Aluno> alunosBuscados = alunoDAO.listarTodos();
                    boolean encontrado = false;

                    for (Aluno aluno : alunosBuscados) {
                        if (aluno.getNome().toLowerCase().contains(busca) || aluno.getCpf().equals(busca)) {
                            System.out.println("ID: " + aluno.getId() + " | Nome: " + aluno.getNome() + " | CPF: " + aluno.getCpf());
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Nenhum aluno encontrado.");
                    }
                }

                case 5 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Data de nascimento (YYYY-MM-DD): ");
                    String dataNascimento = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    Aluno novoAluno = new Aluno(nome, email, cpf, dataNascimento, telefone);
                    if (alunoDAO.inserir(novoAluno)) {
                        System.out.println("Aluno cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar aluno.");
                    }
                }

                case 6 -> {
                    System.out.print("Informe o ID do aluno para ver os treinos: ");
                    int idAlunoTreino = scanner.nextInt();
                    scanner.nextLine();
                    ArrayList<Treino> treinos = treinoDAO.listarPorAluno(idAlunoTreino);
                    System.out.println("\n--- Treinos do Aluno ---");
                    for (Treino t : treinos) {
                        System.out.println("ID: " + t.getId() + " | Tipo: " + t.getTipo() + " | Duração: " + t.getDuracao() + " min | Início: " + t.getDataInicio());
                    }
                }

                case 7 -> {
                    System.out.print("ID do aluno: ");
                    int idAluno = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Tipo de treino: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Duração (minutos): ");
                    int duracao = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Data de início (YYYY-MM-DD): ");
                    String dataInicio = scanner.nextLine();

                    Treino novoTreino = new Treino(idAluno, tipo, descricao, duracao, dataInicio);
                    if (treinoDAO.inserir(novoTreino)) {
                        System.out.println("Treino cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro ao cadastrar treino.");
                    }
                }

                case 8 -> {
                    System.out.print("ID do treino a excluir: ");
                    int idTreinoExcluir = scanner.nextInt();
                    scanner.nextLine();
                    if (treinoDAO.excluir(idTreinoExcluir)) {
                        System.out.println("Treino excluído com sucesso!");
                    } else {
                        System.out.println("Erro ao excluir treino.");
                    }
                }

                case 9 -> {
                    System.out.println("Encerrando o sistema.");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Opção inválida.");
            }
        }
    }
}