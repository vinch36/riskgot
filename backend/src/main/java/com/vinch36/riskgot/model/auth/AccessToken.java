package com.vinch36.riskgot.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken {
    Long iat;
    Long exp;
}
