import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.mowk.ksr.classification.ChebyshevMetric;
import pl.mowk.ksr.classification.EuclideanMetric;
import pl.mowk.ksr.classification.ManhattanMetric;
import pl.mowk.ksr.classification.Ngram;
import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Feature;

import java.util.ArrayList;
import java.util.List;

public class MetricTest {

    ArticleFeatures articleFeatures;
    ArticleFeatures articleFeatures1;
    Ngram gram;
    List<Feature> features = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        this.articleFeatures = new ArticleFeatures("grzech", 1, "usa");
        this.articleFeatures1 = new ArticleFeatures("pech", 7, "usa");
        this.gram = new Ngram(3, false);
        features.add(Feature.Title);
        features.add(Feature.Avg_nr_of_words_in_sentence);

    }


    @Test
    public void euclideanDistance() {
        EuclideanMetric euclid = new EuclideanMetric(gram);
        Assert.assertEquals(7.2, euclid.calculateDistance(articleFeatures, articleFeatures1, features), 0.1);
    }

    @Test
    public void manhatanDistance() {
        ManhattanMetric euclid = new ManhattanMetric(gram);
        Assert.assertEquals(10.0, euclid.calculateDistance(articleFeatures, articleFeatures1, features), 0.1);
    }

    @Test
    public void chebyshevDistance() {
        ChebyshevMetric euclid = new ChebyshevMetric(gram);
        Assert.assertEquals(6.0, euclid.calculateDistance(articleFeatures, articleFeatures1, features), 0.1);
    }


}
