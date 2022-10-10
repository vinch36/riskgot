package com.vinch36.riskgot.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name="risk_got_user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    String email;

    String password;


}
