package N1;

public class Fraction implements FractionInterface {
    private int numerator; // Числитель
    private int denominator; // Знаменатель
    private Double cachedDecimalValue = null; // Кэш вещественного значения

    // Конструктор с числителем и знаменателем
    public Fraction(int numerator, int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Знаменатель должен быть положительным!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Возвращает вещественное значение дроби
    @Override
    public double getDecimalValue() {
        if (cachedDecimalValue == null) {
            cachedDecimalValue = (double) numerator / denominator;
        }
        return cachedDecimalValue;
    }

    // Установка числителя
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
        cachedDecimalValue = null; // Обнуляем кэш
    }

    // Установка знаменателя
    @Override
    public void setDenominator(int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Знаменатель должен быть положительным!");
        }
        this.denominator = denominator;
        cachedDecimalValue = null; // Обнуляем кэш
    }

    // Строковое представление дроби
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Сравнение дробей по состоянию
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction other)) return false;
        return this.numerator * other.denominator == this.denominator * other.numerator;
    }
}