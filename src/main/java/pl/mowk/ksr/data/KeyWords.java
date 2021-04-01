package pl.mowk.ksr.data;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyWords {
    private String word;
    private int quantity;

    public KeyWords() {
    }

    public KeyWords(String word, int quantity) {
        this.word = word;
        this.quantity = quantity;
    }

    public String getWord() {
        return word;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<String> loadFromFile() throws IOException {
        String path = "src/main/resources/keywords/slowa.txt";
        BufferedReader fileReader = null;
        List<String> keywords = null;
        try {
            fileReader = new BufferedReader(new FileReader(path));
            String full = fileReader.readLine();
            String[] list = full.split("\\|");
            keywords = new ArrayList<>();
            for (String l : list) {
                keywords.add(l);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        return keywords;
    }

    public List<String> getKeyWords() throws IOException {
        List<String> kw;
        kw = loadFromFile();
        return kw;
    }
}
