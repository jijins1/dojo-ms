package com.pharmagest.monalisa.dojo.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pingouin {
    @Id
    private Long id;
    @Column
    private Long taille;
    /**
     * Poids en kilo
     */
    @Column
    private Long poids;
    
}
