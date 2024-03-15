import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class CustomerDelivery {
    public static String fullAddress = "";
    JFrame frame = new JFrame();
    JLabel customerNameLabel = new JLabel("Customer Name: ");
    JTextField customerNameField = new JTextField();
    JLabel label = new JLabel("Enter address (No, Street Name, Barangay, Municipality, Province): ");
    JTextField textField = new JTextField();
    JButton submitButton = new JButton("Enter");
    JLabel shortestRouteLabel = new JLabel("Shortest Route: ");
    JLabel resultLabel = new JLabel("Total Distance: ");
    JButton returnButton = new JButton("Return to first page");
    JButton addressMatcherButton = new JButton("Open Address Matcher");
    JLabel imgLabel = new JLabel(new ImageIcon("C:\\Users\\evban\\Music\\TSP2.png"));

    CustomerDelivery() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(650, 350);
        frame.setLocationRelativeTo(null);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(imgLabel, BorderLayout.CENTER);

        JPanel customerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints custGbc = new GridBagConstraints();
        custGbc.anchor = GridBagConstraints.WEST;
        custGbc.insets = new Insets(0, 20, 0, 10);
        customerPanel.add(customerNameLabel, custGbc);
        custGbc.gridx = 1;
        custGbc.weightx = 1;
        custGbc.fill = GridBagConstraints.HORIZONTAL;
        customerPanel.add(customerNameField, custGbc);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 20, 0, 10);
        inputPanel.add(label, gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(textField, gbc);

        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitPanel.add(submitButton);

        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultPanel.add(resultLabel);

        JPanel shortestRoutePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        shortestRoutePanel.add(shortestRouteLabel);

        JPanel returnButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        returnButtonPanel.add(returnButton);

        JPanel addressMatcherButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addressMatcherButtonPanel.add(addressMatcherButton);

        JPanel inputSubmitPanel = new JPanel();
        inputSubmitPanel.setLayout(new BoxLayout(inputSubmitPanel, BoxLayout.Y_AXIS));
        inputSubmitPanel.add(customerPanel);
        inputSubmitPanel.add(inputPanel);
        inputSubmitPanel.add(submitPanel);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(inputSubmitPanel, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new GridLayout(4, 1));
        bottomPanel.add(resultPanel);
        bottomPanel.add(shortestRoutePanel);
        bottomPanel.add(returnButtonPanel);
        bottomPanel.add(addressMatcherButtonPanel);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = customerNameField.getText();
                fullAddress = textField.getText();
                String[] addressParts = fullAddress.split(",");
                String municipality = "";
                if (addressParts.length >= 4) {
                    municipality = addressParts[3].trim();
                }
                TSP tsp = new TSP();
                tsp.generateTSPPaths(municipality);

                List<List<String>> tspPaths = tsp.getTspPaths();
                List<String> minPath = tsp.getMinPath();
                int minDistance = tsp.getMinDistance();
                displayResult(minPath, minDistance, customerName);
            }
        });


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LaunchPage launchPage = new LaunchPage();
                frame.dispose();
            }
        });

        addressMatcherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MatcherWindow window = new MatcherWindow(fullAddress);
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public void displayResult(List<String> minPath, int minDistance, String customerName) {
        shortestRouteLabel.setText("Shortest Route for " + customerName + ": " + minPath);
        resultLabel.setText("Total Distance: " + minDistance);
    }

    public static void main(String[] args) {
        new CustomerDelivery();
    }
}
