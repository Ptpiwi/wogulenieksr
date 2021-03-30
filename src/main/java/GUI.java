import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JLabel label;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JFrame frame;
    private JPanel panel;
    JTextField k;
    JTextField podzial;
    JComboBox metric;
    JComboBox c1;
    JComboBox c2;
    JComboBox c3;
    JComboBox c4;

    public GUI() {
        frame = new JFrame();
        k = new JTextField();
        podzial = new JTextField();
        metric = new JComboBox();
        c1 = new JComboBox();
        c2 = new JComboBox();
        c3 = new JComboBox();
        c4 = new JComboBox();
        label = new JLabel();
        label2= new JLabel();
        label3= new JLabel();
        label4= new JLabel();
        panel = new JPanel(null);
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

        JButton button = new JButton("Zapisz");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wynik = k.getText();
            }
        });
        button.setBounds(220,250,80,30);

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
        panel.add(podzial);
        panel.add(button);

        frame.pack();
        frame.setSize(750,370);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Komputerowe systemy rozpoznawania");
        frame.setVisible(true);
    }
}
