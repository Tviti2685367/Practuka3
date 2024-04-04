package Pr2;
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

