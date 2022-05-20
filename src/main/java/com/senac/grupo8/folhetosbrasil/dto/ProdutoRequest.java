package com.senac.grupo8.folhetosbrasil.dto;

import lombok.Data;

@Data
public class ProdutoRequest {
    private String nomeProduto;
    private Double valorCheio;
    private Double valorComDesconto;
}
