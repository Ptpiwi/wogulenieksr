package pl.mowk.ksr.extractions;

import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.KeyWords;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MostCommonKeywordInPart {
    public String find (Article art) throws IOException {
        String[] allWords = art.getBody().split(" ");
        //String[] allWords = text.split(" ");
        KeyWords k = new KeyWords();
        List<String> kw = k.getKeyWords();
        ArrayList<String> kwInText = new ArrayList<>();
        for (int i = 0; i < allWords.length/10; i++) {
            for (String j : kw){
                if (allWords[i].contains(j)){
                    kwInText.add(allWords[i]);
                }
            }
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
