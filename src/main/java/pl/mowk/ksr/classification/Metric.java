package pl.mowk.ksr.classification;

import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Feature;

import java.util.List;

public interface Metric {
    public double calculateDistance(ArticleFeatures art1, ArticleFeatures art2, List<Feature> features);
}
