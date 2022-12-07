import java.util.ArrayList;
import java.util.Random;

/**
 * Первый семинар.
 * 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
 * 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
 * 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
 * 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
 *
 * Пункты реализовать в методе main
 * *Пункты реализовать в разных методах
 *
 * int i = new Random().nextInt(k); //это кидалка случайных чисел!)
 */
public class JavaSeminar1 {
    static int randNum(){                       //псевдослуч. число
        int r = new Random().nextInt(2001);
        System.out.println("Случайное число = "+r);
        return r;
    }
    static int oldestBit(int i){                //старший значащий бит числа
        int x ;
        String str = Integer.toString(i, 2);
        System.out.println(str);
        x = str.length();
        System.out.println("номер старшего бита = "+x);
        return x;
    }
    static boolean multipleNum(int del, int num){    //проверка на кратность
        if (num % del == 0){
            return true;
        }
        else return false;
    }
    static void printAr(ArrayList<Integer> m){          //вывод на печать
        System.out.println(m.toString());
    }
    public static void main(String[] args) {
        ArrayList<Integer> m1 = new ArrayList<Integer>();  // т.к. не ясно какова будет величина массива, выбираем ArrayList
        ArrayList<Integer> m2 = new ArrayList<Integer>();
        int i = randNum();
        int n = oldestBit(i);
        for (int j = 1; j < Short.MAX_VALUE; j++){
            if (multipleNum(n, j)){
                m1.add(j);
            }
        }
        for (int j = Short.MIN_VALUE; j < i; j++){
            if (!multipleNum(n, j)){
                m2.add(j);
            }
        }
        printAr(m1);
        printAr(m2);
    }
}
