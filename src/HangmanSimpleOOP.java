import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HangmanSimpleOOP {
    private ArrayList<String> list;
    private String word;
    private String[] letters;
    private String guess;
    private ArrayList<String> pastGuesses;
    private int numWrongAttempts;
    private boolean correct;
    private String[] userProgress;
    private int maxWrongGuesses;
    private int lettersGuessed; // number of letters guessed correctly

    public HangmanSimpleOOP(){
        list = new ArrayList<>();
        word = "";
        guess = "";
        pastGuesses = new ArrayList<>();
        numWrongAttempts = 0;
        maxWrongGuesses = 0;
        lettersGuessed = 0;
    }

    public void setList(){
        Collections.addAll(list, "tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance", "pancakes", "stream");
    }

    public ArrayList<String> getList(){
        return list;
    }

    public void setWord(String word){
        this.word = word;
    }

    public String getWord(){
        return word;
    }

    public void setLetters(){
        this.letters = word.split("");
    }

    public String[] getLetters(){
        return letters;
    }

    public void setGuess(String guess){
        this.guess = guess;
    }

    public String getGuess(){
        return guess;
    }

    public void setPastGuesses(){
           pastGuesses.add(guess);
    }

    public ArrayList<String> getPastGuesses(){
        return pastGuesses;
    }

    public void setNumWrongAttempts(){
        if (!correct){
            numWrongAttempts++;
        }
    }

    public int getNumWrongAttempts(){
        return numWrongAttempts;
    }

    public void setCorrect(boolean correct){
        this.correct = correct;
    }

    public boolean getCorrect(){
        return correct;
    }

    // Fill the initial array with blanks so we can replace with letter as we go
    public void setUserProgress(){
        userProgress = new String[word.length()];
        for (int i = 0; i< word.length(); i++){
            userProgress[i] = "_ ";
        }
    }

    public String[] getUserProgress(){
        return userProgress;
    }

    public void setMaxWrongGuesses(int maxWrongGuesses){
        this.maxWrongGuesses =  maxWrongGuesses;
    }

    public int getMaxWrongGuesses() {
        return maxWrongGuesses;
    }

    public void setLettersGuessed(){
        lettersGuessed++;
    }

    public int getLettersGuessed(){
        return lettersGuessed;
    }

    public void pickRandom(){
        Random rnd = new Random();
        int rndIndex = rnd.nextInt(list.size());
        word = list.get(rndIndex);
    }

    public String displayWordLength(){
        String str = "";
        for (int i = 0; i< word.length(); i++){
            str += "_ ";
        }
        return "Here is the word I am thinking of: " + str;
    }

    public String welcomeMessage(){
        return "Welcome, let's play hangman!";
    }

    public String exitMessage(boolean userWins){
        String thanks = "Thank you for playing!";
        if (userWins){
            return "You've won! The word was " + word + ".\n"
                    + thanks;
        } else {
            // come back to this part
            return "Sorry, you have no more guesses left. The word was " + word + ".\n"
                    + "\n" + thanks;
        }

    }

    public void updateUserProgress(){
        for (int i = 0; i < letters.length; i++){
            if (guess.equals(letters[i])){
                userProgress[i] = " " + guess + " ";
                setCorrect(true);
                // increment letters guessed correctly by one
                setLettersGuessed();

            }
        }
    }

}
