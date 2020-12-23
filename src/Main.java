import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
           Fraction f1 = new Fraction(22, 10); //Создание дробей
           Fraction f2 = new Fraction(17, 19);
           System.out.println(f1.sum(f1, f2));  //Сложение
           System.out.println(f1.sub(f1, f2));  //Вычитание
           System.out.println(f1.comp(f1, f2)); //Умножение
           System.out.println(f1.div(f1, f2));  //Деление
    }
}
