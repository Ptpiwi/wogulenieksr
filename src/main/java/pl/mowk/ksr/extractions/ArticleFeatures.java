package pl.mowk.ksr.extractions;

import lombok.Getter;
import lombok.ToString;
import pl.mowk.ksr.data.Article;

import java.util.ArrayList;
import java.util.List;


@Getter
@ToString
public class ArticleFeatures {
    private String actualClass;
    private String predictedClass;
    //todo zamiast list wypadło by skorzystać z map
    private List<String> textFeatures = new ArrayList<>();
    private List<Double> numberFeatures = new ArrayList<>();

    public ArticleFeatures(Article article, List<Feature> features) {
        this.actualClass = article.getPlace();
        for (Feature feature :
                features) {
            extractFeatures(article, feature);
        }
    }


    private void extractFeatures(Article article, Feature feature) {
        switch (feature) {
            case First_keyword:
                try {
                    textFeatures.add(TheFirstKeyword.find(article));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case Title:
                textFeatures.add(TextTitle.title(article));
                break;
            case Rel_Number_Of_Occurrences_Keywords:
                try {
                    numberFeatures.add(RelNumberOfOccurrencesKeywords.calculate(article));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case Rell_Number_Of_Words_In_Capital_Letters:
                numberFeatures.add(RellNumberOfWordsInCapitalLetters.calculate(article));
                break;
            case First_keyword_nr:
                try {
                    numberFeatures.add(OccurrencesOfTheFirstKeyword.count(article));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case Number_of_words:
                numberFeatures.add(NumberOfWords.count(article));
                break;
            case Most_common_keyword_in_part:
                try {
                    textFeatures.add(MostCommonKeywordInPart.find(article));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case Most_common_keyword:
                try {
                    textFeatures.add(MostCommonKeyword.find(article));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case Currency:
                try {
                    Currency.find(article);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case Avg_nr_of_words_in_sentence:
                numberFeatures.add(AvgNumberOfWordsInSentence.countSentences(article));
                break;
            default:
                System.out.println("To nie powinno sie pojawic, cos poszlo nie tak przy ekstrakcji");
                break;

        }
    }

    public ArticleFeatures(String a, double b) {
        textFeatures.add(a);
        numberFeatures.add(b);
    }

}
