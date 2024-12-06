import N1.Fraction;
import N2.Cat;
import N2.MeowCounter;
import N3.ListMerger;
import N4.Competition;
import N4.Pupil;
import N5.ConsonantsInSingleWord;
import N6.QueueCheck;
import N7.Point;
import N7.Polyline;
import N8.NameNumberStream;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {

    // Универсальный метод для чтения списка строк (или других типов данных)
    public static <T> List<T> readList(Scanner scanner, Class<T> clazz) {
        // Создаём список для хранения введённых данных
        List<T> list = new ArrayList<>();

        // Чтение строки ввода от пользователя
        String input = scanner.nextLine();

        // Разделяем строку по пробелам на отдельные элементы
        String[] tokens = input.split("\\s+");

        // Проходим по каждому элементу массива и пытаемся преобразовать в нужный тип
        for (String token : tokens) {
            try {
                // Если тип данных - String (строки или символы)
                if (clazz.equals(String.class)) {
                    list.add(clazz.cast(token)); // Добавляем строку в список
                }
                // Если тип данных - Integer (целое число)
                else if (clazz.equals(Integer.class)) {
                    list.add(clazz.cast(Integer.parseInt(token))); // Преобразуем строку в число и добавляем в список
                }
            } catch (Exception e) {
                // Если произошла ошибка преобразования, выводим сообщение и повторяем ввод
                System.out.println("Некорректный ввод, введите только корректные данные.");
                return readList(scanner, clazz); // Повторный вызов метода для ввода данных
            }
        }

        // Возвращаем заполненный список
        return list;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nВыберите задание:");
            System.out.println("1 - Дроби");
            System.out.println("2 - Количество мяуканий ");
            System.out.println("3 - Вставить элементы списка L1 в список L2 ");
            System.out.println("4 - Многоборье ");
            System.out.println("5 - Cогласные буквы в одно слово");
            System.out.println("6 - Очередь");
            System.out.println("7 - Стрим");
            System.out.println("8 - Файл со строками");
            System.out.println("0 - Выход");
            System.out.println("Введите цифру задания: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Чистим буфер перед чтением следующей строки

            switch (choice) {
                case 1:
                    // Пример использования с дробью типа Integer
                    Fraction<Integer> fraction = new Fraction<>(3, 4);
                    System.out.println("Дробь: " + fraction);
                    System.out.println("Вещественное значение : " + fraction.getDecimalValue());
                    System.out.println("Кэшированное значение : " + fraction.getDecimalValue());

                    // Устанавливаем новый числитель
                    fraction.setNumerator(6);
                    System.out.println("Обновлённая дробь : " + fraction);
                    System.out.println("Новое вещественное значение : " + fraction.getDecimalValue());

                    // Устанавливаем новый знаменатель
                    fraction.setDenominator(8);
                    System.out.println("Обновлённая дробь : " + fraction);
                    System.out.println("Новое вещественное значение : " + fraction.getDecimalValue());

                    // Создаём вторую дробь для сравнения
                    Fraction<Integer> fraction2 = new Fraction<>(6, 8);
                    System.out.println("Новая вторая дробь: " + fraction2);
                    if (fraction.equals(fraction2)) {
                        System.out.println(fraction + " и " + fraction2 + " равны.");
                    } else {
                        System.out.println(fraction + " и " + fraction2 + " не равны.");
                    }
                    break;

                case 2:
                    List<MeowCounter> counters = new ArrayList<>(); // Список счетчиков котов
                    System.out.print("Введите количество котов/кошек: ");
                    while (!scanner.hasNextInt()) { // Проверка на ввод числа
                        System.out.print("Ошибка! Введите целое число: ");
                        scanner.next(); // Очистка ввода
                    }
                    int numberOfCats = scanner.nextInt();
                    scanner.nextLine(); // Очистка буфера после ввода числа

                    for (int i = 0; i < numberOfCats; i++) {
                        System.out.print("Введите имя кота/кошки " + (i + 1) + ": ");
                        String name = scanner.nextLine();
                        counters.add(new MeowCounter(new Cat(name))); // Создаем кота и добавляем в список счетчиков
                    }

                    // Вывод строкового представления всех котов
                    System.out.println("Список котов/кошек: ");
                    for (int i = 0; i < counters.size(); i++) {
                        System.out.println(i + 1 + ". " + counters.get(i).getCat().toString()); // Выводим строковое представление кота с индексом
                    }

                    // Цикл для мяуканья
                    while (true) {
                        System.out.print("Выберите кота/кошку, чтобы погладить (введите номер кота/кошки)\nИли введите 0, чтобы погладить всех\nИли введите -1, чтобы закончить. \nВыбранное действие: ");
                        while (!scanner.hasNextInt()) { // Проверка на ввод числа
                            System.out.print("Ошибка! Введите целое число: ");
                            scanner.next(); // Очистка ввода
                        }
                        int choice2 = scanner.nextInt();

                        if (choice2 == 0) {
                            // Гладим всех котов/кошек
                            System.out.println("Все коты/кошки: ");
                            for (MeowCounter counter : counters) {
                                counter.meow(); // Вызываем мяуканье для каждого кота
                            }
                        } else if (choice2 == -1) {
                            break; // Выход из цикла, если введено -1
                        } else if (choice2 > 0 && choice2 <= counters.size()) {
                            // Гладим выбранного кота
                            counters.get(choice2 - 1).meow(); // Вызываем мяуканье для выбранного кота
                        } else {
                            System.out.println("Выбран неверный номер кота/кошки.");
                        }
                    }

                    // Вывод количества мяуканий для каждого кота
                    System.out.println("\nКоличество мяуканий для каждого кота:");
                    for (MeowCounter counter : counters) {
                        System.out.println(counter.getCat().toString() + " мяукал " + counter.getMeowCount() + " раз(а).");
                    }

                    // Возвращаемся к менюшке
                    System.out.println(); // Оставляем пустую строку для красоты
                    break;

                case 3:
                    // Запрос типа данных для ввода: числа или строки
                    System.out.println("Введите тип данных (1 - числа, 2 - строки):");

                    // Чтение ввода пользователя для выбора типа данных
                    int dataTypeChoice = scanner.nextInt();

                    // Поглощаем символ новой строки, который остаётся после ввода числа
                    scanner.nextLine();

                    // Обработчик данных в зависимости от выбора пользователя
                    if (dataTypeChoice == 1) {  // Если выбран тип данных - числа
                        // Запрос на ввод элементов первого списка (L1)
                        System.out.println("Введите элементы первого списка (L1), разделенные пробелами:");

                        // Чтение списка целых чисел
                        List<Integer> L1 = readList(scanner, Integer.class);

                        // Запрос на ввод элементов второго списка (L2)
                        System.out.println("Введите элементы второго списка (L2), разделенные пробелами:");

                        // Чтение второго списка целых чисел
                        List<Integer> L2 = readList(scanner, Integer.class);

                        // Слияние двух отсортированных списков L1 и L2
                        List<Integer> mergedList = ListMerger.mergeSortedLists(L1, L2);

                        // Выводим результат слияния двух списков
                        System.out.println("Результат слияния: " + mergedList);
                    } else if (dataTypeChoice == 2) {  // Если выбран тип данных - строки
                        // Запрос на ввод элементов первого списка (L1)
                        System.out.println("Введите элементы первого списка (L1), разделенные пробелами:");

                        // Чтение списка строк
                        List<String> L1 = readList(scanner, String.class);

                        // Запрос на ввод элементов второго списка (L2)
                        System.out.println("Введите элементы второго списка (L2), разделенные пробелами:");

                        // Чтение второго списка строк
                        List<String> L2 = readList(scanner, String.class);

                        // Слияние двух отсортированных списков строк L1 и L2
                        List<String> mergedList = ListMerger.mergeSortedLists(L1, L2);

                        // Выводим результат слияния двух списков
                        System.out.println("Результат слияния: " + mergedList);
                    } else {
                        // Если пользователь ввел некорректный выбор типа данных
                        System.out.println("Некорректный выбор типа данных.");
                    }
                    break;


                case 4:
                    // Создаем объект класса Competition для хранения данных о соревновании
                    Competition competition = new Competition();

                    try (BufferedReader reader = new BufferedReader(new FileReader("src/N4/Pupils.txt"))) {
                        // Читаем первое значение из файла — количество участников
                        int n = Integer.parseInt(reader.readLine());

                        // Обрабатываем данные каждого участника
                        for (int i = 0; i < n; i++) {
                            String[] data = reader.readLine().split(" "); // Разделяем строку по пробелам
                            String surname = data[0]; // Фамилия участника
                            String name = data[1];    // Имя участника
                            int[] scores = new int[4]; // Массив для хранения баллов

                            // Считываем 4 балла участника
                            for (int j = 0; j < 4; j++) {
                                scores[j] = Integer.parseInt(data[2 + j]); // Преобразуем строку в число
                            }

                            // Добавляем участника в коллекцию соревнования
                            competition.addPupil(surname, name, scores);
                        }
                    } catch (IOException e) {
                        // Обрабатываем ошибки при чтении файла и завершаем выполнение case
                        System.out.println("Ошибка при чтении файла: " + e.getMessage());
                        return;
                    }

                    // Выводим лучших участников соревнования
                    System.out.println("Лучшие участники многоборья:");
                    List<Pupil> topPupils = competition.getTopThreeWithTies(); // Получаем список лучших участников
                    for (Pupil pupil : topPupils) {
                        // Печатаем информацию об участнике
                        System.out.println(pupil);
                    }
                    break;


                case 5:
                    Set<Character> result = ConsonantsInSingleWord.getConsonantsFromFile("src/N5/Text.txt");

                    // Выводим результат
                    System.out.println("Согласные буквы, которые входят ровно в одно слово:");
                    for (char c : result) {
                        System.out.println(c);
                    }
                    break;

                case 6:
                    // Запрашиваем у пользователя количество элементов в очереди
                    int n = -1;
                    while (n <= 0) {
                        System.out.print("Введите количество элементов в очереди (положительное целое число): ");
                        if (scanner.hasNextInt()) {
                            n = scanner.nextInt();
                            if (n <= 0) {
                                System.out.println("Ошибка: количество элементов должно быть положительным числом.");
                            }
                        } else {
                            System.out.println("Ошибка: введено нецелое число. Попробуйте снова.");
                            scanner.next(); // Очистить буфер ввода
                        }
                    }

                    // Создаём очередь с обобщённым типом
                    Queue<Object> queue = new LinkedList<>();

                    // Запрашиваем элементы очереди
                    System.out.println("Введите элементы очереди (целые числа, вещественные числа или символы):");

                    for (int i = 0; i < n; i++) {
                        String input = scanner.next();

                        try {
                            // Пробуем парсить как целое число
                            Integer num = Integer.parseInt(input);
                            queue.add(num); // Добавляем целое число в очередь
                        } catch (NumberFormatException e1) {
                            try {
                                // Пробуем парсить как вещественное число
                                Double num = Double.parseDouble(input);
                                queue.add(num); // Добавляем вещественное число в очередь
                            } catch (NumberFormatException e2) {
                                // Если это не число, добавляем как символ/строку
                                queue.add(input.charAt(0)); // Берём первый символ строки
                            }
                        }
                    }

                    // Вызов метода из класса QueueCheck для проверки очереди
                    boolean result1 = QueueCheck.checkQueue(queue);

                    // Выводим результат
                    if (result1) {
                        System.out.println("В очереди есть хотя бы один элемент, равный следующему за ним.");
                    } else {
                        System.out.println("В очереди нет элементов, равных следующему за ним.");
                    }
                    break;

                case 7:
                    // Создаем набор точек
                    List<Point> points = Arrays.asList(
                            new Point(1.0, 2.0),
                            new Point(2.0, -5.0),
                            new Point(3.0, -4.0),
                            new Point(3.0, 4.0),
                            new Point(2.0, 5.0),
                            new Point(1.0, 2.0)  // Повторяющаяся точка
                    );

                    // Обработка точек с помощью стрима
                    Polyline polyline = new Polyline(
                            points.stream()
                                    .distinct() // Убираем точки с одинаковыми координатами X и Y
                                    .map(p -> new Point(p.getX(), Math.abs(p.getY()))) // Преобразуем Y в положительное
                                    .sorted(Comparator.comparingDouble(Point::getX)) // Сортируем по X
                                    .toList() // Собираем результат в список точек
                    );

                    // Вывод результата
                    System.out.println(polyline);
                    break;

                    /*
                    Удаление одинаковых объектов Point (с одинаковыми X и Y).
                    Сортировка точек по координате X.
                    Преобразование отрицательных координат Y в положительные.
                    Сбор всех точек в объект Polyline — ломаную линию.
                     */

                case 8:
                    // Вызов стрима для обработки имен из файла
                    String filePath = "src/N8/Imena.txt";  // Путь к файлу
                    Map<Integer, List<String>> result8 = NameNumberStream.processNamesFromFile(filePath);

                    // Выводим результат
                    System.out.println(result8);
                    break;

                case 0:
                    exit = true; // Завершаем цикл, если выбрали выход
                    break;

                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }
        }
        scanner.close();
    }
    // Метод для чтения списка с клавиатуры
    private static List<Integer> readList(Scanner scanner) {
        List<Integer> list = new ArrayList<>();
        String input = scanner.nextLine();
        String[] items = input.split("\\s+");

        for (String item : items) {
            try {
                list.add(Integer.parseInt(item));
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод, введите только числа.");
            }
        }
        return list;
    }

}