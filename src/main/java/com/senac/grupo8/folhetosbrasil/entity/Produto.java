package com.senac.grupo8.folhetosbrasil.entity;

import com.senac.grupo8.folhetosbrasil.dto.ProdutoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeProduto;
    private Double valorCheio;
    private Double valorComDesconto;

    @ManyToOne
    private Folheto folheto;

    public Produto(ProdutoRequest request, Folheto folheto) {
        this.nomeProduto = request.getNomeProduto();
        this.valorCheio = request.getValorCheio();
        this.valorComDesconto = request.getValorComDesconto();
        this.folheto = folheto;
    }
}
