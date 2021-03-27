package pl.mowk.ksr;
import org.junit.Before;
import org.junit.Test;
import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.Dataset;

import static org.assertj.core.api.Assertions.assertThat;

public class DatasetTest {

    Dataset dataset;

    @Before
    public void setUp() throws Exception {
        dataset = new Dataset("src/test/resources/debugdataset");
    }

    @Test
    public void debuk(){
        for (Article article: dataset.getArticles()
             ) {
            System.out.print(article.toString());
        }
    }


}