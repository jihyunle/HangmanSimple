import java.util.ArrayList;
import java.util.Collections;

public class HangmanSimpleOOP {
    private ArrayList<String> list;
    private String answer;
    private String[] answersLetters;
    private String guess;
    private ArrayList<String> pastGuesses;
    private int numWrongAttempts;
    private boolean correct;
    private String[] userProgress;

    public HangmanSimpleOOP(){
        list = new ArrayList<>();
        answer = "";
        guess = "";
        pastGuesses = new ArrayList<>();
        numWrongAttempts = 0;
    }

    public void setList(){
        Collections.addAll(list, "tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance", "pancakes", "stream");
    }

    public ArrayList<String> getList(){
        return list;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswersLetters(){
        this.answersLetters = answer.split("");
    }

    public String[] getAnswersLetters(){
        return answersLetters;
    }

    public void setGuess(String guess){
        this.guess = guess;
    }

    public String getGuess(){
        return guess;
    }

    public void setPastGuesses(ArrayList<String> pastGuesses){
       this.pastGuesses = pastGuesses;
    }

    public ArrayList<String> getPastGuesses(){
        return pastGuesses;
    }

    public void setNumWrongAttempts(int numWrongAttempts){
        this.numWrongAttempts = numWrongAttempts;
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
        userProgress = new String[answer.length()];
        for (int i=0; i<answer.length(); i++){
            userProgress[i] = " _ ";
        }
    }

    public String[] getUserProgress(){
        return userProgress;
    }

    public String pickRandom(){
        int rndIndex = 1 + (int)Math.random()*(list.size());
        answer = list.get(rndIndex);
        return answer;
    }

    public String displayWordLength(){
        String str = "";
        for (int i=0; i<answer.length(); i++){
            str.concat("_" + " ");
        }
        return "Here is the word I am thinking of: " + str;
    }

    public String welcomeMessage(){
        return "Welcome, let's play hangman!";
    }

    public String exitMessage(boolean userWins){
        String thanks = "Thank you for playing!";
        if (userWins){
            return "You've won! The word was " + answer + ".\n"
                    + thanks;
        } else {
            // come back to this part
            return "Sorry, you have no more guesses left. The word was " + answer + ".\n"
                    + "\n" + thanks;
        }

    }

    public void check(){
        if (!correct){
            numWrongAttempts++;
        }
    }

}
