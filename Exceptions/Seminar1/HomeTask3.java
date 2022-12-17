package Excepts;
/**
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
 * каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
 * Если длины массивов не равны, необходимо как-то оповестить пользователя.
 *
 * В данном решении программа выбросит RunTimeException при несовпадении длин массивов.
 */

import java.util.Arrays;

public class HomeTask3 {
    static int[] diffArray(int[]a1, int[]a2){
        if (a1.length != a2.length){
            throw new RuntimeException("Длины массивов не совпадают");
        }
        int[] diff = new int[a1.length];
        for (int i = 0; i < diff.length ; i++) {
            diff[i] = a2[i] - a1[i];
        }
        return diff;
    }
    public static void main(String[] args) {
        int[]a1 = new int[]{2,4,6,8,10};
        int[]a2 = new int[]{4,9,16,25,36};
        System.out.println(Arrays.toString(diffArray(a1, a2)));
    }
}
