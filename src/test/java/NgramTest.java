import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.mowk.ksr.classification.EuclideanMetric;
import pl.mowk.ksr.classification.Ngram;
import pl.mowk.ksr.data.ArticleReader;

public class NgramTest {

    Ngram gram;

    @Before
    public void setUp() {
        gram = new Ngram(3);
    }

    @Test
    public void difrentWords() {
        Assert.assertEquals(4.0 / 11.0, gram.wordsSimlarity("summary", "summarization"), 0.01);
    }

    @Test
    public void sameWords() {
        Assert.assertEquals(1.0, gram.wordsSimlarity("summary", "summary"), 0.01);
    }

    @Test
    public void oneWord() {
        Assert.assertEquals(0.0, gram.wordsSimlarity("summary", ""), 0.01);
        Assert.assertEquals(0.0, gram.wordsSimlarity("", "summary"), 0.01);
    }

    @Test
    public void wordsDistance() {
        System.out.println(gram.wordsDistance("summary", "summarization"));
        System.out.println(gram.wordsDistance("pech", "lech"));
        System.out.println(gram.wordsDistance("boby", "oby marley"));

    }

}
