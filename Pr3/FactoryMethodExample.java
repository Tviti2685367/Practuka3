// Інтерфейс, що визначає методи для відображення результатів обчислень
interface Displayable {
    void displayResult();
}

// Базовий клас, що реалізує інтерфейс Displayable
abstract class Shape implements Displayable {
    abstract void draw();
}

// Конкретні підкласи класу Shape
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }

    @Override
    public void displayResult() {
        System.out.println("Displaying Circle Result");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Rectangle");
    }

    @Override
    public void displayResult() {
        System.out.println("Displaying Rectangle Result");
    }
}

// Фабричний метод для створення об'єктів типу Shape
abstract class ShapeFactory {
    abstract Shape createShape();
}

// Конкретні фабрики для створення конкретних об'єктів
class CircleFactory extends ShapeFactory {
    @Override
    Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory extends ShapeFactory {
    @Override
    Shape createShape() {
        return new Rectangle();
    }
}

// Клас, що використовує фабрику для створення об'єктів
public class FactoryMethodExample {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();  // Виводить "Drawing Circle"
        circle.displayResult(); // Виводить "Displaying Circle Result"

        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();  // Виводить "Drawing Rectangle"
        rectangle.displayResult(); // Виводить "Displaying Rectangle Result"
    }
}
