
import java.io.FileWriter; // Para escrever em arquivos
import java.io.IOException; // Para capturar exceções ao manipular arquivos
import java.io.PrintWriter; // Para escrever no arquivo de texto
import java.util.InputMismatchException; // Para capturar exceções de tipo de entrada incorreto
import java.util.Locale; // Para garantir a manipulação correta de strings com acentuação (em alguns casos de idioma)
import java.util.Scanner; // Para ler a entrada do usuário
import java.util.SimpleTimeZone; // Essa classe não está sendo usada no código, então pode ser removida

public class CalculadoraApp {

    public static void main(String[] args) {
        // Criação do scanner para leitura de entradas do usuário
        Scanner scanner = new Scanner(System.in);

        // Declaração das variáveis para armazenar os números e a operação
        Double valorUm;
        Double valorDois;
        String operacao;
        boolean continuar; // Variável para controlar a repetição do loop de operações

        try {
            do {
                System.out.println("Digite o valor um: ");
                valorUm = scanner.nextDouble(); // Recebe o valor digitado pelo usuário e converte para double

                // Solicita a operação (soma, subtração, divisão ou multiplicação)
                System.out.println("Digite a operação:( +, -, /, *): ");
                operacao = scanner.next(); // Recebe a operação desejada como string

                System.out.println("Digite o valor dois: ");
                valorDois = scanner.nextDouble();

                System.out.println("Resultado: " + realizarCalculo(valorUm, valorDois, operacao));

                // Pergunta ao usuário se ele quer realizar outra operação
                continuar = verificarNovaOperacao();
            } while (continuar); // Repete o loop enquanto o usuário responder "S" (sim) para continuar

        } catch (InputMismatchException exception) {

            System.out.println("Os valors para calculo devem ser númericos =) ");
        }

    }

    // Método para perguntar se o usuário deseja realizar uma nova operação
    public static boolean verificarNovaOperacao() {
        Scanner sc = new Scanner(System.in); // Novo scanner para ler a resposta

        System.out.println("Deseja realizar uma nova operação ? (S ou N) ");

        return sc.nextLine().toUpperCase(Locale.ROOT).equals("S");
    }

    // Método para realizar o cálculo de acordo com a operação fornecida
    public static Double realizarCalculo(Double valorUm, Double valorDois, String operacao) {
        // Variável que armazenará o resultado do cálculo
        Double respostaCalculo = 0.0;

        // Switch para realizar o cálculo de acordo com a operação
        switch (operacao) {
            case "+":
                respostaCalculo = valorUm + valorDois;
                break;

            case "-":
                respostaCalculo = valorUm - valorDois;
                break;

            case "/":
                respostaCalculo = valorUm / valorDois;
                break;

            case "*":
                respostaCalculo = valorUm * valorDois;
                break;

            default:
                System.out.println("Operação é inválida ");
        }
        return respostaCalculo; // Retorna o resultado do cálculo
    }
    // Método para salvar o resultado da operação em um arquivo .txt
    public static void salvarResultadoEmArquivo(Double valorUm, Double valorDois, String operacao, Double resultado) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("resultado_calculo.txt", true))) {

            writer.printf("Operação: %.2f %s %.2f = %.2f\n", valorUm, operacao, valorDois, resultado);
            System.out.println("Resultado salvo no arquivo 'resultado_calculo.txt'.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o resultado no arquivo.");
            e.printStackTrace();
        }
    }
}
//Importação das classes necessárias:
//
//    import java.io.FileWriter; e import java.io.PrintWriter; são usados para escrever no arquivo.
//    import java.io.IOException; é necessário para capturar exceções relacionadas à manipulação de arquivos.
//
//Método salvarResultadoEmArquivo:
//
//    Este método é responsável por salvar o cálculo e o resultado em um arquivo chamado resultado_calculo.txt.
//    O arquivo é aberto em modo de append, ou seja, o novo conteúdo é adicionado ao final do arquivo, sem sobrescrever o conteúdo anterior.
//    A linha writer.printf(...) é usada para formatar a saída de forma legível, exibindo o cálculo e o resultado.
//
//Usando PrintWriter para salvar no arquivo:
//
//    A classe PrintWriter é usada junto com FileWriter para escrever no arquivo.
//    O try-with-resources é utilizado para garantir que o arquivo seja fechado corretamente após o uso.