package atvmarciofim;
import java.util.Scanner;
public class Main {
    public static final int QTD_ESTOQUE = 100; 
    public static final Scanner ler = new Scanner(System.in);
    public static void main(String[] args) {
        Produto[] produtos = new Produto[QTD_ESTOQUE];
        int tamProdutos = 0; 
        int opcao;
        do {
            System.out.println("\n\nMENU");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Filtrar por categoria");
            System.out.println("4 - Ordenar por nome"); // nao funciona
            System.out.println("5 - Remover produto");
            System.out.println("6 - Atualizar preço");
            System.out.println("7 - Listar subtotal de valor por estoque");
            System.out.println("8 - Sair");
            System.out.print("Digite a sua opção: ");
            opcao = ler.nextInt();
            ler.nextLine();
            switch (opcao) {
                case 1:
                    tamProdutos = cadastrarProduto(produtos, tamProdutos);
                    break;
                case 2:
                    listarProdutos(produtos, tamProdutos);
                    break;
                case 3:
                    filtrarPorCategoria(produtos, tamProdutos);
                    break;
                case 4:
                    ordenarPorNome(produtos, tamProdutos);
                    break;
                case 5:
                    tamProdutos = removerProduto(produtos, tamProdutos);
                    break;
                case 6:
                    atualizarPreco(produtos, tamProdutos);
                    break;
                case 7:
                    listarSubtotalPorEstoque(produtos, tamProdutos);
                    break;
                case 8:
                    System.out.println("\n\nEncerrando o programa!");
                    break;
                default:
                    System.out.println("\n\nOpção inválida!");
                    break;
            }
        } while (opcao != 8);
    }
    public static int cadastrarProduto(Produto[] produtos, int tam) {
        if (tam == produtos.length) {
            System.out.println("\n\nEstoque cheio! Não é possível adicionar mais produtos.");
            return tam;
        }
        System.out.println("\n\nEntre com as informações do produto " + (tam + 1));
        produtos[tam] = lerProduto();
        return tam + 1;
    }
    public static void listarProdutos(Produto[] produtos, int tam) {
        if (tam == 0) {
            System.out.println("\n\nO estoque está vazio.");
            return;
        }
        System.out.println("\n\nListagem de Produtos:");
        for (int i = 0; i < tam; ++i) {
            System.out.println(produtos[i]);
        }
    }
    public static Produto lerProduto() {
        System.out.print("Digite o nome: ");
        String nome = ler.nextLine();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = ler.nextInt();
        ler.nextLine();
        System.out.print("Digite o preço: ");
        double preco = ler.nextDouble();
        ler.nextLine();
        System.out.print("Digite a categoria: ");
        String categoria = ler.nextLine();
        return new Produto(nome, quantidade, preco, categoria)
        ;
    }
    public static void filtrarPorCategoria(Produto[] produtos, int tam) {
        System.out.print("Digite a categoria para filtrar: ");
        String categoria = ler.nextLine();
        System.out.println("\nProdutos na categoria '" + categoria + "':");
        for (int i = 0; i < tam; ++i) {
            if (produtos[i].getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(produtos[i]);
            }
        }
    }
    public static void ordenarPorNome(Produto[] produtos, int tam) {
        for (int i = 0; i < tam - 1; ++i) {
            for (int j = 0; j < tam - 1 - i; ++j) {
                if (produtos[j].getNome().compareToIgnoreCase(produtos[j + 1].getNome()) > 0) {
                    Produto temp = produtos[j];
                    produtos[j] = produtos[j + 1];
                    produtos[j + 1] = temp;
                }
            }
        }
        System.out.println("\nProdutos ordenados por nome.");
    }
    public static int removerProduto(Produto[] produtos, int tam) {
        System.out.print("Digite o nome do produto a ser removido: ");
        String nome = ler.nextLine();
        for (int i = 0; i < tam; ++i) {
            if (produtos[i].getNome().equalsIgnoreCase(nome)) {
                for (int j = i; j < tam - 1; ++j) {
                    produtos[j] = produtos[j + 1];
                }
                produtos[tam - 1] = null;
                System.out.println("Produto removido com sucesso.");
                return tam - 1;
            }
        }
        System.out.println("Produto não encontrado.");
        return tam;
    }
    public static void atualizarPreco(Produto[] produtos, int tam) {
        System.out.print("Digite o nome do produto para atualizar o preço: ");
        String nome = ler.nextLine();
        for (int i = 0; i < tam; ++i) {
            if (produtos[i].getNome().equalsIgnoreCase(nome)) {
                System.out.print("Digite o novo preço: ");
                double novoPreco = ler.nextDouble();
                ler.nextLine();
                produtos[i].setPreco(novoPreco);
                System.out.println("Preço atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
    public static void listarSubtotalPorEstoque(Produto[] produtos, int tam) {
        double subtotal = 0;
        for (int i = 0; i < tam; ++i) {
            subtotal += produtos[i].getPreco() * produtos[i].getQuantidade();
        }
        System.out.println("\nSubtotal do valor do estoque: R$ " + subtotal);
    }
}