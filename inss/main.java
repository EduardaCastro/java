package inss;
import java.util.Scanner;

public class main {
     public static void main(String[] args) {
        // Criar um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Pedir ao usuário o salário bruto
        System.out.print("Digite seu salário bruto: R$ ");
        double salarioBruto = scanner.nextDouble();

        // Definir o teto de contribuição
        double tetoContribuicao = 8400.00;

        // Variáveis para armazenar a contribuição
        double contribuicao = 0.0;

        // Verificar se o salário está acima do teto
        if (salarioBruto > tetoContribuicao) {
            salarioBruto = tetoContribuicao;
        }

        // Calcular a contribuição ao INSS com base nas faixas
        if (salarioBruto <= 1302.00) {
            contribuicao = salarioBruto * 0.075;
        } else if (salarioBruto <= 2571.29) {
            contribuicao = 1302.00 * 0.075 + (salarioBruto - 1302.00) * 0.09;
        } else if (salarioBruto <= 3856.94) {
            contribuicao = 1302.00 * 0.075 + (2571.29 - 1302.00) * 0.09 + (salarioBruto - 2571.29) * 0.12;
        } else {
            contribuicao = 1302.00 * 0.075 + (2571.29 - 1302.00) * 0.09 + (3856.94 - 2571.29) * 0.12 + (salarioBruto - 3856.94) * 0.14;
        }

        // Calcular o salário líquido
        double salarioLiquido = salarioBruto - contribuicao;

        // Exibir os resultados
        System.out.printf("Valor da contribuição ao INSS: R$ %.2f%n", contribuicao);
        System.out.printf("Salário líquido: R$ %.2f%n", salarioLiquido);

        // Fechar o scanner
        scanner.close();
    }
}

