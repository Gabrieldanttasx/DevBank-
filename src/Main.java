import model.Conta;
import model.ContaPoupanca;
import service.Banco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        int opcao;

        do {
            System.out.println("\n========== DEVBANK ==========");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Ver saldo/dados");
            System.out.println("6 - Ver histórico");
            System.out.println("7 - Aplicar rendimento (poupança)");
            System.out.println("8 - Listar contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF do cliente: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Tipo de conta:");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupança");
                    System.out.print("Escolha: ");
                    int tipo = scanner.nextInt();

                    banco.criarConta(nome, cpf, tipo);
                    break;

                case 2:
                    System.out.print("Número da conta: ");
                    int contaDeposito = scanner.nextInt();

                    Conta contaD = banco.buscarConta(contaDeposito);
                    if (contaD != null) {
                        System.out.print("Valor do depósito: R$ ");
                        double valor = scanner.nextDouble();
                        contaD.depositar(valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta: ");
                    int contaSaque = scanner.nextInt();

                    Conta contaS = banco.buscarConta(contaSaque);
                    if (contaS != null) {
                        System.out.print("Valor do saque: R$ ");
                        double valor = scanner.nextDouble();
                        contaS.sacar(valor);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Conta de origem: ");
                    int origem = scanner.nextInt();

                    System.out.print("Conta de destino: ");
                    int destino = scanner.nextInt();

                    Conta contaOrigem = banco.buscarConta(origem);
                    Conta contaDestino = banco.buscarConta(destino);

                    if (contaOrigem != null && contaDestino != null) {
                        System.out.print("Valor da transferência: R$ ");
                        double valor = scanner.nextDouble();
                        contaOrigem.transferir(contaDestino, valor);
                    } else {
                        System.out.println("Conta de origem ou destino não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Número da conta: ");
                    int contaConsulta = scanner.nextInt();

                    Conta contaC = banco.buscarConta(contaConsulta);
                    if (contaC != null) {
                        contaC.exibirDados();
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 6:
                    System.out.print("Número da conta: ");
                    int contaHistorico = scanner.nextInt();

                    Conta contaH = banco.buscarConta(contaHistorico);
                    if (contaH != null) {
                        contaH.exibirHistorico();
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 7:
                    System.out.print("Número da conta poupança: ");
                    int contaPoup = scanner.nextInt();

                    Conta contaP = banco.buscarConta(contaPoup);
                    if (contaP != null) {
                        if (contaP instanceof ContaPoupanca) {
                            ((ContaPoupanca) contaP).aplicarRendimento();
                        } else {
                            System.out.println("Essa conta não é poupança.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 8:
                    banco.listarContas();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}