import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class HangmanSimple {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);

        welcome();

        ArrayList<String> words = new ArrayList<>();
        // Initialize array list with provided words
        addWords(words); // this returns the array list
        // Answer = word for user to guess
        String answer = chooseRandomWord(words);
        String[] answersLetters = splitWordToLetters(answer);

        showWordLength(answer);

        // Show user their guess and # guess they have left
        int count = 0;
        userTakesGuess(count, answersLetters, answer, input);
    }

    public static void userTakesGuess(int count, String[] letters, String answer, Scanner input){
        while (count<6){

            System.out.println("Enter your letter or word guess: ");
            String guess = input.nextLine().toLowerCase();

            if (guess.equals(answer)){
                System.out.println("You've won! The word was " + answer);
            }
            String userString = "";

            for (int i=0; i<letters.length; i++) {
                if (guess.equalsIgnoreCase(letters[i])){
                    userString += letters[i];
                } else {
                    userString += " _ ";
                    count++;
                    System.out.println("You have guessed incorrectly " + count + "/6 times.");
                }
            }
            System.out.println("Your guess so far: " + userString);


        }
        System.out.println("Sorry, you have no more guesses left. The word was " + answer);
    }

    public static String[] splitWordToLetters(String answer){
        String[] letters = answer.split("");
        return letters;
    }

    public static void showWordLength(String answer){
        System.out.print("Here is the word I am thinking of: ");
        for (int i=0; i<answer.length(); i++){
            System.out.print(" " + "_");
        }
    }

    public static ArrayList addWords(ArrayList<String> words){
        words.add("tree");
        words.add("rain");
        words.add("bear");
        words.add("encourage");
        words.add("promise");
        words.add("soup");
        words.add("chess");
        words.add("insurance");
        words.add("pancakes");
        words.add("stream");
        return words;
    }

    public static String chooseRandomWord(ArrayList<String> words){
        Random rnd = new Random();
        return words.get(rnd.nextInt(words.size()));

    }

    public static void  welcome(){
        System.out.println("Welcome, Let's play hangman!");
    }

    public static void  exit(){
        System.out.println("Thank you for playing!");
    }

}