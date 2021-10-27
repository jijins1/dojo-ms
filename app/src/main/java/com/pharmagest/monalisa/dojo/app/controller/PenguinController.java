package com.pharmagest.monalisa.dojo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pharmagest.monalisa.compta.v1.server.openapi.PenguinApi;
import com.pharmagest.monalisa.compta.v1.server.openapi.model.Penguin;
import com.pharmagest.monalisa.dojo.app.mapper.PengouinMapper;
import com.pharmagest.monalisa.dojo.core.service.PingouinService;

@RestController
public class PenguinController implements PenguinApi {
    private final PingouinService pingouinService;
    private final PengouinMapper pengouinMapper;
    
    @Autowired
    public PenguinController(final PingouinService pingouinService, final PengouinMapper pengouinMapper) {
        this.pingouinService = pingouinService;
        this.pengouinMapper = pengouinMapper;
    }
    
    @Override
    public ResponseEntity<Penguin> getPingouin(final Long penguinId) {
        return ResponseEntity.ok(pengouinMapper.toModel(pingouinService.findById(penguinId)));
    }
}
