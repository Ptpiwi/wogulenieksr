package pl.mowk.ksr.classification;

import pl.mowk.ksr.extractions.ArticleFeatures;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class EuclideanMetric implements Metric {
    Ngram ngram;

    public EuclideanMetric(Ngram ngram) {
        this.ngram = ngram;
    }

    public double calculateDistance(ArticleFeatures art1, ArticleFeatures art2) {
        double distance = 0;
        int size = art1.getNumberFeatures().size();
        for (int i = 0; i < size; i++) {
            distance += pow((art1.getNumberFeatures().get(i) - art2.getNumberFeatures().get(i)), 2);
        }
        size = art1.getTextFeatures().size();
        for (int i = 0; i < size; i++) {
            distance += pow(ngram.wordsDistance(art1.getTextFeatures().get(i), art2.getTextFeatures().get(i)), 2);
        }
        distance = sqrt(distance);
        return distance;
    }


}
