package LMS23;

import java.util.List;
import java.util.Map;

class Product {
    private int id;
    private Category category;
    private String name;
    private Map<KeyCharacter, List<String>> characterMap;
    private double price;

    public Product(int id, Category category, String name, Map<KeyCharacter, List<String>> characterMap, double price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.characterMap = characterMap;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public Map<KeyCharacter, List<String>> getCharacterMap() {
        return characterMap;
    }

    public double getPrice() {
        return price;
    }
}