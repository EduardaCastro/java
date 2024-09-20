package atividademarcio;
import java.util.Scanner;

    public class main {  
    public static void main ( String [] args) {
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[10];
        System.out.println("Digite 10 valores:");
        for (int i = 0; i < 10; i++) {
            valores[i] = scanner.nextInt();
        }
        boolean ordenado = true;
        for (int i = 0; i < valores.length - 1; i++) {
            if (valores[i] > valores[i + 1]) {
                ordenado = false;
                break;
            }
        }
        if (ordenado) {
            System.out.println("O vetor está ordenado.");
        } else {
            System.out.println("O vetor não está ordenado.");
        }
            String continuar;
        do {
            System.out.print("Digite um valor a ser encontrado: ");
            int valorBuscado = scanner.nextInt();
            int posicao = -1;

            // Buscar o valor no vetor
            for (int i = 0; i < valores.length; i++) {
                if (valores[i] == valorBuscado) {
                    posicao = i;
                    break;
                }
            }
            if (posicao != -1) {
           System.out.println("Valor " + valorBuscado + " encontrado na posição: " + posicao);
            } else {
           System.out.println("Valor " + valorBuscado + " não encontrado no vetor.");
            }

           System.out.print("Deseja continuar a busca? (sim ou não): ");
            continuar = scanner.next();
            } while (continuar.equalsIgnoreCase("s"));

        scanner.close();

    }
}
