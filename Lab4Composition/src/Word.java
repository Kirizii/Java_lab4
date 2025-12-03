import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє слово як набір літер.
 */
public class Word {

    private final List<Letter> letters = new ArrayList<>();

    public Word(String value) {

        for (char c : value.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(new Letter(c));
            }
        }
    }

    /**
     * Повертає кількість літер у слові.
     */
    public int length() {
        return letters.size();
    }

    /**
     * Перевіряє, чи починається слово з приголосної.
     */
    public boolean startsWithConsonant() {
        if (letters.isEmpty()) {
            return false;
        }
        return letters.get(0).isConsonant();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.getValue());
        }

        return sb.toString();
    }
}
