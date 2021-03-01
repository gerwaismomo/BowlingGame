package com.github.gerwaismomo;

public class Roll {

    private char roll;
    private boolean valid;

    public Roll(char roll) {
        this.roll = roll;

        this.valid = validate(roll);
    }

    private boolean validate(char roll) {
        boolean good = false;
        String rollString = ""+ roll;
        if (rollString.matches("x|[1-9]]|-"))
            good = true;
        return good;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
