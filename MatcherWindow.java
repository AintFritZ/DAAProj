import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MatcherWindow {

    String mainAddress = CustomerDelivery.fullAddress;
    JFrame frame = new JFrame();
    JLabel mainAddressLabel = new JLabel("Enter New Main Address:");
    JLabel currentAddressLabel = new JLabel("Currently Entered Address: " + CustomerDelivery.fullAddress);
    JLabel textToMatchLabel = new JLabel("Enter Text to be Matched:");
    JTextField mainAddressField = new JTextField();
    JTextField textToMatchField = new JTextField();
    JButton enterButton = new JButton("Enter");
    JButton matchButton = new JButton("Match");
    JLabel occurrencesLabel = new JLabel("Occurrences: ");
    JLabel positionsLabel = new JLabel("Positions: ");
    JButton backButton = new JButton("Back to First Page");

    String currentAddress;

    MatcherWindow(String fullAddress) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 260);
        frame.setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.add(mainAddressLabel);
        inputPanel.add(mainAddressField);
        inputPanel.add(currentAddressLabel);
        inputPanel.add(new JLabel(""));
        inputPanel.add(textToMatchLabel);
        inputPanel.add(textToMatchField);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        JPanel buttonPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel1.add(enterButton);
        buttonPanel1.add(matchButton);
        buttonPanel.add(buttonPanel1);
        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel2.add(backButton);
        buttonPanel.add(buttonPanel2);

        JPanel resultPanel = new JPanel(new GridLayout(3, 1));
        resultPanel.add(occurrencesLabel);
        resultPanel.add(positionsLabel);
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(resultPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainAddress = mainAddressField.getText();
                currentAddress = "Currently Entered Address: " + mainAddress;
                currentAddressLabel.setText(mainAddress);
            }
        });

        matchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textToMatch = textToMatchField.getText();
                matcher(mainAddress, textToMatch);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LaunchPage launchPage = new LaunchPage();
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public void matcher(String MainAddy, String textToMatch){
        int occ = 0;
        String MainAddyUpper = MainAddy.toUpperCase();
        String[] MainAddyArray = MainAddyUpper.split("\\W+");

        textToMatch = textToMatch.toUpperCase();

        StringBuilder positionsStringBuilder = new StringBuilder();
        for (int i = 0; i < MainAddyArray.length; i++) {
            if (textToMatch.equals(MainAddyArray[i])) {
                occ++;
                positionsStringBuilder.append(i + 1).append(" ");
            }
        }

        occurrencesLabel.setText("Occurrences: " + occ);
        positionsLabel.setText("Positions: " + positionsStringBuilder.toString());
    }

    //public static void main(String[] args) {
        //new MatcherWindow();
    //}
}
