package com.senac.grupo8.folhetosbrasil.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class AdicionarProdutosRequest {
    @NotNull
    @Min(1)
    private Long idFolheto;
    @NotNull
    List<ProdutoRequest> produtos = new ArrayList<>();
}
