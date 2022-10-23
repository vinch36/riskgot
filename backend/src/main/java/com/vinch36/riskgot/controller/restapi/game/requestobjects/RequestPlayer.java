package com.vinch36.riskgot.controller.restapi.game.requestobjects;

import lombok.Data;

@Data
public class RequestPlayer {
    private String user_email;
    private Long game_id;
}
