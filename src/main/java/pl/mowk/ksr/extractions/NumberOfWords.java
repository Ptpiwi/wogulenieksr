package pl.mowk.ksr.extractions;

import pl.mowk.ksr.data.Article;

public class NumberOfWords {
    static public double count(Article art){
        String[] allWords = art.getBody().split(" ");
        int wordCount = 0;
        for (String i : allWords){
            wordCount++;
        }
        return wordCount;
    }
}

