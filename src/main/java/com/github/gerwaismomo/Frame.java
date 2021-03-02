package com.github.gerwaismomo;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    List<Roll> rolls;
    boolean complete;
    int currentScore;

    public Frame() {
        this.rolls = new ArrayList<>();
        this.complete = false;
        this.currentScore = 0;
    }

    public void addRoll(Roll roll) {
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
}
