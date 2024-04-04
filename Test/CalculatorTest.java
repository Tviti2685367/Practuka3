import Pr2.ProblemSolver; // Додамо імпорт класу ProblemSolver

// Додамо ключове слово public до класу CalculatorTest
public class CalculatorTest {

    // Додамо ключове слово public до методу testCalculations
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
}
