package com.senac.grupo8.folhetosbrasil.service;

import com.senac.grupo8.folhetosbrasil.dto.AdicionarProdutosRequest;
import com.senac.grupo8.folhetosbrasil.dto.FolhetoCreateRequest;
import com.senac.grupo8.folhetosbrasil.dto.FolhetoResponse;
import com.senac.grupo8.folhetosbrasil.entity.Folheto;
import com.senac.grupo8.folhetosbrasil.entity.Produto;
import com.senac.grupo8.folhetosbrasil.repository.FolhetoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FolhetoService {

    private final FolhetoRepository repository;

    public FolhetoService(FolhetoRepository repository) {
        this.repository = repository;
    }

    public Folheto cadastrarNovoFolheto(FolhetoCreateRequest request) {
        Folheto folheto = new Folheto(request);
        return repository.save(folheto);
    }

    public List<Folheto> buscarTodosFolhetos() {
        return repository.findAll();
    }

    public Folheto buscarFolhetoPorId(Long id) {
        Optional<Folheto> optionalFolheto = repository.findById(id);
        if (optionalFolheto.isEmpty())
            throw new RuntimeException("Folheto não encontrado");
        return optionalFolheto.get();
    }

    public List<Folheto> buscarPorEstadoCidadeBairro(String estado, String cidade, String bairro) {
        estado = Objects.isNull(estado) ? "%" : "%" + estado + "%";
        cidade = Objects.isNull(cidade) ? "%" : "%" + cidade + "%";
        bairro = Objects.isNull(bairro) ? "%" : "%" + bairro + "%";
        return repository.findAllByEstadoContainsAndCidadeContainsAndBairroContains(estado, cidade, bairro);
    }

    public Folheto cadastrarProdutos(AdicionarProdutosRequest request) {
        Optional<Folheto> optionalFolheto = repository.findById(request.getIdFolheto());
        if(optionalFolheto.isEmpty())
            throw new RuntimeException("Folheto não encontrado");
        Folheto folheto = optionalFolheto.get();
        request.getProdutos().forEach(p -> {
            folheto.adicionarProduto(new Produto(p, folheto));
        });
        repository.save(folheto);
        return folheto;
    }
}
