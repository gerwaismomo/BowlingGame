package com.github.gerwaismomo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class BowlingTest {

    @Test
    public void game_withSimpleRolls_isWellScored() {
        Bowling game = new Bowling("54 54 54 54 54 54 54 54 54 54");
        assertEquals(90, game.getGameScore());
    }

    @Test
    public void game_withNeitherStrikeNorSpare_isWellScored() {
        Bowling game = new Bowling("54 54 -4 54 -- 54 54 5- 54 54");
        assertEquals(72, game.getGameScore());
    }

    @Test
    public void game_withStrikeIn10turns_isWellScored() {
        Bowling game = new Bowling("x 54 54 54 54 54 54 54 54 54");
        assertEquals(100, game.getGameScore());
    }

    @Test
    public void game_withSpareIn0turns_isWellScored() {
        Bowling game = new Bowling("5/ 54 54 54 54 54 54 54 54 54");
        assertEquals(96, game.getGameScore());
    }

    @Test
    public void game_withSpareAndStrikesAndGuttersIn10turns_isWellScored() {
        Bowling game = new Bowling("5/ 54 54 x 54 54 54 -3 54 54");
        assertEquals(100, game.getGameScore());
    }

    @Test
    public void game_withStrikesIn10turns_isWellScored() {
        Bowling game = new Bowling("x x x x x x x x 54 54");
        assertEquals(242, game.getGameScore());
    }

    @Test
    public void game_withSparesIn10turns_isWellScored() {
        Bowling game = new Bowling("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 54");
        assertEquals(144, game.getGameScore());
    }

    @Test
    public void game_with2StrikesBonuses_isWellScored() {
        Bowling game = new Bowling("x x x x x x x x x x x x");
        assertEquals(300, game.getGameScore());
    }

    @Test
    public void game_with2Bonus_isWellScored() {
        Bowling game = new Bowling("x x x x x x x x x x 44");
        assertEquals(282, game.getGameScore());
    }

    @Test
    public void game_with1Bonus_isWellScored() {
        Bowling game = new Bowling("x x x x x x x x x 5/ 5");
        assertEquals(270, game.getGameScore());
    }
}
