package Seminar3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

/**
 * *Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.
 * (Вставить элемент в список в первой позиции.)
 */
public class Task3 {
    static void fillArray(ArrayList<Integer> list){             // заполнение и сортировка
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(rand.nextInt(1000));
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer t0, Integer t1) {
                return t0 - t1;
            }
        });
        System.out.println(list+" 1000 элем-ов int отсортированых Comparator ");
    }
    // методы для сравнения ArrayList и LinkedList:  количество увеличил, на 1000 итераций  оба метода 1 мсек =)
    static void f1(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        long st = System.currentTimeMillis();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            list.add(0, rand.nextInt(10));
        }
        System.out.println(list);
        long end = System.currentTimeMillis();
        System.out.println(end - st+" мсек. Это ArrayList");
    }

    static void f2(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        long st = System.currentTimeMillis();
        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            list.add(0, rand.nextInt(10));
        }
        System.out.println(list);
        long end = System.currentTimeMillis();
        System.out.println(end - st+" мсек. Это LinkedList");
    }

    public static void main(String[] args) {
        ArrayList<Integer> Numbers = new ArrayList<Integer>();
        long st = System.currentTimeMillis();
        fillArray(Numbers);
        long end = System.currentTimeMillis();
        System.out.println(end - st+" мсек");               // время заполнения и сортировки

        f1();
        f2();
    }
}
