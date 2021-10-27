package com.pharmagest.monalisa.dojo.core.repository;

import java.util.List;

import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.pharmagest.monalisa.dojo.core.config.CoreConfig;
import com.pharmagest.monalisa.dojo.core.entity.Pingouin;

@ExtendWith(SpringExtension.class)
@ExtendWith(RandomBeansExtension.class)
@DataJpaTest()
@ContextConfiguration(classes = CoreConfig.class)
class PingouinRepositoryIT {
    
    @Autowired
    PingouinRepository pingouinRepository;
    
    @Random(type = Pingouin.class)
    List<Pingouin> pingouins;
    
    @BeforeEach
    void setUp() {
        pingouinRepository.saveAll(pingouins);
    }
    
    @Test
    void itShouldFindAllByTaille() {
        List<Pingouin> result = pingouinRepository.findAllByTaille(pingouins.get(0).getTaille());
        Assertions.assertThat(result).isNotEmpty().allSatisfy(pingouin -> {
            Assertions.assertThat(pingouin.getTaille()).isEqualTo(pingouins.get(0).getTaille());
        });
    }
}