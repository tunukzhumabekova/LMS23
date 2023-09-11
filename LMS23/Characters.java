package LMS23;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Characters {
        private int id;
        private Map<KeyCharacter, List<String>> characterMap;

        public Characters(int id) {
            this.id = id;
            this.characterMap = new HashMap<>();
        }

        public int getId() {
            return id;
        }

        public Map<KeyCharacter, List<String>> getCharacterMap() {
            return characterMap;
        }

        public void addCharacter(KeyCharacter key, List<String> values) {
            characterMap.put(key, values);
        }
}
