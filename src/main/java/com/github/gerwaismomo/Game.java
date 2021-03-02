package com.github.gerwaismomo;

public class Game {
    int gameScore;
    public Game(String turns) {
        this.gameScore = 0;

        processTurns(turns);
    }

    public void processTurns(String turns) {
        turns = turns.replaceAll("\\s", "");
        System.out.println(" turns "+ turns);

        Frame frame = new Frame();
        for(char c: turns.toCharArray()) {
            Roll roll = new Roll(c);
            if(!roll.isValid())
                throw new RuntimeException("Bad set");

            frame.addRollOrExit(roll);

            if(frame.isComplete()) {
                gameScore += frame.getCurrentScore();
                frame = new Frame();
            }
        }
    }

    public int getGameScore() {
        return gameScore;
    }
}
