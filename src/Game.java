import java.util.Scanner;

public class Game {

    // declaring variables
    private boolean gameWon;
    private int lostPoints;
    private String movieToGuess;
    private String wrongChar;
    private String guessedChar;

    // declaring constructor
    public Game(String chosenMovie) {
        movieToGuess = chosenMovie;
        lostPoints = 0;
        guessedChar = "";
        wrongChar = "";
        gameWon = false;
    }


    // Method that converts letters to underscore
    public String replacer() {
        if (guessedChar.equals("")) {
            return movieToGuess.replaceAll("[a-zA-Z]", "_");
        } else {
            return movieToGuess.replaceAll("[a-zA-Z&&[^" + guessedChar + "]]", "_");
        }
    }

    // Reading user input and searching for it in the title
    private String inputLetter() {

        System.out.println("Guess a letter:");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();

        if (!letter.matches("[a-z]")) {
            System.out.println("Wrong input.");
            return inputLetter();
        } else if (wrongChar.contains(letter) || guessedChar.contains(letter)) {
            System.out.println("This letter was already guessed.");
            return inputLetter();
        } else {
            return letter;
        }
    }

    // Method for guessing
    public void guessLetter() {

        String guessedLetter = inputLetter();
        // Keeping track of wrong letters and guesse
        if (movieToGuess.toLowerCase().contains(guessedLetter)) {
            guessedChar += guessedLetter + guessedLetter.toUpperCase();
        } else {
            lostPoints++;
            wrongChar += " " + guessedLetter;
        }
    }

    // Method to show wrong letters
    public String getWrongChar() {
        return wrongChar;
    }

    // Method to check if the game is won
    public boolean WinGame() {
        return gameWon;
    }

    // Method to check if the game has ended
    public boolean gameEnd() {
        if (lostPoints >= 10) {
            return true;
        }

        if (!replacer().contains("_")) {
            gameWon = true;
            return true;
        }
        return false;
    }


}
