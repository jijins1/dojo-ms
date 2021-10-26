package com.pharmagest.monalisa.dojo.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import io.github.glytching.junit.extension.random.Random;
import io.github.glytching.junit.extension.random.RandomBeansExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharmagest.monalisa.dojo.api.PingouinModel;
import com.pharmagest.monalisa.dojo.app.mapper.PingouinMapper;
import com.pharmagest.monalisa.dojo.app.mapper.PingouinMapperImpl;
import com.pharmagest.monalisa.dojo.core.config.CoreConfig;
import com.pharmagest.monalisa.dojo.core.entity.Pingouin;
import com.pharmagest.monalisa.dojo.core.service.PingouinService;

@ExtendWith(SpringExtension.class)
@ExtendWith(RandomBeansExtension.class)
@WebMvcTest(controllers = PingouinController.class)
@Import(PingouinMapperImpl.class)
class PingouinControllerIT {
    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    PingouinService pingouinService;
    @Random()
    Pingouin pingouin;
    
    @Test
    void itShouldFindWithSameSize()
            throws Exception {
        Mockito.doReturn(pingouin).when(pingouinService).findById(1605L);
    
        ResultActions resultActions = mvc.perform(get("/pingouin/1605")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    
        PingouinModel pingouinModel = objectMapper.readValue(resultActions.andReturn().getResponse().getContentAsString(), new TypeReference<>() {
        });
        assertThat(pingouinModel.getPoids()).isNotNull();
        assertThat(pingouinModel.getTaille()).isNotNull();
    }
}