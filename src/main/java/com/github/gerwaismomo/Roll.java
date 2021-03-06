package com.github.gerwaismomo;

import java.util.ArrayList;
import java.util.List;

public class Roll {

    private char key;
    private boolean valid;

    public Roll(char roll) {
        this.key = roll;
        this.valid = validate(roll);
    }

    private boolean validate(char roll) {
        boolean good = false;
        String rollString = ""+ roll;
        if (rollString.matches("x|[1-9]|-|/"))
            good = true;
        return good;
    }

    public int score() {
        switch (key) {
            case 'x':
            case '/': return 10;
            case '-': return 0;
            default: return 1 + ((int)key - (int)'1');
        }
    }

    public List<Integer> getBonusFactors() {
        List<Integer> bonusFactors = new ArrayList<>();
        switch (key) {
            case 'x': bonusFactors.add(1);
            case '/': bonusFactors.add(1);
                        break;
            default:
        }
        return bonusFactors;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

}
