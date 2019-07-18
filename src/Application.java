import java.util.Scanner;
import java.io.File;

public class Application {

    public static void main(String[] args) throws Exception{

        // GETTING RANDOM MOVIE FROM THE FILE

        // declaring variables
        String movies = "";
        String chosenMovie = "";
        int size = 0;
        int randomMovie= 0;
        File file = new File("movielist.txt");
        Scanner scanner = new Scanner(file);

        // Checking how many movies are in the file
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            movies += line + "\n";
            size++;
        }
        // TEST : Printing number of movies
        //System.out.println("There are " + size + " movies in the pool.");

        // Randomly pick one movie
        randomMovie = (int) (Math.random()* size);
        // TEST: Printing randomly picked number
        //System.out.println(randomMovie);

        // getting the title
        File file2 = new File("movielist.txt");
        Scanner scanner2 = new Scanner(file2);

        int i = 0;
        while (i <= randomMovie){
            chosenMovie = scanner2.nextLine();
            i++;
        }

        //TEST: Check the title of randomly picked movie
        //System.out.println(chosenMovie);


        // Creating a game object with chosen Movie
        Game game = new Game(chosenMovie);

        System.out.println("Guess the Movie");

        while(!game.gameEnd()){
            System.out.println("You are guessing: " + game.replacer());
            System.out.println("You have guessed (" + game.getWrongChar().length()/2 + ") wrong letters:"  + game.getWrongChar());
            game.guessLetter();
        }
        if(game.WinGame()){
            System.out.println("You win.");
            System.out.println("You guessed " + chosenMovie + " correctly!!");
        }
        else{
            System.out.println("You have guessed (" + game.getWrongChar().length()/2 + ") wrong letters:" + game.getWrongChar());
            System.out.println("You lost.");
            System.out.println("The movie title You tried to guess was " + chosenMovie);
        }
    }
}