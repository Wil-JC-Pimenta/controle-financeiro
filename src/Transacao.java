import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Transacao {
    private String descricao;
    private double valor;

    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return descricao + ": R$" + valor;
    }
}
