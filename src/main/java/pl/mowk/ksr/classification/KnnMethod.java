package pl.mowk.ksr.classification;

import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Feature;

import java.util.List;

public class KnnMethod {
    Metric metric;
    List<ArticleFeatures> trainingSet;
    List<ArticleFeatures> testSet;
    List<Feature> features;

    int kValue;

    public KnnMethod(int k, double proportion, List<ArticleFeatures> dataSet, List<Feature> features, Metric metric) {
        this.kValue = k;
        this.features = features;
        this.metric = metric;
    datasetSpliter(dataSet, proportion);
    }

    private void datasetSpliter(List<ArticleFeatures> dataSet, double proportion) {
    int splitingPoint = (int)(dataSet.size()*proportion);
        this.trainingSet = (dataSet.subList(0, splitingPoint));
        this.testSet = dataSet.subList(splitingPoint, dataSet.size());
    }
}
