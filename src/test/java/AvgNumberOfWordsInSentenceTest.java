import org.junit.Test;
import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.AvgNumberOfWordsInSentence;

public class AvgNumberOfWordsInSentenceTest {

    String testString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sed ullamcorper nisl. Aliquam commodo rhoncus lacus at convallis. Maecenas gravida eros vel nunc lobortis, non malesuada risus interdum. Nunc justo elit, convallis id auctor eget, ultrices vitae nisi. Nullam ut placerat erat, ac iaculis quam. Suspendisse semper tempus nisl. Donec ipsum velit, ornare sed tellus sodales, lacinia vulputate neque. Nulla mauris mi, aliquet nec tellus at, maximus faucibus erat. Cras tempus porttitor vulputate. Nulla eget nulla ut sem vestibulum laoreet vitae sit amet orci. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut nec dignissim libero, vel finibus ante. Integer imperdiet lacus at rhoncus bibendum.";
    @Test
    public void debuk(){
        Article article = new Article("title", testString, "usa");
        System.out.println(AvgNumberOfWordsInSentence.countSentences(article));
    }
}
