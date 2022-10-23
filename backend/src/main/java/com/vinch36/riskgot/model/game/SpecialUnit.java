package com.vinch36.riskgot.model.game;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class SpecialUnit {

    public enum SpecialUnits {CHEVALIER, FORTIFICATION, ENGIN_DE_SIEGE}

    @Enumerated(EnumType.STRING)
    SpecialUnits name;
}
