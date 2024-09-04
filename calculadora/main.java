package calculadora;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);

        // Pedir ao usuário o primeiro número
        System.out.print("Digite o primeiro número inteiro: ");
        int num1 = scanner.nextInt();

        // Pedir ao usuário o segundo número
        System.out.print("Digite o segundo número inteiro: ");
        int num2 = scanner.nextInt();

        // Calcular soma, subtração, multiplicação e divisão
        int soma = num1 + num2;
        int subtracao = num1 - num2;
        int multiplicacao = num1 * num2;
        
        // Mostrar os resultados
        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);
        
        // Verificar se o segundo número é zero antes de dividir
        if (num2 != 0) {
            double divisao = (double) num1 / num2;
            System.out.println("Divisão: " + divisao);
        } else {
            System.out.println("Divisão: Não é possível dividir por zero.");
        }

        // Fechar o scanner
        scanner.close();
    }
}