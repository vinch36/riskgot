package com.vinch36.riskgot.model.game.cards;

import com.vinch36.riskgot.model.game.Game;
import com.vinch36.riskgot.model.game.Player;
import com.vinch36.riskgot.model.game.SpecialUnit;
import com.vinch36.riskgot.model.game.Territory;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="risk_got_cardterritory")
public class TerritoryCard extends Card{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    Territory.TerritoryNames name;

    @Enumerated(EnumType.STRING)
    SpecialUnit.SpecialUnits specialUnit;

    @OneToOne
    @JoinColumn(name="territory_id",referencedColumnName = "id", nullable=false)
    Territory territory;

    @ManyToOne
    @JoinColumn(name="player_id",referencedColumnName = "id")
    Player owningPlayer;

    @ManyToOne
    @JoinColumn(name="game_id",referencedColumnName = "id")
    Game game;

}
