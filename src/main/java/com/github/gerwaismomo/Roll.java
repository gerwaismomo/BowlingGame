package com.github.gerwaismomo;

public class Roll {

    private String roll;
    private boolean valid;

    public Roll(String roll) {
        this.roll = roll;

        this.valid = validate(roll);
    }

    private boolean validate(String roll) {
        boolean good = false;
        if( roll.length() == 1) {
            if (roll.matches("x"))
                good = true;
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
