package com.vinch36.riskgot.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="risk_got_player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("user_id")
    private User user;

    @ManyToOne
    @MapsId("game_id")
    private Game game;

    private String family;
}
