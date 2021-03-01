package com.github.gerwaismomo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class FrameTest {

    @Test
    public void frame_strike_isValid() {
        Roll roll = new Roll('x');
        Frame frame = new Frame();
        frame.addRoll(roll);
        assertTrue(frame.isValid());
    }

    @Test
    public void frame_withOneCharNotX_isNotValid() {
        Roll roll = new Roll('1');
        Frame frame = new Frame();
        frame.addRoll(roll);
        assertFalse(frame.isValid());

        roll = new Roll('1');
        frame = new Frame();
        frame.addRoll(roll);
        assertFalse(frame.isValid());

        roll = new Roll('-');
        frame = new Frame();
        frame.addRoll(roll);
        assertFalse(frame.isValid());
    }

    @Test
    public void frame_withFirstCharSpare_isNotValid() {
        Roll roll1 = new Roll('/');
        Roll roll2 = new Roll('/');
        Frame frame = new Frame();
        frame.addRoll(roll1);
        frame.addRoll(roll2);
        assertFalse(frame.isValid());

        roll1 = new Roll('/');
        roll2 = new Roll('3');
        frame = new Frame();
        frame.addRoll(roll1);
        frame.addRoll(roll2);
        assertFalse(frame.isValid());
    }
}
