package pl.mowk.ksr.classification;

import pl.mowk.ksr.extractions.ArticleFeatures;

public interface Metric {
    public double calculateDistance(ArticleFeatures art1, ArticleFeatures art2);
}
