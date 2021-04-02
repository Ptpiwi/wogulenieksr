package pl.mowk.ksr.classification;

import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Feature;

import java.util.List;

import static java.lang.Math.*;
import static java.lang.Math.pow;

public class ManhattanMetric implements Metric {
    Ngram ngram;
    public ManhattanMetric(Ngram ngram){
        this.ngram=ngram;
    }

    public double calculateDistance(ArticleFeatures art1, ArticleFeatures art2, List<Feature> features) {
        double distance = 0;
        for (Feature feature : features
        ) {
            if (art1.getNumberFeatures().containsKey(feature)) {
                distance += abs((art1.getNumberFeatures().get(feature) - art2.getNumberFeatures().get(feature)));
            } else if (art1.getTextFeatures().containsKey(feature)) {
                distance += ngram.wordsDistance(art1.getTextFeatures().get(feature), art2.getTextFeatures().get(feature));
            }
        }
        return distance;
    }


}
