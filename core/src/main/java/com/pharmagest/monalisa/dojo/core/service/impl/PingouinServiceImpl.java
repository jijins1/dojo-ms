package com.pharmagest.monalisa.dojo.core.service.impl;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmagest.monalisa.dojo.core.entity.Pingouin;
import com.pharmagest.monalisa.dojo.core.repository.PingouinRepository;
import com.pharmagest.monalisa.dojo.core.service.PingouinService;

@Service
@Slf4j
public class PingouinServiceImpl implements PingouinService {
    
    PingouinRepository pingouinRepository;
    
    @Autowired
    public PingouinServiceImpl(PingouinRepository pingouinRepository) {
        this.pingouinRepository = pingouinRepository;
    }
    
    @Override
    @Transactional(readOnly = true)
    @Cacheable("pingouin")
    public Pingouin findById(final Long idPingouin) {
        Optional<Pingouin> pingouinOptional = pingouinRepository.findById(idPingouin);
        Pingouin pingouin = pingouinOptional.orElseThrow(() -> new RuntimeException("Not Found"));
        return pingouin;
    }
    
    @Override
    @Transactional(readOnly = true)
    @CachePut("pingouin")
    @CacheEvict(value = "pingouinBySize", allEntries = true)
    public Pingouin updatePingoun(final Long idPingouin) {
        Optional<Pingouin> pingouinOptional = pingouinRepository.findById(idPingouin);
        Pingouin pingouin = pingouinOptional.orElseThrow(() -> new RuntimeException("Not Found"));
        return pingouin;
    }
    
    @Override
    @Transactional(readOnly = true)
    @Cacheable("pingouinBySize")
    public List<Pingouin> findAllPingouinWithSameSizeHasPingouin(Long pingouinId) {
        log.info("Get all pingouin with same size has {}", pingouinId);
        Pingouin pingouin = this.findById(pingouinId);
        
        return pingouinRepository.findAllByTaille(pingouin.getTaille());
    }
}
