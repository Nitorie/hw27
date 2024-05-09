import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private List<String> words;
    private String targetText;

    public Model() {
        words = new ArrayList<>();
        loadWordsFromFile("src/Words.txt");
        targetText = getRandomWord();
    }

    private void loadWordsFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim().toLowerCase()); // Делаем каждое слово маленьким
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.get(index);
    }

    public String getTargetText() {
        return targetText;
    }
}