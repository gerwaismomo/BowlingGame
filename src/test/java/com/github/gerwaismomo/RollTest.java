package com.github.gerwaismomo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class RollTest {

    @Test
    public void roll_strike_isValid() {
        Roll roll = new Roll('x');
        assertTrue(roll.isValid());
    }

    @Test
    public void roll_spare_isValid() {
        Roll roll = new Roll('/');
        assertTrue(roll.isValid());
    }

    @Test
    public void roll_gutter_isValid() {
        Roll roll = new Roll('-');
        assertTrue(roll.isValid());
    }

    @Test
    public void roll_digit_isValid() {
        Roll roll = new Roll('1');
        assertTrue(roll.isValid());
        roll = new Roll('2');
        assertTrue(roll.isValid());
        roll = new Roll('9');
        assertTrue(roll.isValid());
    }
}
