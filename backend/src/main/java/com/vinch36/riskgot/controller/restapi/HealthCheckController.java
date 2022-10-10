package com.vinch36.riskgot.controller.restapi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.vinch36.riskgot.RiskgotApplication.startTime;

@RestController
public class HealthCheckController {


    @GetMapping("/healthcheck")
    public String healthCheck(){
        final long duration = System.currentTimeMillis() - startTime;
        String result ="OK, RISK SERVER IS UP AND RUNNING SINCE: " + duration + " ms";
        //System.out.println("call to /healthcheck - returned : " + result);
        return result;
    }




}
