package com.pharmagestmonalisa.dojo.dojoms.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmagest.monalisa.dojo.core.entity.Pingouin;
import com.pharmagest.monalisa.dojo.core.service.PingouinService;
import com.pharmagest.monalisa.dojo.ms.api.PingouinModel;

@RestController
@RequestMapping("pingouin")
@Slf4j
public class PingouinController {
    
    private final PingouinService pingouinService;
    
    public PingouinController(PingouinService pingouinService) {
        this.pingouinService = pingouinService;
    }
    
    @PostMapping
    @RequestMapping(value = "/{parametre-cre-id}")
            public ResponseEntity<PingouinModel> findById(final @PathVariable("parametre-cre-id") Long idPingouin) {
        Pingouin pingouin = pingouinService.findById(idPingouin);
        return ResponseEntity.ok(null);
    }
    
    @PostMapping
    @RequestMapping(value = "/{parametre-cre-id}/same-size")
    public ResponseEntity<List<PingouinModel>> findWithSameSize(final @PathVariable("parametre-cre-id") Long idPingouin) {
        List<Pingouin> allPingouinWithSameSizeHasPingouin = pingouinService.findAllPingouinWithSameSizeHasPingouin(idPingouin);
        return ResponseEntity.ok(null);
    }
    
}
