package com.besysoft.bootcamp.repository.database;

import com.besysoft.bootcamp.domain.Genero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGeneroRepository extends JpaRepository<Genero, Long> {
}
