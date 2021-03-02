package com.github.gerwaismomo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class FrameTest {

    @Test
    public void frame_strike_isValid() {
        Roll roll = new Roll('x');
        Frame frame = new Frame();
        frame.addRollOrExit(roll);
        assertTrue(frame.isComplete());
    }

    @Test
    public void frame_withOneCharNotX_isNotValid() {
        Roll roll = new Roll('1');
        Frame frame = new Frame();
        frame.addRollOrExit(roll);
        assertFalse(frame.isComplete());

        roll = new Roll('1');
        frame = new Frame();
        frame.addRollOrExit(roll);
        assertFalse(frame.isComplete());

        roll = new Roll('-');
        frame = new Frame();
        frame.addRollOrExit(roll);
        assertFalse(frame.isComplete());
    }

    @Test
    public void frame_withFirstCharSpare_throwsError() {
        final Roll roll1 = new Roll('/');
        final Frame frame = new Frame();
        assertThrows(IllegalArgumentException.class, () -> frame.addRollOrExit(roll1));
    }

    @Test
    public void frame_withSecondCharStrike_throwsError() {
        Roll roll1 = new Roll('1');
        final Roll roll2 = new Roll('x');
        final Frame frame = new Frame();
        frame.addRollOrExit(roll1);
        assertThrows(IllegalArgumentException.class, () -> frame.addRollOrExit(roll2));
    }

    @Test
    public void frame_withTwoGutters_isValid() {
        Roll roll1 = new Roll('-');
        Roll roll2 = new Roll('-');
        Frame frame = new Frame();
        frame.addRollOrExit(roll1);
        frame.addRollOrExit(roll2);
        assertTrue(frame.isComplete());
    }

    @Test
    public void frame_withoutStrikeOrSpare_lessThan10() {
        Roll roll1 = new Roll('1');
        Roll roll2 = new Roll('8');
        Frame frame = new Frame();
        frame.addRollOrExit(roll1);
        frame.addRollOrExit(roll2);
        assertTrue(10 > frame.getCurrentScore());
    }

    @Test
    public void frame_withTwoRollsGreaterThan9_throwsError() {
        Roll roll1 = new Roll('4');
        final Roll roll2 = new Roll('6');
        final Frame frame = new Frame();
        frame.addRollOrExit(roll1);
        assertThrows(IllegalArgumentException.class, () -> frame.addRollOrExit(roll2));
    }
}
