# Завдання 2 - Класи та об'єкти

### Завдання 1

- Розробити клас, що серіалізується, для зберігання параметрів і результатів
обчислень.

### Calculator.java

```java
package pr2;

import java.io.Serializable;

// Клас для зберігання параметрів і результатів обчислень
class CalculationData implements Serializable {
    private static final long serialVersionUID = 1L; // Версія для серіалізації

    private double parameter1;
    private double parameter2;
    private double result;

    public CalculationData(double parameter1, double parameter2, double result) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.result = result;
    }

    // Геттери і сеттери
    public double getParameter1() {
        return parameter1;
    }

    public void setParameter1(double parameter1) {
        this.parameter1 = parameter1;
    }

    public double getParameter2() {
        return parameter2;
    }

    public void setParameter2(double parameter2) {
        this.parameter2 = parameter2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}

// Клас для знаходження рішення задачі
class ProblemSolver implements Serializable {
    private static final long serialVersionUID = 1L; // Версія для серіалізації

    private CalculationData calculationData;

    public ProblemSolver(double parameter1, double parameter2) {
        this.calculationData = new CalculationData(parameter1, parameter2, 0.0);
    }

    // Метод для вирішення задачі
    public void solveProblem() {
        double result = // ваш алгоритм обчислення рішення задачі на основі параметрів
        calculationData.setResult(result);
    }

    // Геттер для отримання результату обчислень
    public double getResult() {
        return calculationData.getResult();
    }
}
```

### Calculation.java

```java
package pr2;

import java.io.*;

// Клас для демонстрації серіалізації та використання transient полів
public class SerializationDemo {
    // Поля класу
    private static final String FILENAME = "object.ser"; // Ім'я файлу для збереження
    private transient int transientField = 10; // Поле, яке буде виключено з серіалізації

    // Головний метод класу для демонстрації
    public static void main(String[] args) {
        SerializationDemo object = new SerializationDemo();
        
        // Серіалізація об'єкта
        serializeObject(object);
        
        // Відновлення об'єкта з файлу
        SerializationDemo restoredObject = deserializeObject();
        
        // Виведення значення transient поля
        System.out.println("Value of transient field after deserialization: " + restoredObject.transientField);
    }

    // Метод для серіалізації об'єкта
    private static void serializeObject(SerializationDemo object) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            out.writeObject(object);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для відновлення об'єкта з файлу
    private static SerializationDemo deserializeObject() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILENAME))) {
            SerializationDemo object = (SerializationDemo) in.readObject();
            System.out.println("Object deserialized successfully.");
            return object;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Метод для перевірки transient поля після серіалізації
    private void checkTransientField() {
        System.out.println("Value of transient field: " + transientField);
    }
}
```

### MainTest.java

```java

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
```



### Використання командного рядка Java

Ця програма призначена для розрахунку частоти серцебиття на основі заданих значень температури тіла людини та індивідуальної фізіологічної норми. Зазначається, що при підвищенні температури на 1 градус частота збільшується на 10 ударів за хвилину.

#### Компіляція та виконання

1. **Компіляція програми:**
javac HeartRateCalculator.java

2. **Виконання програми з передачею аргументів командного рядка:**

java HeartRateCalculator 36.5 70

## Приклад використання:

$ java HeartRateCalculator 36.5 70

3. **Результат розрахунку частоти серцебиття:**

При температурі тіла 36.5 градусів та індивідуальній фізіологічній нормі 70 ударів за хвилину,
частота серцебиття становить 770 ударів за хвилину

### Ось результат ↓

![Результат](/images.png/2.png)

*Автор роботи: Olexandr Tytarenko 34  PPC NTU "KhPI"*