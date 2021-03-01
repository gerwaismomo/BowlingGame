package com.github.gerwaismomo;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    List<Roll> rolls;
    boolean valid;

    public Frame() {
        this.rolls = new ArrayList<>();
        boolean valid = false;
    }

    public void addRoll(Roll roll) {
        if(rolls.size() == 0 && roll.getKey() == '/')
            throw new IllegalArgumentException(""+roll.getKey());
        if(rolls.size() == 1 ) {
            if (roll.getKey() == 'x')
                throw new IllegalArgumentException("" + roll.getKey());
        }
        rolls.add(roll);
        this.valid = this.validate();
    }

    private boolean validate() {
        boolean good = false;
        if(rolls.size() == 1) {
            good = rolls.get(0).getKey() == 'x';
        } else if(rolls.size() == 2){

        }
        return good;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
