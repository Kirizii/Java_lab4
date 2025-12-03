import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє текст як набір речень.
 */
public class Text {

    private final List<Sentence> sentences = new ArrayList<>();

    /**
     * Парсить рядок у структуру класів Text → Sentence → Word + Punctuation.
     */
    public static Text parse(String text) {

        Text result = new Text();
        Sentence sentence = new Sentence();
        StringBuilder wordBuffer = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                wordBuffer.append(c);
            } else {

                if (!wordBuffer.isEmpty()) {
                    sentence.addComponent(new Word(wordBuffer.toString()));
                    wordBuffer.setLength(0);
                }

                if (isPunctuation(c)) {
                    sentence.addComponent(new Punctuation(c));
                }

                if (c == '.' || c == '!' || c == '?') {
                    result.sentences.add(sentence);
                    sentence = new Sentence();
                }
            }
        }

        if (!wordBuffer.isEmpty()) {
            sentence.addComponent(new Word(wordBuffer.toString()));
        }

        if (!sentence.toString().isEmpty()) {
            result.sentences.add(sentence);
        }

        return result;
    }

    private static boolean isPunctuation(char c) {
        return ",.:;!?\"()".indexOf(c) != -1;
    }

    /**
     * Видаляє в усьому тексті слова заданої довжини,
     * що починаються з приголосної.
     */
    public void removeWordsByLengthAndConsonantStart(int wordLength) {

        for (Sentence sentence : sentences) {
            sentence.removeWordsByLengthAndConsonantStart(wordLength);
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Sentence sentence : sentences) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(sentence.toString());
        }

        return sb.toString();
    }
}

