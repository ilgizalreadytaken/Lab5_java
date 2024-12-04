package N3;

import java.util.ArrayList;
import java.util.List;

public class ListMerger {

    // Метод для слияния двух отсортированных списков
    public static List<Integer> mergeSortedLists(List<Integer> L1, List<Integer> L2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        // Слияние двух отсортированных списков
        while (i < L1.size() && j < L2.size()) {
            // Если элемент из списка L1 меньше или равен элементу из списка L2, добавляем его в mergedList
            if (L1.get(i) <= L2.get(j)) {
                mergedList.add(L1.get(i)); // Добавляем текущий элемент из L1
                i++; // Переходим к следующему элементу в L1
            } else {
                mergedList.add(L2.get(j)); // Добавляем текущий элемент из L2
                j++; // Переходим к следующему элементу в L2
            }
        }

        // Добавляем оставшиеся элементы из списка L1, если они есть
        while (i < L1.size()) {
            mergedList.add(L1.get(i)); // Добавляем оставшиеся элементы из L1 в mergedList
            i++; // Переходим к следующему элементу в L1
        }

        // Добавляем оставшиеся элементы из списка L2, если они есть
        while (j < L2.size()) {
            mergedList.add(L2.get(j)); // Добавляем оставшиеся элементы из L2 в mergedList
            j++; // Переходим к следующему элементу в L2
        }

        return mergedList;
    }
}
