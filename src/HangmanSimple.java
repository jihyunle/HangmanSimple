import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class HangmanSimple {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);

        welcome();

        // Initialize array list
        ArrayList<String> list = new ArrayList<>();

        // Add words to array list and return it
        addWords(list);

        // Choose a random word and split into letters
        String word = chooseRandomWord(list);
        String[] letters = split(word);

        // Show user the word length
        showWordLength(word);
        System.out.println();

        // Show user their guess and # guess they have left
        int count = 0;
        userTakesGuess(count, letters, word, input);

        exit();
    }


    public static void userTakesGuess(int count, String[] letters, String word, Scanner input){
        /*
        * Create an array and Fill it with blank underscores
        * */
        String[] userProgress = new String[word.length()];
        for (int i=0; i<word.length(); i++){
            userProgress[i] = " _ ";
        }

        /*
        * Create an array list to store all guesses
        * */
        ArrayList<String> pastGuesses = new ArrayList<>();

        int maxWrongGuesses = 6;
        boolean keepGuessing = true;

        while ((count < maxWrongGuesses) && keepGuessing){
            boolean correct = false;


            System.out.println("Enter your letter or word guess: ");
            String guess = input.nextLine().toLowerCase();
            if (!pastGuesses.contains(guess)){
                pastGuesses.add(guess);
            } else {
                System.out.println("You already guessed that letter. Please try a different one:");
                continue;
            }


            if (guess.equals(word)){
                System.out.println("You've won! The word was " + word);
                break;
            }

            System.out.print("Your guess so far: ");
            for (int i=0; i<letters.length; i++) {  // Iterates as many times as the length of the word
                if (guess.equals(letters[i])){
                    userProgress[i] = " " + guess + " ";
                    correct = true;
                }
            }
            count = check(correct, count);


//            System.out.println(pastGuesses);

            for (int i=0; i<userProgress.length;i++){
                System.out.print(userProgress[i]);
            }

            System.out.println();
            if (!correct){
                System.out.println("You have guessed incorrectly " + count + "/6 times.");
            }

            if (count==maxWrongGuesses){
                System.out.println("Sorry, you have no more guesses left. The word was " + word);
                break;
            }

            if (!keepGuessing(userProgress, keepGuessing, word)){
                keepGuessing = !keepGuessing;
//                break;
            }

        }

    }

    public static boolean keepGuessing(String[] userProgress, boolean keepGuessing, String word){
        String str = "";
        for (String u:userProgress){
            str += u;
        }

        str = "";
        String[]arr = str.split("");
        for (int i=0; i<arr.length; i++){
            if (arr[i]!=" "){
                str += arr[i];
            }
        }

        if (str==word){
            return !keepGuessing;
        } else {
            return keepGuessing;
        }
    }

    public static int check(boolean correct, int count){
        if (!correct){
            count++;
        }
        return count;
    }


    public static String[] split(String answer){
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

    public static void welcome(){
        System.out.println("Welcome, Let's play hangman!");
    }

    public static void exit(){
        System.out.println("Thank you for playing!");
        System.exit(0);
    }
}
