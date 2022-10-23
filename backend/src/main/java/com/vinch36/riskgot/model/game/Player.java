package com.vinch36.riskgot.model.game;

import com.vinch36.riskgot.model.auth.User;
import com.vinch36.riskgot.model.game.cards.CharacterCard;
import com.vinch36.riskgot.model.game.cards.GoalCard;
import com.vinch36.riskgot.model.game.cards.MaesterCard;
import com.vinch36.riskgot.model.game.cards.TerritoryCard;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="risk_got_player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @MapsId("user_id")
    User user;

    @ManyToOne
    @JoinColumn(name="game_id",referencedColumnName = "id")
    Game game;

    @ManyToOne
    @MapsId("family_name")
    Family family;


    @OneToMany(mappedBy="owningPlayer")
    List<Territory> territories;


    @OneToMany(mappedBy="owningPlayer")
    List<GoalCard> goalCards;

    @OneToMany(mappedBy="owningPlayer")
    List<TerritoryCard> territoryCards;


    @OneToMany(mappedBy="owningPlayer")
    List<MaesterCard> maesterCards;

    @OneToMany(mappedBy="owningPlayer")
    List<CharacterCard> characterCards;

}
