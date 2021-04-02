package pl.mowk.ksr.classification;

import pl.mowk.ksr.data.ArticleReader;

public class KnnMethod {
    ArticleReader dataSet;
    Metric metric = new EuclideanMetric(new Ngram(3));
    Double kValue;
    public KnnMethod(ArticleReader articleReader, Metric metric){
        this.dataSet=articleReader;
        this.metric=metric;
    }
    public KnnMethod(ArticleReader articleReader){
        this.dataSet=articleReader;
    }



}
