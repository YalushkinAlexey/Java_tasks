package Excepts2;
/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить
 * у пользователя ввод данных.
 */

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Scanner;
public class HomeTask1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            try {
                Number nf = NumberFormat.getNumberInstance().parse(str);
                float f = Float.parseFloat(str);
                System.out.println("введенное число : "+ f);
                break;
            } catch (ParseException e) {
                System.out.println("а вот это уже не Float, давай по новой");
            }
        }
    }
}
