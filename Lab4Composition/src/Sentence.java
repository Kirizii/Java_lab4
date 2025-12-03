import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє речення,
 * складене зі слів і розділових знаків.
 */
public class Sentence {

    private final List<Object> components = new ArrayList<>();

    public void addComponent(Object element) {
        components.add(element);
    }

    /**
     * Видаляє слова заданої довжини,
     * що починаються з приголосної літери.
     */
    public void removeWordsByLengthAndConsonantStart(int length) {

        List<Object> filtered = new ArrayList<>();

        for (Object obj : components) {
            if (obj instanceof Word) {
                Word word = (Word) obj;

                if (word.length() == length && word.startsWithConsonant()) {
                    continue;
                }
            }
            filtered.add(obj);
        }

        components.clear();
        components.addAll(filtered);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Object previous = null;

        for (Object obj : components) {

            if (obj instanceof Word) {
                if (sb.length() > 0 && !(previous instanceof Punctuation)) {
                    sb.append(" ");
                }
                sb.append(obj.toString());
            }
            else if (obj instanceof Punctuation) {
                sb.append(obj.toString());
            }

            previous = obj;
        }

        return sb.toString();
    }
}
