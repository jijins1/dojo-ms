package com.pharmagest.monalisa.dojo.core.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.pharmagest.monalisa.dojo.core.entity.Pingouin;

public interface PingouinService {
    
    @Transactional(readOnly = true)
    @Cacheable("pingouin")
    Pingouin updatePingoun(Long idPingouin);
    
    /**
     * Recherche tout les pingouins avec la meme taille que le pingouin avec l'ID pingouinId
     * @param pingouinId
     * @return
     * @throws RuntimeException si aucun pingouin avec l'id pingouinId
     */
    List<Pingouin> findAllPingouinWithSameSizeHasPingouin(Long pingouinId );
    
    /**
     * Recherche avec l'ID pingouinId
     * @param idPingouin
     * @return
     * @throws RuntimeException si aucun pingouin avec l'id pingouinId
     */
    Pingouin findById(Long idPingouin);
    
}
