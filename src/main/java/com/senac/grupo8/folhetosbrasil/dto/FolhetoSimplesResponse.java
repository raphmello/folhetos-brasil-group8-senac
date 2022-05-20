package com.senac.grupo8.folhetosbrasil.dto;

import com.senac.grupo8.folhetosbrasil.entity.Folheto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FolhetoSimplesResponse {
    private Long id;
    private String nomeEstabelecimento;

    public FolhetoSimplesResponse(Folheto folheto) {
        this.id = folheto.getId();
        this.nomeEstabelecimento = folheto.getNomeEstabelecimento();
    }
}
