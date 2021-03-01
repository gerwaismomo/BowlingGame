package com.github.gerwaismomo;

public class Roll {

    private String roll;
    private boolean valid;

    public Roll(String roll) {
        this.roll = roll;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
