package com.github.gerwaismomo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class BowlingTest {

    @Test
    public void game_withSimpleRolls_isValid() {
        Game game = new Game("54 54 54 54 54 54 54 54 54 54");
        assertEquals(90, game.getGameScore());
    }

}
