package impostoderenda ;
import java.util.Scanner;

public class main {
     public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Digite seu salário bruto: R$ ");
        double salarioBruto = scanner.nextDouble();

     
        double imposto = 0.0;
        double deducao = 0.0;

      
        if (salarioBruto <= 1903.98) {
            imposto = 0;
            deducao = 0;
        } else if (salarioBruto <= 2826.65) {
            imposto = salarioBruto * 0.075;
            deducao = 142.80;
        } else if (salarioBruto <= 3751.05) {
            imposto = salarioBruto * 0.15;
            deducao = 354.80;
        } else if (salarioBruto <= 4664.68) {
            imposto = salarioBruto * 0.225;
            deducao = 636.13;
        } else {
            imposto = salarioBruto * 1.275;
            deducao = 869.36;
        }

        double impostoDevido = imposto - deducao;

   
        System.out.printf("Valor do imposto de renda calculado: R$ %.2f%n", imposto);
        System.out.printf("Valor do imposto de renda a pagar: R$ %.2f%n", impostoDevido);

        scanner.close();
    }
}
