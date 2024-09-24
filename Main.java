package gerenciadortarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            
            do {
                System.out.println("=== Gerenciador de Tarefas ===");
                System.out.println("1. Adicionar Tarefa");
                System.out.println("2. Listar Tarefas");
                System.out.println("3. Marcar Tarefa como Concluida");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opcao: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Titulo da Tarefa: ");
                        String titulo = scanner.nextLine();
                        tarefas.add(new Tarefa(titulo));
                        System.out.println("Tarefa adicionada!\n");
                    }
                    case 2 -> {
                        System.out.println("=== Lista de Tarefas ===");
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println((i + 1) + ". " + tarefas.get(i));
                        }
                        System.out.println();
                    }
                    case 3 -> {
                        System.out.print("Numero da Tarefa a Marcar como Concluida: ");
                        int numeroTarefa = scanner.nextInt();
                        if (numeroTarefa > 0 && numeroTarefa <= tarefas.size()) {
                            tarefas.get(numeroTarefa - 1).setConcluida(true);
                            System.out.println("Tarefa marcada como concluida!\n");
                        } else {
                            System.out.println("Numero invalido!\n");
                        }
                    }
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opcao invalida. Tente novamente.\n");
                }
            } while (opcao != 0);
        }
    }
}

