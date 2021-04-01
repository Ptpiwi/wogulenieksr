package pl.mowk.ksr.extractions;

import pl.mowk.ksr.data.Article;

public class AvgNumberOfWordsInSentence {
    public static double countSentences(Article article){
        String[] segments = article.getBody().split("\\.");
        double tmp= 0;
        for (String sentence:
                segments
             ) {
            char[] ch = new char[sentence.length()];
            for(int i=0;i<sentence.length();i++)
            {
                ch[i]= sentence.charAt(i);
                if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )
                    tmp++;
            }
        }
        return tmp/segments.length;
    }
    
}
