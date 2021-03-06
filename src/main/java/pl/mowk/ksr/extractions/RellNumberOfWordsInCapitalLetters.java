package pl.mowk.ksr.extractions;

import pl.mowk.ksr.data.Article;
import java.io.IOException;
import java.util.ArrayList;

public class RellNumberOfWordsInCapitalLetters {
    public static double calculate(Article art) {
        String[] allWords = art.getBody().split(" ");
        //String[] allWords = text.split(" ");
        ArrayList<String> currInText = new ArrayList<>();
        int sumCapital = 0;
        for (String i : allWords) {
            if (Character.isUpperCase(i.charAt(0)))
            {
                sumCapital++;
            }
        }
        double result = (sumCapital * 1.0) / allWords.length;
        return result;
    }
}
