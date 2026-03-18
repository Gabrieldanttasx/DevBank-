package model;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void aplicarRendimento() {
        double rendimento = saldo * 0.005; // 0,5%
        saldo += rendimento;
        historico.add("Rendimento aplicado de R$ " + String.format("%.2f", rendimento));
        System.out.println("Rendimento aplicado com sucesso.");
    }
}