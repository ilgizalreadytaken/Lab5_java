package N6;

import java.util.*;

public class QueueCheck {
    // Метод для проверки, есть ли в очереди хотя бы один элемент, равный следующему за ним
    public static boolean checkQueue(Queue<Number> queue) {
        // Если очередь пустая или содержит только один элемент, то ничего не проверяем
        if (queue.size() <= 1) {
            return false;
        }

        // Преобразуем очередь в список для удобства обращения по индексам
        List<Number> list = new ArrayList<>(queue);

        // Проверяем, равен ли текущий элемент следующему, учитывая круговой порядок
        for (int i = 0; i < list.size(); i++) {
            int nextIndex = (i + 1) % list.size(); // Индекс следующего элемента по кругу
            if (list.get(i).equals(list.get(nextIndex))) {
                return true; // Если нашли равные элементы, возвращаем true
            }
        }

        return false; // Если равных элементов нет
    }
}
