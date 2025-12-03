import java.util.Scanner;

/**
 * Реалізація роботи з текстом через систему класів:
 * Letter -> Word -> Sentence -> Text.
 */
public class Lab4Composition {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть довжину слів для видалення: ");
            int wordLength = scanner.nextInt();
            scanner.nextLine();
            String rawText =
                    "Simple         приклад\t  тексту,   where   слова   of\tрізних   мов   знаходяться   разом.";
            System.out.println("\nПочатковий текст:");
            System.out.println(rawText);
            String normalizedText = rawText.replaceAll("[\\t ]+", " ");
            Text text = Text.parse(normalizedText);
            text.removeWordsByLengthAndConsonantStart(wordLength);

            System.out.println("\nТекст після обробки:");
            System.out.println(text);

        } catch (Exception e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        }
    }
}
