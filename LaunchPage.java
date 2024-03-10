import javax.swing.*;
import java.awt.event.*;

public class LaunchPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton Button1 = new JButton("1. Knapsack");
    JButton Button2 = new JButton("2. Selection Sort");
    JButton Button3 = new JButton("3. Customers Delivery");
    JButton Button4 = new JButton("4. String Matching");

    LaunchPage(){

        int buttonWidth = 200;
        int buttonHeight = 40;
        int numButtons = 4;

        int centerX = (frame.getWidth() - buttonWidth) / 2;
        int centerY = (frame.getHeight() - (buttonHeight * numButtons + (numButtons - 1) * 10)) / 2;

        Button1.setBounds(centerX, centerY, buttonWidth, buttonHeight);
        Button1.setFocusable(false);
        Button1.addActionListener(this);

        Button2.setBounds(centerX, centerY + (buttonHeight + 10), buttonWidth, buttonHeight);
        Button2.setFocusable(false);
        Button2.addActionListener(this);

        Button3.setBounds(centerX, centerY + 2 * (buttonHeight + 10), buttonWidth, buttonHeight);
        Button3.setFocusable(false);
        Button3.addActionListener(this);

        Button4.setBounds(centerX, centerY + 3 * (buttonHeight + 10), buttonWidth, buttonHeight);
        Button4.setFocusable(false);
        Button4.addActionListener(this);

        frame.add(Button1);
        frame.add(Button2);
        frame.add(Button3);
        frame.add(Button4);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);

        frame.setLayout(null);
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int centerX = (frame.getWidth() - buttonWidth) / 2;
                int centerY = (frame.getHeight() - (buttonHeight * numButtons + (numButtons - 1) * 10)) / 2;
                Button1.setBounds(centerX, centerY, buttonWidth, buttonHeight);
                Button2.setBounds(centerX, centerY + (buttonHeight + 10), buttonWidth, buttonHeight);
                Button3.setBounds(centerX, centerY + 2 * (buttonHeight + 10), buttonWidth, buttonHeight);
                Button4.setBounds(centerX, centerY + 3 * (buttonHeight + 10), buttonWidth, buttonHeight);
            }
        });
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Button1){
            frame.dispose();
            Window window1 = new Window();
        }
        if(e.getSource()==Button4){
            frame.dispose();
            MatcherWindow window1 = new MatcherWindow();
        }

    }

}
