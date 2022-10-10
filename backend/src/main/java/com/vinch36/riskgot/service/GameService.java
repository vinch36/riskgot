package com.vinch36.riskgot.service;


import com.vinch36.riskgot.model.Game;
import com.vinch36.riskgot.model.User;
import com.vinch36.riskgot.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    public Optional<Game> getGame(final Long id){
        return gameRepository.findById(id);
    }

    public Iterable<Game> getGames(){
        return gameRepository.findAll();
    }

    public void deleteGame(final Long id){
        gameRepository.deleteById(id);
    }

    public Game saveGame(Game game){
        Game savedGame=gameRepository.save(game);
        return savedGame;
    }
}
