package model;

public class ContaCorrente extends Conta {
    private static final double TAXA_SAQUE = 2.50;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public boolean sacar(double valor) {
        double valorTotal = valor + TAXA_SAQUE;

        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return false;
        }

        if (saldo >= valorTotal) {
            saldo -= valorTotal;
            historico.add("Saque de R$ " + String.format("%.2f", valor)
                    + " + taxa de R$ " + String.format("%.2f", TAXA_SAQUE));
            System.out.println("Saque realizado com sucesso. Taxa aplicada: R$ "
                    + String.format("%.2f", TAXA_SAQUE));
            return true;
        } else {
            System.out.println("Saldo insuficiente para saque + taxa.");
            return false;
        }
    }
}