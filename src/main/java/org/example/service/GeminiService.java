package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.Cliente;
import org.example.model.gemini.GeminiRequest;
import org.example.service.prompt.PromptBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeminiService {

    private final ObjectMapper mapper = new ObjectMapper();
    PromptBuilder promptBuilder = new PromptBuilder();
    private static final String apiKey = "MeuPauDeOculos";
    private final HttpClient client = HttpClient.newHttpClient();
    private static final String url = "https://jsonplaceholder.typicode.com/posts";

    public GeminiService(){
        mapper.registerModule(new JavaTimeModule());
    }

    public String gerarMensagem(Cliente cliente) throws IOException, InterruptedException {
        String prompt = promptBuilder.gerarPrompt(cliente);
        GeminiRequest requestGemini = new GeminiRequest(prompt);
        String jsonGemini = mapper.writeValueAsString(requestGemini);

        HttpRequest requestHttp = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonGemini))
                .build();

        HttpResponse<String> response = client.send(requestHttp, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        return response.body();
    }
}