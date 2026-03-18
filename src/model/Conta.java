package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private static int SEQUENCIAL = 1001;

    protected int numeroConta;
    protected Cliente cliente;
    protected double saldo;
    protected List<String> historico;

    public Conta(Cliente cliente) {
        this.numeroConta = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
        historico.add("Conta criada com saldo inicial de R$ 0.00");
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            historico.add("Depósito de R$ " + String.format("%.2f", valor));
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return false;
        }

        if (saldo >= valor) {
            saldo -= valor;
            historico.add("Saque de R$ " + String.format("%.2f", valor));
            System.out.println("Saque realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }

    public boolean transferir(Conta destino, double valor) {
        if (destino == null) {
            System.out.println("Conta de destino inválida.");
            return false;
        }

        if (this.sacar(valor)) {
            destino.depositar(valor);
            historico.add("Transferência de R$ " + String.format("%.2f", valor)
                    + " para a conta " + destino.getNumeroConta());
            destino.historico.add("Transferência recebida de R$ " + String.format("%.2f", valor)
                    + " da conta " + this.getNumeroConta());
            System.out.println("Transferência realizada com sucesso.");
            return true;
        }

        return false;
    }

    public void exibirDados() {
        System.out.println("==================================");
        System.out.println("Tipo: " + this.getClass().getSimpleName());
        System.out.println("Conta: " + numeroConta);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Saldo: R$ " + String.format("%.2f", saldo));
        System.out.println("==================================");
    }

    public void exibirHistorico() {
        System.out.println("===== HISTÓRICO DA CONTA " + numeroConta + " =====");
        for (String item : historico) {
            System.out.println("- " + item);
        }
        System.out.println("======================================");
    }
}