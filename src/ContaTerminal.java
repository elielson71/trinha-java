import java.util.ArrayList;
import java.util.Scanner;
public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> result = entrada(scanner);
        String cliente = result.get(0);
        String agencia = result.get(1); 
        int numero = Integer.parseInt(result.get(2));
        double saldo = Double.parseDouble(result.get(3));

        if(validar(agencia, numero, saldo)){
            retorno(cliente, agencia, numero, saldo);
        }


    }

    private static ArrayList<String> entrada(Scanner scanner) {
        System.out.println("Digite o numero da conta:");
        String numeroStr = scanner.nextLine();
        int numero = Integer.parseInt(numeroStr);
        System.out.println("Por favor, digite o número da Agência !");
        String agencia = scanner.nextLine();
        System.out.println("Por favor, digite o Nome do cliente!");
        String cliente = scanner.nextLine();
        System.out.println("Digite o saldo:");
        String saldoStr = scanner.nextLine();
        double saldo = Double.parseDouble(saldoStr);

        ArrayList<String> result = new ArrayList<>();
        result.add(cliente);
        result.add(agencia);
        result.add(String.valueOf(numero));
        result.add(String.valueOf(saldo));
        return result;
    }

    private static void retorno(String cliente, String agencia, int numero, double saldo) {
        System.out.println("Olá "+ cliente +", obrigado por criar uma conta em nosso banco, sua agência é "+ agencia +", conta "+numero+" e seu saldo "+saldo+" já está disponível para saque");
    }

    private static boolean validar(String agencia, int numero, double saldo) {
        if (agencia == null || agencia.isEmpty() || agencia.length() < 4 || agencia.length() > 5) {
            System.out.println("Agência inválida!");
            return false;
        }
        if (numero <= 0 || String.valueOf(numero).length() != 4) {
            System.out.println("Número da conta inválido!");
            return false;
        }
        if (saldo < 0) {
            System.out.println("Saldo inválido!");
            return false;
        }
        return true;
    }
}
