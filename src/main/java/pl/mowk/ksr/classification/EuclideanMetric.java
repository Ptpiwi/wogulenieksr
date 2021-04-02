package pl.mowk.ksr.classification;

import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Feature;

import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class EuclideanMetric implements Metric {
    Ngram ngram;

    public EuclideanMetric(Ngram ngram) {
        this.ngram = ngram;
    }

    public double calculateDistance(ArticleFeatures art1, ArticleFeatures art2, List<Feature> features) {
        double distance = 0;
        for (Feature feature : features
        ) {
            if (art1.getNumberFeatures().containsKey(feature)) {
                distance += pow((art1.getNumberFeatures().get(feature) - art2.getNumberFeatures().get(feature)), 2);
            } else if (art1.getTextFeatures().containsKey(feature)) {
                distance += pow(ngram.wordsDistance(art1.getTextFeatures().get(feature), art2.getTextFeatures().get(feature)), 2);
            }
        }
        distance = sqrt(distance);
        return distance;
    }

}
