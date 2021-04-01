package pl.mowk.ksr.extractions;

import pl.mowk.ksr.data.Article;

import java.io.IOException;

public class OccurrencesOfTheFirstKeyword {
    public static double count(Article art) throws IOException {
        String firstKW;
        TheFirstKeyword first = new TheFirstKeyword();
        firstKW = first.find(art);
        String[] allWords = art.getBody().split(" ");
        int counter = 0;
        for (String i : allWords){
           if(i.contains(firstKW)) {
               counter++;
           }
        }
        return counter;
    }
}
