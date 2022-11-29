package com.curso.motoservice.repository;

import com.curso.motoservice.entities.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
    public List<Moto> findByUserId(Long userId);
}
