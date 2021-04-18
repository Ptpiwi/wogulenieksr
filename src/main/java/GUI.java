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
import java.util.Arrays;
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
        metric.addItem("Euclidean");
        metric.addItem("Chebyshev");
        metric.addItem("Manhattan");

        c1.setBounds(250,150,450,30);
        c1.addItem("Wszystkie cechy");
        c1.addItem("Długość dokumentu");
        c1.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c1.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c1.addItem("Pierwsze słowo kluczowe");
        c1.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c1.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c1.addItem("Względna liczba słów wielką literą");
        c1.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c1.addItem("Tytuł dokumentu");
        c1.addItem("Najczęściej występująca w dokumencie waluta");

        c2.setBounds(250,190,450,30);
        c2.addItem("Wszystkie cechy");
        c2.addItem("Długość dokumentu");
        c2.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c2.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c2.addItem("Pierwsze słowo kluczowe");
        c2.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c2.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c2.addItem("Względna liczba słów wielką literą");
        c2.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c2.addItem("Tytuł dokumentu");
        c2.addItem("Najczęściej występująca w dokumencie waluta");

        c3.setBounds(250,230,450,30);
        c3.addItem("Wszystkie cechy");
        c3.addItem("Długość dokumentu");
        c3.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c3.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c3.addItem("Pierwsze słowo kluczowe");
        c3.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c3.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c3.addItem("Względna liczba słów wielką literą");
        c3.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c3.addItem("Tytuł dokumentu");
        c3.addItem("Najczęściej występująca w dokumencie waluta");

        c4.setBounds(250,270,450,30);
        c4.addItem("Wszystkie cechy");
        c4.addItem("Długość dokumentu");
        c4.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c4.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c4.addItem("Pierwsze słowo kluczowe");
        c4.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c4.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c4.addItem("Względna liczba słów wielką literą");
        c4.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c4.addItem("Tytuł dokumentu");
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
                        metric1 = new EuclideanMetric(gram);
                        break;
                    case 1:
                        metric1 = new ChebyshevMetric(gram);
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
                System.out.print((System.currentTimeMillis()-time));
                System.out.println();
                time = System.currentTimeMillis();
                List<ArticleFeatures> tmp = new ArrayList<>(knnMethod.classifyData());
                System.out.print("Classification time:");
                System.out.print((System.currentTimeMillis()-time));
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
                q.setAccuracy(q.calculateAcc(predicted,actual)*100);
                q.setPrecision(q.calculatePrecisionForAll(predicted, actual, labels)*100);
                q.setRecall(q.calculateRecallForAll(predicted, actual, labels)*100);
                q.setPrecision_usa(q.calculatePrecision(predicted,actual,"usa")*100);
                q.setRecall_usa(q.calculateRecall(predicted,actual,"usa")*100);
                q.setPrecision_uk(q.calculatePrecision(predicted,actual,"uk")*100);
                q.setRecall_uk(q.calculateRecall(predicted,actual,"uk")*100);
                q.setPrecision_wg(q.calculatePrecision(predicted,actual,"west-germany")*100);
                q.setRecall_wg(q.calculateRecall(predicted,actual,"west-germany")*100);
                q.setPrecision_france(q.calculatePrecision(predicted,actual,"france")*100);
                q.setRecall_france(q.calculateRecall(predicted,actual,"france")*100);
                q.setPrecision_canada(q.calculatePrecision(predicted,actual,"canada")*100);
                q.setRecall_canada(q.calculateRecall(predicted,actual,"canada")*100);
                q.setPrecision_japan(q.calculatePrecision(predicted,actual,"japan")*100);
                q.setRecall_japan(q.calculateRecall(predicted,actual,"japan")*100);
                q.setF1(q.calculateF1(predicted,actual,labels)*100);
