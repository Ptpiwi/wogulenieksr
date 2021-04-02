package pl.mowk.ksr.extractions;

import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.KeyWords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonKeyword {
    public static String find (Article art) throws IOException {
        String[] allWords = art.getBody().split(" ");
        //String[] allWords = text.split(" ");
        KeyWords k = new KeyWords();
        List<String> kw = k.getKeyWords();
        ArrayList<String> kwInText = new ArrayList<>();
        for (String i : allWords) {
            for (String j : kw) {
                if (i.equals(j)) {
                    kwInText.add(j);
                }
            }
        }
        if(kwInText.size() == 0){
            return "none";
        }
        ArrayList<KeyWords> single = new ArrayList<>();
        int j = 0;
        for (String a : kwInText) {
            int i = 0;
            for (String b : kwInText) {
                if (a.equals(b)) {
                    i++;
                }
            }
            single.add(new KeyWords(a, i));
        }
        KeyWords pom = new KeyWords("", 0);
        for (KeyWords i : single) {
            if (i.getQuantity() > pom.getQuantity()) {
                pom = i;
            }
        }
        return pom.getWord();
    }
}

