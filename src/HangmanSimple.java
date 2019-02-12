import java.util.*;

public class HangmanSimple {
    private static int count;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        HangmanSimple.count = count;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);

        welcome();

        // Initialize array list
        ArrayList<String> list = new ArrayList<>();
        String answer = "";
        String[] letters;

        // Add words to array list and return it
        addWords(list);

        // Choose a random answer and split it into letters
        answer = chooseRandomWord(list);
        letters = split(answer);

        // Show user the answer length
        showWordLength(answer);
        System.out.println();

        // Show user their guess and # guess they have left
        int count = 0;
        userTakesGuess(count, letters, answer, input);

        exit();
    }


    public static void userTakesGuess(int count, String[] letters, String answer, Scanner input){
        /*
        * Create an array and Fill it with blank underscores
        * */
        String[] userProgress = new String[answer.length()];
        for (int i=0; i<answer.length(); i++){
            userProgress[i] = " _ ";
        }

        /*
        * Create an array list to store all guesses
        * */
        ArrayList<String> pastGuesses = new ArrayList<>();

        int maxWrongGuesses = 6;
//        boolean keepGuessing = true;

        while ((count < maxWrongGuesses)){
            boolean correct = false;

            System.out.println("Enter your letter or answer guess: ");
            String guess = input.nextLine().toLowerCase();

//            if (userProgress.length==answer.length()){
//                break;
//            }

            if (!pastGuesses.contains(guess)){
                pastGuesses.add(guess);
            } else {
                System.out.println("You already guessed that letter. Please try a different one:");
                continue;
            }

            if (guess.equals(answer)){
                System.out.println("You've won! The answer was " + answer);
                break;
            }

            System.out.print("Your guess so far: ");
            for (int i=0; i<letters.length; i++) {  // Iterates as many times as the length of the answer
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
                System.out.println("Sorry, you have no more guesses left. The answer was " + answer);
                break;
            }

//            if (keepGuessing(userProgress, answer)==false){
//                break;
//            }

        }

    }

    public static boolean keepGuessing(String[] userProgress, String word){
        String str = "";
        for (String u:userProgress){
            str.join(" ", u);
        }

        if (str.length()==word.length()){
            return false;
        } else {
            return true;
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
        Collections.addAll(words, "tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance", "pancakes", "stream");
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
