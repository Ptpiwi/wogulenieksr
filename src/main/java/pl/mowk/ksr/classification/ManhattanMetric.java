package pl.mowk.ksr.classification;

import pl.mowk.ksr.extractions.ArticleFeatures;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class ManhattanMetric implements Metric {
    Ngram ngram;
    public ManhattanMetric(Ngram ngram){
        this.ngram=ngram;
    }

    public double calculateDistance(ArticleFeatures art1, ArticleFeatures art2) {
        double distance = 0;
        int size = art1.getNumberFeatures().size();
        for (int i = 0; i < size; i++) {
            distance += abs((art1.getNumberFeatures().get(i) - art2.getNumberFeatures().get(i)));
        }
        size = art1.getTextFeatures().size();
        for (int i = 0; i < size; i++) {
            distance += ngram.wordsDistance(art1.getTextFeatures().get(i), art2.getTextFeatures().get(i));
        }
        return distance;
    }


}
