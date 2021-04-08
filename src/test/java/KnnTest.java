import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.mowk.ksr.classification.EuclideanMetric;
import pl.mowk.ksr.classification.KnnMethod;
import pl.mowk.ksr.classification.Metric;
import pl.mowk.ksr.classification.Ngram;
import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class KnnTest {


    @Test
    public void classifyDebug() {


        Ngram gram = new Ngram(3, false);
        Metric metric = new EuclideanMetric(gram);
        List<Feature> features = new ArrayList<>();
        features.add(Feature.Title);
        features.add(Feature.Avg_nr_of_words_in_sentence);
        features.add(Feature.Number_of_words);
        features.add(Feature.Currency);
        features.add(Feature.First_keyword);
        features.add(Feature.Most_common_keyword);
        features.add(Feature.Most_common_keyword_in_part);
        features.add(Feature.First_keyword_nr);
        features.add(Feature.Rel_Number_Of_Occurrences_Keywords);
        features.add(Feature.Rell_Number_Of_Words_In_Capital_Letters);


        long time = System.currentTimeMillis();
        ArticleReader dataset = new ArticleReader("src/main/resources/reuters", features);
        //this.dataset = new ArticleReader("src/test/resources/debugdataset", features);
        System.out.print("Extraction time:");
        System.out.print((System.currentTimeMillis()-time)/1000);
        System.out.println();
        KnnMethod knnMethod = new KnnMethod(3, 0.95, dataset.getArticles(), features, metric);
        time = System.currentTimeMillis();
        knnMethod.normalizeDataset();
        System.out.print("Normalization time:");
        System.out.print((System.currentTimeMillis()-time)/1000);
        System.out.println();
        time = System.currentTimeMillis();
        List<ArticleFeatures> tmp = new ArrayList<>(knnMethod.classifyData());
        System.out.print("Classification time:");
        System.out.print((System.currentTimeMillis()-time)/1000);
        System.out.println();
        for (ArticleFeatures articleFeatures:
                tmp) {
            System.out.println(articleFeatures.toString());
        }


    }

    @Test
    public void classifyTest() {
        List<ArticleFeatures> articleFeatures = new ArrayList<>();
        articleFeatures.add(new ArticleFeatures("cingciong", 11, "japan"));
        articleFeatures.add(new ArticleFeatures("ciongciong", 14, "japan"));
        articleFeatures.add(new ArticleFeatures("ciocioong", 13, "japan"));
        articleFeatures.add(new ArticleFeatures("grzech", 29, "usa"));
        articleFeatures.add(new ArticleFeatures("grzechu", 28, "usa"));
        articleFeatures.add(new ArticleFeatures("grzesiek", 25, "usa"));
        articleFeatures.add(new ArticleFeatures("grzegorz", 24, "usa"));
        articleFeatures.add(new ArticleFeatures("grzegrzolka", 26, "usa"));


        articleFeatures.add(new ArticleFeatures("grzechucgrzeg", 23, "usa"));
        articleFeatures.add(new ArticleFeatures("ngciong", 12, "japan"));

        List<Feature> features = new ArrayList<>();
        features.add(Feature.Title);
        features.add(Feature.Avg_nr_of_words_in_sentence);
        Ngram gram = new Ngram(3, false);
        Metric metric = new EuclideanMetric(gram);
        KnnMethod knn = new KnnMethod(3, 0.8, articleFeatures, features, metric);
        for (ArticleFeatures articleFeatures1:
             knn.classifyData()) {
            Assert.assertEquals(articleFeatures1.getActualClass(), articleFeatures1.getPredictedClass());
        }

    }
    @Test
    public void IleArt(){

        List<Feature> features = new ArrayList<>();
        features.add(Feature.Title);



        ArticleReader dataset = new ArticleReader("src/main/resources/reuters", features);
        System.out.println(dataset.getArticles().size());
    }


}
