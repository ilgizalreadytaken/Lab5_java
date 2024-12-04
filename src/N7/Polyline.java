package N7;

import java.util.*;

public class Polyline {
    private Set<Point> points;  // Используем Set, чтобы автоматически исключать дубликаты

    public Polyline(List<Point> points) {
        // Переводим список в Set для удаления дубликатов
        this.points = new LinkedHashSet<>(points);  // Используем LinkedHashSet, чтобы сохранить порядок
    }

    @Override
    public String toString() {
        // Преобразуем точки в строку
        return "Линия " + points.toString();
    }
}
