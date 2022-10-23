package com.vinch36.riskgot.model.game;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vinch36.riskgot.model.game.cards.CharacterCard;
import com.vinch36.riskgot.model.game.cards.GoalCard;
import com.vinch36.riskgot.model.game.cards.MaesterCard;
import com.vinch36.riskgot.model.game.cards.TerritoryCard;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="risk_got_game")
public class Game {

    public enum GameMode{ESCARMOUCHE,DOMINATION};

    public enum GameStatus
    { CREATED, FULL, INITIALIZATION, PLAYING, FINISHED};


    public enum GameStatusInitialization
    { FAMILY_CHOICE, CHOOSE_GOALS, CHOOSE_TERRITORIES, PLACE_ARMIES, NOT_APPLICABLE};

    public enum GameStatusPlaying
    { ADD_ARMIES, BUY_CARDS, UPDATE_CHARACTERS, ATTACK, MOVE_ARMY, ACHIEVE_GOAL, NOT_APPLICABLE};



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    GameMode gameMode;

    @Enumerated(EnumType.STRING)
    GameStatus gameStatus;

    @Enumerated(EnumType.STRING)
    GameStatusInitialization gameStatusInitialization;

    @Enumerated(EnumType.STRING)
    GameStatusPlaying gameStatusPlaying;

    String title;

    String description;

    String imageUrl;

    Date createdDate;

    Integer numberOfPlayers;

    Integer currentNumberOfPlayers;

    Integer likes;

    @OneToMany(mappedBy="id")
    List<Player> players;

    @OneToMany(mappedBy="game")
    @JsonManagedReference("game_region")
    List<Region> regions;

    @OneToMany(mappedBy="game")
    List<Territory> territories;


    @OneToMany(mappedBy="game")
    List<CharacterCard> characterCards;


    @OneToMany(mappedBy="game")
    List<GoalCard> goalCards;

    @OneToMany(mappedBy="game")
    List<TerritoryCard> territoryCards;

    @OneToMany(mappedBy="game")
    List<MaesterCard> maesterCards;

    @OneToMany(mappedBy="game")
    List<Family> families;






}
