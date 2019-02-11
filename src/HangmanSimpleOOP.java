import java.util.ArrayList;
import java.util.Collections;

public class HangmanSimpleOOP {
    private ArrayList<String> list;
    private String answer;
    private String[] answersLetters;

    public HangmanSimpleOOP(){
        list = new ArrayList<>();
        answer = "";
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
        this.answersLetters = answer.split("");;
    }

    public String[] getAnswersLetters(){
        return answersLetters;
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

}
