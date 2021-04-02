package pl.mowk.ksr.extractions;

import lombok.Getter;
import lombok.ToString;
import pl.mowk.ksr.data.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@ToString
public class ArticleFeatures {
    private String actualClass;
    private String predictedClass;
    private Map<Feature, String> textFeatures = new HashMap<Feature, String>();
    private Map<Feature, Double> numberFeatures = new HashMap<Feature, Double>();

    public ArticleFeatures(Article article) {
        this.actualClass = article.getPlace();
        extractFeatures(article);
    }

    //for debug purposes only
    public ArticleFeatures(String a, double b) {
        textFeatures.put(Feature.Title, a);
        numberFeatures.put(Feature.Avg_nr_of_words_in_sentence, b);
    }

    private void extractFeatures(Article article) {
        try {
            textFeatures.put(Feature.First_keyword, TheFirstKeyword.find(article));
            textFeatures.put(Feature.Title, TextTitle.title(article));
            textFeatures.put(Feature.Most_common_keyword, MostCommonKeyword.find(article));
            textFeatures.put(Feature.Currency, Currency.find(article));
            textFeatures.put(Feature.Most_common_keyword_in_part, MostCommonKeywordInPart.find(article));
            numberFeatures.put(Feature.Rel_Number_Of_Occurrences_Keywords, RelNumberOfOccurrencesKeywords.calculate(article));
            numberFeatures.put(Feature.Rell_Number_Of_Words_In_Capital_Letters, RellNumberOfWordsInCapitalLetters.calculate(article));
            numberFeatures.put(Feature.First_keyword_nr, RelNumberOfOccurrencesKeywords.calculate(article));
            numberFeatures.put(Feature.Avg_nr_of_words_in_sentence, AvgNumberOfWordsInSentence.countSentences(article));
            numberFeatures.put(Feature.Number_of_words, NumberOfWords.count(article));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPredictedClass(String predictedClass){
        this.predictedClass = predictedClass;
    }


}
