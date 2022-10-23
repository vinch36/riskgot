package com.vinch36.riskgot.model.game;


import com.vinch36.riskgot.model.game.cards.CharacterCard;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="risk_got_family")
public class Family {


    public enum FamilyNames{STARK, BARATHEON, LANISTER, TYRELL, MARTELL }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    FamilyNames name;

    Integer playOrder;

    String color;

    Integer startMoney;


    @OneToOne
    @JoinColumn(name="capitalTerritory_id", referencedColumnName = "id")
    Territory capitalTerritory;

    @OneToMany(mappedBy="family")
    private List<CharacterCard> characterCards;

    @ManyToOne
    @JoinColumn(name="game_id",referencedColumnName = "id", nullable=false)
    Player game;

}
