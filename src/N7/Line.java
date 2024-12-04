package N7;

public class Line {
    private Point start; // Начало линии
    private Point end;   // Конец линии

    // Конструктор
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    // Текстовое представление линии
    @Override
    public String toString() {
        return "Линия от " + start + " до " + end;
    }
}
