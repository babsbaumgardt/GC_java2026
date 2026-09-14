package stardewManagerPOO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class stardewManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner pra ler as opcoes no terminal

        // lista usando polimorfismo pra guardar maes e filhotes juntos
        List<Animal> curral = new ArrayList<>();

        // criando e cadastrando os animais do slide
        curral.add(new VacaMae(101, "Mimosa", "Holandesa", 7, "Sem filhotes"));
        curral.add(new GalinhaMae(102, "Giselda", "Caipira", 1, "Botando ovos"));
        curral.add(new OvelhaMae(103, "Chiquinha", "Merino", 3, "Pronta para tosquia"));

        int opcao = 0; // guarda a escolha do usuario no menu

        // loop pra manter o menu rodando ate escolher a opcao 3
        while (opcao != 3) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Ver animais do curral");
            System.out.println("2. Comércio (Coletar/Retirar produtos)");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt(); // le o numero digitado

            if (opcao == 1) {
                System.out.println("\n--------------------------------------------------");
                System.out.println("  ANIMAIS NO CURRAL:");
                System.out.println("--------------------------------------------------");

                // passa por cada animal da lista mostrando as informacoes
                for (Animal a : curral) {
                    System.out.println("\n[ID: " + a.getId() + "] " + a.getNome() + " (" + a.getEspecie() + ")");
                    System.out.println(" - Raça: " + a.getRaca());
                    System.out.println(" - Idade: " + a.getIdade() + " anos | Status: " + a.getStatus());
                    System.out.print(" - Som: ");
                    a.emitirSom(); // polimorfismo rodando o som especifico de cada um
                }
                System.out.println("--------------------------------------------------");

            } else if (opcao == 2) {
                System.out.println("\n--------------------------------------------------");
                System.out.println("  COLETANDO PRODUTOS DOS ANIMAIS:");
                System.out.println("--------------------------------------------------");

                // coleta o produto especifico de cada animal
                for (Animal a : curral) {
                    System.out.println(a.getNome() + " (" + a.getEspecie() + ") -> Produto: " + a.coletarProduto());
                }
                System.out.println("--------------------------------------------------");

            } else if (opcao == 3) {
                System.out.println("\nSaindo do Stardew Manager... Até logo!");
            } else {
                System.out.println("\nOpção inválida, tente novamente!");
            }
        }

        scanner.close(); // fecha o scanner ao encerrar
    }
}