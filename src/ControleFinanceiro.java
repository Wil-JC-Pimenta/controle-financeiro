import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleFinanceiro {
    private List<Transacao> transacoes; // Lista para armazenar as transações
    private double saldo; // Saldo total

    public ControleFinanceiro() {
        this.transacoes = new ArrayList<>(); // Inicializa a lista de transações
        this.saldo = 0; // Inicializa o saldo como zero
    }

    public void adicionarTransacao(String descricao, double valor) {
        Transacao transacao = new Transacao(descricao, valor); // Cria uma nova transação
        transacoes.add(transacao); // Adiciona a transação à lista
        saldo += valor; // Atualiza o saldo com o valor da transação
        for (int i = 0; i < transacoes.size(); i++) {
            System.out.println("*** Índice da transação: " + i + " - " + transacoes.get(i)); // Exibe as transações com seus índices
        }

    }

    public void removerTransacao(int indice) {
        if (indice >= 0 && indice < transacoes.size()) { // Verifica se o índice é válido
            saldo -= transacoes.get(indice).getValor(); // Deduz o valor da transação removida do saldo
            transacoes.remove(indice); // Remove a transação da lista
        } else {
            System.out.println("Índice inválido");
        }
    }

    public void listarTransacoes() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação cadastrada");
        } else {
            for (int i = 0; i < transacoes.size(); i++) {
                System.out.println(i + " - " + transacoes.get(i)); // Exibe as transações com seus índices
            }
        }
    }

    public void mostrarSaldo() {
        System.out.println("Saldo atual: R$" + saldo); // Exibe o saldo atual
    }

    public static void main(String[] args) {
        ControleFinanceiro controle = new ControleFinanceiro(); // Cria uma instância do controle financeiro
        Scanner scanner = new Scanner(System.in); // Cria um scanner para entrada de dados

        while (true) {
            System.out.println("1 - Adicionar transação");
            System.out.println("2 - Remover transação");
            System.out.println("3 - Listar transações");
            System.out.println("4 - Ver saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt(); // Lê a opção escolhida pelo usuário
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Descrição da transação: ");
                    String descricao = scanner.nextLine(); // Lê a descrição da transação
                    System.out.print("Valor da transação: ");
                    double valor = scanner.nextDouble(); // Lê o valor da transação
                    controle.adicionarTransacao(descricao, valor); // Adiciona a transação
                    break;
                case 2:
                    System.out.print("Índice da transação a ser removida: ");
                    int indice = scanner.nextInt(); // Lê o índice da transação a ser removida
                    controle.removerTransacao(indice); // Remove a transação
                    break;
                case 3:
                    controle.listarTransacoes(); // Lista as transações
                    break;
                case 4:
                    controle.mostrarSaldo(); // Exibe o saldo
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close(); // Fecha o scanner
                    System.exit(0); // Sai do programa
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
