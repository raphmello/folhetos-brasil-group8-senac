package com.senac.grupo8.folhetosbrasil.dto;

import com.senac.grupo8.folhetosbrasil.entity.Folheto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FolhetoResponse {
    private Long id;
    private String nomeEstabelecimento;
    private LocalDate dataVigenciaInicial;
    private LocalDate dataVigenciaFinal;
    private String estado;
    private String cidade;
    private String bairro;
    private List<ProdutoResponse> produtos;

    public FolhetoResponse(Folheto folheto) {
        this.id = folheto.getId();
        this.nomeEstabelecimento = folheto.getNomeEstabelecimento();
        this.dataVigenciaInicial = folheto.getDataVigenciaInicial();
        this.dataVigenciaFinal = folheto.getDataVigenciaFinal();
        this.estado = folheto.getEstado();
        this.cidade = folheto.getCidade();
        this.bairro = folheto.getBairro();
        this.produtos = new ArrayList<>();
        folheto.getProdutos().forEach(p -> {
            produtos.add(new ProdutoResponse(p));
        });
    }
}
