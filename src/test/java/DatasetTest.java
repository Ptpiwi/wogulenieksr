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
        List<Feature> features = new ArrayList<>();

        //git
        //features.add(Feature.Title);

        //git
        //features.add(Feature.Number_of_words);

        // git chyba
        //features.add(Feature.Avg_nr_of_words_in_sentence);


        //features.add(Feature.Currency);

        //todo zwraca dla kazdego artykułu stg or billion Shinpan HOURS ICCO simul CUTS gt gasolin Canon band Nippon Exxon Metal GM rice nickel ADB Jiji
        //features.add(Feature.First_keyword);

        //git
        //features.add(Feature.Most_common_keyword);

        //todo pusto
        //features.add(Feature.Most_common_keyword_in_part);

        //todo zwraca same zera
        //features.add(Feature.First_keyword_nr);

        //todo zwraca same zera
        //features.add(Feature.Rel_Number_Of_Occurrences_Keywords);

        //todo chyba git ale wartości sa bardzo małe - może zamiana na promile?
        //features.add(Feature.Rell_Number_Of_Words_In_Capital_Letters);

        dataset = new ArticleReader("src/test/resources/debugdataset", features);
    }

    @Test
    public void debuk(){
        for (ArticleFeatures article: dataset.getArticles()
             ) {
            System.out.println(article.toString());
        }
    }


}