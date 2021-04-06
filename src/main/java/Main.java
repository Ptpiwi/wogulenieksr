import org.junit.Assert;
import pl.mowk.ksr.classification.*;
import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.data.KeyWords;
import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Currency;
import pl.mowk.ksr.extractions.Feature;
import pl.mowk.ksr.extractions.NumberOfWords;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

//        Ngram gram = new Ngram(3, true);
//        Metric metric = new EuclideanMetric(gram);
//        List<Feature> features = new ArrayList<Feature>();
//        features.add(Feature.Title);
//        features.add(Feature.Avg_nr_of_words_in_sentence);
//        features.add(Feature.Currency);
//        features.add(Feature.First_keyword);
//        features.add(Feature.First_keyword_nr);
//        features.add(Feature.Most_common_keyword);
//        features.add(Feature.Most_common_keyword_in_part);
//        features.add(Feature.Number_of_words);
//        features.add(Feature.Rel_Number_Of_Occurrences_Keywords);
//        features.add(Feature.Rell_Number_Of_Words_In_Capital_Letters);
//
//        ArticleReader dataset = new ArticleReader("src\\main\\resources\\reuters", features);
//        for (ArticleFeatures article : dataset.getArticles()
//        ) {
//            System.out.println(article.toString());
//        }
//
//        List<String> labels = new ArrayList<>();
//        labels.add("usa");
//        labels.add("west-germany");
//        labels.add("france");
//        labels.add("uk");
//        labels.add("canada");
//        labels.add("japan");
//
//        long time = System.currentTimeMillis();
//        //ArticleReader dataset = new ArticleReader("src/main/resources/reuters", features);
//        //this.dataset = new ArticleReader("src/test/resources/debugdataset", features);
//        System.out.print("Extraction time:");
//        System.out.print((System.currentTimeMillis()-time)/1000);
//        System.out.println();
//        KnnMethod knnMethod = new KnnMethod(6, 0.5, dataset.getArticles(), features, metric);
//        time = System.currentTimeMillis();
//        knnMethod.normalizeDataset();
//        System.out.print("Normalization time:");
//        System.out.print((System.currentTimeMillis()-time)/1000);
//        System.out.println();
//        time = System.currentTimeMillis();
//        List<ArticleFeatures> tmp = new ArrayList<>(knnMethod.classifyData());
//        System.out.print("Classification time:");
//        System.out.print((System.currentTimeMillis()-time)/1000);
//        System.out.println();
//
//        QualityOfMeasures q = new QualityOfMeasures();
//        List<String> predicted = new ArrayList<>();
//        List<String> actual = new ArrayList<>();
//
//        for (ArticleFeatures articleFeatures: tmp) {
//            //System.out.println(articleFeatures.toString());
//            predicted.add(articleFeatures.getPredictedClass());
//            actual.add(articleFeatures.getActualClass());
//        }
//            System.out.println(actual);
//            System.out.println(predicted);
//            System.out.println(" ");
//
//        System.out.println(q.calculateAcc(predicted,actual));
//        System.out.println(q.calculatePrecisionForAll(predicted, actual, labels));
//        System.out.println(q.calculateRecallForAll(predicted, actual, labels));
//        System.out.println(q.calculateRecall(predicted,actual,"japan"));
//        System.out.println(q.calculatePrecision(predicted,actual,"japan"));
//        System.out.println(q.calculateRecall(predicted,actual,"france"));
//        System.out.println(q.calculatePrecision(predicted,actual,"france"));
//        System.out.println(q.calculateRecall(predicted,actual,"usa"));
//        System.out.println(q.calculatePrecision(predicted,actual,"usa"));
//        System.out.println(q.calculateRecall(predicted,actual,"uk"));
//        System.out.println(q.calculatePrecision(predicted,actual,"uk"));
//        System.out.println(q.calculateRecall(predicted,actual,"canada"));
//        System.out.println(q.calculatePrecision(predicted,actual,"canada"));
//        System.out.println(q.calculateRecall(predicted,actual,"west-germany"));
//        System.out.println(q.calculatePrecision(predicted,actual,"west-germany"));
        SwingUtilities.invokeLater(GUI::GUI_start);
    }
}
