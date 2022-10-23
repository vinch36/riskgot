package com.vinch36.riskgot.controller.restapi.game;

import com.vinch36.riskgot.model.game.Game;
import com.vinch36.riskgot.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;


    /**
     * Read - Get all games
     * @return - An Iterable object of Game
     */
    @GetMapping("/games")
    public Iterable<Game> getGames() {

        return gameService.getGames();
    }

    /**
     * Read - Get one employee
     * @param id The id of the employee
     * @return An Employee object full filled
     */
    @GetMapping("/games/{id}")
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
    @PostMapping("/games")
    public Game createGame(@AuthenticationPrincipal Jwt principal, @RequestHeader(HttpHeaders.AUTHORIZATION) String auth, @RequestBody Game game)  {

//        HttpResponse<String> response = Unirest.post("https://dev-9-9s2dzx.us.auth0.com/oauth/token")
//                .header("content-type", "application/json")
//                .body("{\"client_id\":\"tiUMF5I3QYl9ugWXu7HVsbarNxrOCMyD\",\"client_secret\":\"ctpzHDVGsjr2AYphGJKO_XJb1-9AQ4r3iMmHC_XB4CNk_sSgl8botLx_GeE6Nmsj\",\"audience\":\"https://dev-9-9s2dzx.us.auth0.com/api/v2/\",\"grant_type\":\"client_credentials\"}")
//                .asString();
        System.out.println(principal.getClaimAsString("sub"));
        return gameService.createNewGame(game);

    }





    @PutMapping("/games/{id}")
    public Game updateGame(@PathVariable("id") final Long id, @RequestBody Game game) {
        return gameService.updateGame(game, id);

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
