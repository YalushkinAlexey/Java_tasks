package Seminar5;

import java.util.*;
/**
 * Создать словарь HashMap. Обобщение <Integer, String>.
 * Заполнить пятью ключами (индекс, ФИО+Возраст+Пол "Иванов Иван Иванович 28 м"),
 * добавить ключ, если не было!)
 * Изменить значения сделав пол большой буквой.
 * Пройти по коллекции и вывести значения в формате Фамилия инициалы "Иванов И.И."
 * *Сортировать значения по возрасту и вывести отсортированную коллекция как в четвёртом пункте.
 */
public class Sem5Task1 {
    static Map fillingStr(Map<Integer, String> human){
        human.put(1,"Иванов Иван Иванович 38 м");
        human.put(2,"Петров Петр Петрович 29 м");
        human.put(3,"Иванова Иванка Трамповна 32 ж");
        human.put(4,"Васильева Василиса Васильевна 31 ж");
        human.put(5,"Прутков Каземир Владимирович 35 м");
        return human;
    }
    static void printEntry(Map<Integer, String> people){
        for (Map.Entry entry: people.entrySet()) {
            System.out.println(entry);
        }
    }
    static void printKeys(Map<Integer,String> people){
        Set<Integer> keys = people.keySet();
        System.out.println("Список ключей   "+keys);
    }

    static void toUp(Map<Integer, String> people){
        Set<Integer> keys = people.keySet();
        for (Integer key: keys){
            String str = people.get(key);
            int ind = str.length()-1; //gender index
            str =str.substring(0,ind) + Character.toUpperCase(str.charAt(ind));
            System.out.println(str);
            people.put(key, str);
        }
    }
    static void fio(Map<Integer, String> people){
        Set<Integer> keys = people.keySet();
        for (Integer key: keys){
            String[] str = people.get(key).split(" ");
            String name = Character.toUpperCase(str[1].charAt(0))+".";
            String thirdName = Character.toUpperCase(str[2].charAt(0))+".";
            people.put(key, str[0]+" "+name+thirdName+" "+str[3]+" "+str[4]);
        }
        toUp(people);
    }
    static void finSort(Map<Integer, String> people){
        Set<Integer> keys = people.keySet();
        LinkedList<String>list = new LinkedList<>();
        for (Integer key: keys){
            list.add(people.get(key));
        }
        for (int i = 0; i < list.size(); i++) {
            int max = Integer.parseInt(list.get(i).split(" ")[2]);
            for (int j = 0; j < list.size(); j++) {
                int curAge = Integer.parseInt(list.get(j).split(" ")[2]);
                if (max < curAge){
                    max = curAge;
                    String str = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, str);
                }
            }
        }
        System.out.println("\nОтсортированный по возрасту список :");
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> people = new HashMap<>();
        people = fillingStr(people);
        printKeys(people);
        System.out.println("\nСписок значений (Key = Value)\n");
        printEntry(people);
        System.out.println("\nЗаменим маленькие буквы обозначающие пол на большие:\n");
        toUp(people);
        System.out.println("\nСократим Имя и Отчество до инициал:\n");
        fio(people);
        finSort(people);


    }
}
