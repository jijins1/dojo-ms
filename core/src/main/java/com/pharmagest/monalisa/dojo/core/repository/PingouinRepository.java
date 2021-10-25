package com.pharmagest.monalisa.dojo.core.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pharmagest.monalisa.dojo.core.entity.Pingouin;

public interface PingouinRepository extends CrudRepository<Pingouin, Long> {
    List<Pingouin> findAllByTaille(Long taille);
}
