package com.epam.engx.drills.bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Nurmakanov
 */
public class GameTest {
    private final Game game = new Game();

    @Test
    public void rollingZeroEachRollShouldHaveZeroScore() {
        //GIVEN
        int rolls = 20;
        int pins = 0;
        int expectedScore = 0;
        //WHEN
        rollNTimes(rolls, pins);
        //THEN
        assertThat(game.score(), is(expectedScore));
    }

    @Test
    public void rollingOneEachRoleShouldHaveTwentyScore() {
        //GIVEN
        int rolls = 20;
        int pins = 1;
        int expectedScore = 20;
        //WHEN
        rollNTimes(rolls, pins);
        //THEN
        assertThat(game.score(), is(expectedScore));
    }

    @Test
    public void rollingSpareShouldDoubleRollAfterSpare() {
        //GIVEN
        int expectedScore = 18;
        //WHEN
        game.roll(4);
        game.roll(6);//spare
        game.roll(4);
        rollNTimes(17, 0);
        //THEN
        assertThat(game.score(), is(expectedScore));
    }

    @Test
    public void rollingSpareInDifferentFramesShouldNotDoubleNextRollAfterWrongSpare() {
        //GIVEN
        int expectedScore = 18;
        //WHEN
        game.roll(2);
        game.roll(7);//not spare
        game.roll(3);//wrong spare
        game.roll(6);
        rollNTimes(16, 0);
        //THEN
        assertThat(game.score(), is(expectedScore));
    }

    @Test
    public void rollingStrikeShouldDoubleNextFrame() {
        //GIVEN
        int expectedScore = 26;
        //WHEN
        rollStrike();
        game.roll(2);
        game.roll(6);
        rollNTimes(16, 0);
        //THEN
        assertThat(game.score(), is(expectedScore));
    }

    @Test
    public void perfectGame() {
        rollNTimes(12, 10);

        assertThat(game.score(), is(300));
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollNTimes(int times, int pins) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }
}
