package com.pharmagest.monalisa.dojo.app.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmagest.monalisa.dojo.app.mapper.PingouinMapper;
import com.pharmagest.monalisa.dojo.core.entity.Pingouin;
import com.pharmagest.monalisa.dojo.core.service.PingouinService;
import com.pharmagest.monalisa.dojo.api.PingouinModel;

/**
 * Creation d'un controller la facon classique
 */
@RestController
@RequestMapping(value = "pingouin",
        produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class PingouinController {
    
    private final PingouinService pingouinService;
    private final PingouinMapper pingouinMapper;
    
    public PingouinController(PingouinService pingouinService, PingouinMapper pingouinMapper) {
        log.info("Start Pingouin Controller");
        this.pingouinService = pingouinService;
        this.pingouinMapper = pingouinMapper;
    }
    
    @PostMapping
    @RequestMapping(value = "/{pingouin-id}")
    public ResponseEntity<PingouinModel> findById(final @PathVariable("pingouin-id") Long idPingouin) {
        Pingouin pingouin = pingouinService.findById(idPingouin);
        return ResponseEntity.ok(pingouinMapper.toModel(pingouin));
    }
    
    @PostMapping
    @RequestMapping(value = "/{pingouin-id}/same-size")
    public ResponseEntity<List<PingouinModel>> findWithSameSize(final @PathVariable("pingouin-id") Long idPingouin) {
        List<Pingouin> allPingouinWithSameSizeHasPingouin = pingouinService.findAllPingouinWithSameSizeHasPingouin(idPingouin);
        return ResponseEntity.ok(pingouinMapper.toModel(allPingouinWithSameSizeHasPingouin));
    }
}
