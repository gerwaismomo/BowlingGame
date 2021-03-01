package com.github.gerwaismomo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

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
    public void frame_withFirstCharSpare_throwsError() {
        final Roll roll1 = new Roll('/');
        final Frame frame = new Frame();
        assertThrows(IllegalArgumentException.class, () -> frame.addRoll(roll1));
    }

    @Test
    public void frame_withSecondCharStrike_throwsError() {
        Roll roll1 = new Roll('1');
        final Roll roll2 = new Roll('x');
        final Frame frame = new Frame();
        frame.addRoll(roll1);
        assertThrows(IllegalArgumentException.class, () -> frame.addRoll(roll2));
    }

    @Test
    public void frame_withTwoGutters_isValid() {
        Roll roll1 = new Roll('-');
        Roll roll2 = new Roll('-');
        Frame frame = new Frame();
        frame.addRoll(roll1);
        frame.addRoll(roll2);
        assertTrue(frame.isValid());
    }
}
