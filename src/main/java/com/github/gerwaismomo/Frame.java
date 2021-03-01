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
        rolls.add(roll);
        this.valid = this.validate();
    }

    private boolean validate() {
        boolean good = false;
        if(rolls.size() ==1) {
            good = rolls.get(0).getKey() == 'x';
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
