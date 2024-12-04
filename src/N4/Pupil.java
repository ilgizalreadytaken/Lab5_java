package N4;

public class Pupil {
    // Фамилия ученика
    private String surname;

    // Имя ученика
    private String name;

    // Массив оценок ученика
    private int[] scores;

    // Конструктор для инициализации ученика
    public Pupil(String surname, String name, int[] scores) {
        this.surname = surname;  // Устанавливаем фамилию ученика
        this.name = name;        // Устанавливаем имя ученика
        this.scores = scores;    // Устанавливаем массив оценок ученика
    }

    // Метод для вычисления общей суммы баллов ученика
    public int getTotalScore() {
        int total = 0;  // Переменная для хранения общей суммы баллов

        // Проходим по всем оценкам ученика и суммируем их
        for (int score : scores) {
            total += score;
        }

        // Возвращаем итоговую сумму баллов
        return total;
    }

    // Переопределённый метод toString для вывода фамилии и имени ученика
    @Override
    public String toString() {
        return surname + " " + name;  // Возвращаем строку с фамилией и именем
    }
}
