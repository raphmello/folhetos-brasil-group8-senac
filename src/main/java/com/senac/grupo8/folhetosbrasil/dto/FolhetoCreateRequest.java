package com.senac.grupo8.folhetosbrasil.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FolhetoCreateRequest {
    @NotBlank
    private String nomeEstabelecimento;
    @NotNull
    private LocalDate dataVigenciaInicial;
    @NotNull
    private LocalDate dataVigenciaFinal;
    @NotBlank
    @Length(max = 2, message = "Digite o estado com duas letras (SP, MG, RJ)")
    private String estado;
    @NotBlank
    private String cidade;
    @NotBlank
    private String bairro;
    private List<ProdutoRequest> produtos = new ArrayList<>();
}
