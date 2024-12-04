package N4;

import java.util.*;

public class Competition {
    // Список участников соревнования
    private List<Pupil> pupils;

    // Конструктор, который инициализирует список участников
    public Competition() {
        pupils = new ArrayList<>();  // Инициализация пустого списка участников
    }

    // Метод для добавления участника в соревнование
    public void addPupil(String surname, String name, int[] scores) {
        // Создаем нового ученика и добавляем его в список
        pupils.add(new Pupil(surname, name, scores));
    }

    // Метод для получения списка троих лучших участников (с учетом одинаковых баллов)
    public List<Pupil> getTopThree() {
        // Сортируем участников по убыванию их общей суммы баллов
        pupils.sort((p1, p2) -> Integer.compare(p2.getTotalScore(), p1.getTotalScore()));

        // Создаем список для топ-участников
        List<Pupil> topPupils = new ArrayList<>();

        // Проверяем, что список участников не пуст
        if (pupils.size() > 0) {
            // Добавляем первого участника (с наибольшим количеством баллов)
            topPupils.add(pupils.get(0)); // 1-й участник

            // Если есть второй участник, добавляем его
            if (pupils.size() > 1) {
                topPupils.add(pupils.get(1)); // 2-й участник
            }

            // Если есть третий участник, добавляем его
            if (pupils.size() > 2) {
                topPupils.add(pupils.get(2)); // 3-й участник
            }

            // Получаем сумму баллов для каждого из трех лучших участников
            int top1Score = pupils.get(0).getTotalScore(); // Баллы первого участника
            int top2Score = pupils.size() > 1 ? pupils.get(1).getTotalScore() : Integer.MIN_VALUE; // Баллы второго участника (если есть)
            int top3Score = pupils.size() > 2 ? pupils.get(2).getTotalScore() : Integer.MIN_VALUE; // Баллы третьего участника (если есть)

            // Проходим по всем участникам и добавляем тех, у кого баллы совпадают с лучшими тремя
            for (Pupil pupil : pupils) {
                int pupilScore = pupil.getTotalScore(); // Баллы текущего участника
                // Если баллы ученика совпадают с баллами любого из трех лучших
                if (pupilScore == top1Score || pupilScore == top2Score || pupilScore == top3Score) {
                    // Добавляем ученика в список топ-участников, если его там нет (чтобы избежать дублирования)
                    if (!topPupils.contains(pupil)) {
                        topPupils.add(pupil);
                    }
                }
            }
        }

        // Возвращаем список топ-участников
        return topPupils;
    }
}
