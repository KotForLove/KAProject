import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = 10;
        String[] lines = new String[a]; // Масив для збереження рядків
        int count = 0; // Лічильник для кількості зчитаних рядків

        while (scanner.hasNextLine() && count < a) { // Цикл для зчитування рядків до EOF або до 100 рядків
            lines[count] = scanner.nextLine(); // Зберегти кожен рядок в масив
            count++;
        }

        System.out.println("Enter the substring to search: "); // Запит користувача для введення підрядка
        Scanner inputScanner = new Scanner(System.in);
        String substringToSearch = inputScanner.nextLine();

        // Функція для знаходження всіх входжень підрядка у кожному з рядків
        for (int i = 0; i < count; i++) {
            int lastIndex = 0;
            int occurrences = 0;
            while (lastIndex != -1) {
                lastIndex = lines[i].indexOf(substringToSearch, lastIndex);
                if (lastIndex != -1) {
                    occurrences++;
                    lastIndex += substringToSearch.length();
                }
            }
            System.out.println("Occurrences of \"" + substringToSearch + "\" in line " + i + ": " + occurrences);
        }


    }
}
