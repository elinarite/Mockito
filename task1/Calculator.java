package mockito.task1;
//уровень сложности: Уровень сложности 1 из 10:
//Создайте класс Calculator, который содержит метод add(int a, int b) для сложения
//двух чисел. Напишите тест, используя Mockito, чтобы убедиться, что метод add был
// вызван правильно.
public class Calculator {
    private int a;
    private int b;

    public Calculator() {
    }

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int add(int a, int b){
        return a * b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
