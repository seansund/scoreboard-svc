package com.dex.scoreboard.server.model;

import lombok.Data;

@Data
public class GameClock {
    private int time;
    private int period;

    public static GameClock createGameClock(int time, int period) {
        final GameClock clock = new GameClock();

        clock.time = time;
        clock.period = period;

        return clock;
    }

    public GameClock tick() {
        if (time == 0) {
            return this;
        }

        return createGameClock(this.time - 1, this.period);
    }

    public GameClock reset(int time) {
        if (time <= 0) {
            return this;
        }

        return createGameClock(time, this.period);
    }

    public GameClock periodAdd() {
        if (period >= 4) {
            return this;
        }

        return createGameClock(time, period + 1);
    }

    public GameClock periodSubtract() {
        if (period <= 0) {
            return this;
        }

        return createGameClock(time, period - 1);
    }

    public GameClock periodSet(int period) {
        if (period <=0 || period >= 4) {
            return this;
        }

        return createGameClock(time, period);
    }

    public GameClock timeMinuteChange(int minute) {
        return timeSecondChange(minute * 60);
    }

    public GameClock timeSecondChange(int second) {
        final int newTime = time + second;
        if (newTime < 0) {
            return this;
        }

        return createGameClock(newTime, period);
    }

    public GameClock timeSet(int minute, int second) {
        if (minute < 0 || second < 0) {
            return this;
        }

        return createGameClock(minute * 60 + second, period);
    }

    public String asPrettyTime() {
        final int minutes = time / 60;
        final int seconds = time - (minutes * 60);

        String secondsString = Integer.toString(seconds);
        if (secondsString.length() == 1) {
            secondsString = "0" + secondsString;
        }

        return String.format("%d:%s", minutes, secondsString);
    }

    public String toString() {
        return String.format("Per %d - %s", period, asPrettyTime());
    }
}
