package com.senac.grupo8.folhetosbrasil.dto;

import com.senac.grupo8.folhetosbrasil.entity.Produto;
import lombok.Data;

import java.util.List;

@Data
public class ProdutoResponse {
    private Long id;
    private String nomeProduto;
    private Double valorCheio;
    private Double valorComDesconto;

    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.nomeProduto = produto.getNomeProduto();
        this.valorCheio = produto.getValorCheio();
        this.valorComDesconto = produto.getValorComDesconto();
    }
}
