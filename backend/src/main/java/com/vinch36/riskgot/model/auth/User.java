package com.vinch36.riskgot.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="risk_got_user")
public class User
{
    @Id
    String email;


    String user_id;

    Date created_at;

    String nickname;


    Boolean email_verified;

    Integer logins_count;

    String picture;
}
