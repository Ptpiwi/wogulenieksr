package pl.mowk.ksr.extractions;

import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.KeyWords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//todo cos jest nie ten teges

public class RelNumberOfOccurrencesKeywords {
    public static double calculate(Article art) throws IOException {
        int numberofkw = 0;
        String[] allWords = art.getBody().toLowerCase().split(" ");
        KeyWords k = new KeyWords();
        List<String> kw = k.getKeyWords();
        for (int i = 0; i < allWords.length/10; i++) {
            for (String j : kw){
                if (allWords[i].contains(j)){
                    numberofkw++;
                }
            }
        }
        if(numberofkw == 0){
            return 0;
        }
        double result = (numberofkw * 1.0) / ((double) allWords.length/10);
        return result;
    }
}
