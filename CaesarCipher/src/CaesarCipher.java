import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CaesarCipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String OUTPUT_FILE_PATH = "output.txt";

    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            int index = ALPHABET.indexOf(character);
            if (index != -1) {
                int newIndex = (index + key) % ALPHABET.length();
                result.append(ALPHABET.charAt(newIndex));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static String decrypt(String text, int key) {
        return encrypt(text, ALPHABET.length() - key);
    }

    public static void processFile(int key, boolean encrypt) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(INPUT_FILE_PATH)));
        String result = encrypt ? encrypt(content, key) : decrypt(content, key);
        Files.write(Paths.get(OUTPUT_FILE_PATH), result.getBytes());
    }

    public static void bruteForceDecrypt() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(INPUT_FILE_PATH)));
        for (int key = 1; key < ALPHABET.length(); key++) {
            System.out.println("Key " + key + ": " + decrypt(content, key));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите режим: \n1. Шифрование \n2. Расшифрование \n3. Brute Force");
        int mode = scanner.nextInt();
        scanner.nextLine();

        if (!new File(INPUT_FILE_PATH).exists()) {
            System.out.println("Файл не найден!");
            return;
        }

        if (mode == 3) {
            try {
                bruteForceDecrypt();
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла.");
            }
            return;
        }

        System.out.println("Введите ключ:");
        int key = scanner.nextInt();
        scanner.nextLine();

        try {
            processFile(key, mode == 1);
            System.out.println("Операция успешно выполнена! Файл сохранён в " + OUTPUT_FILE_PATH);
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файла.");
        }
    }
}