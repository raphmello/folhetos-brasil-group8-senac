package com.senac.grupo8.folhetosbrasil.repository;

import com.senac.grupo8.folhetosbrasil.entity.Folheto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolhetoRepository extends JpaRepository<Folheto, Long> {
    @Query(value = "SELECT * FROM folheto f " +
            "WHERE " +
                "LOWER(f.estado) LIKE LOWER(:estado) " +
            "AND LOWER(f.cidade) LIKE LOWER(:cidade) " +
            "AND LOWER(f.bairro) LIKE LOWER(:bairro)", nativeQuery = true)
    List<Folheto> findAllByEstadoContainsAndCidadeContainsAndBairroContains(String estado, String cidade, String bairro);
}
