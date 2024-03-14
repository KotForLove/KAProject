import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 10; //кількість рядків для тесту
        String[] lines = new String[a]; // Масив для збереження рядків
        int count = 0; // Лічильник для кількості зчитаних рядків

        while (scanner.hasNextLine() && count < a) { // Цикл для зчитування рядків до EOF або до 100 рядків
            lines[count] = scanner.nextLine(); // Зберегти кожен рядок в масив
            count++;
        }

        System.out.println("Enter the substring to search: "); // Запит користувача для введення підрядка
        Scanner inputScanner = new Scanner(System.in);
        String substringToSearch = inputScanner.nextLine();

        int[] occurrencesArray = new int[count]; // Масив для збереження кількості входжень в кожному рядку

        // Знайти кількість входжень підрядка в кожному рядку і зберегти їх у масив
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
            occurrencesArray[i] = occurrences;
        }

        // Сортування масиву occurrencesArray за допомогою алгоритму сортування злиттям
        mergeSort(occurrencesArray, 0, count - 1);

        // Вивести результати у форматі "<кількість входжень> <індекс рядка у текстовому файлі починаючи з 0>"
        for (int i = 0; i < count; i++) {
            System.out.println(occurrencesArray[i] + " " + lines[i]);
        }

    }

    // Функція сортування злиттям
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    // Функція поєднання двох підмасивів
    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}
