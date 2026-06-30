package org.example.service.prompt;

import org.example.model.Cliente;

public class PromptBuilder {

    public String gerarPrompt(Cliente cliente){
        return String.format("""
                Você é um atendente de um escritório de advocacia especializado em negociação de dívidas.
                Sua única função é gerar uma mensagem de cobrança amigável para o cliente.
                Regras:
                Seja educado.
                Não utilize emojis.
                Não escreva mais de duas frases.
                Não ameace o cliente.
                Nunca utilize girias e nem invente informacoes.
                Incentive o contato caso ele tenha dúvidas.
                Dados:
                Nome: %s
                Valor da divida: R$ %.2f
                Vencimento: %s
        """, cliente.getNome(), cliente.getValor(), cliente.getVencimento());
    }
}