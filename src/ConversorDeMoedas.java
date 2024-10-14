import java.util.Map;

public class ConversorDeMoedas {

        private Map<String, Double> taxasDeCambio;

        //Construtor que recebe as taxas de cambio
        public ConversorDeMoedas(Map<String, Double> taxasDeCambio) {
            this.taxasDeCambio = taxasDeCambio;
        }

        //metodo para converter o valor de uma moeda para outra
        public double converter(String moedaOrigem, String moedaDestino, double valor) {
            double taxaDeCambio;

            if (moedaOrigem.equals("USD")) {
                // Se a moeda de origem for USD, usa a taxa de câmbio diretamente
                taxaDeCambio = taxasDeCambio.get(moedaDestino);
            } else {
                // Caso contrário, calcula a taxa de câmbio relativa ao USD
                double taxaOrigemParaUSD = taxasDeCambio.get(moedaOrigem);
                double taxaUSParaDestino = taxasDeCambio.get(moedaDestino);
                taxaDeCambio = taxaUSParaDestino / taxaOrigemParaUSD;
            }
            // Retorna o valor convertido
            return valor * taxaDeCambio;
        }

}
