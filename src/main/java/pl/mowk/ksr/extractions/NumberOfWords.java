package pl.mowk.ksr.extractions;

public class NumberOfWords {
    public int count(String text){
        int wordCount = 0;
        boolean word = false;
        int endOfLine = text.length() - 1;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i)) && i != endOfLine) {
                word = true;
            } else if (!Character.isLetter(text.charAt(i)) && word) {
                wordCount++;
                word = false;
            } else if (Character.isLetter(text.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }
}

