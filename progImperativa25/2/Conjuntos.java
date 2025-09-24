import java.util.Scanner;

public class Conjuntos {
    public static final int CAPACIDADE = 30;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] conjuntoA = new int[CAPACIDADE];
        int[] conjuntoB = new int[CAPACIDADE];
        int tamA = 0;
        int tamB = 0;

        int opcao;
        do {
            System.out.println("\nMENU:");
            System.out.println("1) Inserir 1 elemento no Conjunto A");
            System.out.println("2) Inserir 1 elemento no Conjunto B");
            System.out.println("3) Imprimir os Conjuntos A e B");
            System.out.println("4) Gerar e Imprimir a união de A e B");
            System.out.println("5) Gerar e Imprimir a interseção entre A e B");
            System.out.println("6) Gerar e Imprimir a diferença A - B");
            System.out.println("7) Gerar e Imprimir a diferença B - A");
            System.out.println("0) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    tamA = inserirElemento(conjuntoA, tamA);
                    break;
                case 2:
                    tamB = inserirElemento(conjuntoB, tamB);
                    break;
                case 3:
                    System.out.print("Conjunto A = ");
                    imprimir(conjuntoA, tamA);
                    System.out.print("Conjunto B = ");
                    imprimir(conjuntoB, tamB);
                    break;
                case 4:
                    int[] uniao = uniao(conjuntoA, tamA, conjuntoB, tamB);
                    System.out.print("União = ");
                    imprimir(uniao, tamanho(uniao));
                    break;
                case 5:
                    int[] inter = interseccao(conjuntoA, tamA, conjuntoB, tamB);
                    System.out.print("Interseção = ");
                    imprimir(inter, tamanho(inter));
                    break;
                case 6:
                    int[] difAB = diferenca(conjuntoA, tamA, conjuntoB, tamB);
                    System.out.print("A - B = ");
                    imprimir(difAB, tamanho(difAB));
                    break;
                case 7:
                    int[] difBA = diferenca(conjuntoB, tamB, conjuntoA, tamA);
                    System.out.print("B - A = ");
                    imprimir(difBA, tamanho(difBA));
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ---------- Funções auxiliares ----------

    public static int inserirElemento(int[] v, int tam) {
        if (tam >= v.length) {
            System.out.println("O conjunto está cheio!");
            return tam;
        }
        System.out.print("Digite o valor: ");
        int valor = input.nextInt();
        if (buscaSequencial(v, tam, valor) != -1) {
            System.out.println("Valor já existe no conjunto!");
            return tam;
        }
        v[tam] = valor;
        tam++;
        return tam;
    }

    public static int buscaSequencial(int[] v, int tam, int x) {
        for (int i = 0; i < tam; i++) {
            if (v[i] == x) return i;
        }
        return -1;
    }

    public static void imprimir(int[] v, int tam) {
        System.out.print("{");
        for (int i = 0; i < tam; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(v[i]);
        }
        System.out.println("}");
    }

    public static int[] uniao(int[] a, int tamA, int[] b, int tamB) {
        int[] resultado = new int[CAPACIDADE * 2];
        int tamRes = 0;

        for (int i = 0; i < tamA; i++) {
            resultado[tamRes++] = a[i];
        }
        for (int i = 0; i < tamB; i++) {
            if (buscaSequencial(resultado, tamRes, b[i]) == -1) {
                resultado[tamRes++] = b[i];
            }
        }
        return cortar(resultado, tamRes);
    }

    public static int[] interseccao(int[] a, int tamA, int[] b, int tamB) {
        int[] resultado = new int[Math.min(tamA, tamB)];
        int tamRes = 0;

        for (int i = 0; i < tamA; i++) {
            if (buscaSequencial(b, tamB, a[i]) != -1) {
                resultado[tamRes++] = a[i];
            }
        }
        return cortar(resultado, tamRes);
    }

    public static int[] diferenca(int[] a, int tamA, int[] b, int tamB) {
        int[] resultado = new int[tamA];
        int tamRes = 0;

        for (int i = 0; i < tamA; i++) {
            if (buscaSequencial(b, tamB, a[i]) == -1) {
                resultado[tamRes++] = a[i];
            }
        }
        return cortar(resultado, tamRes);
    }

   
    public static int[] cortar(int[] v, int tam) {
        int[] novo = new int[tam];
        for (int i = 0; i < tam; i++) {
            novo[i] = v[i];
        }
        return novo;
    }


    public static int tamanho(int[] v) {
        return v.length;
    }
}
