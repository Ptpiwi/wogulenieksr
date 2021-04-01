package pl.mowk.ksr.extractions;

import lombok.Getter;
import lombok.Setter;
import pl.mowk.ksr.data.Article;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ArticleFeatures {
    private List<String> textFeatures = new ArrayList<String>();
    private List<Double> numberFeatures = new ArrayList<Double>();

    public ArticleFeatures(Article article){
        numberFeatures.add((double) NumberOfWords.count(article));
    }
    public ArticleFeatures(String a, double b){
        textFeatures.add(a);
        numberFeatures.add(b);
    }

}
