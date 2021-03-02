package com.github.gerwaismomo;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private List<Roll> rolls;
    private boolean complete;
    private int currentScore;

    public Frame() {
        this.rolls = new ArrayList<>();
        this.complete = false;
        this.currentScore = 0;
    }

    public void addRollOrExit(Roll roll) {
        if(validateRoll(roll)) {
            this.currentScore = evalScore(roll);
            rolls.add(roll);
            this.complete = this.frameComplete();
        }
    }

    private boolean validateRoll(Roll roll) {
        if(rolls.size() == 0 && roll.getKey() == '/')
            throw new IllegalArgumentException(""+roll.getKey());
        if(rolls.size() == 1 ) {
            if (roll.getKey() == 'x')
                throw new IllegalArgumentException("" + roll.getKey());
            else if(roll.getKey() != '/') {
                if (!((this.currentScore + roll.score()) < 10))
                    throw new IllegalArgumentException(""+ currentScore +" " + roll.getKey());
            }
        }
        return true;
    }

    private int evalScore(Roll roll) {
        switch (roll.getKey()) {
            case 'x' :
            case '/' : return roll.score();
            default  : return currentScore + roll.score();
        }
    }

    private boolean frameComplete() {
        boolean good = false;
        if(rolls.size() == 1) {
            good = rolls.get(0).getKey() == 'x';
        } else if(rolls.size() == 2){
            good = true;
        }
        return good;
    }

    public boolean isComplete() {
        return complete;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getLatestRollScore() {
        int latestRollScore = 0;
        if(!rolls.isEmpty()) {
            Roll latestRoll = rolls.get(rolls.size()-1);
            switch (latestRoll.getKey()) {
                case '/' : latestRollScore = 10 - rolls.get(0).score();
                            break;
                default  : latestRollScore = latestRoll.score();
            }
            System.out.print("key: "+ latestRoll.getKey());
        }
        System.out.println(" latestRollScore:= "+ latestRollScore);
        return latestRollScore;
    }

    public List<Integer> getLatestRollBonusFactors() {
        List<Integer> bonuses = new ArrayList<>();
        if(!rolls.isEmpty()) {
            bonuses = rolls.get(rolls.size()-1).getBonusFactors();
        }
        return bonuses;
    }
}
