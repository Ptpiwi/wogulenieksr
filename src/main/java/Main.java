import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.data.KeyWords;
import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Currency;
import pl.mowk.ksr.extractions.Feature;
import pl.mowk.ksr.extractions.NumberOfWords;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Feature> features = new ArrayList<Feature>();
        features.add(Feature.Title);
        features.add(Feature.Avg_nr_of_words_in_sentence);
        features.add(Feature.Currency);
        features.add(Feature.First_keyword);
        features.add(Feature.First_keyword_nr);
        features.add(Feature.Most_common_keyword);
        features.add(Feature.Most_common_keyword_in_part);
        features.add(Feature.Number_of_words);
        features.add(Feature.Rel_Number_Of_Occurrences_Keywords);
        features.add(Feature.Rell_Number_Of_Words_In_Capital_Letters);


        ArticleReader dataset = new ArticleReader("src\\main\\resources\\reuters",features);
        for (ArticleFeatures article: dataset.getArticles()
        ) {
            System.out.println(article.toString());
        }
        //sprawdzanie currency
        //sprawdzanie gui
       // new GUI_start();
        //SwingUtilities.invokeLater(GUI::gui_end);
        //sprawdzanie keywords
//        KeyWords k = new KeyWords();
//        List<String> kw = k.getKeyWords();
//        for (String l : kw) {
//            System.out.print(k.getKeyWords());
//        }
        //sprawdzanie NumberOfWords
//        NumberOfWords n = new NumberOfWords().count();
//        system


    }
}
