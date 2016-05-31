package com.epam.engx.drills.bowling;

/**
 * @author Nurmakanov on 16.04.2016.
 */
public class Game {
    public static final int MAX_SCORE = 10;
    private final int[] rolls = new int[21];
    private int rollIndex = 0;

    public void roll(int pins) {
        rolls[rollIndex] = pins;
        rollIndex++;
    }

    public int score() {
        int score = 0;
        int roll = 0;
        for (int i = 0; i < 10; i++) {
            if (isStrike(rolls[roll])) {
                score = calculateStrike(score, roll);
                roll++;
            } else if (isSpareInFrame(roll)) {
                score = calculateSpare(score, roll);
                roll += 2;
            } else {
                score += rolls[roll] + rolls[roll + 1];
                roll += 2;
            }

        }
        return score;
    }

    private int calculateStrike(int score, int roll) {
        score += 10 + rolls[roll + 1] + rolls[roll + 2];
        return score;
    }

    private boolean isStrike(int roll) {
        return roll == MAX_SCORE;
    }

    private boolean isSpareInFrame(int roll) {
        return rolls[roll] + rolls[roll + 1] == MAX_SCORE;
    }

    private int calculateSpare(int score, int roll) {
        score += MAX_SCORE + rolls[roll + 2];
        return score;
    }
}
