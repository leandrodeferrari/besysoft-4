package com.besysoft.bootcamp.repository.database;

import com.besysoft.bootcamp.domain.PeliculaSerie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaSerieRepository extends JpaRepository<PeliculaSerie, Long> {
}
