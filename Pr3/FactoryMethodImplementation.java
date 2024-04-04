// Інтерфейс для фабрикуючого методу
interface ShapeFactory {
    Shape createShape();
}

// Класи, що реалізують інтерфейс ShapeFactory
class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}

// Основний клас програми
public class FactoryMethodImplementation {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();  // Виводить "Drawing Circle"

        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();  // Виводить "Drawing Rectangle"
    }
}
