package service;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        contas = new ArrayList<>();
    }

    public void criarConta(String nome, String cpf, int tipoConta) {
        Cliente cliente = new Cliente(nome, cpf);
        Conta conta;

        if (tipoConta == 1) {
            conta = new ContaCorrente(cliente);
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca(cliente);
        } else {
            System.out.println("Tipo de conta inválido.");
            return;
        }

        contas.add(conta);
        System.out.println("Conta criada com sucesso.");
        conta.exibirDados();
    }

    public Conta buscarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        System.out.println("===== CONTAS CADASTRADAS =====");
        for (Conta conta : contas) {
            conta.exibirDados();
        }
    }
}