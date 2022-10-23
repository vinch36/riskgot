package com.vinch36.riskgot.model.game.cards;

import com.vinch36.riskgot.model.game.Game;
import com.vinch36.riskgot.model.game.Player;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="risk_got_cardmaester")
public class MaesterCard extends Card{
    public enum MasterNames {CORRUPTION, FORCE_DE_LACIER, CONSOLIDEZ_VOS_REMPARTS, PRETEZ_SERMENT, PRETEZ_SERMENT_2, ARMES_DE_GUERRE, PREPARATIONS_POUR_LA_GUERRE, PREPARATIONS_POUR_LA_GUERRE_2, ETABLIR_LAVANTAGE, EMBUSCADE_DESEPEREE, UNE_TREVE_TEMPORAIRE, DESERTION_MASSIVE, UN_TISSU_DE_MENSONGE, CONFUSION_DANS_LES_RANGS, REVOLTE_DU_PEUPLE_LIBRE, MENE_DANS_UN_PIEGE, PERTES_IMPREVUES, LHIVER_VIENT};


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    MasterNames name;

    String text;

    @ManyToOne
    @JoinColumn(name="player_id",referencedColumnName = "id")
    Player owningPlayer;

    @ManyToOne
    @JoinColumn(name="game_id",referencedColumnName = "id")
    Game game;

}
