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
        if( noRollInFrame() && isSpare(roll) )
            throw new IllegalArgumentException(""+roll.getKey());
        if( oneRollInFrame() ) {
            if (isStrike(roll))
                throw new IllegalArgumentException("" + roll.getKey());
            else if( ! isSpare(roll) ) {
                if ( ! ((this.currentScore + roll.score()) < 10) )
                    throw new IllegalArgumentException(""+ currentScore +" " + roll.getKey());
            }
        }
        return true;
    }

    private boolean noRollInFrame() {
        return rolls.size() == 0;
    }
    private boolean oneRollInFrame() {
        return rolls.size() == 1;
    }
    private boolean twoRollsInFrame() {
        return rolls.size() == 2;
    }
    private boolean isSpare(Roll roll) {
        return roll.getKey() == '/';
    }
    private boolean isStrike(Roll roll) {
        return roll.getKey() == 'x';
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
        if( oneRollInFrame() ) {
            good = isStrike(rolls.get(0));
        } else if( twoRollsInFrame() ){
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
