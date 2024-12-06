package N5;

import java.io.*;
import java.util.*;

public class ConsonantsInSingleWord {
    // Метод для извлечения всех согласных букв, которые встречаются ровно в одном слове
    public static Set<Character> getConsonantsFromFile(String filePath) {
        Set<Character> consonants = new TreeSet<>(); // Множество для хранения согласных, которые встречаются только в одном слове
        Set<Character> consonantsInMultipleWords = new HashSet<>(); // Множество для согласных, встречающихся в нескольких словах
        Set<Character> currentWordConsonants = new HashSet<>(); // Множество для хранения согласных, встречающихся в текущем слове

        // Множество согласных букв русского алфавита
        String consonantSet = "бвгджзклмнпрстфхцчшщ";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Чтение файла построчно
            while ((line = reader.readLine()) != null) {
                // Разделяем строку на слова
                String[] words = line.split("\\s+");

                // Обрабатываем каждое слово
                for (String word : words) {
                    currentWordConsonants.clear(); // Очищаем множество перед обработкой нового слова
                    // Проходим по каждой букве слова
                    for (char c : word.toLowerCase().toCharArray()) {
                        // Проверяем, является ли буква согласной
                        if (consonantSet.indexOf(c) >= 0) {
                            currentWordConsonants.add(c); // Добавляем согласную в множество текущего слова
                        }
                    }

                    // Если в слове есть согласные, добавляем их в соответствующие множества
                    for (char c : currentWordConsonants) {
                        if (consonants.contains(c)) {
                            // Если согласная уже встречалась, добавляем её в множество для многократных букв
                            consonantsInMultipleWords.add(c);
                        } else {
                            // Иначе добавляем согласную в основное множество
                            consonants.add(c);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Обработка ошибок при чтении файла
        }

        // Убираем из множества согласных те, которые встречаются в нескольких словах
        consonants.removeAll(consonantsInMultipleWords);

        // Возвращаем результат: множество согласных, встречающихся ровно в одном слове
        return consonants;
    }
}

/*
Алгоритм для извлечения согласных, встречающихся ровно в одном слове:
Инициализируем три множества:
  consonants — для хранения согласных, которые встречаются только в одном слове.
  consonantsInMultipleWords — для согласных, встречающихся в нескольких словах.
  currentWordConsonants — для согласных, встречающихся в текущем слове.

Читаем файл построчно.
Для каждой строки:
  Разделяем строку на слова.
  Для каждого слова:
    Проходим по буквам и добавляем согласные в currentWordConsonants.
    Если согласная уже встречалась, добавляем её в consonantsInMultipleWords, иначе — в consonants.
    После обработки всех слов удаляем из множества consonants те согласные,
        которые встречаются в нескольких словах (передаются в consonantsInMultipleWords).
    Возвращаем результат — множество согласных, встречающихся ровно в одном слове.

Добавление в consonants:
Когда мы встречаем согласную, она добавляется в consonants, если она встречалась только в текущем слове.

Добавление в consonantsInMultipleWords:
Когда согласная встречается в другом слове, она добавляется в consonantsInMultipleWords.
Однако это не означает, что она автоматически удаляется из consonants. */

