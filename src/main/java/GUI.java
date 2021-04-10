import org.apache.commons.math3.random.MersenneTwister;
import pl.mowk.ksr.classification.*;
import pl.mowk.ksr.data.Article;
import pl.mowk.ksr.data.ArticleReader;
import pl.mowk.ksr.extractions.ArticleFeatures;
import pl.mowk.ksr.extractions.Feature;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Guard;
import java.util.ArrayList;
import java.util.List;

public class GUI {

    public static void GUI_start() {
        JFrame frame = new JFrame();
        JTextField k = new JTextField();
        JTextField podzial = new JTextField();
        JComboBox metric = new JComboBox();
        JComboBox c1 = new JComboBox();
        JComboBox c2 = new JComboBox();
        JComboBox c3 = new JComboBox();
        JComboBox c4 = new JComboBox();
        JLabel label = new JLabel();
        JLabel label2= new JLabel();
        JLabel label3= new JLabel();
        JLabel label4= new JLabel();
        JPanel panel = new JPanel(null);
        metric.setBounds(250,100,120,30);
        metric.addItem("Chebyshev");
        metric.addItem("Euclidean");
        metric.addItem("Manhattan");

        c1.setBounds(250,150,450,30);
        c1.addItem("Wszystkie cechy");
        c1.addItem("Długość dokumentu");
        c1.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c1.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c1.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c1.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c1.addItem("Względna liczba słów wielką literą");
        c1.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c1.addItem("Pierwsze słowo kluczowe z tytułu dokumentu");
        c1.addItem("Pierwsze słowo kluczowe");
        c1.addItem("Najczęściej występująca w dokumencie waluta");

        c2.setBounds(250,190,450,30);
        c2.addItem("Wszystkie cechy");
        c2.addItem("Długość dokumentu");
        c2.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c2.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c2.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c2.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c2.addItem("Względna liczba słów wielką literą");
        c2.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c2.addItem("Pierwsze słowo kluczowe z tytułu dokumentu");
        c2.addItem("Pierwsze słowo kluczowe");
        c2.addItem("Najczęściej występująca w dokumencie waluta");

        c3.setBounds(250,230,450,30);
        c3.addItem("Wszystkie cechy");
        c3.addItem("Długość dokumentu");
        c3.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c3.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c3.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c3.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c3.addItem("Względna liczba słów wielką literą");
        c3.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c3.addItem("Pierwsze słowo kluczowe z tytułu dokumentu");
        c3.addItem("Pierwsze słowo kluczowe");
        c3.addItem("Najczęściej występująca w dokumencie waluta");

        c4.setBounds(250,270,450,30);
        c4.addItem("Wszystkie cechy");
        c4.addItem("Długość dokumentu");
        c4.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c4.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c4.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c4.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c4.addItem("Względna liczba słów wielką literą");
        c4.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c4.addItem("Pierwsze słowo kluczowe z tytułu dokumentu");
        c4.addItem("Pierwsze słowo kluczowe");
        c4.addItem("Najczęściej występująca w dokumencie waluta");

        c1.addActionListener(e -> {
            if (c1.getSelectedIndex() == 0){
                c2.setVisible(false);
                c3.setVisible(false);
                c4.setVisible(false);
            }
        });

        JButton button = new JButton("Zapisz");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ngram gram = new Ngram(3, true);
                Metric metric1;
                switch (metric.getSelectedIndex()){
                    case 0:
                        metric1 = new ChebyshevMetric(gram);
                        break;
                    case 1:
                        metric1 = new EuclideanMetric(gram);
                        break;
                    case 2:
                        metric1 = new ManhattanMetric(gram);
                        break;
                    default:
                        metric1 = new EuclideanMetric(gram);
                        break;
                }
                List<Feature> features = new ArrayList<Feature>();
                if(c1.getSelectedIndex() != 0){
                    choose(features, c1.getSelectedIndex());
                    choose(features, c2.getSelectedIndex());
                    choose(features, c3.getSelectedIndex());
                    choose(features, c4.getSelectedIndex());
                } else {
                    choose(features, c1.getSelectedIndex());
                }
                ArticleReader dataset = new ArticleReader("src\\main\\resources\\reuters", features);
                double podzial1 = Double.parseDouble(podzial.getText())/100;
                long time = System.currentTimeMillis();
                System.out.print("Extraction time:");
                System.out.print((System.currentTimeMillis()-time)/1000);
                System.out.println();
                KnnMethod knnMethod = new KnnMethod(Integer.parseInt(k.getText()),podzial1, dataset.getArticles(), features, metric1);
                time = System.currentTimeMillis();
                knnMethod.normalizeDataset();
                System.out.print("Normalization time:");
                System.out.print((System.currentTimeMillis()-time)/1000);
                System.out.println();
                time = System.currentTimeMillis();
                List<ArticleFeatures> tmp = new ArrayList<>(knnMethod.classifyData());
                System.out.print("Classification time:");
                System.out.print((System.currentTimeMillis()-time)/1000);
                List<String> labels = new ArrayList<>();
                labels.add("usa");
                labels.add("west-germany");
                labels.add("france");
                labels.add("uk");
                labels.add("canada");
                labels.add("japan");
                QualityOfMeasures q = new QualityOfMeasures();
                List<String> predicted = new ArrayList<>();
                List<String> actual = new ArrayList<>();

                for (ArticleFeatures articleFeatures: tmp) {
                    predicted.add(articleFeatures.getPredictedClass());
                    actual.add(articleFeatures.getActualClass());
        }
                System.out.println("Accuracy: " + q.calculateAcc(predicted,actual));
                System.out.println("Precision: " + q.calculatePrecisionForAll(predicted, actual, labels));
                System.out.println("Recall: " + q.calculateRecallForAll(predicted, actual, labels));
//                System.out.println("Recall japan: " + q.calculateRecall(predicted,actual,"japan"));
//                System.out.println("Precision japan: " + q.calculatePrecision(predicted,actual,"japan"));
//                System.out.println("Recall france: " + q.calculateRecall(predicted,actual,"france"));
//                System.out.println("Precision france: " + q.calculatePrecision(predicted,actual,"france"));
                System.out.println("Precision usa: " + q.calculatePrecision(predicted,actual,"usa"));
                System.out.println("Recall usa: " + q.calculateRecall(predicted,actual,"usa"));
                System.out.println("Precision uk: " + q.calculatePrecision(predicted,actual,"uk"));
                System.out.println("Recall uk: " + q.calculateRecall(predicted,actual,"uk"));
//                System.out.println("Recall canada: " + q.calculateRecall(predicted,actual,"canada"));
//                System.out.println("Precision canada: " + q.calculatePrecision(predicted,actual,"canada"));
//                System.out.println("Recall west germany: " + q.calculateRecall(predicted,actual,"west-germany"));
//                System.out.println("Precision west-germany: " + q.calculatePrecision(predicted,actual,"west-germany"));
                System.out.println("F1: " + q.calculateF1(predicted,actual,labels));
                System.out.println();
                SwingUtilities.invokeLater(GUI::gui_end);
            }
        });
        button.setBounds(250,330,80,30);

        //panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        label.setText("Podaj k: ");
        label2.setText("Wybierz metrykę: ");
        label3.setText("Wybierz ceche: ");
        label4.setText("Podaj ile procent zajmuje zbiór uczący: ");
        label.setBounds(10,10,120,50);
        k.setBounds(250, 20, 120, 30);
        podzial.setBounds(250,60,120,30);
        label4.setBounds(10,50,250,50);
        label2.setBounds(10,88,120,50);
        label3.setBounds(10,137,120,50);

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(k);
        panel.add(metric);
        panel.add(c1);
        panel.add(c2);
        panel.add(c3);
        panel.add(c4);
        panel.add(podzial);
        panel.add(button);

        frame.pack();
        frame.setSize(750,500);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Komputerowe systemy rozpoznawania");
        frame.setVisible(true);
    }

    public static void choose(List<Feature> features, int list){
            switch (list){
                case 0:
                    features.add(Feature.Title);
                    features.add(Feature.Avg_nr_of_words_in_sentence);
                    features.add(Feature.Currency);
                    features.add(Feature.First_keyword);
                    features.add(Feature.First_keyword_nr);
                    features.add(Feature.Most_common_keyword);
                    features.add(Feature.Most_common_keyword_in_part);
                    features.add(Feature.Number_of_words);
                    features.add(Feature.Rel_Number_Of_Occurrences_Keywords);
                    features.add(Feature.Rell_Number_Of_Words_In_Capital_Letters);
                    break;
                case 1:
                    features.add(Feature.Number_of_words);
                    break;
                case 2:
                    features.add(Feature.Most_common_keyword);
                    break;
                case 3:
                    features.add(Feature.Most_common_keyword_in_part);
                    break;
                case 4:
                    features.add(Feature.Rel_Number_Of_Occurrences_Keywords);
                    break;
                case 5:
                    features.add(Feature.First_keyword_nr);
                    break;
                case 6:
                    features.add(Feature.Rell_Number_Of_Words_In_Capital_Letters);
                    break;
                case 7:
                    features.add(Feature.Avg_nr_of_words_in_sentence);
                    break;
                case 8:
                    features.add(Feature.Title);
                    break;
                case 9:
                    features.add(Feature.First_keyword);
                    break;
                case 10:
                    features.add(Feature.Currency);
                    break;
            }
        }

    public static void gui_end(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Wyniki", TitledBorder.CENTER, TitledBorder.TOP));
        panel.setLayout(new BorderLayout());
        String [][] data ={{"2","80,3","0.85","0.84","0.26","0.87","0.90","0.11","0.86"},
                         {"5","84","0.70","0.80","0.33","0.90","0.89","0.26","0.79"},
                         {"7","83,6","0.79","0.81","0.30","0.87","0.90","0.23","0.83"},
                         {"10","82,3","0.81","0.79","0.34","0.90","0.89","0.25","0.86"},
                         {"20","82","0.82","0.83","0.35","0.89","0.90","0.13","0.85"},
        };
        String[] title = { "k", "Accuracy", "Precicion","Precicion for usa", "Precicion for uk", "Recall","Recall for usa","Recall fo uk", "F1"};
        JTable tabela = new JTable(data,title);
        //tabela.setSize(800,300);
        tabela.setRowHeight(50);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for (int i=0; i<tabela.getColumnCount(); i++){
            tabela.getColumnModel().getColumn(i).setPreferredWidth(150);
        }

        panel.add(new JScrollPane(tabela),BorderLayout.CENTER);
        frame.pack();
        frame.setSize(1200,700);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Komputerowe systemy rozpoznawania");
        frame.setVisible(true);

    }

}
