package com.github.gerwaismomo;

import java.util.ArrayList;
import java.util.List;

public class Game {
    int gameScore;
    List<Integer> bonusForehead;

    public Game(String turns) {
        this.gameScore = 0;
        this.bonusForehead = new ArrayList<>();

        processTurns(turns);
    }

    public void processTurns(String turns) {
        turns = turns.replaceAll("\\s", "");
        System.out.println(" turns "+ turns);

        Frame frame = new Frame();
        int frameCount = 0;
        for(char c: turns.toCharArray()) {
            Roll roll = new Roll(c);
            if(!roll.isValid())
                throw new RuntimeException("Bad set");

            frame.addRollOrExit(roll);

            if(frameCount < 10) {
                gameScore += (1 + bonusFactor()) * frame.getLatestRollScore();
                updateBonusFactor(frame.getLatestRollBonusFactors());
            } else {
                gameScore += bonusFactor() * frame.getLatestRollScore();
            }
            if(frame.isComplete()) {
                frame = new Frame();
                frameCount++;
            }
        }
    }

    private int bonusFactor() {
        int factor = 0;
        if(!bonusForehead.isEmpty()) {
            factor = bonusForehead.remove(0);
        }
        return factor;
    }

    private void updateBonusFactor(List<Integer> newBonuses) {
        if(bonusForehead.isEmpty()) {
            bonusForehead = newBonuses;
        } else {
            if(!newBonuses.isEmpty()) {
                bonusForehead.set(0, (bonusForehead.get(0) + newBonuses.get(0)));
                if (newBonuses.size() == 2)
                    bonusForehead.add(newBonuses.get(1));
            }
        }
    }

    public int getGameScore() {
        return gameScore;
    }
}
