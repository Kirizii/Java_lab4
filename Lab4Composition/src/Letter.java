/**
 * Клас, що представляє одну літеру.
 */
public class Letter {

    private final char value;

    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    /**
     * Перевіряє, чи є літера приголосною.
     */
    public boolean isConsonant() {
        char ch = Character.toLowerCase(value);
        String vowels = "aeiouаеєиіїоуюя";
        return Character.isLetter(ch) && vowels.indexOf(ch) == -1;
    }
}
