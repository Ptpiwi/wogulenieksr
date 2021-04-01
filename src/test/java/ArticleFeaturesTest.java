import org.junit.Before;
import org.junit.Test;
import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.extractions.ArticleFeatures;


public class ArticleFeaturesTest {

   ArticleFeatures features= new ArticleFeatures("grzech", 1.5);



    @Test
    public void debuk(){
        for (Object obj: features.getTextFeatures()
        ) {
            System.out.print(obj.toString());
        }
        for (Object obj: features.getNumberFeatures()
        ) {
            System.out.print(obj.toString());
        }
    }


}
