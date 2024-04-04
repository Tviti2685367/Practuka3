package Pr2;
/**
 * Клас для розрахунку частоти серцебиття.
 */
public class HeartRateCalculator {
    // Базова частота серцебиття в здоровому стані
    private static final int BASE_HEART_RATE = 60; // ударів за хвилину
    // Нормальна температура тіла людини
    private static final double NORMAL_BODY_TEMPERATURE = 37.0; // градуси Цельсія
    // Коефіцієнт зміни частоти за градус температури
    private static final int RATE_CHANGE_PER_DEGREE = 10; // ударів за хвилину на градус Цельсія

    /**
     * Метод для розрахунку частоти серцебиття.
     * @param bodyTemperature температура тіла (градуси Цельсія)
     * @return частота серцебиття (ударів за хвилину)
     */
    public static int calculateHeartRate(double bodyTemperature) {
        return BASE_HEART_RATE + (int) ((bodyTemperature - NORMAL_BODY_TEMPERATURE) * RATE_CHANGE_PER_DEGREE);
    }

    public static void main(String[] args) {
        // Приклад використання
        double bodyTemperature = 38.5; // Припустимо, що температура тіла становить 38.5 градусів Цельсія
        int heartRate = calculateHeartRate(bodyTemperature);
        System.out.println("Частота серцебиття при температурі " + bodyTemperature + " градусів Цельсія: " + heartRate + " ударів за хвилину");
    }
}
