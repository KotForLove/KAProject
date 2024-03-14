import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lines = new String[100]; // Масив для збереження рядків
        int count = 0; // Лічильник для кількості зчитаних рядків

        while (scanner.hasNextLine() && count < 100) { // Цикл для зчитування рядків до EOF або до 100 рядків
            lines[count] = scanner.nextLine(); // Зберегти кожен рядок в масив
            count++;
        }

        for (int i = 0; i < count; i++) { // Цикл для виведення збережених рядків
            System.out.println(lines[i]);
        }

        System.out.println("гальма"); // Стоп слово для перевірки виконання
    }
}
