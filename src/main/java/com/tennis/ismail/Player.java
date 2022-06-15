package com.tennis.ismail;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Player {

    private String username;

    public Player(String username) {

        this.username = username;
    }

}
