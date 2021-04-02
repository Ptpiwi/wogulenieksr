package pl.mowk.ksr.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Feature;

@Getter
@NoArgsConstructor
public class ArticleReader {
    private List<ArticleFeatures> articles;
    private List<ArticleFeatures> articlesTest;
    private List<ArticleFeatures> articlesTraining;
    private List<String> stopWords = new ArrayList<>();
    private String path;
    private String[] allowedPlaces = {"usa", "france", "canada", "japan", "west-germany"};
    private List<Feature> features = new ArrayList<Feature>();
    public ArticleReader(String path, List<Feature> features) {
        this.path = path;
        this.features=features;
        extractStopWords();
        extractDataFromDirectory(path);
    }

    private void extractDataFromDirectory(String path) {
        articles = new ArrayList<>();
        try {
            File directory = new File(path);
            var files = directory.listFiles();
            if (files != null) {
                for (File file : files
                ) {
                    extractDataFromFile(file);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<String> extractPlacesFromElement(Element element) {
        List<String> tmp = new ArrayList<>();
        for (Element e : element.select("d")
        ) {
            tmp.add(e.select("d").text());
        }
        return tmp;
    }


    private void extractDataFromFile(File file) throws IOException {
        Document document = Jsoup.parse(file, "UTF-8");
        for (Element element : document.select("REUTERS")) {
            List<String> tmp = extractPlacesFromElement(element);

            if (checkIfPlacesAreGood(tmp)) {
                Article tempArticle =new Article(
                        element.select("title").text(),
                        bieda(element.select("text").html()),
                        tmp.get(0)
                );
                articles.add(new ArticleFeatures(tempArticle, features));
            }

        }

    }

    private boolean checkIfPlacesAreGood(List<String> places) {
        if (places.size()==1){
            return Arrays.asList(allowedPlaces).contains(places.get(0));
        }
        return false;
    }

    private void extractStopWords(){
        JSONArray array = null;
        try {
            String content = Files.readString(Path.of("src/main/resources/keywords/stoplist"),StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(content);

            if (jsonArray != null) {
                int len = jsonArray.length();
                for (int i = 0; i < len; i++) {
                    stopWords.add(jsonArray.get(i).toString());
                }
            }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String bieda(String bobmarley){
        String[] segments = bobmarley.split("</dateline>");
        String[] body = segments[segments.length - 1].toLowerCase().split(" ");
        StringBuilder builder = new StringBuilder();
        for(String word : body) {
            if (!stopWords.contains(word)) {
                builder.append(word);
                builder.append(' ');
            }
        }
        return builder.toString().trim();
    }

    public void dataSpliter(double prOfTraingData){

    }

}
