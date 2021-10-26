package com.pharmagest.monalisa.dojo.app.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.pharmagest.monalisa.compta.v1.server.openapi.model.Penguin;
import com.pharmagest.monalisa.dojo.core.entity.Pingouin;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PengouinMapper {
    
    @Mapping(source = "poids", target = "weight", qualifiedByName = "kgToPound")
    @Mapping(source = "taille", target = "size")
    Penguin toModel(Pingouin pingouin);
    
    List<Penguin> toModel(List<Pingouin> pingouin);
    
    @Named("kgToPound")
    static Long kgToPound(Long poidsKg) {
        return ((Double) (poidsKg * 2.205)).longValue();
    }
    
}
