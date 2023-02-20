package com.dex.scoreboard.server.runners;

import com.dex.scoreboard.server.model.GameClock;
import com.dex.scoreboard.server.repository.GameClockRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class GameClockWatcher implements ApplicationRunner {
    private GameClockRepository repository;

    public GameClockWatcher(GameClockRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.clockObservable().subscribe((GameClock clock) -> {
            System.out.println("GameClock: " + clock);
        });

        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
