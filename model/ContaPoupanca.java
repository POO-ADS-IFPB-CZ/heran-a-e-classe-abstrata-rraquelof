package model;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numero, String nome_titular, double saldo) {
        super(numero, nome_titular, saldo);
    }

    public void reajustar(double percentual){
        saldo = saldo + saldo * percentual;
    }

    @Override
    public void imprimirTipoConta(){
        System.out.println("Conta Poupança");
    }

}
