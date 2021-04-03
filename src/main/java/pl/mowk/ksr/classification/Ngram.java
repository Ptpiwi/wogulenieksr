package pl.mowk.ksr.classification;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Ngram {

    private int numberOfGrams = 3;

    public Ngram(int numberOfGrams) {
        this.numberOfGrams = numberOfGrams;
    }

    public double wordsDistance(String s1, String s2) {
        double tmp = wordsSimlarity(s1, s2);
        if (tmp == 0) return Double.POSITIVE_INFINITY;
        else return 1 / tmp;
    }

    //todo what if the lenght of text is shorter than number of grams
    public double wordsSimlarity(String s1, String s2) {
        List<String> ngrams = new ArrayList<>();
        if (s1.equals("") || s2.equals("")) return 0;
        int h = 0;
        for (int i = 0; i < s1.length() - numberOfGrams + 1; i++)
            ngrams.add(s1.substring(i, i + numberOfGrams));
        for (String gram : ngrams
        ) {
            if (s2.contains(gram)) h++;
        }
        if (s1.length() > s2.length()) return 1 - s1.length() - numberOfGrams + 1;
        else return 1 - s2.length() - numberOfGrams + 1;


    }

}
