package N8;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class NameNumberStream {

    // Метод для обработки файла и группировки людей по номерам
    public static Map<Integer, List<String>> processNamesFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Чтение строк из файла
            return reader.lines()
                    // Разделяем строку на имя и номер по символу ":"
                    .map(line -> line.split(":"))
                    // Отфильтровываем строки, которые не содержат номера, или где номер пустой
                    .filter(parts -> parts.length == 2 && !parts[1].isEmpty())
                    // Группируем людей по их номерам, сортируя номера в порядке возрастания
                    .collect(Collectors.groupingBy(
                            parts -> Integer.parseInt(parts[1]),  // Используем номер в качестве ключа
                            TreeMap::new,  // Сортировка по ключу (номеру)
                            Collectors.mapping(
                                    parts -> capitalize(parts[0]),  // Преобразуем имя в формат с первой заглавной буквой
                                    Collectors.toList())  // Составляем список имен для каждого номера
                    ));
        } catch (IOException e) {
            // Если произошла ошибка при чтении файла, выводим информацию об ошибке
            e.printStackTrace();
            return Collections.emptyMap();  // Возвращаем пустую карту в случае ошибки
        }
    }

    // Метод для приведения первого символа имени к верхнему регистру, а остальных — к нижнему
    private static String capitalize(String name) {
        // Проверяем, что имя не пустое или null
        if (name == null || name.isEmpty()) {
            return name;  // Если имя пустое, возвращаем его без изменений
        }
        // Преобразуем первый символ в верхний регистр, остальные — в нижний
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}

/*
В обычном классе без использования стримов мы могли бы использовать
более традиционные структуры данных, такие как циклы for или while,
чтобы обрабатывать данные построчно и вручную управлять состоянием.
В отличие от этого, Stream API представляет собой декларативный способ
обработки данных, где мы определяем шаги обработки (например, фильтрацию,
преобразование и сбор данных) и стрим сам управляет процессом.
 */