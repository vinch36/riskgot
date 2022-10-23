package com.vinch36.riskgot.service;


import com.vinch36.riskgot.model.game.Game;
import com.vinch36.riskgot.model.game.Region;
import com.vinch36.riskgot.repository.jpa.GameRepository;
import com.vinch36.riskgot.repository.jpa.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private RegionRepository regionRepository;

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
        Game savedGame = gameRepository.save(game);
        return savedGame;
    }

    public Game createNewGame(Game game)
    {
        Game newGame = new Game();
        newGame.setTitle(game.getTitle());
        newGame.setGameMode(game.getGameMode());
        newGame.setImageUrl(game.getImageUrl());
        newGame.setNumberOfPlayers(game.getNumberOfPlayers());
        newGame.setDescription(game.getDescription());
        newGame.setCurrentNumberOfPlayers(0);
        newGame.setLikes(0);


        newGame.setCreatedDate(new Date());
        newGame.setGameStatus(Game.GameStatus.CREATED);
        newGame.setGameStatusInitialization(Game.GameStatusInitialization.NOT_APPLICABLE);
        newGame.setGameStatusPlaying(Game.GameStatusPlaying.NOT_APPLICABLE);

        gameRepository.save(newGame);
        //initializeRegions(newGame);
        return newGame;
    }


    public Game updateGame(Game game, Long id)
    {
        Optional<Game>  g = this.getGame(id);
        if (g.isPresent()) {

            Game currentGame = g.get();
            String name = game.getTitle();
            if(name != null) {
                currentGame.setTitle(name);
            }
            Integer nbPlayer = game.getNumberOfPlayers();
            if(nbPlayer != null) {
                currentGame.setNumberOfPlayers(nbPlayer);
            }

            Integer likes = game.getLikes();
            if(likes != null) {
                currentGame.setLikes(likes);
            }
            String imageUrl = game.getImageUrl();
            if(imageUrl != null) {
                currentGame.setImageUrl(imageUrl);
            }
            Integer currentNumberOfPlayers = game.getCurrentNumberOfPlayers();
            if(currentNumberOfPlayers != null) {
                currentGame.setCurrentNumberOfPlayers(currentNumberOfPlayers);
            }

            return gameRepository.save(game);
        }
        else{
            return null;
        }


    }


    private void initializeRegions(Game game)
    {
        game.setRegions(new ArrayList<Region>());
        game.getRegions().add(new Region(Region.RegionNames.DORNE, 4, game));
        game.getRegions().add(new Region(Region.RegionNames.BIEF, 2, game));
        game.getRegions().add(new Region(Region.RegionNames.NORD, 2, game));


        regionRepository.saveAll(game.getRegions());
    }




}
