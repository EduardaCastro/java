package fatorial;
import java.util.Scanner;

public class main {   
public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

        // Solicitar ao usuário que insira um número inteiro positivo
        System.out.print("Digite um número inteiro positivo: ");
        int numero = scanner.nextInt();

        // Verificar se o número é positivo
        if (numero < 0) {
            System.out.println("Por favor, digite um número inteiro positivo.");
        } else {
            // Inicializar o resultado do fatorial como 1
            long fatorial = 1;

            // Calcular o fatorial usando um loop while
            int contador = numero;
            while (contador > 0) {
                fatorial *= contador;
                contador--;
            }

            // Exibir o resultado
            System.out.println("O fatorial de " + numero + " é " + fatorial + ".");
        }

        scanner.close();
    }
}
