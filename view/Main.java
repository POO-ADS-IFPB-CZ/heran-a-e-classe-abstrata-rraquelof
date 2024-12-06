package view;

import model.Conta;
import model.ContaPoupanca;
import model.ContaEspecial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();

        while (true) {
            System.out.println("---MENU---");
            System.out.println("1 - Criar nova conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Escolha o tipo de conta:");
                System.out.println("1 - Conta Comum");
                System.out.println("2 - Conta Especial");
                System.out.println("3 - Conta Poupança");
                System.out.print("Opção: ");
                int tipoConta = scanner.nextInt();

                System.out.print("Digite o número da conta: ");
                int numero = scanner.nextInt();
                scanner.nextLine(); // Consumir o \n
                System.out.print("Digite o nome do titular: ");
                String nomeTitular = scanner.nextLine();
                System.out.print("Digite o saldo inicial: ");
                double saldo = scanner.nextDouble();

                Conta novaConta;
                if (tipoConta == 1) {
                    novaConta = new Conta(numero, nomeTitular, saldo);
                } else if (tipoConta == 2) {
                    System.out.print("Digite o limite da conta especial: ");
                    double limite = scanner.nextDouble();
                    novaConta = new ContaEspecial(numero, nomeTitular, saldo, limite);
                } else if (tipoConta == 3) {
                    novaConta = new ContaPoupanca(numero, nomeTitular, saldo);
                } else {
                    System.out.println("Tipo de conta inválido!");
                    continue;
                }
                contas.add(novaConta);
                System.out.println("Conta criada!");

            } else if (opcao == 2) {
                if (contas.isEmpty()) {
                    System.out.println("Não há contas cadastradas!");
                } else {
                    for (Conta conta : contas) {
                        System.out.println("Número: " + conta.getNumero());
                        System.out.println("Titular: " + conta.getNome_titular());
                        System.out.println("Saldo: " + conta.getSaldo());
                        System.out.print("Tipo: ");
                        conta.imprimirTipoConta();
                        System.out.println("--------------");
                    }
                }

            } else if (opcao == 3) { // Depositar
                System.out.print("Digite o número da conta: ");
                int numero = scanner.nextInt();
                Conta conta = Conta.encontrarConta(contas, numero);

                if (conta != null) {
                    System.out.print("Digite o valor para depósito: ");
                    double valor = scanner.nextDouble();
                    conta.depositar(valor);
                    System.out.println("Depósito realizado com sucesso!");
                } else {
                    System.out.println("Conta não encontrada!");
                }

            } else if (opcao == 4) { // Sacar
                System.out.print("Digite o número da conta: ");
                int numero = scanner.nextInt();
                Conta conta = Conta.encontrarConta(contas, numero);

                if (conta != null) {
                    System.out.print("Digite o valor para saque: ");
                    double valor = scanner.nextDouble();
                    if (conta.sacar(valor)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente ou limite excedido!");
                    }
                } else {
                    System.out.println("Conta não encontrada!");
                }

            } else if (opcao == 5) {
                System.out.println("Saindo...");
                break;

            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
