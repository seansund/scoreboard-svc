package com.dex.scoreboard.server.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Game {
    private Team home;
    private Team away;

    public static Game createGame(@NonNull Team home, @NonNull Team away) {
        final Game newGame = new Game();

        newGame.home = home;
        newGame.away = away;

        return newGame;
    }
}
