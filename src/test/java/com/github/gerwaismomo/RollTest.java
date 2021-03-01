package com.github.gerwaismomo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class RollTest {

    @Test
    public void roll_x_isValid() {
        Roll roll = new Roll("x");

        assertTrue(roll.isValid());
    }
}
