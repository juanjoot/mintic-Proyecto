package com.caffeapi.aplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caffeapi.aplication.entity.TipoDocumento;

@Repository
public interface DocumentosRepository extends JpaRepository<TipoDocumento, Integer>{

}
