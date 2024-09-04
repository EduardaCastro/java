 package numeros;
import java.util.Scanner;

public class main {
    
 public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número inteiro: ");
        int num1 = scanner.nextInt();

        // Pedir ao usuário o segundo número
        System.out.print("Digite o segundo número inteiro: ");
        int num2 = scanner.nextInt();

        // Determinar o menor e o maior número para definir o intervalo
        int menor = Math.min(num1, num2);
        int maior = Math.max(num1, num2);

        // Exibir números pares
        System.out.println("Números pares entre " + menor + " e " + maior + ":");
        for (int i = menor; i <= maior; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        // Exibir números ímpares
        System.out.println("Números ímpares entre " + menor + " e " + maior + ":");
        for (int i = menor; i <= maior; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }

        // Fechar o scanner
        scanner.close();
    }
}
