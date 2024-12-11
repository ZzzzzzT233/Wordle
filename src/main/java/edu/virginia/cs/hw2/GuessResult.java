package edu.virginia.cs.hw2;

import java.util.Arrays;

public class GuessResult {
    public static final int GUESS_RESULT_ARRAY_SIZE = 5;
    private final LetterResult[] guessResult =
            {LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY};
    private String answer; //always uppercase
    private String guess; //always uppercase

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        verifyInput(answer.toUpperCase());
        this.answer = answer.toUpperCase();
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        verifyInput(guess.toUpperCase());
        this.guess = guess.toUpperCase();
    }

    public LetterResult[] getGuessResult() {
        verifyAllFieldsAreInitialized();
        if (guess.equals(answer)) {
            return getCorrectAnswerArray();
        }
        AddgtoGuessResult();
        AddYtoGuessResult();
        AddGtoGuessResult();

        return guessResult;
    }

    private void verifyInput(String input){
        if(input.length() != 5 ){
            throw new IllegalStateException("Wrong guessing word/ answer word size");
        }
        for (int i = 0; i < 5; i++) {
            char ch = input.charAt(i);
            if (ch < 'A') {
                throw new IllegalStateException("Input Word should be a string");
            } else if (ch > 'Z') {
                throw new IllegalStateException("Input Word should be a string");
            }
        }
    }

    private LetterResult[] AddYtoGuessResult(){
        for (int i = 0; i < 5; i++) {
            if (answer.indexOf(guess.charAt(i)) != i & answer.indexOf(guess.charAt(i)) != -1){
                guessResult[i] = LetterResult.YELLOW;
            }
        }
        return guessResult;
    }

    private LetterResult[] AddgtoGuessResult(){
        for(int i = 0; i < 5; i++){
            if(answer.indexOf(guess.charAt(i)) == -1){
                guessResult[i] = LetterResult.GRAY;
            }
        }
        return guessResult;
    }

    private LetterResult[] AddGtoGuessResult(){
        for(int i = 0; i < 5; i++){
            if(answer.charAt(i) == guess.charAt(i)){
                guessResult[i] = LetterResult.GREEN;
            }
        }
        return guessResult;
    }

    private void verifyAllFieldsAreInitialized() {
        if (guess == null) {
            throw new IllegalStateException("The guess field in GuessResult must be initialized before calling getGuessResult");
        }
        if (answer == null) {
            throw new IllegalStateException("The guess field in GuessResult must be initialized before calling getGuessResult");
        }
    }

    private LetterResult[] getCorrectAnswerArray() {
        fillGuessResultArrayWithOneColor(LetterResult.GREEN);
        return guessResult;
    }

    private void fillGuessResultArrayWithOneColor(LetterResult letterResult) {
        Arrays.fill(guessResult, letterResult);
    }


}
