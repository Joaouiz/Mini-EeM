package org.example.repository;

import org.example.model.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    String url = "jdbc:mariadb://localhost:3306/automacao";

    String usuario = "root";
    String senha = "9998";

    public List<Cliente> buscarClientes(){
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
                String status = rs.getString("status");

                Cliente kpop = new Cliente(id, nome, telefone, valor, vencimento, status);
                listaClientes.add(kpop);
            }

            /*for(Cliente e : listaClientes){
                System.out.println("ID: " + e.getId() + " | Nome: " + e.getNome() + " | Vencimento: " + e.getVencimento() + " | Status: " + e.getStatus());
            }*/


        } catch (Exception e) {
            e.printStackTrace();

        }

        return listaClientes;
    }

}