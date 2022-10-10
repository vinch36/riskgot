package com.vinch36.riskgot.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="risk_got_game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    Integer numberOfPlayers;
}
