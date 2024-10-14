import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class TaxaDeCambioService {
    private String apiKey;
    private String endereco;
    private Gson gson;



    // Construtor que inicializa a chave da API e o endereço da API
    public TaxaDeCambioService(String apiKey) {
        this.apiKey = apiKey;
        this.endereco = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";;
        this.gson = new Gson();
    }
    // Método para obter as taxas de câmbio da API
    public Map<String, Double> obterTaxasDeCambio() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        // Converte a resposta JSON em um mapa de taxas de câmbio
        Map<String, Object> rates = gson.fromJson(json, Map.class);
        return (Map<String, Double>) rates.get("conversion_rates");
    }
}
