package LMS23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Gadgetarium {
        private  Map<Integer, Product> productMap;
        private Map<Integer, Characters> characterMap;

        public Gadgetarium() {
            this.productMap = new HashMap<>();
            this.characterMap = new HashMap<>();
        }

        public void saveProduct(Product product) {
            productMap.put(product.getId(), product);
        }

        public void updateProduct(Product updatedProduct) {
            productMap.put(updatedProduct.getId(), updatedProduct);
        }

        public Product getByIdProduct(int productId) {
            return productMap.get(productId);
        }

        public List<Product> searchByProductName(String productName) {
            List<Product> matchingProducts = new ArrayList<>();
            for (Product product : productMap.values()) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    matchingProducts.add(product);
                }
            }
            return matchingProducts;
        }

        public List<Product> filterByCharacter(KeyCharacter key, String value) {
            List<Product> filteredProducts = new ArrayList<>();
            for (Product product : productMap.values()) {
                if (product.getCharacterMap().containsKey(key) &&
                        product.getCharacterMap().get(key).contains(value)) {
                    filteredProducts.add(product);
                }
            }
            return filteredProducts;
        }

        public List<Product> sortByCharacter(KeyCharacter key) {
            List<Product> sortedProducts = new ArrayList<>(productMap.values());
            sortedProducts.sort((p1, p2) -> {
                List<String> values1 = p1.getCharacterMap().get(key);
                List<String> values2 = p2.getCharacterMap().get(key);
                if (values1 == null || values2 == null) {
                    return 0;
                }
                return values1.toString().compareTo(values2.toString());
            });
            return sortedProducts;
        }

        public void deleteByProduct(int productId) {
            productMap.remove(productId);
        }

        public List<Product> getAllProducts() {
            return new ArrayList<>(productMap.values());
        }

        public void deleteCharacterByKeyName(int characterId, KeyCharacter key) {
            Characters characters = characterMap.get(characterId);
            if (characters != null) {
                characters.getCharacterMap().remove(key);
            }
        }

        public void deleteAllCharacters() {
            characterMap.clear();
        }

    public void saveCharacter(Characters characters1) {
    }
}
