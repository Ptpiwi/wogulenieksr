import org.junit.Test;
import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.KeyWords;
import pl.mowk.ksr.extractions.AvgNumberOfWordsInSentence;

import java.io.IOException;

public class KeywordsTest {
    @Test
    public void debuk() throws IOException {
        KeyWords keyWords = new KeyWords();
        System.out.println(keyWords.getKeyWords());
    }
}
