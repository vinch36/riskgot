package com.vinch36.riskgot.controller.restapi;

import com.vinch36.riskgot.model.Game;
import com.vinch36.riskgot.model.Player;
import com.vinch36.riskgot.model.User;
import com.vinch36.riskgot.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;


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
    public Player createPlayer(@RequestBody Player player){
        return playerService.savePlayer(player);
    }




    @PutMapping("/player/{id}")
    public Player updateEmployee(@PathVariable("id") final Long id, @RequestBody Player player) {
        Optional<Player> u = playerService.getPlayer(id);
        if(u.isPresent()) {
            Player currentPlayer = u.get();

            String family = player.getFamily();
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
