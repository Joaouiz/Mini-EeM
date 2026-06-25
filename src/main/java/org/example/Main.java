package org.example;

import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mariadb://localhost:3306/automacao";

        String usuario = "root";
        String senha = "9998";

        List<Cliente> listaClientes = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Conectado!");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");

            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                double valor = rs.getDouble("valor");
                LocalDate vencimento = rs.getDate("vencimento").toLocalDate();
                /*
                Você pode usar o rs.getObject() passando a classe desejada como segundo parâmetro. Fica super limpo:
                // Busca direto do ResultSet já convertendo para LocalDate
                LocalDate data = rs.getObject("nome_da_coluna", LocalDate.class);
                 */
                String status = rs.getString("status");
                Cliente kpop = new Cliente(id, nome, telefone, valor, vencimento, status);
                listaClientes.add(kpop);
            }

            for(Cliente e : listaClientes){
                System.out.println("ID: " + e.getId() + " | Nome: " + e.getNome() + " | Vencimento: " + e.getVencimento() + " | Status: " + e.getStatus());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.writeValue(new File("clientes.json"), listaClientes);

            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listaClientes);

            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}