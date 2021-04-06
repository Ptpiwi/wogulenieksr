package pl.mowk.ksr.classification;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Ngram {

    private int numberOfGrams = 3;
    private boolean normalize;

    public Ngram(int numberOfGrams, boolean normalize) {
        this.numberOfGrams = numberOfGrams;
        this.normalize = normalize;
    }

    //todo what if the lenght of text is shorter than number of grams
    public double wordsDistance(String s1, String s2) {
        int tempGrams = numberOfGrams;
        List<String> ngrams = new ArrayList<String>();
        if (s1.equals("") || s2.equals("")) return 1;
        if (s1.length()<tempGrams) tempGrams= s1.length();
        if (s2.length()<tempGrams) tempGrams= s2.length();
        int h = 0;
        for (int i = 0; i < s1.length() - tempGrams + 1; i++)
            ngrams.add(s1.substring(i, i + tempGrams));
        for (String gram : ngrams
        ) {
            if (s2.contains(gram)) h++;
        }
        if (normalize) {
            if (s1.length() > s2.length()) {
                return (1.0 - ((double) h / (double) (s1.length() - tempGrams + 1)));
            }
            else {
                return (1.0 - ((double) h / (double) (s2.length() - tempGrams + 1)));
            }
        }
        else if (s1.length() > s2.length()){
            return ((double) (s1.length() - tempGrams + 1) / (double) h);
        }
        else {
            return ((double) (s2.length() - tempGrams + 1) / (double) h);
        }
    }

}
