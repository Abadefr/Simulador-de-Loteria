import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class SimuladorDeLoteria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> numerosEscolhidos = new HashSet<>();
        Random random = new Random();

        // Solicitar ao usuário que escolha seus números
        System.out.println("Escolha 6 números de 1 a 60:");

        while (numerosEscolhidos.size() < 6) {
            System.out.print("Digite um número: ");
            int numero = scanner.nextInt();

            // Validar se o número está dentro do intervalo
            if (numero < 1 || numero > 60) {
                System.out.println("Número inválido! Escolha um número entre 1 e 60.");
            } else {
                numerosEscolhidos.add(numero);
            }
        }

        // Sortear 6 números aleatórios
        Set<Integer> numerosSorteados = new HashSet<>();
        while (numerosSorteados.size() < 6) {
            int numeroSorteado = random.nextInt(60) + 1; // Gera número entre 1 e 60
            numerosSorteados.add(numeroSorteado);
        }

        // Mostrar os números sorteados
        System.out.println("Números sorteados: " + numerosSorteados);

        // Comparar os números escolhidos com os sorteados
        numerosEscolhidos.retainAll(numerosSorteados); // Mantém apenas os números que estão em ambos os conjuntos

        // Mostrar resultados
        System.out.println("Você acertou " + numerosEscolhidos.size() + " números!");
        if (!numerosEscolhidos.isEmpty()) {
            System.out.println("Números acertados: " + numerosEscolhidos);
        } else {
            System.out.println("Você não acertou nenhum número.");
        }

        scanner.close();
    }
}
