package N4;

import java.util.*;
import java.util.stream.Collectors;

public class Competition {
    private Map<Pupil, Integer> pupilScores; // Словарь для хранения участников и их суммарных баллов

    public Competition() {
        pupilScores = new HashMap<>(); // Инициализация словаря HashMap
    }

    public void addPupil(String surname, String name, int[] scores) {
        Pupil pupil = new Pupil(surname, name, scores); // Создаем объект Pupil
        int totalScore = pupil.getTotalScore(); // Считаем суммарный балл
        pupilScores.put(pupil, totalScore); // Добавляем участника и его баллы в словарь
    }

    /*
     * Метод для получения топ-3 участников и тех, кто набрал одинаковое количество баллов с ними.
     * @return список участников.
     */
    public List<Pupil> getTopThreeWithTies() {
        // Преобразуем словарь в список записей (ключ-значение) и сортируем их по убыванию баллов
        List<Map.Entry<Pupil, Integer>> sortedEntries = pupilScores.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())) // Сортировка по значению (баллам)
                .collect(Collectors.toList()); // Преобразование в список

        // Если участников меньше 3, возвращаем их всех
        if (sortedEntries.size() <= 3) {
            return sortedEntries.stream()
                    .map(Map.Entry::getKey) // Извлекаем ключи (участники)
                    .collect(Collectors.toList());
        }

        // Определяем уникальные значения баллов для топ-3 участников
        Set<Integer> topScores = new HashSet<>();
        for (int i = 0; i < sortedEntries.size() && topScores.size() < 3; i++) {
            topScores.add(sortedEntries.get(i).getValue()); // Добавляем баллы в множество
        }

        // Возвращаем всех участников, чьи баллы совпадают с баллами из топ-3
        return sortedEntries.stream()
                .filter(entry -> topScores.contains(entry.getValue())) // Фильтруем по топовым баллам
                .map(Map.Entry::getKey) // Извлекаем участников (ключи словаря)
                .collect(Collectors.toList()); // Преобразуем в список
    }
}


/**
 * Алгоритм метода getTopThreeWithTies:
 * 1. Получить записи (entry) из словаря (Map), содержащие участников и их баллы.
 * 2. Отсортировать записи по убыванию баллов.
 *    - Используем Stream API для сортировки.
 * 3. Проверить количество участников:
 *    - Если участников 3 или меньше, вернуть всех участников.
 * 4. Найти уникальные баллы для топ-3 мест:
 *    - Создать множество (Set) для хранения уникальных баллов.
 *    - Проходить по отсортированным записям, добавляя баллы в множество, пока оно не будет содержать 3 элемента.
 * 5. Отобрать участников, чьи баллы входят в топ-3:
 *    - Используем фильтрацию с помощью Stream API.
 *    - Проверяем, входят ли баллы участника в множество топ-3 баллов.
 * 6. Вернуть список участников, удовлетворяющих условиям.
 */

