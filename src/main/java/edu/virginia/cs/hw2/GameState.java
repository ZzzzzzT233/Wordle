package edu.virginia.cs.hw2;

public class GameState {

    public static final int MAX_GUESSES = 6;
    private String answer;
    private int guessCount;
    private GameStatus gameStatus;
    private WordleDictionary legalGuessDictionary;


    protected GameState(String answer, WordleDictionary dictionary, int guessCount, GameStatus status) {
        this.answer = answer.toUpperCase();
        this.legalGuessDictionary = dictionary;
        this.guessCount = guessCount;
        this.gameStatus = status;
        if (0 == legalGuessDictionary.getDictionarySize()) {
            throw new EmptyDictionaryException("Error: Cannot play Wordle with an Empty Dictionary");
        }
        if (!legalGuessDictionary.containsWord(answer)) {
            throw new IllegalWordException(
                    "Created a game with an illegal answer not found in the dictionary: " + answer);
        }
    }

    public GameState(String answer, WordleDictionary dictionary) {
        this(answer, dictionary, 0, GameStatus.PLAYING);
    }

    public GameState(String answer) {
        this(answer, getDefaultGuessesDictionary(), 0, GameStatus.PLAYING);
    }

    private static WordleDictionary getDefaultGuessesDictionary() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        return factory.getDefaultGuessesDictionary();
    }

    public GameState() {
        this(getRandomAnswerFromDefaultDictionary(), getDefaultGuessesDictionary(), 0, GameStatus.PLAYING);
    }

    private static String getRandomAnswerFromDefaultDictionary() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        WordleDictionary answersDictionary = factory.getDefaultAnswersDictionary();
        return answersDictionary.getRandomWord();
    }

    public boolean isGameOver() {
        return GameStatus.PLAYING != gameStatus;
    }

    public boolean isWin() {
        return GameStatus.WON == gameStatus;
    }

    public boolean isLoss() {
        return GameStatus.LOST == gameStatus;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public int getRemainingGuesses() {
        return MAX_GUESSES - guessCount;
    }

    public String getAnswer() {
        return answer;
    }

    public LetterResult[] submitGuess(String guess) {
        GuessResult guessResult = new GuessResult();
        guessResult.setGuess(guess);
        guessResult.setAnswer(answer);

        //TODO: Stub - Implement method with TDD - tests must go in GameTest.java
        guessCount++;
        //If the guess is not a legal word, then the game is over.
        if(!legalGuessDictionary.containsWord(guess)){
            throw new IllegalWordException("Error: The word is not in the dictionary.");
        }
        if (isGameOver()) {
            throw new GameAlreadyOverException("Error: Game is already over");
        }
        if (guessResult.getGuess().equals(guessResult.getAnswer())) {
            gameStatus = GameStatus.WON;
        }
        else {
            if (guessCount == MAX_GUESSES) {
                gameStatus = GameStatus.LOST;
            }
        }
        return guessResult.getGuessResult();
    }

    protected enum GameStatus {
        PLAYING, WON, LOST;
    }

}
