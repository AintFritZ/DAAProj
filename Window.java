import javax.swing.*;

public class Window {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("<html>Enter Products: <br>(Example: Canned Goods, 5, 450)</html>");
    JTextField textField = new JTextField();

    Window() {
        int frameWidth = 420;
        int frameHeight = 420;
        int textFieldWidth = 250;
        int textFieldHeight = 40;
        int labelHeight = 40; 

        int textFieldX = (frameWidth - textFieldWidth) / 2;
        int textFieldY = (frameHeight - textFieldHeight - labelHeight) / 2;

        int labelX = (frameWidth - textFieldWidth) / 2;

        int labelY = textFieldY - labelHeight;

        textField.setBounds(textFieldX, textFieldY, textFieldWidth, textFieldHeight);
        label.setBounds(labelX, labelY, textFieldWidth, labelHeight);

        frame.add(label);
        frame.add(textField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
