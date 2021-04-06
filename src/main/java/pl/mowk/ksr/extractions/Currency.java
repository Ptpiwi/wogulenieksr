package pl.mowk.ksr.extractions;

import pl.mowk.ksr.data.Article;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Currency {

    public static String find (Article art) throws IOException {
        //String [] currency = {"dlr", "euro", "USD","pound"};
        File file = new File("src\\main\\resources\\keywords\\currency");

        String[] allWords = art.getBody().toLowerCase().split(" ");

        //String[] allWords = text.split(" ");
        ArrayList<String> list = findInFile(file);
        ArrayList<String> currInText = new ArrayList<>();
        for (String i : allWords) {
            for (String j : list) {
                if (i.contains(j)) {;
                currInText.add(j);
                }
            }
        }
        if(currInText.size() == 0){
            return " ";
        }
        ArrayList<SingleCurrency> single = new ArrayList<>();
        int j = 0;
        for(String a: currInText){
            int i = 0;
            for(String b: currInText){
                if(a.equals(b)){
                    i++;
                }
            }
            single.add(new SingleCurrency(a,i));
        }
        SingleCurrency pom = new SingleCurrency("",0);
        for(SingleCurrency i: single){
            if(i.getQuantity() > pom.getQuantity()){
                pom = i;
            }
        }
        return pom.getName();
    }
    public static ArrayList<String> findInFile(File file) {
        ArrayList<String> b = new ArrayList();
        try(BufferedReader a = new BufferedReader(new FileReader (file))) {
            String c = null;
            while ((c = a.readLine())!= null){
                b.add(c);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            }
        return b;
    }
}

class SingleCurrency{
    String name;
    int quantity;

    public SingleCurrency(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}