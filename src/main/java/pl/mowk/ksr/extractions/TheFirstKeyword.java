package pl.mowk.ksr.extractions;

import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.KeyWords;

import java.io.IOException;
import java.util.List;

public class TheFirstKeyword {
    public static String find(Article art) throws IOException {
        String first = null;
        KeyWords k = new KeyWords();
        List<String> kw = k.getKeyWords();
        String[] allWords = art.getBody().split(" ");
        for (String i : allWords){
            for(String j: kw){
                if(i.contains(j)) {
                    first = j;
                    break;
                }
            }
        }
        if(first == null){
            return "none";
        }
        return first;
    }
}
