package edu.virginia.cs.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessResultTest {

    private GuessResult testGuessResult;

    @BeforeEach
    public void setupTestResult() {
        testGuessResult = new GuessResult();
    }

    @Test
    @DisplayName("GuessResult constructor verification.")
    public void testThrowsErrorOnUninitializedFields() {
        assertNull(testGuessResult.getGuess());
        assertNull(testGuessResult.getAnswer());
        assertThrows(IllegalStateException.class, () ->
                testGuessResult.getGuessResult());
    }

    @Test
    @DisplayName("Correct answer Guess Result Test")
    public void testLetterResultCorrectAnswer() {
        givenInputGuessAndAnswer("MATCH", "MATCH");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("GGGGG", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ All g")
    public void testLetterResultWrongAnswer() {
        givenInputGuessAndAnswer("DBKYX", "MATCH");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("ggggg", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ ALL Y")
    public void testLetterResultAnswer_AllY() {
        givenInputGuessAndAnswer("ATCHM", "MATCH");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("YYYYY", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test_ 1g4Y")
    public void testLetterResultAnswer_1g4Y() {
        givenInputGuessAndAnswer("ATCHK", "MATCH");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("YYYYg", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ 1g4G")
    public void testLetterResultAnswer_1g4G() {
        givenInputGuessAndAnswer("MATCK", "MATCH");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("GGGGg", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ 2y3G")
    public void testLetterResultAnswer_2y3G() {
        givenInputGuessAndAnswer("MATHC", "MATCH");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("GGGYY", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ 2y1G2g")
    public void testLetterResultAnswer_2y1G2g() {
        givenInputGuessAndAnswer("MBKHC", "MATCH");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("GggYY", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ All g with 2 repeated")
    public void testLetterResultAnswer_gwith2r() {
        givenInputGuessAndAnswer("GKNRF", "APPLE");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("ggggg", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ All y with 2 repeated")
    public void testLetterResultAnswer_ywith2r() {
        givenInputGuessAndAnswer("PALEP", "APPLE");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("YYYYY", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ All G with 2 repeated")
    public void testLetterResultAnswer_Gwith2r() {
        givenInputGuessAndAnswer("APPLE", "APPLE");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("GGGGG", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ 3G2Y with 2 repeated")
    public void testLetterResultAnswer_3G2Ywith2r() {
        givenInputGuessAndAnswer("APPEL", "APPLE");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("GGGYY", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ 3g2Y with 2 repeated")
    public void testLetterResultAnswer_3g2Ywith2r() {
        givenInputGuessAndAnswer("KNNEL", "APPLE");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("gggYY", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ 3g2G with 2 repeated")
    public void testLetterResultAnswer_3g2Gwith2r() {
        givenInputGuessAndAnswer("JPPKN", "APPLE");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("gGGgg", getLetterResultArrayAsString(guessResult));
    }


    @Test
    @DisplayName("Wrong answer Guess Result Test _ All g with 3 repeated")
    public void testLetterResultAnswer_gwith3r() {
        givenInputGuessAndAnswer("LKNPI", "ERROR");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("ggggg", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ All G with 3 repeated")
    public void testLetterResultAnswer_4Y1Gwith3r() {
        givenInputGuessAndAnswer("RERRO", "ERROR");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("YYGYY", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ AllG with 3 repeated")
    public void testLetterResultAnswer_Gwith3r() {
        givenInputGuessAndAnswer("ERROR", "ERROR");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("GGGGG", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Wrong answer Guess Result Test _ AllG with 3 repeated")
    public void testLetterResultAnswer_3g2Ywith3r() {
        givenInputGuessAndAnswer("KNPRO", "ERROR");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("gggYY", getLetterResultArrayAsString(guessResult));
    }
    @Test
    @DisplayName("Wrong answer Guess Result Test _ AllG with 3 repeated")
    public void testLetterResultAnswer_2g1G2Ywith3r() {
        givenInputGuessAndAnswer("KNRRO", "ERROR");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("ggGYY", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Edge Case_ size less than 5")
    public void testLetterResultAnswer_SizeLessThan5() {
        assertThrows(IllegalStateException.class, () ->
                givenInputGuessAndAnswer("KNR", "ERROR"));
    }

    @Test
    @DisplayName("Edge Case_ size more than 5")
    public void testLetterResultAnswer_SizeMoreThan5() {
        assertThrows(IllegalStateException.class, () ->
                givenInputGuessAndAnswer("KNRKKKL", "ERROR"));
    }

    @Test
    @DisplayName("Edge Case_ Guess not String")
    public void testLetterResultAnswer_GuessNotString() {
        assertThrows(IllegalStateException.class, () ->
                givenInputGuessAndAnswer("12345", "ERROR"));
    }








    private void givenInputGuessAndAnswer(String guess, String answer) {
        testGuessResult.setGuess(guess);
        testGuessResult.setAnswer(answer);
    }

    @Test
    @DisplayName("Helper function that converts the LetterResult[] in String for ease of use")
    public void testGetLetterResultArrayAsString() {
        LetterResult[] testArray = {LetterResult.GREEN, LetterResult.GRAY, LetterResult.YELLOW,LetterResult.GREEN, LetterResult.YELLOW};
        assertEquals("GgYGY", getLetterResultArrayAsString(testArray));
    }

    private String getLetterResultArrayAsString(LetterResult[] letterResultArray) {
        StringBuilder builder = new StringBuilder(5);
        for (LetterResult letterResult : letterResultArray) {
            char letterResultCharacter = getCharacterForLetterResult(letterResult);
            builder.append(letterResultCharacter);
        }
        return builder.toString();
    }

    @Test
    @DisplayName("LetterResult.Green -> `G`")
    public void testGetCharacterForLetterResult_Green() {
        assertEquals('G', getCharacterForLetterResult(LetterResult.GREEN));
    }

    @Test
    @DisplayName("LetterResult.Yellow -> `Y`")
    public void testGetCharacterForLetterResult_Yellow() {
        assertEquals('Y', getCharacterForLetterResult(LetterResult.YELLOW));
    }

    @Test
    @DisplayName("LetterResult.Gray -> `Y`")
    public void testGetCharacterForLetterResult_Gray() {
        assertEquals('g', getCharacterForLetterResult(LetterResult.GRAY));
    }

    private static char getCharacterForLetterResult(LetterResult letterResult) {
        return switch(letterResult) {
            case GRAY -> 'g';
            case GREEN -> 'G';
            case YELLOW -> 'Y';
        };
    }

}