import javax.swing.*;
import java.awt.event.*;

public class LaunchPage implements ActionListener {
    public String Name = "";

    JFrame frame = new JFrame();
    JLabel titleLabel = new JLabel("<html><center>DAA project<br>By:<br>Etienne V, Banquil<br>Aliyah Aira A, Llana<br>Jhoanna May P, Lacorte</center></html>");
    JButton Button1 = new JButton("1. Knapsack");
    JButton Button2 = new JButton("2. Selection Sort");
    JButton Button3 = new JButton("3. Customers Delivery");
    JButton Button4 = new JButton("4. String Matching");
    JButton Button5 = new JButton("5. Exit");

    LaunchPage() {
        int buttonWidth = 200;
        int buttonHeight = 40;
        int numButtons = 4;

        int frameWidth = 280;
        int frameHeight = 460;

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, frameWidth, 100);
        frame.add(titleLabel);

        Button1.setBounds((frameWidth - buttonWidth) / 2, 120, buttonWidth, buttonHeight);
        Button1.setFocusable(false);
        Button1.addActionListener(this);

        Button2.setBounds((frameWidth - buttonWidth) / 2, 170, buttonWidth, buttonHeight);
        Button2.setFocusable(false);
        Button2.addActionListener(this);

        Button3.setBounds((frameWidth - buttonWidth) / 2, 220, buttonWidth, buttonHeight);
        Button3.setFocusable(false);
        Button3.addActionListener(this);

        Button4.setBounds((frameWidth - buttonWidth) / 2, 270, buttonWidth, buttonHeight);
        Button4.setFocusable(false);
        Button4.addActionListener(this);

        Button5.setBounds((frameWidth - buttonWidth) / 2, 320, buttonWidth, buttonHeight);
        Button5.setFocusable(false);
        Button5.addActionListener(this);

        frame.add(Button1);
        frame.add(Button2);
        frame.add(Button3);
        frame.add(Button4);
        frame.add(Button5);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);

        frame.setLocationRelativeTo(null);

        frame.setLayout(null);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Button1) {
            frame.dispose();
            Knapsack window1 = new Knapsack();
        }
        if (e.getSource() == Button2) {
            frame.dispose();
            SortingAlgos SortingAlgos = new SortingAlgos(Knapsack.weightGross);
        }
        if (e.getSource() == Button3) {
            frame.dispose();
            CustomerDelivery CustomerDelivery = new CustomerDelivery();
        }
        if (e.getSource() == Button4) {
            frame.dispose();
            MatcherWindow window1 = new MatcherWindow(Name);
        }
        if (e.getSource() == Button5) {
            frame.dispose();
        }

    }

}
