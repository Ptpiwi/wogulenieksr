package pl.mowk.ksr.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import pl.mowk.ksr.data.Article;

@Getter
@NoArgsConstructor
public class ArticleReader {
    private List<Article> articles;
    private String path;
    private String[] allowedPlaces = {"usa", "france", "canada", "japan", "west-germany"};

    public ArticleReader(String path) {
        this.path = path;
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
                articles.add(new Article(
                        element.select("title").text(),
                        element.select("text").text(),
                        tmp.get(0)
                ));
            }

        }

    }

    private boolean checkIfPlacesAreGood(List<String> places) {
        if (places.size()==1){
            return Arrays.asList(allowedPlaces).contains(places.get(0));
        }
        return false;
    }

    private String bieda(String bobmarley){
        StringBuilder tmp = new StringBuilder();
        Pattern pattern = Pattern.compile("<title>(.*?)</dateline>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(bobmarley);
        while (matcher.find()) {
            tmp.append(matcher.group(1));
        }
        return tmp.toString();
    }

}
