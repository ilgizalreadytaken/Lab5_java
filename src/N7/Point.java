package N7;

import java.util.Objects;


public class Point {
    private double x;  // Координата X
    private double y;  // Координата Y

    // Конструктор для инициализации координат X и Y
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Геттер для координаты X
    public double getX() {
        return x;
    }

    // Геттер для координаты Y
    public double getY() {
        return y;
    }

    // Метод для получения текстового представления точки
    public String toString() {
        return "{" + x + ";" + y + "}";  // Форматируем строку как "{X;Y}"
    }

    // Переопределение метода equals для правильного сравнения точек
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    // Переопределение метода hashCode для корректной работы в коллекциях
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}