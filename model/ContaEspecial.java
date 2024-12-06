package model;

public class ContaEspecial extends Conta{
    private double limite;

    public ContaEspecial(int numero, String nome_titular, double saldo, double limite) {
        super(numero, nome_titular, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void imprimirTipoConta(){
        System.out.println("Conta Especial");
    }

    @Override
    public boolean sacar(double valor){
        if (valor <= this.limite + this.saldo){
            this.saldo -= valor;
            return true;
        }else{
            return false;
        }
    }
}
