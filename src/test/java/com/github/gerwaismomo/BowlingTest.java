package com.github.gerwaismomo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class BowlingTest {

    @Test
    public void game_withSimpleRolls_isWellScored() {
        Game game = new Game("54 54 54 54 54 54 54 54 54 54");
        assertEquals(90, game.getGameScore());
    }

    @Test
    public void game_withNeitherStrikeNorSpare_isWellScored() {
        Game game = new Game("54 54 -4 54 -- 54 54 5- 54 54");
        assertEquals(72, game.getGameScore());
    }

    @Test
    public void game_withStrikeIn10turns_isWellScored() {
        Game game = new Game("x 54 54 54 54 54 54 54 54 54");
        assertEquals(100, game.getGameScore());
    }

    @Test
    public void game_withSpareIn0turns_isWellScored() {
        Game game = new Game("5/ 54 54 54 54 54 54 54 54 54");
        assertEquals(96, game.getGameScore());
    }

    @Test
    public void game_withSpareAndStrikesAndGuttersIn10turns_isWellScored() {
        Game game = new Game("5/ 54 54 x 54 54 54 -3 54 54");
        assertEquals(100, game.getGameScore());
    }

    @Test
    public void game_withStrikesIn10turns_isWellScored() {
        Game game = new Game("x x x x x x x x 54 54");
        assertEquals(242, game.getGameScore());
    }

    @Test
    public void game_withSparesIn10turns_isWellScored() {
        Game game = new Game("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 54");
        assertEquals(144, game.getGameScore());
    }


}
