import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.mowk.ksr.classification.Ngram;

public class NgramTest {

    Ngram normalizedGram;
    Ngram gram;

    @Before
    public void setUp() {
        normalizedGram = new Ngram(3, true);
        gram = new Ngram(3, false);
    }

    @Test
    public void differentWords() {
        Assert.assertEquals(7.0 / 11.0, normalizedGram.wordsDistance("summary", "summarization"), 0.01);
        Assert.assertEquals(11.0 / 4.0, gram.wordsDistance("summary", "summarization"), 0.01);
    }

    @Test
    public void sameWords() {
        Assert.assertEquals(0, normalizedGram.wordsDistance("summary", "summary"), 0.01);
    }

    @Test
    public void shortWords() {
        Assert.assertEquals(0.5, normalizedGram.wordsDistance("sum", "su"), 0.01);
    }

    @Test
    public void oneWord() {
        Assert.assertEquals(1.0, normalizedGram.wordsDistance("summary", ""), 0.01);
        Assert.assertEquals(1.0, normalizedGram.wordsDistance("", "summary"), 0.01);
    }



}
