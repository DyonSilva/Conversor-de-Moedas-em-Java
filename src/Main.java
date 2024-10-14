import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String apiKey = "e31d12554647211d50d1aac8";
        TaxaDeCambioService taxaDeCambioService = new TaxaDeCambioService(apiKey);

        Map<String, Double> taxasDeCambio = taxaDeCambioService.obterTaxasDeCambio();
        ConversorDeMoedas conversor = new ConversorDeMoedas(taxasDeCambio);

        int selecao = 0;
        Scanner leitura = new Scanner(System.in);

        while (selecao != 7) {
            // Exibe o menu de opções para o usuário
            System.out.println("Conversor de Moedas");
            System.out.println("1) Dolar => Real");
            System.out.println("2) Real => Dolar");
            System.out.println("3) Dolar => Euro");
            System.out.println("4) Euro => Dolar");
            System.out.println("5) Dolar => Peso Argentino");
            System.out.println("6) Peso Argentino => Dolar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida");
            selecao = leitura.nextInt();

            String moedaOrigem = "";
            String moedaDestino = "";

            // Define as moedas de origem e destino com base na seleção do usuário
            switch (selecao) {
                case 1:
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    System.out.println("Dolar Americano (USD) para Real Brasileiro (BRL)");
                    break;
                case 2:
                    moedaOrigem = "BRL";
                    moedaDestino = "USD";
                    System.out.println("Real Brasileiro (BRL) para Dolar Americano (USD)");
                    break;
                case 3:
                    moedaOrigem = "USD";
                    moedaDestino = "EUR";
                    System.out.println("Dolar Americano (USD) para EURO (EUR)");
                    break;
                case 4:
                    moedaOrigem = "EUR";
                    moedaDestino = "USD";
                    System.out.println("Euro (EUR) para Dolar Americano (USD)");
                    break;
                case 5:
                    moedaOrigem = "USD";
                    moedaDestino = "ARS";
                    System.out.println("Dolar Americano (USD) para Peso Argentino (ARS)");
                    break;
                case 6:
                    moedaOrigem = "ARS";
                    moedaDestino = "USD";
                    System.out.println("Peso Argentino (ARS para) Dolar Americano (USD)");
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    continue;
            }

            // Solicita ao usuário o valor a ser convertido
            System.out.println("Digite o valor para ser convertido: ");
            double valor = leitura.nextDouble();

            // Realiza a conversão usando o conversor de moedas
            double valorConvertido = conversor.converter(moedaOrigem, moedaDestino, valor);

            // Exibe o valor convertido
            System.out.println("Valor convertido: " + String.format("%.2f", valorConvertido) + " " + moedaDestino);
        }
    }

}
