package com.vinch36.riskgot.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="risk_got_game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String title;

    String description;

    String imageUrl;

    Date createdDate;

    Integer numberOfPlayers;

    Integer currentNumberOfPlayers;

    Integer likes;
}
