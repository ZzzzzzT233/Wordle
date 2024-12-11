package edu.virginia.cs.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private GameState testGame;

    private GameState testGame2;
    private LetterResult[] testGuessResult;


// 8 Tests for GameState class
    @Test
    public void testConstructorWithIllegalAnswer() {
        assertThrows(IllegalWordException.class,
                () -> new GameState("QZXYX"));
    }

    @Test
    public void testConstructorWithLegalAnswer() {
        assertDoesNotThrow(() -> new GameState("COMMA"));
    }

    @Test
    public void testWin() {
        testGame = new GameState("DEBUG");
        LetterResult[] r = testGame.submitGuess("debug");
        assertTrue(testGame.isWin());
        assertTrue(testGame.isGameOver());
    }

    @Test
    public void testLost() {
        testGame = new GameState("DEBUG");
        for (int i = 0; i < GameState.MAX_GUESSES; i++) {
            assertFalse(testGame.isWin());
            assertFalse(testGame.isGameOver());
            testGame.submitGuess("KNEAD");
        }
    }

    @Test
    public void testWinInTheSecondGuess() {
        testGame = new GameState("DEBUG");
        testGame.submitGuess("amber");
        testGame.submitGuess("debug");
        assertTrue(testGame.isWin());
        assertTrue(testGame.isGameOver());
    }

    @Test
    public void testWinInTheLastGuess() {
        testGame = new GameState("DEBUG");
        for (int i = 0; i < GameState.MAX_GUESSES - 1; i++) {
            testGame.submitGuess("Loyal");
        }
        testGame.submitGuess("debug");
        assertTrue(testGame.isWin());
        assertTrue(testGame.isGameOver());
    }

    @Test
    public void testGameAlreadyOverException() {
        testGame = new GameState("DEBUG");
        assertDoesNotThrow(() -> testGame.submitGuess("debug"));
        assertThrows(GameAlreadyOverException.class,
                () -> testGame.submitGuess("debug"));
    }

    @BeforeEach
    public void setup() {
        testGame = new GameState("COMMA");
    }

    @Test
    public void testsubmitGuess_PLAYING() {
        String validGuess = "APPLE";
        testGuessResult = testGame.submitGuess(validGuess);
        assertEquals(1,testGame.getGuessCount());
        //guess is not the answer and the game is not over.
        assertFalse(testGame.isWin());
        //guess again
        validGuess = "COMMA";
        testGuessResult = testGame.submitGuess(validGuess);
        assertEquals(2,testGame.getGuessCount());
        //the game is over and the player won.
        assertTrue(testGame.isWin());
    }

}