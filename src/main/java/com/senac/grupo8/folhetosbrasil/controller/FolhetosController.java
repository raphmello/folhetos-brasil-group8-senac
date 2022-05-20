package com.senac.grupo8.folhetosbrasil.controller;

import com.senac.grupo8.folhetosbrasil.dto.*;
import com.senac.grupo8.folhetosbrasil.entity.Folheto;
import com.senac.grupo8.folhetosbrasil.service.FolhetoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/folhetos")
public class FolhetosController {

    private final FolhetoService folhetoService;

    public FolhetosController(FolhetoService folhetoService) {
        this.folhetoService = folhetoService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar folhetos pelo {id}")
    public FolhetoResponse buscarFolhetosPeloId(@PathVariable Long id) {
        Folheto folheto = folhetoService.buscarFolhetoPorId(id);
        return new FolhetoResponse(folheto);
    }

    @GetMapping
    @Operation(summary = "Buscar todos os folhetos cadastrados (somente id e nomeEstabelecimento)")
    public List<FolhetoSimplesResponse> buscarFolhetos() {
        List<Folheto> folhetos = folhetoService.buscarTodosFolhetos();
        List<FolhetoSimplesResponse> responseList = new ArrayList<>();
        folhetos.forEach(f -> {
            responseList.add(new FolhetoSimplesResponse(f));
        });
        return responseList;
    }

    @PostMapping("/procurar")
    @Operation(summary = "Buscar folhetos por Estado, Cidade e Bairro (somente id e nomeEstabelecimento)")
    public List<FolhetoSimplesResponse> buscarFolhetosComFiltro(@RequestBody FolhetosFiltoRequest request) {
        List<Folheto> folhetos = folhetoService.buscarPorEstadoCidadeBairro(request.getEstado(), request.getCidade(), request.getBairro());
        List<FolhetoSimplesResponse> responseList = new ArrayList<>();
        folhetos.forEach(f -> {
            responseList.add(new FolhetoSimplesResponse(f));
        });
        return responseList;
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastrar folheto")
    public FolhetoResponse cadastrarFolheto(@RequestBody @Valid FolhetoCreateRequest request) {
        Folheto entity = folhetoService.cadastrarNovoFolheto(request);
        return new FolhetoResponse(entity);
    }

    @PostMapping("/produtos/cadastrar")
    @Operation(summary = "Cadastrar produto ao folheto")
    public FolhetoResponse cadastrarProduto(@RequestBody @Valid AdicionarProdutosRequest request) {
        Folheto folheto = folhetoService.cadastrarProdutos(request);
        return new FolhetoResponse(folheto);
    }


}
