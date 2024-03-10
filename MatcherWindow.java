import javax.swing.*;
import java.awt.event.*;

public class MatcherWindow {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Enter Main Address: ");
    JLabel label2 = new JLabel("Enter Text to be Matched: ");
    JTextField textField = new JTextField();
    JTextField textField2 = new JTextField();
    JButton matchButton = new JButton("Match");
    JTextArea console = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(console);

    String mainAddress;
    String textToMatch;

    MatcherWindow() {
        int frameWidth = 420;
        int frameHeight = 420;
        int labelWidth = 150;
        int labelHeight = 40;
        int textFieldWidth = 200;
        int textFieldHeight = 30;
        int buttonWidth = 100;
        int buttonHeight = 30;
        int consoleWidth = 380;
        int consoleHeight = 100;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(null);
        frame.setResizable(true);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                repositionComponents();
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Set initial positions
        label.setBounds(20, (frameHeight - labelHeight) / 2 - 60, labelWidth, labelHeight);
        textField.setBounds(labelWidth + 30, (frameHeight - textFieldHeight) / 2 - 60, textFieldWidth, textFieldHeight);
        label2.setBounds(20, (frameHeight - labelHeight) / 2 - 20, labelWidth, labelHeight);
        textField2.setBounds(labelWidth + 30, (frameHeight - textFieldHeight) / 2 - 20, textFieldWidth, textFieldHeight);
        matchButton.setBounds((frameWidth - buttonWidth) / 2, (frameHeight - buttonHeight) / 2 + 20, buttonWidth, buttonHeight);
        scrollPane.setBounds((frameWidth - consoleWidth) / 2, (frameHeight - consoleHeight) / 2 + 60, consoleWidth, consoleHeight);

        frame.add(label);
        frame.add(label2);
        frame.add(textField);
        frame.add(textField2);
        frame.add(matchButton);
        frame.add(scrollPane);

        matchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainAddress = textField.getText();
                textToMatch = textField2.getText();
                matcher(mainAddress, textToMatch);
            }
        });
    }

    private void repositionComponents() {
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        int labelWidth = 150;
        int labelHeight = 40;
        int textFieldWidth = 200;
        int textFieldHeight = 30;
        int buttonWidth = 100;
        int buttonHeight = 30;
        int consoleWidth = 380;
        int consoleHeight = 100;
        int verticalOffset = 30;

        label.setBounds((frameWidth - labelWidth - textFieldWidth - 30) / 2, (frameHeight - labelHeight) / 2 - 60, labelWidth, labelHeight);
        textField.setBounds(label.getX() + labelWidth + 30, (frameHeight - textFieldHeight) / 2 - 60, textFieldWidth, textFieldHeight);
        label2.setBounds((frameWidth - labelWidth - textFieldWidth - 30) / 2, (frameHeight - labelHeight) / 2 - 20, labelWidth, labelHeight);
        textField2.setBounds(label2.getX() + labelWidth + 30, (frameHeight - textFieldHeight) / 2 - 20, textFieldWidth, textFieldHeight);
        matchButton.setBounds((frameWidth - buttonWidth) / 2, (frameHeight - buttonHeight) / 2 + 20, buttonWidth, buttonHeight);
        scrollPane.setBounds((frameWidth - consoleWidth) / 2, (frameHeight - consoleHeight) / 2 + 60 + verticalOffset, consoleWidth, consoleHeight);
    }

    public void matcher(String MainAddy, String Addy){
        int occ = 0;
        String MainAddyUpper = MainAddy.toUpperCase();
        String[] MainAddyArray = MainAddyUpper.split("\\W+");

        Addy = Addy.toUpperCase();

        StringBuilder occurencesStringBuilder = new StringBuilder("Number Of Occurrences: ");
        StringBuilder positionsStringBuilder = new StringBuilder("Words Positions: ");

        for (int i = 0; i < MainAddyArray.length; i++) {
            if (Addy.equals(MainAddyArray[i])) {
                occ++;
                positionsStringBuilder.append(i + 1).append(" ");
            }
        }
        occurencesStringBuilder.append(occ);

        console.append(occurencesStringBuilder.toString() + "\n");
        console.append(positionsStringBuilder.toString() + "\n");
    }
}
