package com.vinch36.riskgot.model.core;


import lombok.Data;

import java.util.Date;

@Data
public class HealthCheck {
    String message;
    Date startDate;
    long timeSinceStarted;

}
