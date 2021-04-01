package pl.mowk.ksr.classification;

import pl.mowk.ksr.extractions.ArticleFeatures;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class ChebyshevMetric implements Metric{
    Ngram ngram;
    public ChebyshevMetric(Ngram ngram){
        this.ngram=ngram;
    }

    public double calculateDistance(ArticleFeatures art1, ArticleFeatures art2) {
        double distance = 0;
        int size = art1.getNumberFeatures().size();
        for (int i = 0; i < size; i++) {
            double tmp = abs((art1.getNumberFeatures().get(i) - art2.getNumberFeatures().get(i)));
            if (distance<tmp) distance=tmp;
        }
        size = art1.getTextFeatures().size();
        for (int i = 0; i < size; i++) {
            double tmp = ngram.wordsDistance(art1.getTextFeatures().get(i), art2.getTextFeatures().get(i));
            if (distance<tmp) distance=tmp;
        }
        return distance;
    }




}
