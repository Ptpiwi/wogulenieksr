import org.junit.Before;
import org.junit.Test;
import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.extractions.ArticleFeatures;

import java.util.Map;


public class ArticleFeaturesTest {

   ArticleFeatures features= new ArticleFeatures("grzech", 1.5);



    @Test
    public void debuk(){

            System.out.print(features.getTextFeatures().toString());
            System.out.print(features.getNumberFeatures().toString());
    }


}
