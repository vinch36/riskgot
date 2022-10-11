package com.vinch36.riskgot.controller.restapi;

import com.vinch36.riskgot.model.Game;
import com.vinch36.riskgot.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;


    /**
     * Read - Get all games
     * @return - An Iterable object of Game
     */
    @GetMapping("/game")
    public Iterable<Game> getGames() {
        return gameService.getGames();
    }

    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object full filled
     */
    @GetMapping("/game/{id}")
    public Game getEmployee(@PathVariable("id") final Long id) {
        Optional<Game> game = gameService.getGame(id);
        if(game.isPresent()) {
            return game.get();
        } else {
            return null;
        }
    }

    /**
     * Create - Add a new game
     * @param game An object game
     * @return The game object saved
     */
    @PostMapping("/game")
    public Game createGame(@RequestBody Game game){
        return gameService.saveGame(game);
    }




    @CrossOrigin
    @PutMapping("/game/{id}")
    public Game updateEmployee(@PathVariable("id") final Long id, @RequestBody Game game) {
        Optional<Game> u = gameService.getGame(id);
        if(u.isPresent()) {
            Game currentGame = u.get();

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

            Date date = game.getCreatedDate();
            if(date != null) {
                currentGame.setCreatedDate(date);
            }
            String imageUrl = game.getImageUrl();
            if(imageUrl != null) {
                currentGame.setImageUrl(imageUrl);
            }
            Integer currentNumberOfPlayers = game.getCurrentNumberOfPlayers();
            if(currentNumberOfPlayers != null) {
                currentGame.setCurrentNumberOfPlayers(currentNumberOfPlayers);
            }
            gameService.saveGame(currentGame);
            return currentGame;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/game/{id}")
    public void deleteGame(@PathVariable("id") final Long id) {
        gameService.deleteGame(id);
    }


}
