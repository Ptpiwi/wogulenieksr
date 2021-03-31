import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        c1.addItem("Długość dokumentu");
        c1.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c1.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c1.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c1.addItem("Liczba słów kluczowych w pierwszej połowie dokumentu");
        c1.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c1.addItem("Względna liczba słów wielką literą");
        c1.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c1.addItem("Pierwsze słowo kluczowe z tytułu dokumentu");
        c1.addItem("Pierwsze słowo kluczowe");
        c1.addItem("Najczęściej występująca w dokumencie waluta");

        c2.setBounds(250,190,450,30);
        c2.addItem("Długość dokumentu");
        c2.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c2.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c2.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c2.addItem("Liczba słów kluczowych w pierwszej połowie dokumentu");
        c2.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c2.addItem("Względna liczba słów wielką literą");
        c2.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c2.addItem("Pierwsze słowo kluczowe z tytułu dokumentu");
        c2.addItem("Pierwsze słowo kluczowe");
        c2.addItem("Najczęściej występująca w dokumencie waluta");

        c3.setBounds(250,230,450,30);
        c3.addItem("Długość dokumentu");
        c3.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c3.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c3.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c3.addItem("Liczba słów kluczowych w pierwszej połowie dokumentu");
        c3.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c3.addItem("Względna liczba słów wielką literą");
        c3.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c3.addItem("Pierwsze słowo kluczowe z tytułu dokumentu");
        c3.addItem("Pierwsze słowo kluczowe");
        c3.addItem("Najczęściej występująca w dokumencie waluta");

        c4.setBounds(250,270,450,30);
        c4.addItem("Długość dokumentu");
        c4.addItem("Najczęstsze słowo kluczowe w dokumencie");
        c4.addItem("Najczęstsze słowo kluczowe w pierwszych 10 % dokumentu");
        c4.addItem("Względna liczba wystąpień słów kluczowych w pierwszych 10 % tekstu");
        c4.addItem("Liczba słów kluczowych w pierwszej połowie dokumentu");
        c4.addItem("Liczba wystąpień pierwszego słowa kluczowego w pierwszych 10% tekstu");
        c4.addItem("Względna liczba słów wielką literą");
        c4.addItem("Średnia ilość słów w zdaniu po użyciu stop listy");
        c4.addItem("Pierwsze słowo kluczowe z tytułu dokumentu");
        c4.addItem("Pierwsze słowo kluczowe");
        c4.addItem("Najczęściej występująca w dokumencie waluta");

        JButton button = new JButton("Zapisz");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wynik = k.getText();
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
