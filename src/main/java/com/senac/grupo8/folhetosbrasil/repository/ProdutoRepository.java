package com.senac.grupo8.folhetosbrasil.repository;

import com.senac.grupo8.folhetosbrasil.entity.Folheto;
import com.senac.grupo8.folhetosbrasil.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
