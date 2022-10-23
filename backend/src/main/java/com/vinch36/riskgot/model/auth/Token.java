package com.vinch36.riskgot.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="risk_got_token")
public class Token {

    @Id
    @Column(name="access_token", length=8192)
    String access_token;
    Long valid_until;


    public void setValid_untilFromInnerAccessToken()  {

        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] chunks = this.access_token.split("\\.");
        String payload = new String(decoder.decode(chunks[1]));
        ObjectMapper mapper = new ObjectMapper();
        AccessToken accessToken  = null;
        try {
            accessToken = mapper.readValue(payload, AccessToken.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        this.valid_until = accessToken.exp*1000;
    }


    //Will return true if the token is still  valid more than 1 hour
    public Boolean isValid(){
        Long now = System.currentTimeMillis();
        Long expires_in = valid_until - now;
        Long seconds = (Long) (expires_in / 1000) % 60 ;
        Long minutes = (Long) ((expires_in / (1000*60)) % 60);
        Long hours   = (Long) ((expires_in / (1000*60*60)) % 24);

        System.out.println("CURRENT TOKEN EXPIRES IN  : " + String.format("%02d hour, %02d min, %02d sec", hours, minutes, seconds));
        if (expires_in > 1800000){
            System.out.println("STILL VALID MORE THAN 30 MINUTES !");
            return true;
        }
        else{
            System.out.println("WILL EXPIRE IN LESS THAN 30 MINUTES !");
            return false;
        }



    }
}

