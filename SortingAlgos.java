import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;

public class SortingAlgos {
    JFrame frame = new JFrame();
    private SortingProcessWindow previousWindow;
    private double weightGross;
    private List<List<BehindKnapsack.Product>> subsets;

    JLabel instructions = new JLabel("Sort the subsets by: ", SwingConstants.CENTER);
    JButton ButtonA = new JButton("a. Product Name");
    JButton ButtonB = new JButton("b. Weight");
    JButton ButtonC = new JButton("c. Total Amount");


    SortingAlgos(double weightGross) {
        this.weightGross = weightGross;
        this.subsets = BehindKnapsack.KnapsackAlgorithm.knapsack(Knapsack.products, weightGross);

        instructions.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        panel.add(instructions, gbc);
        panel.add(ButtonA, gbc);
        panel.add(ButtonB, gbc);
        panel.add(ButtonC, gbc);


        ButtonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<List<BehindKnapsack.Product>> subsetsSortedByName = BehindKnapsack.SubsetSorter.sortByProductName(subsets);
                BehindKnapsack.Main.displaySubsets(subsetsSortedByName);

                if (previousWindow != null) {
                    previousWindow.closeWindow();
                }
                previousWindow = new SortingProcessWindow(subsetsSortedByName, frame);
            }
        });
        ButtonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<List<BehindKnapsack.Product>> subsetsSortedByWeight = BehindKnapsack.SubsetSorter.sortByWeightAscending(subsets);
                BehindKnapsack.Main.displaySubsets(subsets);
                if (previousWindow != null) {
                    previousWindow.closeWindow();
                }
                previousWindow = new SortingProcessWindow(subsetsSortedByWeight, frame);
            }
        });
        ButtonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<List<BehindKnapsack.Product>> subsetsSortedByAmount = BehindKnapsack.SubsetSorter.sortByTotalAmount(subsets);
                BehindKnapsack.Main.displaySubsets(subsets);
                BehindKnapsack.Main.displaySubsets(subsets);
                if (previousWindow != null) {
                    previousWindow.closeWindow();
                }
                previousWindow = new SortingProcessWindow(subsetsSortedByAmount, frame);
            }
        });

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        new SortingAlgos(knapsack.weightGross);
    }
}
