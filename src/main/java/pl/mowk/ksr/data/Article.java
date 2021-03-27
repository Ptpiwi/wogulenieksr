package pl.mowk.ksr.data;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@ToString
public class Article {
    private String title;
    private String body;
    private String place;

    public Article(String title, String body, String place) {
        this.title = title;
        this.body = body;
        this.place = place;
    }

}
