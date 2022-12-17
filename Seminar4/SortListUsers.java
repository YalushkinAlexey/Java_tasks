package Seminar4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortListUsers {
    static void writeFileHuman(){
        try {
            FileWriter fwr = new FileWriter("humans.txt");
            fwr.write("Иванов Иван Иванович 45 м\n");
            fwr.write("Васильева Анна Ивановна 21 ж\n");
            fwr.write("Васнецова Наталья Владимировна 39 ж\n");
            fwr.write("Кондратьева Светлана Михайловна 31 ж\n");
            fwr.write("Петров Дмитрий Никонович 41 м\n");
            fwr.write("Тимофеев Михаил Потапович 33 м\n");
            fwr.write("Храмов Алексей Геннадьевич 40 м\n");
            fwr.write("Храмов Дмитрий Геннадьевич 42 м\n");
            fwr.write("Васильева Вера Валентиновна 22 ж\n");
            fwr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static ArrayList readFileHuman() {
        ArrayList<String> humans = new ArrayList<>();
        try {
            File file = new File("humans.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                humans.add(line);
                //System.out.println(line);     // вывод не печать строки
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return humans;
    }
    static ArrayList<String> sortedByAge(ArrayList<String> humans){
        int index = humans.size()-1;
        while (index >= 0){
            int maxAge = Integer.parseInt(humans.get(index).split(" ")[3]);
            int c = -1;
            for(int i = 0; i<index; i++){
                int current = Integer.parseInt(humans.get(i).split(" ")[3]);
                if (current > maxAge){
                    c = i;
                    maxAge = current;
                }
            }
            if (c!=-1){
                String tmp = humans.get(index);
                humans.set(index, humans.get(c));
                humans.set(c, tmp);
            }
            index--;
        }
        //printHuman(humans);
        return humans;
    }
    static void printHuman(ArrayList<String> list) {

        for (String s : list) {
            String[] tmp = s.split(" ");
            System.out.println(tmp[0] + " " + tmp[1] + " " + tmp[2] + " " + tmp[3] + " " + tmp[4]);
        }
        System.out.println("\n");
    }

    static ArrayList sortedByGenderAndAge(ArrayList<String> humans) {
        ArrayList<String> female = new ArrayList<>();
        ArrayList<String> male = new ArrayList<>();
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).split(" ")[4].equalsIgnoreCase("м")){
                male.add(humans.get(i));
            }
            else {
                female.add(humans.get(i));
            }
        }
        female = sortedByAge(female);
        male = sortedByAge(male);
        humans.clear();
        humans.addAll(female);
        humans.addAll(male);
        printHuman(humans);
        return humans;
    }
    static void sortAll(ArrayList<String>humans){
        ArrayList<String> female = new ArrayList<>();
        ArrayList<String> male = new ArrayList<>();
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).split(" ")[4].equalsIgnoreCase("м")){
                male.add(humans.get(i));
            }
            else {
                female.add(humans.get(i));
            }
        }
        Collections.sort(female);
        printHuman(female);
        Collections.sort(male);
        printHuman(male);
    }
    static void sorted(ArrayList<String> humans){
        Collections.sort(humans);
        printHuman(humans);
    }

    /** Добавим немного разнообразия. Пользователь будет вводить возраст (диапазон) и будем пробовать сортировать. */

    static ArrayList userMethod1(ArrayList<String> humans){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите минимальный и максимальный возраст людей, для поиска");
        int ageMin = sc.nextInt();
        int ageMax = sc.nextInt();
        int count = 0;
        System.out.println();
        ArrayList<String>sortedHumans = new ArrayList<>();
        for (int i = 0; i < humans.size(); i++) {
            int age = Integer.parseInt(humans.get(i).split(" ")[3]);
            if (ageMin <= age && age <= ageMax ){
                sortedHumans.add(humans.get(i));
                count++;
            }
        }
        if (count == 0){
            System.out.println("Не найден человек в заданном возрастном диапазоне");
        }
        else {
            sortedHumans = sortedByGenderAndAge(sortedHumans);
            return sortedHumans;
        }
        return sortedHumans;
    }
    /** Организуем поиск по фамилии */

    static void userMethod2(ArrayList<String>humans) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите фамилию для поиска");
        ArrayList<String>findedPeople = new ArrayList<>();
        String surname = sc.next();
        int count = 0;
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).split(" ")[0].equalsIgnoreCase(surname)){
                findedPeople.add(humans.get(i));
                count++;
            }
        }
        if (count == 0){
            System.out.println("Человека с такой фамилией нет.");
        }
        else printHuman(findedPeople);
    }
    static void start(ArrayList<String> humans){
        Scanner sc = new Scanner(System.in);
        System.out.println("*".repeat(100));
        boolean notExit = true;
        System.out.println("Краткий функционал: файл с данными humans.txt , чтобы записать необходимо раскоментить строку в main\n" +
                "Есть возможность сортировки по фио (Collections.sort)\n" +
                "Есть возможность сортировки по полу и возрасту как вместе так и по отдельности\n" +
                "Есть возможность отсортировать по полу и фио\n" +
                "Дополнительно поиск по фамилии и по возрасту");
        while (notExit) {
            System.out.println("1. Вывести весь список.\n2. Отсортировать в алфавитном порядке\n3. Отсортировать по возрасту\n" +
                    "4. Отсортировать по полу и фио\n" +
                    "5. Отсортировать по полу затем по возрасту (дамы вперед)\n6. Поиск по возрасту (мин ... макс)\n" +
                    "7. Поиск по фамилии\n0. ой все");
            int choise = sc.nextInt();
            switch (choise) {
                case 1:
                    printHuman(humans);
                    break;
                case 2:
                    sorted(humans);
                    break;
                case 3:
                    printHuman(sortedByAge(humans));

                    break;
                case 4:
                    sortAll(humans);
                    break;
                case 5:
                    sortedByGenderAndAge(humans);
                    break;
                case 6:
                    userMethod1(humans);
                    break;
                case 7:
                    userMethod2(humans);
                    break;
                case 0: notExit = false;
                    break;
                default:
                    System.out.println("не правильный выбор, давай по новой\n");
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<String> people;
//        writeFileHuman();
        people = readFileHuman();
        start(people);


    }
}
