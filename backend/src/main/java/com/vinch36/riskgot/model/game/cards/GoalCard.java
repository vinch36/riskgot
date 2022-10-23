package com.vinch36.riskgot.model.game.cards;

import com.vinch36.riskgot.model.game.Game;
import com.vinch36.riskgot.model.game.Player;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="risk_got_cardobjective")
public class GoalCard extends Card{
    public enum ObjeciveNames{EX1,EX2};


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    ObjeciveNames name;


    Integer victoryPoints;

    String text;

    @ManyToOne
    @JoinColumn(name="player_id",referencedColumnName = "id")
    Player owningPlayer;


    @ManyToOne
    @JoinColumn(name="game_id",referencedColumnName = "id")
    Game game;

}
