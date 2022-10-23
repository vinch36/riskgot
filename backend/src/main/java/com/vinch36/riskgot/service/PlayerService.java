package com.vinch36.riskgot.service;

import com.vinch36.riskgot.controller.restapi.game.requestobjects.RequestPlayer;
import com.vinch36.riskgot.model.game.Player;
import com.vinch36.riskgot.repository.jpa.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Optional<Player> getPlayer(final Long id){
        return playerRepository.findById(id);
    }

    public Iterable<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public void deletePlayer(final Long id){
        playerRepository.deleteById(id);
    }

    public Player savePlayer(Player player){
        Player savedPlayer=playerRepository.save(player);
        return savedPlayer;
    }


    public Player createPlayer(Player player){
        Player savedPlayer=playerRepository.save(player);
        return savedPlayer;
    }
}
