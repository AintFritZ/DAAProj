import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AllCombinationWindow {
    private JFrame frame = new JFrame();
    private DefaultTableModel tableModel = new DefaultTableModel();

    public AllCombinationWindow(List<List<BehindKnapsack.Product>> subsets, JFrame parentFrame) {
        initialize(subsets, parentFrame);
    }

    private void initialize(List<List<BehindKnapsack.Product>> subsets, JFrame parentFrame) {
        int frameWidth = 420;
        int frameHeight = 360;

        int parentX = parentFrame.getX();
        int parentY = parentFrame.getY();
        int parentWidth = parentFrame.getWidth();
        int parentHeight = parentFrame.getHeight();

        int frameX = parentX + parentWidth + 10;
        int frameY = parentY;

        frame.setSize(frameWidth, frameHeight);
        frame.setLocation(frameX, frameY);

        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("All Possible Combinations", SwingConstants.CENTER);
        frame.add(label, BorderLayout.NORTH);

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane, BorderLayout.CENTER);

        tableModel.addColumn("Products");
        tableModel.addColumn("Weight");
        tableModel.addColumn("Total Amount");

        for (List<BehindKnapsack.Product> subset : subsets) {
            double totalWeight = subset.stream().mapToDouble(BehindKnapsack.Product::getWeight).sum();
            int totalAmount = subset.stream().mapToInt(BehindKnapsack.Product::getAmount).sum();
            StringBuilder productsString = new StringBuilder();
            for (BehindKnapsack.Product product : subset) {
                productsString.append(product.getName()).append(", ");
            }
            if (productsString.length() > 1) {
                productsString.setLength(productsString.length() - 2);
            }
            Object[] rowData = {productsString.toString(), totalWeight, totalAmount};
            tableModel.addRow(rowData);
        }

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setVisible(true);
    }
    public void closeWindow() {
        frame.dispose();
    }
}
