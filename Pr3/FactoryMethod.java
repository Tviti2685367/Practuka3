// Базовий клас, що визначає метод фабрики
abstract class Shape {
    abstract void draw();
}

// Конкретні підкласи класу Shape
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Rectangle");
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

        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();  // Виводить "Drawing Rectangle"
    }
}
