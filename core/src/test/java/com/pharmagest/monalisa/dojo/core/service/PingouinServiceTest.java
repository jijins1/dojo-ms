package com.pharmagest.monalisa.dojo.core.service;

import java.util.List;

import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pharmagest.monalisa.dojo.core.config.CoreConfig;
import com.pharmagest.monalisa.dojo.core.config.TestApplicationBoot;
import com.pharmagest.monalisa.dojo.core.entity.Pingouin;
import com.pharmagest.monalisa.dojo.core.repository.PingouinRepository;

@ExtendWith(SpringExtension.class)
@ExtendWith(RandomBeansExtension.class)
@SpringBootTest(classes = TestApplicationBoot.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PingouinServiceTest {
    
    @Autowired
    PingouinRepository pingouinRepository;
    @Autowired
    PingouinService pingouinService;
    @Random(type = Pingouin.class)
    List<Pingouin> pingouins;
    
    @BeforeEach
    void setUp() {
        pingouins.subList(0,3).forEach(pingouin -> pingouin.setTaille(20L));
        pingouinRepository.saveAll(pingouins);
    }
    
    @Test
    void itShouldFindAllPingouinWithSameSizeHasPingouin() {
        List<Pingouin> result = pingouinService.findAllPingouinWithSameSizeHasPingouin(pingouins.get(0).getId());
        Assertions.assertThat(result)
                .allSatisfy(pingouin -> Assertions.assertThat(pingouin.getTaille()).isEqualTo(20L))
                .anySatisfy(pingouin -> Assertions.assertThat(pingouin.getId()).isEqualTo(pingouins.get(1).getId()))
                .anySatisfy(pingouin -> Assertions.assertThat(pingouin.getId()).isEqualTo(pingouins.get(2).getId()));
    }
}