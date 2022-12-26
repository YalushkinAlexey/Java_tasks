package Seminar6;

import java.util.*;

/**
 * Объявить и инициализировать экземпляр класса HashSet. Обобщение String.
 * Добавить пять элементов в множество.
 * Отсортировать значения используя итератор.
 * Отсортированный результат сохранить в LinkedHashSet
 * Создать TreeSet с компаратором.
 * Скопировать содержимое первого множества (HashSet) в TreeSet.
 * *Скорректировать компаратор так, чтобы поля хранились в обратном порядке.
 */
public class ControlHomeWork {
    static HashSet putTo(HashSet<String> set, String element){    // 2. задание.  вызывается в цикле в main
        set.add(element);
        return set;
    }
    static void printSet(HashSet<String>set){
        System.out.println(set);
    }
    static LinkedHashSet sort(HashSet<String> set){
        LinkedHashSet<String> lSet = new LinkedHashSet<>();
        Iterator<String> iterator= set.iterator(); {
        }
        String str = "";
        while (iterator.hasNext()){        // получаем список итераторов, закидываем в строку/   Задание 3
            str+= iterator.next()+" ";
        }
        String [] arr = str.substring(0,str.length()-1).split(" ");  //  дальше сортировка тудой - сюдой
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (maxStr(arr[i],arr[j])){
                    String tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
            //System.out.println("this is just "+i+" row of array<String> "+arr[i]);
            lSet.add(arr[i]);   // Отсортированный элемент укладывается в LinkedHashSet   // Задание 4
        }
        System.out.println("This is LinkedHashSet "+lSet);
        return lSet;
    }
    //Сравнение строк
    static boolean maxStr(String s1, String s2){
        int len = 0;
        boolean flag = false;
        if (s1.length()>s2.length()){len = s2.length();}
        else len = s1.length();
        for (int i = 0; i < len ; i++) {
            char ch1 = s1.charAt(i);       // Для сравнения строк использую топорный, но действенный метод,
            char ch2 = s2.charAt(i);       // через char (т.к. любой символ имеет конкретное значение в кодировке)
            if (ch1 > ch2){flag = true; break;}
            else if (ch1 < ch2){flag = false; break;}   // опять же, меняя вывод false и true местами можем получить обратную сортировку
        }
        return flag;
    }

    public static void main(String[] args) {
        HashSet<String> mySet = new HashSet<>();   //  1.  задание
        LinkedHashSet<String> myLinkedSet = new LinkedHashSet<>();
        Random rand = new Random(100);       // добавим немного загадки
        int numberOfElement = 5;                   // количество элементов мн-ва. P.S. можно менять :)
        String str = "a";                          // добавим букву, чтобы по первой букве не отсортировывались
        for (int i = 0; i < numberOfElement; i++) {
            putTo(mySet, str+"R"+(rand.nextInt(100)) );   // и вторую букву с цифрами чтобы глазу легче было
        }
        printSet(mySet);
        myLinkedSet = sort(mySet);

        // TreeSet с компаратором
        TreeSet<String> myTreeSet = new TreeSet<>(new Comparator<String>() {   // Задание 5
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) { return 0;}
                if (o1.compareTo(o2)>0) {return 1;}
                else return -1;
            }
        });
        myTreeSet.addAll(mySet);            // Задание 6.   Тут в принципе Comparator за нас все делает
        System.out.println("\n"+mySet);
        System.out.println("This is TreeSet with Comparator "+myTreeSet);

        // Делаем treeSet с компаратором в обратном порядке
        TreeSet<String> myTreeSet1 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2)) { return 0;}
                if (o1.compareTo(o2)>0) {return -1;}        // поменяем значения(1 на -1) после <  >  получим обратную сортировку
                else return 1;
            }
        });
        myTreeSet1.addAll(mySet);
        System.out.println("\n"+mySet);
        System.out.println("This is TreeSet with Comparator Reversed "+myTreeSet1);   // 7/ задание
    }
}
