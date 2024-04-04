package Pr2;
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
