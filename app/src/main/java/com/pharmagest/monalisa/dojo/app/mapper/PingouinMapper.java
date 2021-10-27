package com.pharmagest.monalisa.dojo.app.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.pharmagest.monalisa.dojo.core.entity.Pingouin;
import com.pharmagest.monalisa.dojo.api.PingouinModel;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PingouinMapper {
    PingouinModel toModel(Pingouin pingouin);
    List<PingouinModel> toModel(List<Pingouin> pingouin);
}