//
                GUI.gui_end(q);
            }
        });
        button.setBounds(250,330,80,30);

        //panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        label.setText("Podaj k: ");
        label2.setText("Wybierz metrykę: ");
        label3.setText("Wybierz ceche: ");
        label4.setText("Podaj wielkość zbioru treningowego [%]: ");
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
                    features.add(Feature.First_keyword);
                    break;
                case 5:
                    features.add(Feature.Rel_Number_Of_Occurrences_Keywords);
                    break;
                case 6:
                    features.add(Feature.First_keyword_nr);
                    break;
                case 7:
                    features.add(Feature.Rell_Number_Of_Words_In_Capital_Letters);
                    break;
                case 8:
                    features.add(Feature.Avg_nr_of_words_in_sentence);
                    break;
                case 9:
                    features.add(Feature.Title);
                    break;
                case 10:
                    features.add(Feature.Currency);
                    break;
            }
        }

    public static void gui_end(QualityOfMeasures q){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(null);
//        panel.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Wyniki", TitledBorder.CENTER, TitledBorder.TOP));
//        panel.setLayout(new BorderLayout());
        JTextField k = new JTextField();
        JTextField acc = new JTextField();
        JTextField recall = new JTextField();
        JTextField prec = new JTextField();
        JTextField recall_usa = new JTextField();
        JTextField prec_usa = new JTextField();
        JTextField recall_uk = new JTextField();
        JTextField prec_uk = new JTextField();
        JTextField recall_wg = new JTextField();
        JTextField prec_wg = new JTextField();
        JTextField recall_fr = new JTextField();
        JTextField prec_fr = new JTextField();
        JTextField recall_can = new JTextField();
        JTextField prec_can = new JTextField();
        JTextField recall_ja = new JTextField();
        JTextField prec_ja = new JTextField();
        JTextField f1 = new JTextField();

        JLabel acc_l= new JLabel();
        JLabel recall_l= new JLabel();
        JLabel prec_l= new JLabel();
        JLabel recall_usa_l= new JLabel();
        JLabel prec_usa_l= new JLabel();
        JLabel recall_uk_l= new JLabel();
        JLabel prec_uk_l= new JLabel();
        JLabel recall_wg_l= new JLabel();
        JLabel prec_wg_l= new JLabel();
        JLabel recall_fr_l= new JLabel();
        JLabel prec_fr_l= new JLabel();
        JLabel recall_can_l= new JLabel();
        JLabel prec_can_l= new JLabel();
        JLabel recall_ja_l= new JLabel();
        JLabel prec_ja_l= new JLabel();
        JLabel f1_l= new JLabel();

        acc_l.setText("Accuracy: ");
        recall_l.setText("Recall: ");
        prec_l.setText("Precision: ");
        recall_usa_l.setText("Recall dla 'usa': ");
        prec_usa_l.setText("Precision dla 'usa': ");
        recall_uk_l.setText("Recall dla 'uk': ");
        prec_uk_l.setText("Precision dla 'uk': ");
        recall_wg_l.setText("Recall dla 'west-germany': ");
        prec_wg_l.setText("Precision dla 'west-germany': ");
        recall_fr_l.setText("Recall dla 'france': ");
        prec_fr_l.setText("Precision dla 'france': ");
        recall_can_l.setText("Recall dla 'canada': ");
        prec_can_l.setText("Precision dla 'canada': ");
        recall_ja_l.setText("Recall dla 'japan': ");
        prec_ja_l.setText("Precision dla 'japan': ");
        f1_l.setText("F1: ");

        acc_l.setBounds(10,10,120,50);
        recall_l.setBounds(10,60,120,50);
        prec_l.setBounds(10,110,120,50);
        recall_usa_l.setBounds(10,160,120,50);
        prec_usa_l.setBounds(10,210,120,50);
        recall_uk_l.setBounds(10,260,120,50);
        prec_uk_l.setBounds(10,310,120,50);
        f1_l.setBounds(10,360,120,50);
        recall_wg_l.setBounds(600,10,300,50);
        prec_wg_l.setBounds(600,60,300,50);
        recall_fr_l.setBounds(600,110,300,50);
        prec_fr_l.setBounds(600,160,300,50);
        recall_can_l.setBounds(600,210,300,50);
        prec_can_l.setBounds(600,260,300,50);
        recall_ja_l.setBounds(600,310,300,50);
        prec_ja_l.setBounds(600,360,300,50);

        acc.setBounds(250,20,120,30);
        recall.setBounds(250,70,120,30);
        prec.setBounds(250,120,120,30);
        recall_usa.setBounds(250,170,120,30);
        prec_usa.setBounds(250,220,120,35);
        recall_uk.setBounds(250,270,120,30);
        prec_uk.setBounds(250,320,120,30);
        f1.setBounds(250,370,120,30);
        recall_wg.setBounds(850,20,120,30);
        prec_wg.setBounds(850,70,120,30);
        recall_fr.setBounds(850,120,120,30);
        prec_fr.setBounds(850,170,120,30);
        recall_can.setBounds(850,220,120,30);
        prec_can.setBounds(850,270,120,30);
        recall_ja.setBounds(850,320,120,30);
        prec_ja.setBounds(850,370,120,30);

        acc.setText(String.valueOf(q.getAccuracy()));
        recall.setText(String.valueOf(q.getRecall()));
        prec.setText(String.valueOf(q.getPrecision()));
        recall_usa.setText(String.valueOf(q.getRecall_usa()));
        prec_usa.setText(String.valueOf(q.getPrecision_usa()));
        recall_uk.setText(String.valueOf(q.getRecall_uk()));
        prec_uk.setText(String.valueOf(q.getPrecision_uk()));
        f1.setText(String.valueOf(q.getF1()));
        recall_wg.setText(String.valueOf(q.getRecall_wg()));
        prec_wg.setText(String.valueOf(q.getPrecision_wg()));
        recall_fr.setText(String.valueOf(q.getRecall_france()));
        prec_fr.setText(String.valueOf(q.getPrecision_france()));
        recall_can.setText(String.valueOf(q.getRecall_canada()));
        prec_can.setText(String.valueOf(q.getPrecision_canada()));
        recall_ja.setText(String.valueOf(q.getRecall_japan()));
        prec_ja.setText(String.valueOf(q.getPrecision_japan()));

        panel.add(acc_l);
        panel.add(recall_l);
        panel.add(prec_l);
        panel.add(recall_usa_l);
        panel.add(prec_usa_l);
        panel.add(recall_uk_l);
        panel.add(prec_uk_l);
        panel.add(recall_wg_l);
        panel.add(prec_wg_l);
        panel.add(recall_fr_l);
        panel.add(prec_fr_l);
        panel.add(recall_can_l);
        panel.add(prec_can_l);
        panel.add(recall_ja_l);
        panel.add(prec_ja_l);
        panel.add(f1_l);

        panel.add(k);
        panel.add(acc);
        panel.add(recall);
        panel.add(prec);
        panel.add(recall_usa);
        panel.add(prec_usa);
        panel.add(recall_uk);
        panel.add(prec_uk);
        panel.add(recall_wg);
        panel.add(prec_wg);
        panel.add(recall_fr);
        panel.add(prec_fr);
        panel.add(recall_can);
        panel.add(prec_can);
        panel.add(recall_ja);
        panel.add(prec_ja);
        panel.add(f1);


        frame.pack();
        frame.setSize(1200,700);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Komputerowe systemy rozpoznawania");
        frame.setVisible(true);

    }

}
