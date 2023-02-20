package com.dex.scoreboard.server.controllers;

import com.dex.scoreboard.server.model.Game;
import com.dex.scoreboard.server.repository.GameRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Arrays;
import java.util.List;

@Controller
@CrossOrigin
public class GameController {
    private final GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    public Game getGame() {
        return repository.getGame();
    }
}
