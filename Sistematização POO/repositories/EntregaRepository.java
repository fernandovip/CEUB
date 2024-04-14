package com.aula.entrega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aula.entrega.models.EntregaModel;

@Repository
public interface EntregaRepository extends JpaRepository<EntregaModel, Integer> {

}
