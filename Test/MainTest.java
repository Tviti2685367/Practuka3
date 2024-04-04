package Test;

import Pr.Main;

public class MainTest {

    public static void main(String[] args) {
        // Перевірка, чи програма коректно виводить повідомлення, якщо немає аргументів командного рядка 
        testNoArguments();
         
        // Перевірка, чи програма коректно виводить передані аргументи командного рядка 
        testWithArguments();
    }

    public static void testNoArguments() {
        String[] args = {};
        Main.main(args); // Викликаємо метод main з класу Main 
    }

    public static void testWithArguments() {
        String[] args = {"Hello", "World!", "Olexandr"};
        Main.main(args); // Викликаємо метод main з класу Main 
    }
}