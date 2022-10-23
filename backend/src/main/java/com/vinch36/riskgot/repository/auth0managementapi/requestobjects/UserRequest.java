package com.vinch36.riskgot.repository.auth0managementapi.requestobjects;

import com.vinch36.riskgot.model.auth.User;
import lombok.Data;

@Data
public class UserRequest {
    String nickname;
    String picture;

    public UserRequest(User user)
    {
        this.nickname=user.getNickname();
        this.picture=user.getPicture();

    }


}
