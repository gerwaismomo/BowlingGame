package com.github.gerwaismomo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class BowlingTest {

    @Test
    public void game_withSimpleRolls_isValid() {
        Game game = new Game("54 54 54 54 54 54 54 54 54 54");
        assert(90, game.finalScore());
    }

}
