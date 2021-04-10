package pl.mowk.ksr.extractions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.mowk.ksr.data.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Setter
@ToString
public class ArticleFeatures {
    private String actualClass;
    private String predictedClass;
    private Map<Feature, String> textFeatures = new HashMap<>();
    private Map<Feature, Double> numberFeatures = new HashMap<>();

    public ArticleFeatures(Article article) {
        this.actualClass = article.getPlace();
        extractFeatures(article);
    }

    //for debug purposes only
    public ArticleFeatures(String a, double b, String actualClass) {
        textFeatures.put(Feature.Title, a);
        numberFeatures.put(Feature.Avg_nr_of_words_in_sentence, b);
        this.actualClass = actualClass;
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
            numberFeatures.put(Feature.First_keyword_nr, OccurrencesOfTheFirstKeyword.count(article));
            numberFeatures.put(Feature.Avg_nr_of_words_in_sentence, AvgNumberOfWordsInSentence.countSentences(article));
            numberFeatures.put(Feature.Number_of_words, NumberOfWords.count(article));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPredictedClass(String predictedClass){
        this.predictedClass = predictedClass;
    }


    public void normalize(Map<Feature, Double> min, Map<Feature, Double> max){
        for (Map.Entry<Feature, Double> entry :  numberFeatures.entrySet())
        {
            entry.setValue((entry.getValue()-min.get(entry.getKey()))/(max.get(entry.getKey())-min.get(entry.getKey())));
        }
    }

    public Map<Feature, String> getTextFeatures() {
        return textFeatures;
    }

    public String getActualClass() {
        return actualClass;
    }

    public String getPredictedClass() {
        return predictedClass;
    }

    public Map<Feature, Double> getNumberFeatures() {
        return numberFeatures;
    }


}
