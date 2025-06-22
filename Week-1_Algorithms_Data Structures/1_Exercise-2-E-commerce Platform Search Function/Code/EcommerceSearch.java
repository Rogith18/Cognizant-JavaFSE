import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {

    static class Product {
        int productId;
        String name;
        String category;

        Product(int productId, String name, String category) {
            this.productId = productId;
            this.name = name;
            this.category = category;
        }
    }

    static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == targetId) return products[mid];
            if (products[mid].productId < targetId) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    static void printProduct(Product product) {
        if (product != null) {
            System.out.println("[" + product.productId + "] " + product.name + " (" + product.category + ")");
        } else {
            System.out.println("Product not found");
        }
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(101, "Phone", "Electronics"),
            new Product(103, "Shoes", "Fashion"),
            new Product(102, "Book", "Education"),
            new Product(104, "Watch", "Accessories")
        };

        System.out.println("Linear Search for ID 103:");
        Product result1 = linearSearch(products, 103);
        printProduct(result1);

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("\nBinary Search for ID 103:");
        Product result2 = binarySearch(products, 103);
        printProduct(result2);
    }
}
