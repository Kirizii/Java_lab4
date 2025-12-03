/**
 * Клас, що представляє розділовий знак.
 */
public class Punctuation {

    private final char value;

    public Punctuation(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
