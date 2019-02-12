import java.util.Scanner;

public class HangmanSimpleDriver {
    public static void main(String[]args){
        // Call constructor of new class
        HangmanSimpleOOP hangman = new HangmanSimpleOOP();
        Scanner input = new Scanner(System.in);
        // Display welcome message
        System.out.println(hangman.welcomeMessage());
        // Add words to list
        hangman.setList();
        // Choose a random word from list and split
        hangman.pickRandom();
        hangman.setLetters();
        // Display chosen word's length
        System.out.println(hangman.displayWordLength());
        // Show user their guess and # of chances they have left
        userTakesGuess(hangman, input);
    }

    public static void  userTakesGuess(HangmanSimpleOOP hangman, Scanner input){
        hangman.setMaxWrongGuesses(6);
        hangman.setUserProgress();  // initialize only once

        while (hangman.getNumWrongAttempts() < hangman.getMaxWrongGuesses()){
            hangman.setCorrect(false);
            System.out.println("Enter your letter or word guess");
            hangman.setGuess(input.nextLine().toLowerCase());

            if (!hangman.getPastGuesses().contains(hangman.getGuess())){
                hangman.setPastGuesses();
            } else {
                System.out.println("You already guessed that letter. Please try a different one.");
                continue;
            }
            if (hangman.getGuess().equals(hangman.getWord())){
                System.out.println(hangman.exitMessage(true));
                break;
            }

            System.out.println("Your guess so far: ");
            hangman.updateUserProgress();
            for (int i = 0; i < hangman.getUserProgress().length; i++){
                System.out.print(hangman.getUserProgress()[i]);
            }

            if (hangman.getLettersGuessed()==hangman.getLetters().length){
                System.out.println("\n" + hangman.exitMessage(true));
                break;
            }
            hangman.setNumWrongAttempts();
            System.out.println();
            if (!hangman.getCorrect()){
                System.out.println("You have guessed incorrectly " + hangman.getNumWrongAttempts() + "/6 times.");
            }
            if (hangman.getNumWrongAttempts()==hangman.getMaxWrongGuesses()){
                System.out.println(hangman.exitMessage(false));
                break;
            }

        }
    }
}
