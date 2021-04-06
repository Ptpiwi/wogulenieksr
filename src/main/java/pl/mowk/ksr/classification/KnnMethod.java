package pl.mowk.ksr.classification;

import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.extractions.*;

import java.util.*;

public class KnnMethod {
    Metric metric;
    Double proportion;
    List<ArticleFeatures> trainingSet;
    List<ArticleFeatures> testSet;
    List<Feature> features;

    int kValue;

    public KnnMethod(int k, double proportion, List<ArticleFeatures> dataSet, List<Feature> features, Metric metric) {
        this.kValue = k;
        this.features = features;
        this.metric = metric;
        this.proportion = proportion;
        datasetSpliter(dataSet, proportion);
    }

    private void datasetSpliter(List<ArticleFeatures> dataSet, double proportion) {
        int splitingPoint = (int) (dataSet.size() * proportion);
        this.trainingSet = (dataSet.subList(0, splitingPoint));
        this.testSet = dataSet.subList(splitingPoint, dataSet.size());
        System.out.println(dataSet.size());
        System.out.println(proportion);
        System.out.println(trainingSet.size());
        System.out.println(testSet.size());
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
        Map<String, Integer> occurencesMap = new HashMap<>();
        for (int i = 0; i < kValue; i++) {
            String tmp = trainingSet.get(i).getActualClass();
            if (!occurencesMap.containsKey(tmp)) {
                occurencesMap.put(tmp, 0);
            } else occurencesMap.put(tmp, occurencesMap.get(tmp) + 1);
        }
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : occurencesMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        if (maxEntry == null) {
            System.out.println("To nie powinno sie wyświetlic, blad w classify article");
        }
        article.setPredictedClass(maxEntry.getKey());
    }


    public List<ArticleFeatures> getData() {
        List<ArticleFeatures> dataset = new ArrayList<>(trainingSet);
        dataset.addAll(testSet);
        return dataset;
    }


    public void normalizeDataset() {
        List<ArticleFeatures> dataset = new ArrayList<>(trainingSet);
        dataset.addAll(testSet);

        Map<Feature, Double> min = getMinFeatures(dataset);
        Map<Feature, Double> max = getMaxFeatures(dataset);
        for (ArticleFeatures articleFeatures :
                dataset) {
            articleFeatures.normalize(min, max);
        }
        datasetSpliter(dataset, proportion);
    }

    private Map<Feature, Double> getMinFeatures(List<ArticleFeatures> dataset) {
        Map<Feature, Double> min = new HashMap<>();
        for (Map.Entry<Feature, Double> entry : dataset.get(0).getNumberFeatures().entrySet()) {
            min.put(entry.getKey(), entry.getValue());
        }
        for (ArticleFeatures articleFeatures :
                dataset) {
            for (Map.Entry<Feature, Double> entry : articleFeatures.getNumberFeatures().entrySet()) {
                if (min.get(entry.getKey()) > entry.getValue())
                    min.put(entry.getKey(), entry.getValue());
            }
        }
        return min;
    }

    private Map<Feature, Double> getMaxFeatures(List<ArticleFeatures> dataset) {
        Map<Feature, Double> max = new HashMap<>();
        for (Map.Entry<Feature, Double> entry : dataset.get(0).getNumberFeatures().entrySet()) {
            max.put(entry.getKey(), entry.getValue());
        }
        for (ArticleFeatures articleFeatures :
                dataset) {
            for (Map.Entry<Feature, Double> entry : articleFeatures.getNumberFeatures().entrySet()) {
                if (max.get(entry.getKey()) < entry.getValue())
                    max.put(entry.getKey(), entry.getValue());
            }
        }
        return max;
    }


}
