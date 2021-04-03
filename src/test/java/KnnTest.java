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
import java.util.List;

public class KnnTest {

    ArticleReader dataset;
    List<Feature> features = new ArrayList<>();
    Ngram gram;
    KnnMethod knnMethod;
    Metric metric;

    @Before
    public void setUp() {

        this.gram = new Ngram(3, false);
        this.metric = new EuclideanMetric(gram);
        this.features.add(Feature.Title);

        this.features.add(Feature.Avg_nr_of_words_in_sentence);
        //features.add(Feature.Number_of_words);
        features.add(Feature.Currency);
        features.add(Feature.First_keyword);
        features.add(Feature.Most_common_keyword);
        //features.add(Feature.Most_common_keyword_in_part);
        //features.add(Feature.First_keyword_nr);
        //features.add(Feature.Rel_Number_Of_Occurrences_Keywords);
        //features.add(Feature.Rell_Number_Of_Words_In_Capital_Letters);


        long time = System.currentTimeMillis();
        this.dataset = new ArticleReader("src/main/resources/reuters", features);
        //this.dataset = new ArticleReader("src/test/resources/debugdataset", features);
        System.out.print("Extraction time:");
        System.out.print((System.currentTimeMillis()-time)/1000);
        System.out.println();
        this.knnMethod = new KnnMethod(2, 0.7, dataset.getArticles(), features, metric);

    }

    @Test
    public void normalizeDebug() {
        /*
        //List<ArticleFeatures> tmp = new ArrayList<ArticleFeatures>(knnMethod.classifyData());
        List<Double> debug = new ArrayList<>();

        for (ArticleFeatures articleFeatures :
                knnMethod.getData()) {
            debug.add(articleFeatures.getNumberFeatures().get(Feature.Avg_nr_of_words_in_sentence));
        }

        System.out.println("po normalizacji");
        knnMethod.normalizeDataset();
        for(int i=0; i<knnMethod.getData().size(); i++){
            System.out.print(debug.get(i));
            System.out.print(" is now a ");
            System.out.print(knnMethod.getData().get(i).getNumberFeatures().get(Feature.Avg_nr_of_words_in_sentence));
            System.out.println();
        }

         */
    }

    @Test
    public void classifyDebug() {
        long time = System.currentTimeMillis();
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


}
