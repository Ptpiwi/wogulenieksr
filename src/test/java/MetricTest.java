import org.junit.Assert;
import org.junit.Test;
import pl.mowk.ksr.classification.ChebyshevMetric;
import pl.mowk.ksr.classification.EuclideanMetric;
import pl.mowk.ksr.classification.ManhattanMetric;
import pl.mowk.ksr.classification.Ngram;
import pl.mowk.ksr.extractions.ArticleFeatures;

public class MetricTest {

    ArticleFeatures features = new ArticleFeatures("grzech", 1);
    ArticleFeatures features2 = new ArticleFeatures("pech", 7);
    Ngram gram = new Ngram(3);

    @Test
    public void euclideanDistance() {
        EuclideanMetric euclid = new EuclideanMetric(gram);
        Assert.assertEquals(7.2, euclid.calculateDistance(features, features2), 0.1);
    }

    @Test
    public void manhatanDistance() {
        ManhattanMetric euclid = new ManhattanMetric(gram);
        Assert.assertEquals(10.0, euclid.calculateDistance(features, features2), 0.1);
    }

    @Test
    public void chebyshevDistance() {
        ChebyshevMetric euclid = new ChebyshevMetric(gram);
        Assert.assertEquals(6.0, euclid.calculateDistance(features, features2), 0.1);
    }


}
