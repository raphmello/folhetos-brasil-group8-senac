package com.senac.grupo8.folhetosbrasil.entity;

import com.senac.grupo8.folhetosbrasil.dto.FolhetoCreateRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Folheto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeEstabelecimento;
    private LocalDate dataVigenciaInicial;
    private LocalDate dataVigenciaFinal;
    private String estado;
    private String cidade;
    private String bairro;

    @OneToMany(mappedBy = "folheto", cascade = CascadeType.ALL)
    private List<Produto> produtos = new ArrayList<>();

    public Folheto(FolhetoCreateRequest request) {
         this.nomeEstabelecimento = request.getNomeEstabelecimento();
         this.dataVigenciaInicial = request.getDataVigenciaInicial();
         this.dataVigenciaFinal = request.getDataVigenciaFinal();
         this.estado = request.getEstado();
         this.cidade = request.getCidade();
         this.bairro = request.getBairro();
         this.produtos = new ArrayList<>();
        if(!request.getProdutos().isEmpty()) {
            request.getProdutos().forEach(p -> {
                this.produtos.add(new Produto(p, this));
            });
        }
    }

    public void adicionarProduto(Produto produto) {
        if (Objects.isNull(this.produtos))
            this.produtos = new ArrayList<>();
        this.produtos.add(produto);
    }
}
