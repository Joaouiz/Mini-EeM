package org.example;

import java.io.IOException;
import java.util.List;

import org.example.model.Cliente;
import org.example.repository.ClientRepository;
import org.example.service.GeminiService;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ClientRepository repository = new ClientRepository();
        List<Cliente> clientes = repository.buscarClientes();
        GeminiService api = new GeminiService();

        System.out.println(api.gerarMensagem(clientes.get(0)));
    }
}