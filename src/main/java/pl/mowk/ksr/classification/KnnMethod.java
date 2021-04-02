package pl.mowk.ksr.classification;

import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Feature;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        normalize();
    }

    private void datasetSpliter(List<ArticleFeatures> dataSet, double proportion) {
        int splitingPoint = (int) (dataSet.size() * proportion);
        this.trainingSet = (dataSet.subList(0, splitingPoint));
        this.testSet = dataSet.subList(splitingPoint, dataSet.size());
    }

    public List<ArticleFeatures> classifyData() {
        for (ArticleFeatures articleFeatures :
                testSet) {
            classifyArticle(articleFeatures);
        }
        return testSet;
    }

    private void classifyArticle(ArticleFeatures article) {
        trainingSet.sort(Comparator.comparingDouble(a -> metric.calculateDistance(a, article, features)));
        Map<String, Integer> occurencesMap= new HashMap<String, Integer>();
        for (int i=0; i<kValue; i++){
            String tmp = trainingSet.get(i).getActualClass();
            if (!occurencesMap.containsKey(tmp)){
                occurencesMap.put(tmp, 0);
            } else occurencesMap.put(tmp, occurencesMap.get(tmp) + 1);
        }
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : occurencesMap.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        if (maxEntry == null) {
            System.out.println("To nie powinno sie wyświetlic, blad w classify article");
        }
        article.setPredictedClass(maxEntry.getKey());
    }


    //todo
    private void normalize() {

    }
}
