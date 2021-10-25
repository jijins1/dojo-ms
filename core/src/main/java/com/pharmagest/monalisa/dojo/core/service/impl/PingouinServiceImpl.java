package com.pharmagest.monalisa.dojo.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmagest.monalisa.dojo.core.entity.Pingouin;
import com.pharmagest.monalisa.dojo.core.repository.PingouinRepository;
import com.pharmagest.monalisa.dojo.core.service.PingouinService;

@Service
public class PingouinServiceImpl implements PingouinService {
    
    PingouinRepository pingouinRepository;
    
    @Autowired
    public PingouinServiceImpl() {
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Pingouin> findAllPingouinWithSameSizeHasPingouin(Long pingouinId, Long taille) {
        Optional<Pingouin> pingouinOptional = pingouinRepository.findById(pingouinId);
        Pingouin pingouin = pingouinOptional.orElseThrow(() -> new RuntimeException("Not Found"));
        return pingouinRepository.findAllByTaille(pingouin.getTaille());
    }
}