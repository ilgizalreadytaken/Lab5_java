package N1;

public class Fraction<T extends Number> implements FractionInterface<T> {
    private T numerator; // Числитель
    private T denominator; // Знаменатель
    private Double cachedDecimalValue = null; // Кэш вещественного значения

    // Конструктор с числителем и знаменателем
    public Fraction(T numerator, T denominator) {
        if (denominator.doubleValue() == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулевым!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Возвращает вещественное значение дроби
    @Override
    public double getDecimalValue() {
        if (cachedDecimalValue == null) {
            cachedDecimalValue = numerator.doubleValue() / denominator.doubleValue();
        }
        return cachedDecimalValue;
    }

    // Установка числителя
    @Override
    public void setNumerator(T numerator) {
        this.numerator = numerator;
        cachedDecimalValue = null; // Обнуляем кэш
    }

    // Установка знаменателя
    @Override
    public void setDenominator(T denominator) {
        if (denominator.doubleValue() == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулевым!");
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
        if (!(obj instanceof Fraction<?> other)) return false;
        return this.numerator.doubleValue() * other.denominator.doubleValue() ==
                this.denominator.doubleValue() * other.numerator.doubleValue();
    }
}
