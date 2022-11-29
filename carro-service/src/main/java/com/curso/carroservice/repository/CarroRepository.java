package com.curso.carroservice.repository;

import com.curso.carroservice.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByUserId(Long userId);
}
