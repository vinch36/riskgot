package com.vinch36.riskgot.controller.ws;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ChatController {


    @MessageMapping("/resume")
    @SendTo("/start/initial")
    public String chat(String msg) {
        System.out.println(msg);
        return msg;
    }

}
