package com.pharmagest.monalisa.dojo.core.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.pharmagest.monalisa.dojo.core.entity.Pingouin;

public interface PingouinService {
    
    /**
     * Recherche tout les pingouins avec la meme taille que le pingouin avec l'ID pingouinId
     * @param pingouinId
     * @param taille
     * @return
     * @throws RuntimeException si aucun pingouin avec l'id pingouinId
     */
    List<Pingouin> findAllPingouinWithSameSizeHasPingouin(Long pingouinId, Long taille);
}
