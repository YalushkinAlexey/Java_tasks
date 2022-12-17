package Excepts;
/**
 *  Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
 *  и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов
 *  в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
 *  Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException,
 *  т.е. ваше.
 *
 *  Пояснение к решению: Если я правильно понял условие, Исключение должно быть только 1. Поэтому сообщение о некорректной
 *  длине массивов вывел через сообщение в терминале (System.out.println). А RunTimeException оставил для деления на ноль
 */


import java.util.Arrays;

public class HomeTask4 {
    static void divArray(int[]a1, int[]a2){
        int len;
        if (a1.length > a2.length){
            len = a2.length;
            System.out.println("Длина 1го массива больше чем 2го. Поэтому длина результирующего массива будет "+len);
        }
        else if (a1.length < a2.length){
            len = a1.length;
            System.out.println("Длина 2го массива больше чем 1го. Поэтому длина результирующего массива будет "+len);
        }
        double[] div = new double[a1.length];
        for (int i = 0; i < div.length; i++) {
            try {
                div[i] = a2[i] / a1[i];
            }
            catch (Exception e){
                throw new RuntimeException("Деление на ноль не допустимо, я так думаю :)");
           }
        }
        System.out.println(Arrays.toString(div));
    }
    public static void main(String[] args) {
        int[]a1 = new int[]{2, 4, 6, 0};
        int[]a2 = {4, 9, 16, 25, 36};
        divArray(a1, a2);
    }
}
