package com.besysoft.bootcamp.repository.database;

import com.besysoft.bootcamp.domain.Personaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonajeRepository extends JpaRepository<Personaje, Long> {
}
