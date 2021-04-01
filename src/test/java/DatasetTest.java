package pl.mowk.ksr;
import org.junit.Before;
import org.junit.Test;
import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Feature;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DatasetTest {

    ArticleReader dataset;

    @Before
    public void setUp() throws Exception {
        List<Feature> features = new ArrayList<Feature>();
        features.add(Feature.Title);
        //features.add(Feature.Number_of_words);
        //features.add(Feature.Avg_nr_of_words_in_sentence);
        //features.add(Feature.Currency);
        features.add(Feature.First_keyword);
        //features.add(Feature.Most_common_keyword);

        dataset = new ArticleReader("src/test/resources/debugdataset", features);
    }

    @Test
    public void debuk(){
        for (ArticleFeatures article: dataset.getArticles()
             ) {
            System.out.print(article.toString());
        }
    }


}