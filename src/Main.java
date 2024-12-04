import N1.Fraction;
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
                    Fraction fraction = new Fraction(3, 4);
                    System.out.println("Дробь: " + fraction);
                    System.out.println("Вещественное значение : " + fraction.getDecimalValue());
                    System.out.println("Кэшированное значение : " + fraction.getDecimalValue());
                    fraction.setNumerator(6); // Установим новый числитель
                    System.out.println("Обновлённая дробь : " + fraction);
                    System.out.println("Новое вещественное значение : " + fraction.getDecimalValue());

                    fraction.setDenominator(8); // Установим новый знаменатель
                    System.out.println("Обновлённая дробь : " + fraction);
                    System.out.println("Новое вещественное значение : " + fraction.getDecimalValue());
                    Fraction fraction2 = new Fraction(6, 8);
                    System.out.println("Новая вторая дробь: " + fraction2);
                    if (fraction.equals(fraction2)) {
                        System.out.println(fraction + " " + "и" + " " + fraction2 + " " + "равны.");
                    } else {
                        System.out.println(fraction + "и" + fraction2 + "не равны.");
                    }
                    break;

                case 2:

                    break;

                case 3:
                    // Ввод списков L1 и L2
                    System.out.println("Введите элементы первого списка (L1), разделенные пробелами:");
                    List<Integer> L1 = readList(scanner);

                    System.out.println("Введите элементы второго списка (L2), разделенные пробелами:");
                    List<Integer> L2 = readList(scanner);

                    // Выводим исходные списки
                    System.out.println("Исходный список L1: " + L1);
                    System.out.println("Исходный список L2: " + L2);

                    // Слияние списков
                    List<Integer> mergedList = ListMerger.mergeSortedLists(L1, L2);

                    // Выводим результат
                    System.out.println("Результат слияния: " + mergedList);
                    break;

                case 4:
                    // Открываем файл и читаем данные
                    Competition competition = new Competition();
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("src/N4/Pupils.txt"));
                        String line;

                        // Чтение количества участников
                        int n = Integer.parseInt(reader.readLine());

                        // Чтение информации о каждом участнике
                        for (int i = 0; i < n; i++) {
                            line = reader.readLine();
                            String[] data = line.split(" ");
                            String surname = data[0];
                            String name = data[1];
                            int[] scores = new int[4];

                            // Считывание баллов
                            for (int j = 0; j < 4; j++) {
                                scores[j] = Integer.parseInt(data[2 + j]);
                            }

                            // Добавление участника в соревнование
                            competition.addPupil(surname, name, scores);
                        }

                        // Закрытие файла
                        reader.close();

                    } catch (IOException e) {
                        System.out.println("Ошибка при чтении файла: " + e.getMessage());
                        return;
                    }

                    // Получаем лучших участников
                    System.out.println("Лучшие участники многоборья:");
                    List<Pupil> topPupils = competition.getTopThree();
                    for (Pupil pupil : topPupils) {
                        System.out.println(pupil);
                    }
                    break;

                case 5:
                    // Вызываем метод из класса N5.ConsonantsInSingleWord и передаем путь к файлу
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

                    // Создаем очередь
                    Queue<Number> queue = new LinkedList<>();

                    // Запрашиваем элементы очереди
                    System.out.println("Введите элементы очереди (целые или вещественные числа):");

                    // Для каждого элемента проверяем, является ли он числом
                    for (int i = 0; i < n; i++) {
                        String input = scanner.next();

                        // Проверяем, является ли введенная строка числом
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
                                // Если ввод не является числом, выводим ошибку и завершаем ввод
                                System.out.println("Ошибка: введён нечисловой элемент. Программа завершена.");
                                return;
                            }
                        }
                    }

                    // Вызов метода из класса N6.QueueCheck для проверки очереди
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