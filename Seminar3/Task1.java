package Seminar3;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Создать новый список, добавить несколько строк и вывести коллекцию на экран.
 * Итерация всех элементов списка цветов и добавления к каждому символа '!'.
 * Вставить элемент в список в первой позиции.
 * Извлечь элемент (по указанному индексу) из заданного списка.
 * Обновить определенный элемент списка по заданному индексу.
 * Удалить третий элемент из списка.
 * Поиска элемента в списке по строке.
 * Создать новый список и добавить в него несколько елементов первого списка.
 * Удалить из первого списка все элементы отсутствующие во втором списке.
 */

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("Red");
        colors.add("Orange");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Cyan");
        colors.add("Blue");
        colors.add("Purple");
        System.out.print(colors);
        for (int i = 0; i < colors.size(); i++) {
            colors.set(i,colors.get(i)+"!" );           // 2
        }
        System.out.print("\n"+colors);
        colors.add(0,"Black");              // 3
        System.out.print("\n"+colors);
        System.out.println("\n"+colors.get(3));         // 4
        colors.set(4, "White");
        System.out.print("\n"+colors);                  // 5
        colors.remove(3);
        System.out.print("\n"+colors);                  // 6
        if (colors.contains("White")){
            System.out.println("\nWhite содержится в списке по индексу - "+ colors.indexOf("White"));
        }
        else System.out.println("\nтакого нету");       // 7

        // новый список
        ArrayList<String> newColors = new ArrayList<String>();
        newColors.addAll(0, colors.subList(2,5));   // 8
        System.out.println(newColors);
        colors = newColors;                              // 9  (данный способ вполне подходит для удаления лишнего)
        System.out.println(colors);

    }
}
