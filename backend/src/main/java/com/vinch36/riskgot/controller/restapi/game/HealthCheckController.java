package com.vinch36.riskgot.controller.restapi.game;


import com.vinch36.riskgot.model.core.HealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.vinch36.riskgot.RiskgotApplication.startTime;

@RestController
public class HealthCheckController {

    Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

    @CrossOrigin
    @GetMapping("/healthcheck")
    public HealthCheck healthCheck(){

        HealthCheck healthCheck = new HealthCheck();
        healthCheck.setTimeSinceStarted(System.currentTimeMillis() - startTime);
        healthCheck.setStartDate(new Date(startTime));
        healthCheck.setMessage("OK, RISK SERVER IS UP AND RUNNING");
        return healthCheck;
    }




}
