import org.junit.Assert;
import pl.mowk.ksr.classification.*;
import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.data.KeyWords;
import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Currency;
import pl.mowk.ksr.extractions.Feature;
import pl.mowk.ksr.extractions.NumberOfWords;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(GUI::GUI_start);
    }
}
