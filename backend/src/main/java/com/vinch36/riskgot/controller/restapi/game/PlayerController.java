package com.vinch36.riskgot.controller.restapi.game;

import com.vinch36.riskgot.controller.restapi.game.requestobjects.RequestPlayer;
import com.vinch36.riskgot.model.game.Family;
import com.vinch36.riskgot.model.game.Game;
import com.vinch36.riskgot.model.game.Player;
import com.vinch36.riskgot.model.auth.User;
import com.vinch36.riskgot.service.GameService;
import com.vinch36.riskgot.service.PlayerService;
import com.vinch36.riskgot.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @Autowired
    private AuthService authService;


    /**
     * Read - Get all players
     * @return - An Iterable object of Player
     */
    @GetMapping("/player")
    public Iterable<Player> getPlayers() {

        return playerService.getPlayers();
    }

    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object full filled
     */
    @GetMapping("/player/{id}")
    public Player getEmployee(@PathVariable("id") final Long id) {
        Optional<Player> player = playerService.getPlayer(id);
        if(player.isPresent()) {
            return player.get();
        } else {
            return null;
        }
    }

    /**
     * Create - Add a new player
     * @param player An object player
     * @return The player object saved
     */
    @PostMapping("/player")
    public Player createPlayer(@RequestBody RequestPlayer player){
        Optional<User> u = this.authService.getUser(player.getUser_email());
        Optional<Game> g = this.gameService.getGame(player.getGame_id());

        if (u.isPresent()&&g.isPresent())
        {
            User user = u.get();
            Game game = g.get();

            Player newPlayer = new Player();
            newPlayer.setUser(user);
            newPlayer.setGame(game);


            return playerService.createPlayer(newPlayer);
        }
        else return null;



    }




    @PutMapping("/player/{id}")
    public Player updateEmployee(@PathVariable("id") final Long id, @RequestBody Player player) {
        Optional<Player> u = playerService.getPlayer(id);
        if(u.isPresent()) {
            Player currentPlayer = u.get();

            Family family = player.getFamily();
            if(family != null) {
                currentPlayer.setFamily(family);
            }
            User user = player.getUser();
            if(user != null) {
                currentPlayer.setUser(user);
            }
            Game game = player.getGame();
            if(game != null) {
                currentPlayer.setGame(game);
            }
            playerService.savePlayer(currentPlayer);
            return currentPlayer;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an employee
     * @param id - The id of the employee to delete
     */
    @DeleteMapping("/player/{id}")
    public void deletePlayer(@PathVariable("id") final Long id) {
        playerService.deletePlayer(id);
    }


}
