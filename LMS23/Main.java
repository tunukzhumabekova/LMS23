package LMS23;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Gadgetarium gadgetarium = new Gadgetarium();
        Product product1 = new Product(1, Category.PHONE, "Phone Model X", new HashMap<>(), 499.99);
        Product product2 = new Product(2, Category.LAPTOP, "Laptop Model A", new HashMap<>(), 999.99);

        Characters characters1 = new Characters(1);
        characters1.addCharacter(KeyCharacter.CPU, Arrays.asList("Intel i7", "AMD Ryzen"));
        characters1.addCharacter(KeyCharacter.RAM, Arrays.asList("16GB", "32GB"));

        gadgetarium.saveProduct(product1);
        gadgetarium.saveProduct(product2);
        gadgetarium.saveCharacter(characters1);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nGadgetarium Menu:");
            System.out.println("1. Get Product by ID");
            System.out.println("2. Search Products by Name");
            System.out.println("3. Filter Products by Character");
            System.out.println("4. Sort Products by Character");
            System.out.println("5. Delete Product by ID");
            System.out.println("6. Get All Products");
            System.out.println("7. Delete Character by Key Name");
            System.out.println("8. Delete All Characters");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    Product getProduct = gadgetarium.getByIdProduct(productId);
                    if (getProduct != null) {
                        System.out.println("Product found: " + getProduct.getName());
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine();
                    List<Product> searchResults = gadgetarium.searchByProductName(searchName);
                    if (!searchResults.isEmpty()) {
                        System.out.println("Matching products:");
                        for (Product product : searchResults) {
                            System.out.println(product.getName());
                        }
                    } else {
                        System.out.println("No matching products found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter character key (CPU, RAM, OTHER1, OTHER2, OTHER3): ");
                    String characterKey = scanner.next();
                    System.out.print("Enter character value to filter: ");
                    String characterValue = scanner.next();

                    KeyCharacter key = KeyCharacter.valueOf(characterKey.toUpperCase()); // Convert input to enum

                    List<Product> filteredProducts = gadgetarium.filterByCharacter(key, characterValue);
                    if (!filteredProducts.isEmpty()) {
                        System.out.println("Matching products:");
                        for (Product product : filteredProducts) {
                            System.out.println(product.getName());
                        }
                    } else {
                        System.out.println("No matching products found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter character key (CPU, RAM, OTHER1, OTHER2, OTHER3): ");
                    String sortCharacterKey = scanner.next();

                    KeyCharacter sortKey = KeyCharacter.valueOf(sortCharacterKey.toUpperCase()); // Convert input to enum

                    List<Product> sortedProducts = gadgetarium.sortByCharacter(sortKey);
                    if (!sortedProducts.isEmpty()) {
                        System.out.println("Sorted products by " + sortKey + ":");
                        for (Product product : sortedProducts) {
                            System.out.println(product.getName());
                        }
                    } else {
                        System.out.println("No products found to sort by " + sortKey + ".");
                    }
                    break;
                case 5:
                    System.out.print("Enter product ID to delete: ");
                    int deleteProductId = scanner.nextInt();
                    gadgetarium.deleteByProduct(deleteProductId);
                    System.out.println("Product deleted.");
                    break;
                case 6:
                    List<Product> allProducts = gadgetarium.getAllProducts();
                    System.out.println("All products:");
                    for (Product product : allProducts) {
                        System.out.println(product.getName());
                    }
                    break;
                case 7:
                    System.out.print("Enter character ID to delete: ");
                    int characterIdToDelete = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter character key to delete (CPU, RAM, OTHER1, OTHER2, OTHER3): ");
                    String characterKeyToDelete = scanner.next();

                    KeyCharacter keyToDelete = KeyCharacter.valueOf(characterKeyToDelete.toUpperCase());

                    gadgetarium.deleteCharacterByKeyName(characterIdToDelete, keyToDelete);
                    System.out.println("Character deleted.");
                    break;

                case 8:
                    gadgetarium.deleteAllCharacters();
                    System.out.println("All characters deleted.");
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 9);
    }
}
