package calculoimc;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

        // Pedir ao usuário o peso
        System.out.print("Digite seu peso em kg: ");
        double peso = scanner.nextDouble();

        // Pedir ao usuário a altura
        System.out.print("Digite sua altura em metros: ");
        double altura = scanner.nextDouble();

        // Calcular o IMC
        double imc = peso / (altura * altura);

    
        System.out.printf("Seu IMC é: %.2f%n", imc);

        // Classificar o IMC e exibir a avaliação
        if (imc < 18.5) {
            System.out.println("Classificação: Abaixo do peso");
        } else if (imc >= 18.5 && imc < 24.9) {
            System.out.println("Classificação: Peso normal");
        } else if (imc >= 25 && imc < 29.9) {
            System.out.println("Classificação: Sobrepeso");
        } else {
            System.out.println("Classificação: Obesidade");
        }

        // Fechar o scanner
        scanner.close();
    }
}
