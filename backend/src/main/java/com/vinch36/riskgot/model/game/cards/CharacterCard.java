package com.vinch36.riskgot.model.game.cards;

import com.vinch36.riskgot.model.game.Family;
import com.vinch36.riskgot.model.game.Game;
import com.vinch36.riskgot.model.game.Player;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="risk_got_cardcharacter")
public class CharacterCard extends Card{

    public enum CharacterNames{CATELYN_STARK, JON_SNOW, NED_STARK, ROBB_STARK, DEVOS_MERVAULT, MELISANDRE, SLADHOR_SAAN, STANIS_BARATHEON, CERSEI_LANNISTER, JAIME_LANNISTER, TYRION_LANNISTER, TYWIN_LANNISTER, BRIENNE, LORAS_TYRELL, MARGAERY_TYRELL, RENLY_BARATHEON, AREO_HOTAH, DORAN_MARTELL, ELLARIA_SAND, OBERYN_MARTELL};


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    CharacterNames name;

    @ManyToOne
    @JoinColumn(name="family_id",referencedColumnName = "id", nullable=false)
    Family family;

    @ManyToOne
    @JoinColumn(name="player_id",referencedColumnName = "id")
    Player owningPlayer;

    String text;

    @ManyToOne
    @JoinColumn(name="game_id",referencedColumnName = "id")
    Game game;


}
