package Pr2;
import java.io.*;

/**
 * Клас для тестування коректності результатів обчислень та серіалізації/десеріалізації.
 */
public class CalculatorTest {

    /**
     * Метод для тестування коректності результатів обчислень.
     */
    public void testCalculations() {
        // Створюємо об'єкт класу ProblemSolver для вирішення задачі з обчисленням
        ProblemSolver solver = new ProblemSolver(10, 5);
        // Викликаємо метод для вирішення задачі
        solver.solveProblem();
        
        // Отримуємо результат обчислення
        double result = solver.getResult();
        
        // Очікуваний результат
        double expected = 15;
        
        // Перевіряємо, чи результат обчислення відповідає очікуваному результату
        if (result == expected) {
            System.out.println("Calculation test passed successfully.");
        } else {
            System.out.println("Calculation test failed.");
        }
    }

    /**
     * Метод для тестування серіалізації/десеріалізації.
     */
    public void testSerialization() {
        // Створюємо об'єкт класу SerializationDemo для серіалізації/десеріалізації
        SerializationDemo object = new SerializationDemo();
        
        // Серіалізуємо об'єкт
        serializeObject(object);
        
        // Відновлюємо об'єкт з файлу
        SerializationDemo restoredObject = deserializeObject();
        
        // Перевіряємо, чи відновлений об'єкт дорівнює початковому
        if (object.equals(restoredObject)) {
            System.out.println("Serialization test passed successfully.");
        } else {
            System.out.println("Serialization test failed.");
        }
    }

    /**
     * Метод для серіалізації об'єкта.
     */
    private void serializeObject(SerializationDemo object) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("object.ser"))) {
            out.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для десеріалізації об'єкта.
     */
    private SerializationDemo deserializeObject() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("object.ser"))) {
            return (SerializationDemo) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
