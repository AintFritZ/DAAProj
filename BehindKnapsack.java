import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BehindKnapsack {
    static class SubsetSorter {
        public static List<List<Product>> sortByProductName(List<List<Product>> subsets) {
            selectionSort(subsets, Comparator.comparing(s -> s.stream().map(Product::getName).reduce("", String::concat)));
            return subsets;
        }

        public static List<List<Product>> sortByWeightAscending(List<List<Product>> subsets) {
            selectionSort(subsets, Comparator.comparing(s -> s.stream().mapToDouble(Product::getWeight).sum()));
            return subsets;
        }

        public static List<List<Product>> sortByTotalAmount(List<List<Product>> subsets) {
            selectionSort(subsets, Comparator.comparing(s -> s.stream().mapToInt(Product::getAmount).sum()));
            return subsets;
        }

        static void selectionSort(List<List<Product>> subsets, Comparator<List<Product>> comparator) {
            int n = subsets.size();
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (comparator.compare(subsets.get(j), subsets.get(minIndex)) < 0) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    List<Product> temp = subsets.get(i);
                    subsets.set(i, subsets.get(minIndex));
                    subsets.set(minIndex, temp);
                }
            }
        }
    }

    static class Product {
        String name;
        double weight;
        int amount;

        public Product(String name, double weight, int amount) {
            this.name = name;
            this.weight = weight;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public double getWeight() {
            return weight;
        }

        public int getAmount() {
            return amount;
        }
    }

    public static class KnapsackAlgorithm {
        public static List<List<Product>> knapsack(Product[] products, double weightGross) {
            List<List<Product>> subsets = new ArrayList<>();
            int n = products.length;
            int max = 1 << n;

            for (int i = 0; i < max; i++) {
                List<Product> subset = new ArrayList<>();
                double totalWeight = 0;
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        subset.add(products[j]);
                        totalWeight += products[j].weight;
                    }
                }

                if (totalWeight <= weightGross) {
                    subsets.add(subset);
                }
            }

            subsets.add(new ArrayList<>());

            return subsets;
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            double weightGross;
            do {
                System.out.print("Enter the weight gross of the motor vehicle (1-15 kilos): ");
                weightGross = scanner.nextDouble();
                if (weightGross > 15.0) {
                    System.out.println("Invalid. It exceeds weight gross.");
                }
            } while (weightGross > 15.0);

            Product[] products = {
                    new Product("Canned Goods", 5, 450),
                    new Product("Cooking Oil", 3, 725),
                    new Product("Noodles", 2.5, 375),
                    new Product("Soap", 7, 500)
            };

            List<List<Product>> subsets = KnapsackAlgorithm.knapsack(products, weightGross);

            displaySubsets(subsets);

            sortSubsets(scanner, subsets);

            displaySubsets(subsets);
        }

        public static void displaySubsets(List<List<Product>> subsets) {
            System.out.println("Products\t\t\t\t\tWeight\t\tTotal Amount");
            for (List<Product> subset : subsets) {
                double totalWeight = subset.stream().mapToDouble(Product::getWeight).sum();
                int totalAmount = subset.stream().mapToInt(Product::getAmount).sum();
                StringBuilder subsetString = new StringBuilder("{");
                for (Product product : subset) {
                    subsetString.append(product.name).append(", ");
                }
                if (subsetString.length() > 1) {
                    subsetString.setLength(subsetString.length() - 2);
                }
                subsetString.append("}");
                System.out.printf("%-50s%.2f\t\t%d%n", subsetString.toString(), totalWeight, totalAmount);
            }
        }

        public static void sortSubsets(Scanner scanner, List<List<Product>> subsets) {
            System.out.println("\nSort the subsets by:");
            System.out.println("a. Product Name");
            System.out.println("b. Weight");
            System.out.println("c. Total Amount");
            System.out.print("Enter your choice: ");
            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'a':
                    SubsetSorter.sortByProductName(subsets);
                    break;
                case 'b':
                    SubsetSorter.sortByWeightAscending(subsets);
                    break;
                case 'c':
                    SubsetSorter.sortByTotalAmount(subsets);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
